package com.CTS.serviceBookingManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CTS.serviceBookingManagement.model.AppServiceReq;

@Repository
public interface BookingDao extends CrudRepository<AppServiceReq, Integer> {
	List<AppServiceReq> findAllByStatus(String status);
	List<AppServiceReq> findByUserId(Integer userId);
	/*List<AppServiceReq> findAllById(Integer userId);*/
}
