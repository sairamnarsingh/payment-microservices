package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DebitAmount;
import com.example.demo.model.DebitRequest;
import com.example.demo.service.DebitService;


@RestController
@RequestMapping("debit")
public class DebitController {

	@Autowired
	private DebitService debitservice;
	
	@PostMapping("/")
	public ResponseEntity<DebitAmount> debitAmount(@RequestBody DebitRequest debitRequest){
		DebitAmount debitAmount = debitservice.debitAmount(debitRequest);
		return new ResponseEntity<DebitAmount>( debitAmount, HttpStatus.OK);
		
	}
	
}
