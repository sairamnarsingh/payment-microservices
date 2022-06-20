package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.DebitAmount;
import com.example.demo.model.DebitRequest;
import com.example.demo.repository.ItemRepository;

@Service
public class DebitiServiceImpl implements DebitService {

	@Autowired
	private ItemRepository itemrepo;

	@Override
	public DebitAmount debitAmount(DebitRequest debitRequest) {
		// TODO Auto-generated method stub
		return itemrepo.debitAmount(debitRequest);
	}

	

}
