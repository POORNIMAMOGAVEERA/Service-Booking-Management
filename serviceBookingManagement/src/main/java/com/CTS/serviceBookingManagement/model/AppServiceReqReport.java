package com.CTS.serviceBookingManagement.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
public class AppServiceReqReport {
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reportId;
	
	@Column(nullable=false)
	private Date reportDate;
	@Column(nullable=false)
	private String serviceType; // (general, repair, support)
	@Column(nullable=false)
	private String actionTaken;
	@Column(nullable=false)
	private String diagnosisDetails;
	@Column(nullable=false)
	private String isPaid;
	@Column(nullable=false)
	private Integer visitFees;
	@Column(nullable=false)
	private String repairDetails;
	@Transient
	private Integer serReqId;
	
	@OneToOne
	@JsonIgnore
	//@JoinColumn(name = "serReqId", referencedColumnName = "id")
	private AppServiceReq appserReq;
	/*@JsonProperty("serReqId")
	private void unpackNested(Integer serReqId) {
		this.appserviceReq=new AppServiceReq();
       appserviceReq.setId(serReqId);
	}*/
	
	public void setAppserviceReq(AppServiceReq appserReq) {
		this.appserReq = appserReq;
	}
	public AppServiceReq getAppserviceReq() {
		return appserReq;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public Integer getReportId() {
		return reportId;
	}

	

	/*public void setAppserviceReq(AppServiceReq serReq) {
		this.serReq = serReq;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}*/

    public Integer getSerReqId() {
		return serReqId;
	}

	public void setSerReqId(Integer serReqId) {
		this.serReqId = serReqId;
	}

	public Date getReportDate() {
		return reportDate;
	}

	

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getDiagnosisDetails() {
		return diagnosisDetails;
	}

	public void setDiagnosisDetails(String diagnosisDetails) {
		this.diagnosisDetails = diagnosisDetails;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public Integer getVisitFees() {
		return visitFees;
	}

	public void setVisitFees(Integer visitFees) {
		this.visitFees = visitFees;
	}

	public String getRepairDetails() {
		return repairDetails;
	}

	public void setRepairDetails(String repairDetails) {
		this.repairDetails = repairDetails;
	}
   public AppServiceReqReport() {
	   
   }
	
}
