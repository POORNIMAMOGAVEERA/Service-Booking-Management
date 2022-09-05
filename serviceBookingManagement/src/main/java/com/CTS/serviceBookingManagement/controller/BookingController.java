package com.CTS.serviceBookingManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.CTS.serviceBookingManagement.dao.ProductRepository;
import com.CTS.serviceBookingManagement.dto.AllProducts;
import com.CTS.serviceBookingManagement.dto.AppProduct;
import com.CTS.serviceBookingManagement.feign.AuthClient;
import com.CTS.serviceBookingManagement.model.AppServiceReq;
import com.CTS.serviceBookingManagement.model.AppServiceReqReport;
import com.CTS.serviceBookingManagement.service.BookingService;
import com.CTS.serviceBookingManagement.model.JwtResponse;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private AuthClient authclient;
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/servicereq/saveProducts")
	public List<AppProduct> saveProducts() {
		RestTemplate restTemplate=new RestTemplate();
		AllProducts products=restTemplate.getForObject("http://localhost:9000/products",AllProducts.class);
		for(AppProduct appProduct:products.getAllProducts()) {
			productRepository.save(appProduct);
		}
		return (List<AppProduct>) bookingService.getProduct();
	}
	@PutMapping("/servicereq/updateProduct")
	public AppServiceReqReport updateProduct(@RequestHeader(name="Authorization",required = true)String token,@RequestBody AppServiceReqReport appServiceReqreport) throws Exception {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
		return  bookingService.updateReport(appServiceReqreport);
		}else {
			 throw new Exception("e");
		}
	}
	@PostMapping("/servicereq")
	public AppServiceReq createServiceBooking(@RequestHeader(name="Authorization",required = true)String token,@RequestBody AppServiceReq appServiceReq)throws Exception {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
		return  bookingService.createBooking(appServiceReq);
		}else {
			 throw new Exception("e");
		}
	}

	@PutMapping("/servicereq")
	public AppServiceReq updateServiceBooking(@RequestHeader(name="Authorization",required = true)String token,@RequestBody AppServiceReq appServiceReq) throws Exception {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
		return  bookingService.updateBooking(appServiceReq);
		}else {
			 throw new Exception("e");
		}
	}
	@GetMapping("/servicereq")
	public List<AppServiceReq> getAllServiceBooking(@RequestHeader(name="Authorization",required = true)String token)throws Exception {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
			return bookingService.getBooking();
		}else {
			 throw new Exception("e");
		}	
	}

	@DeleteMapping("/servicereq/{id}")
	public void deleteServiceBooking(@RequestHeader(name="Authorization",required = true)String token,@PathVariable("id") int id) throws Exception{
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
		  bookingService.deleteBooking(id);
		}else {
			 throw new Exception("e");
		}	
	}

   @GetMapping("/servicereq/{Id}")
	public AppServiceReq getServiceById(@RequestHeader(name="Authorization",required = true)String token,@PathVariable("Id") int Id)throws Exception {
	   JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
			return bookingService.getBookingById(Id);
		}else {
			 throw new Exception("e");
		}	
	}
	@GetMapping("/servicereq/user/{userId}")
	public List<AppServiceReq> getServiceBookingByUserId(@RequestHeader(name="Authorization",required = true)String token,@PathVariable("userId") int userId)throws Exception {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
			return bookingService.getBookingByUserId(userId);
		}else {
			 throw new Exception("e");
		}	
	}
	@GetMapping("/servicereq/status/{status}")
	public List<AppServiceReq> getServiceBookingByStatus(@RequestHeader(name="Authorization",required = true)String token,@PathVariable("status") String status)throws Exception  {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
			return bookingService.getServiceByStatus(status);
		}else {
			 throw new Exception("e");
		}
	}

	@PostMapping("/servicereq/report")
	public AppServiceReqReport saveReport(@RequestHeader(name="Authorization",required = true)String token,@RequestBody AppServiceReqReport appServiceReqReport)throws Exception  {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
			return bookingService.addReport(appServiceReqReport);
		}else {
			 throw new Exception("e");
		}
	}

	@GetMapping("/servicereq/report")
	public List<AppServiceReqReport> getReports(@RequestHeader(name="Authorization",required = true)String token)throws Exception {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
			return bookingService.getReports();
		}else {
			 throw new Exception("e");
		}
		
	}

	@GetMapping("/servicereq/report/user/{userId}")
	public List<AppServiceReqReport> getReportsByUserId(@RequestHeader(name="Authorization",required = true)String token,@PathVariable("userId") int userId) throws Exception{
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
			return bookingService.getReportByUserId(userId);
		}else {
			 throw new Exception("e");
		}
	}
	/*@GetMapping("/servicereq/report/service/{serviceId}")
	public List<AppServiceReqReport> getReportsByUserId(@PathVariable("serviceId") int serviceId) {
		return bookingService.getReportByServiceId(serviceId);
	}*/
	@GetMapping("/servicereq/report/{reportId}")
	public Optional<AppServiceReqReport> getReportsByReportId(@RequestHeader(name="Authorization",required = true)String token,@PathVariable("reportId") int reportId)throws Exception {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
			return bookingService.getReportByReportId(reportId);
		}else {
			 throw new Exception("e");
		}
	}
	@DeleteMapping("/servicereq/report/{id}")
	public void deleteServiceReport(@RequestHeader(name="Authorization",required = true)String token,@PathVariable("id") int id)throws Exception {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
			bookingService.deleteReport(id);
		}else {
			 throw new Exception("e");
		}
		
	}
	@DeleteMapping("/servicereq/product/{id}")
	public void deleteProduct(@RequestHeader(name="Authorization",required = true)String token,@PathVariable("id") int id)throws Exception {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
			bookingService.deleteProduct(id);
		}else {
			 throw new Exception("e");
		}
		
	}
	@PutMapping("/servicereq/report")
	public AppServiceReqReport updateServiceReport(@RequestHeader(name="Authorization",required = true)String token,@RequestBody AppServiceReqReport appServiceReqreport) throws Exception {
		JwtResponse  jwtResponse = authclient.getValidity(token);
		if(jwtResponse.isValid()) {
		return  bookingService.updateReport(appServiceReqreport);
		}else {
			 throw new Exception("e");
		}
	}

}
