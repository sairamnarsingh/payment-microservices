package com.example.demo.service;

import com.example.demo.model.CreditAmount;
import com.example.demo.model.CreditRequest;

public interface CreditPaymentService {

	public CreditAmount creditAmount(CreditRequest creditRequest);
}
