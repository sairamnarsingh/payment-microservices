package com.example.demo.repository;

import com.example.demo.model.CreditAmount;
import com.example.demo.model.CreditRequest;

public interface CreditRepository {

	double AVAILABLE_AMOUNT = 10000;
	public CreditAmount creditAmount(CreditRequest creditRequest);
	
}
