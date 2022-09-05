package com.CTS.serviceBookingManagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CTS.serviceBookingManagement.dto.AppProduct;

@Repository
public interface ProductRepository extends CrudRepository<AppProduct, Integer> {

}

