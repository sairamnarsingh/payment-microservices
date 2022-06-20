package com.example.demo.model;

import java.io.Serializable;


public class DebitAmount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long accNumber;
	private double availableAmount;
	private double debitAmount;
	private String transactionId;
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public double getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(double availableAmount) {
		this.availableAmount = availableAmount;
	}
	public double getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
	
}
