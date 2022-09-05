package com.CTS.serviceBookingManagement.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.OneToOne;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CTS.serviceBookingManagement.model.AppServiceReq;
import com.CTS.serviceBookingManagement.model.AppServiceReqReport;

@Repository
public interface BookingReportDao extends CrudRepository<AppServiceReqReport, Integer> {

	List<AppServiceReqReport> findAllByReportId(int reportId);
	/*List<AppServiceReqReport> findByUserId(int userId);*/
	/*List<AppServiceReqReport> findAllByappserviceReqUserId(int userId);*/
}
