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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.CTS.serviceBookingManagement.dto.AppProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class AppServiceReq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private Integer productId;
	@Column(nullable=false)
	private Integer userId;
	@Column(nullable=false)
	private Date reqDate;
	@Column(nullable=false)
	private String problem;
	@Column(nullable=false)
	private String description;
	@Column(nullable=false)
	private String status;
	
	/*@OneToOne(mappedBy = "appserviceReq")
	private AppServiceReqReport appreport;*/
	
	@ManyToOne
	@JsonIgnore
	private AppProduct appProduct;

	public AppProduct getAppProduct() {
		return appProduct;
	}

	public void setAppProduct(AppProduct appProduct) {
		this.appProduct = appProduct;
	}

	public Integer getId() {
		return id;
	}

	/*public AppServiceReqReport getAppreport() {
		return appreport;
	}

	public void setAppreport(AppServiceReqReport appreport) {
		this.appreport = appreport;
	}*/


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    public AppServiceReq() {
    	
    }
	@Override
	public String toString() {
		return String.format(
				"AppServiceReq [id=%s, productId=%s, userId=%s, reqDate=%s, problem=%s, description=%s, status=%s]", id,
				productId, userId, reqDate, problem, description, status);
	}
}
