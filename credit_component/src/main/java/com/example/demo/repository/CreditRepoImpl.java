package com.example.demo.repository;

import org.springframework.stereotype.Component;

import com.example.demo.model.CreditAmount;
import com.example.demo.model.CreditRequest;
import com.example.demo.util.RandomNoGenerator;

@Component
public class CreditRepoImpl implements CreditRepository {

	

	@Override
	public CreditAmount creditAmount(CreditRequest creditRequest) {

		double dAmount = AVAILABLE_AMOUNT + creditRequest.getCreditAmount();
		CreditAmount creditAmount = new CreditAmount();
		creditAmount.setCreditAmount(creditAmount.getCreditAmount());
		creditAmount.setTransactionId(RandomNoGenerator.idGen().toUpperCase());
		creditAmount.setAvailableAmount(dAmount);
		return creditAmount;
	}

}
