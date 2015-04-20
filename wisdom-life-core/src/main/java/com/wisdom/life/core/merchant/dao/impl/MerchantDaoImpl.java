package com.wisdom.life.core.merchant.dao.impl;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;

import com.wisdom.life.core.dao.base.impl.AbstractBaseDaoImpl;
import com.wisdom.life.core.merchant.dao.MerchantDao;
import com.wisdom.life.core.merchant.model.Merchant;

public class MerchantDaoImpl extends AbstractBaseDaoImpl<Merchant, String>
		implements MerchantDao {

	public MerchantDaoImpl(MongoEntityInformation<Merchant, String> metadata,
			MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
	}

	public MerchantDaoImpl(MongoRepositoryFactory factory,
			MongoOperations mongoOperations) {
		this(factory.<Merchant, String> getEntityInformation(Merchant.class),
				mongoOperations);
	}

}
