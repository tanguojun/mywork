package com.wisdom.life.core.sysconfig.dao.impl;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;

import com.wisdom.life.core.dao.base.impl.AbstractBaseDaoImpl;
import com.wisdom.life.core.sysconfig.dao.SystemConfigDao;
import com.wisdom.life.core.sysconfig.model.SystemConfig;

public class SystemConfigDaoImpl extends
		AbstractBaseDaoImpl<SystemConfig, String> implements SystemConfigDao {

	public SystemConfigDaoImpl(
			MongoEntityInformation<SystemConfig, String> metadata,
			MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
	}

	public SystemConfigDaoImpl(MongoRepositoryFactory factory,
			MongoOperations mongoOperations) {
		this(
				factory.<SystemConfig, String> getEntityInformation(SystemConfig.class),
				mongoOperations);
	}

}
