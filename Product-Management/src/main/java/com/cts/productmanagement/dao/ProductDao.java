package com.cts.productmanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.productmanagement.model.AppProduct;

public interface ProductDao extends CrudRepository<AppProduct, Integer> {

}
