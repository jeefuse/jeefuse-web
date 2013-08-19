/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.sequence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.system.sequence.service.GsysSequenceService;

/**
 * 序例 Entity CRUD service impl.
 *
 * @author yonclv
 * @generated
 */
@Service(value="gsysSequenceServiceImpl")
public class GsysSequenceServiceImpl  implements GsysSequenceService{
	public final static String SERVICE_ID = "gsysSequenceServiceImpl";

	@Autowired
	protected HibernateDao hibernateDao;// 通用DAO接口

	@Transactional
	public long getNextId(String sequenceName) {
		Assert.notNull(sequenceName);
		final String hql = "select m.nextId from GsysSequence m where m.name=:name";
		Long seq = (Long) hibernateDao.createQuery(hql).setString("name", sequenceName).uniqueResult();
		if (seq == null)
			throw new DataRetrievalFailureException("Could not get next value of sequence '" + sequenceName
					+ "': sequence does not exist");
		final String updateHql = "update GsysSequence m set m.nextId = :nextId where m.name=:name";
		hibernateDao.createQuery(updateHql).setLong("nextId", seq + 1).setString("name", sequenceName)
				.executeUpdate();
		return seq;
	}


	

}
