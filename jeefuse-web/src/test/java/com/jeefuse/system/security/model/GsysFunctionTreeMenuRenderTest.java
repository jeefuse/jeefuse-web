package com.jeefuse.system.security.model;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeefuse.base.modules.tree.renders.menu.TreeMenuRenderUtil;
import com.jeefuse.base.test.SpringTransactionalTestCase;
import com.jeefuse.system.security.service.GsysFunctionService;

/**
 * 测试生成菜单HTML树形结构样式.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class GsysFunctionTreeMenuRenderTest extends SpringTransactionalTestCase {

	@Autowired
	private GsysFunctionService gsysFunctionService;

	@Test
	public void testTreeMenuRender() {
		List<GsysFunction> gsysFunctions = gsysFunctionService.getAll();
		String render = TreeMenuRenderUtil.contructTreeMenuUIHrefMethod(gsysFunctions, null, null, null, null);
		System.out.println(render);
	}

}
