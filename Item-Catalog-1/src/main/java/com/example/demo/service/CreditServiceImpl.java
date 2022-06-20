package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CreditAmount;
import com.example.demo.model.CreditRequest;
import com.example.demo.repository.CreditRepository;

@Service
public class CreditServiceImpl implements CreditPaymentService {

	@Autowired
	private CreditRepository itemrepo;

	@Override
	public CreditAmount creditAmount(CreditRequest creditRequest) {
		return itemrepo.creditAmount(creditRequest);
	}

}
