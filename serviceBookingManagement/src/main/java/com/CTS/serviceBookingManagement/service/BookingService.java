package com.CTS.serviceBookingManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CTS.serviceBookingManagement.dao.BookingDao;
import com.CTS.serviceBookingManagement.dao.BookingReportDao;
import com.CTS.serviceBookingManagement.dao.ProductRepository;
import com.CTS.serviceBookingManagement.dto.AppProduct;
import com.CTS.serviceBookingManagement.model.AppServiceReq;
import com.CTS.serviceBookingManagement.model.AppServiceReqReport;


@Service
public class BookingService {
	
	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	BookingReportDao bookingReportDao;
	

	@Autowired
	private ProductRepository productRepository;
	
	public AppServiceReq createBooking(AppServiceReq appServiceReq) {
		AppProduct appProduct= productRepository.findById(appServiceReq.getProductId()).get();
		appServiceReq.setAppProduct(appProduct);
		return bookingDao.save(appServiceReq);
	}
	
	public List<AppServiceReq> getBooking(){
		return (List<AppServiceReq>) bookingDao.findAll();		 
	}
	public List<AppProduct> getProduct(){
		return (List<AppProduct>) productRepository.findAll();		 
	}
	
	public AppServiceReq updateBooking(AppServiceReq appServiceReq) {
		AppServiceReq book = bookingDao.findById(appServiceReq.getId()).orElse(null);
		book.setReqDate(appServiceReq.getReqDate());
		book.setProblem(appServiceReq.getProblem());
		book.setDescription(appServiceReq.getDescription());
		book.setStatus(appServiceReq.getStatus());
		/*book.setId(appServiceReq.getId());
		book.setUserId(appServiceReq.getUserId());*/
		book.setProductId(appServiceReq.getProductId());
		return bookingDao.save(book);
	}
	public AppServiceReqReport updateReport(AppServiceReqReport appServiceReqreport) {
		AppServiceReqReport report = bookingReportDao.findById(appServiceReqreport.getReportId()).orElse(null);
		report.setServiceType((appServiceReqreport.getServiceType()));
		report.setReportDate((appServiceReqreport.getReportDate()));
		report.setActionTaken((appServiceReqreport.getActionTaken()));
		report.setDiagnosisDetails((appServiceReqreport.getDiagnosisDetails()));
		report.setVisitFees((appServiceReqreport.getVisitFees()));
		report.setRepairDetails((appServiceReqreport.getRepairDetails()));
		/*book.setId(appServiceReq.getId());
		book.setUserId(appServiceReq.getUserId());*/
		report.setIsPaid((appServiceReqreport.getIsPaid()));
		return bookingReportDao.save(report);
	}
	
	public void deleteBooking(Integer id) { 
		bookingDao.deleteById(id);		
	}
	public void deleteReport(Integer id) { 
		bookingReportDao.deleteById(id);		
	}
	public void deleteProduct(Integer id) { 
		productRepository.deleteById(id);		
	}
	
	public List<AppServiceReq> getBookingByUserId(Integer userid) {
		return bookingDao.findByUserId(userid);
	}
	public AppServiceReq getBookingById(Integer id) {
	return bookingDao.findById(id).orElse(null);
   }

	public List<AppServiceReq> getServiceByStatus(String status) {
		return (List<AppServiceReq>) ( bookingDao.findAllByStatus(status));
	}

	public AppServiceReqReport addReport(AppServiceReqReport appServiceReqReport){
		int id=appServiceReqReport.getSerReqId();
		AppServiceReq appServiceReq=bookingDao.findById(id).get();
		appServiceReqReport.setAppserviceReq(appServiceReq);
		return bookingReportDao.save(appServiceReqReport);
	}
	
	public List<AppServiceReqReport> getReports(){
		return(List<AppServiceReqReport>) bookingReportDao.findAll();
	}
	
	public List<AppServiceReqReport> getReportByUserId(int id) throws Exception {
		List<AppServiceReqReport> report=new ArrayList<AppServiceReqReport>();
		for(AppServiceReqReport appServiceReqReport:getReports()) {
			if(id==appServiceReqReport.getAppserviceReq().getUserId()) {
			    report.add(appServiceReqReport);
			}
		}
		return (List<AppServiceReqReport>) report;
	}
	/*public AppServiceReqReport getReportByServiceId(int serviceId) {
		return   bookingReportDao.findAllBySerReqId(serviceId);

	}*/
	
	public Optional<AppServiceReqReport> getReportByReportId(int reportId) {
		return bookingReportDao.findById(reportId);

	}
	
  public AppProduct updateProduct(AppProduct appProduct) {
		
		Integer id = appProduct.getId();
		AppProduct prod = productRepository.findById(id).orElse(appProduct);
		prod.setName(appProduct.getName());
		prod.setModel(appProduct.getModel());
		prod.setCreatedDate(appProduct.getCreatedDate());
		prod.setCost(appProduct.getCost());
		prod.setMake(appProduct.getMake());
		
		return productRepository.save(prod);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/*public AppServiceReq getServiceByReport(String report) {
		return bookingDao.findAllByReport(report);
	}

	public  Iterable<AppServiceReq> getAllBookingReport() {
		return  bookingReportDao.findAll();	
	}

	public AppServiceReqReport getReportById(Integer userid) {
		return bookingReportDao.findById(userid).orElse(null);
	}

	public AppServiceReqReport getReportByreportId(Integer reportId) {
		return bookingDaoReq.findById(reportId).orElse(null);
	}

	public AppServiceReqReport addReport(AppServiceReqReport appServiceReqReport) {
		return bookingDaoReq.save(appServiceReqReport);
	}
	
	public void deleteReport(Integer reportId) {
		bookingDaoReq.deleteById(reportId);
	}*/
	
	
}
