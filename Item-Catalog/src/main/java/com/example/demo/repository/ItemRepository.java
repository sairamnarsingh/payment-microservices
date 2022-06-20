package com.example.demo.repository;

import com.example.demo.model.DebitAmount;
import com.example.demo.model.DebitRequest;

public interface ItemRepository {

	double AVAILABLE_AMOUNT = 10000;
	public DebitAmount debitAmount(DebitRequest debitRequest);
	
}
