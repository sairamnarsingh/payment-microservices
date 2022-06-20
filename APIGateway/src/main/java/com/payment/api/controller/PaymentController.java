package com.payment.api.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.payment.api.model.CreditAmount;
import com.payment.api.model.CreditRequest;
import com.payment.api.model.DebitAmount;
import com.payment.api.model.DebitRequest;

import io.github.resilience4j.retry.annotation.Retry;


@RestController
public class PaymentController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private int attempt=1;

	@Value("${debit-api}")
	private String debit_api;
	
	
	@PostMapping("/debit")
	@Retry(name = "debit-service", fallbackMethod = "debitError")
	public ResponseEntity<DebitAmount>  getDebitRequest(@RequestBody DebitRequest debitRequest){
		System.out.println("props "+ debit_api);
		 System.out.println("retry method called "+ attempt++  +" times "+" at "+new Date());
		return restTemplate.postForEntity(debit_api, debitRequest, DebitAmount.class);
	}
	
	public ResponseEntity<Object> debitError(DebitRequest debitRequest, Throwable e){
			return new ResponseEntity<Object>("Unable to Debit Amount : /n "+debitRequest.getDebitAmount()+"/n Server is Down at the moment" ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/credit")
	@Retry(name = "credit-service", fallbackMethod = "creditError")
	public ResponseEntity<CreditAmount>  getCreditRequest(@RequestBody CreditRequest creditRequest){
		String uri="http://localhost:8000/credit/";
		 System.out.println("retry method called "+ attempt++  +" times "+" at "+new Date());
		return restTemplate.postForEntity(uri, creditRequest, CreditAmount.class);
	}
	
	public ResponseEntity<Object> debitError(CreditRequest creditRequest, Throwable e){
			return new ResponseEntity<Object>("Unable to Credit Amount : /n "+creditRequest.getCreditAmount()+"/n Server is Down at the moment" ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
