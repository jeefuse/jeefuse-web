package com.jeefuse.system.code.service.impl;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeefuse.base.test.SpringTransactionalTestCase;
import com.jeefuse.system.code.model.CodeDefineType;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.service.GsysCodeService;
import com.jeefuse.system.code.service.GsysCodevalueService;

public class GsysCodeServiceImplTest extends SpringTransactionalTestCase {

	@Autowired
	GsysCodeService gsysCodeService;
	@Autowired
	GsysCodevalueService gsysCodevalueService;

	public GsysCodeServiceImplTest() {
	}

	@Test
	public void testSaveCodeValueForTaste() {
		GsysCode code = gsysCodeService.get(CodeDefineType.efficacy.getName());
		String names = "aaa|bbbb";
		String[] nameArr=StringUtils.split(names,"|");
		logger.debug("process size:"+names.length());
		for (int i = 0; i < nameArr.length; i++) {
			GsysCodevalue gsysCodevalue = new GsysCodevalue();
			gsysCodevalue.setGsysCode(code);
			gsysCodevalue.setName(nameArr[i]);
			gsysCodevalue.setValue(String.valueOf(i));
			gsysCodevalueService.save(gsysCodevalue);

		}
	}
}
