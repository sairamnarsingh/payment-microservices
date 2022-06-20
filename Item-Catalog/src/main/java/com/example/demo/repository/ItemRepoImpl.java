package com.example.demo.repository;

import org.springframework.stereotype.Component;

import com.example.demo.model.DebitAmount;
import com.example.demo.model.DebitRequest;
import com.example.demo.util.RandomNoGenerator;

@Component
public class ItemRepoImpl implements ItemRepository {

	

	@Override
	public DebitAmount debitAmount(DebitRequest debitRequest) {

		double dAmount = AVAILABLE_AMOUNT - debitRequest.getDebitAmount();
		debitRequest.setAvailableAmount(dAmount);
		debitRequest.setTransactionId(RandomNoGenerator.idGen());
		DebitAmount debitAmount = new DebitAmount();
		debitAmount.setDebitAmount(debitRequest.getDebitAmount());
		debitAmount.setTransactionId(RandomNoGenerator.idGen().toUpperCase());
		debitAmount.setAvailableAmount(dAmount);
		return debitAmount;
	}

}
