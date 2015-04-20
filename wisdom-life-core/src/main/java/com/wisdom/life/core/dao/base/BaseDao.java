package com.wisdom.life.core.dao.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseDao<T, ID extends Serializable> extends
		MongoRepository<T, ID> {

	public List<T> findAll(Query query);

}
