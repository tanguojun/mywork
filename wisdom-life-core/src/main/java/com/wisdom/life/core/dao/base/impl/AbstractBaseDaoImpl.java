package com.wisdom.life.core.dao.base.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import com.wisdom.life.core.dao.base.BaseDao;

public abstract class AbstractBaseDaoImpl<T, ID extends Serializable> extends
		SimpleMongoRepository<T, ID> implements BaseDao<T, ID> {

	public AbstractBaseDaoImpl(MongoEntityInformation<T, ID> metadata,
			MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
	}

	@Override
	public List<T> findAll(Query query) {
		return getMongoOperations().find(query,
				getEntityInformation().getJavaType(),
				getEntityInformation().getCollectionName());
	}

}
