package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CreditAmount;
import com.example.demo.model.CreditRequest;
import com.example.demo.service.CreditPaymentService;

@RestController
@RequestMapping("credit")
public class CreditController {

	@Autowired
	private CreditPaymentService creditpaymentservice;

	@PostMapping("/")
	public ResponseEntity<CreditAmount> debitAmount(@RequestBody CreditRequest creditRequest) {
		CreditAmount creditAmount = creditpaymentservice.creditAmount(creditRequest);
		return new ResponseEntity<CreditAmount>(creditAmount, HttpStatus.OK);

	}

}
