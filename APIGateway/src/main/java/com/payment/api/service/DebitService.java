package com.payment.api.service;

import com.payment.api.model.DebitAmount;
import com.payment.api.model.DebitRequest;

public interface DebitService {

	DebitAmount debitAmount(DebitRequest debitRequest);

}
