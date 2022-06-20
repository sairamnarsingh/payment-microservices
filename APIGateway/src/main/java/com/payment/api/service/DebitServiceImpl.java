package com.payment.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.payment.api.model.DebitAmount;
import com.payment.api.model.DebitRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class DebitServiceImpl implements DebitService {

	@Autowired
	 private RestTemplate restTemplate;

	
	    @Retry(name = "debitService", fallbackMethod = "getDebitError")
	    @CircuitBreaker(name = "debitService", fallbackMethod = "getDebitError")
	    public DebitAmount debitAmount(DebitRequest debitRequest)
	    {
	    	String uri="http://localhost:8000/debit/";
			ResponseEntity<DebitAmount> postForEntity = restTemplate.postForEntity(uri, debitRequest, DebitAmount.class);
			DebitAmount body = postForEntity.getBody();
			return body;
	    }

	    
	    public DebitAmount getDebitError(DebitRequest debitRequest, Throwable throwable){
	    	DebitAmount body= new DebitAmount();
	    	body.setTransactionId("QWQE12345");
	    	System.out.println("callback method called ");
			return body;
	    }

	
}
