package com.example.demo.service;

import com.example.demo.model.DebitAmount;
import com.example.demo.model.DebitRequest;

public interface DebitService {

	public DebitAmount debitAmount(DebitRequest debitRequest);
}
