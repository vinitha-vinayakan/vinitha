package com.vinitha.examrequest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="payment")
public class PaymentModel {
	@Id
	private String dbaNumDate=null;
	private int amount=-1;
	private String mode="online";
	
	public PaymentModel() {}

	public PaymentModel(String dbaNumDate, int paid) {
		super();
		this.dbaNumDate = dbaNumDate;
		this.amount = paid;
	}

	public String getDbaNumDate() {
		return dbaNumDate;
	}

	public void setDbaNumDate(String dbaNumDate) {
		if (!(dbaNumDate.trim().equals(""))) {
			this.dbaNumDate = dbaNumDate;
		}
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if (amount>0) {
			this.amount = amount;
		}
	}
	public boolean checkEmpty(){
		if(dbaNumDate==null  || amount==-1) {
			return true;
		}
		return false;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	

}
