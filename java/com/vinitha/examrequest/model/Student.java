package com.vinitha.examrequest.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private String rollNo=null;
	private String nameOfStudent=null;
	@OneToOne
	private Batch batch=null;
	@OneToMany
	private List<PaymentModel> payments=null;
	
	public Student() {}
	public Student(String rollNo, String nameOfStudent,Batch batch,List<PaymentModel> payments) {
		this.rollNo = rollNo;
		this.nameOfStudent = nameOfStudent;
		this.batch=batch;
		this.setPayments(payments);
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		if(!(rollNo.trim().equals(""))) {
			this.rollNo = rollNo;
		}
	}
	public String getNameOfStudent() {
		return nameOfStudent;
	}
	public void setNameOfStudent(String nameOfStudent) {
		if (!(nameOfStudent.trim().equals(""))) {
			this.nameOfStudent = nameOfStudent;
		}
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	public List<PaymentModel> getPayments() {
		return payments;
	}
	public void setPayments(List<PaymentModel> payments) {
		this.payments = payments;
	}
	public boolean checkEmpty() {
		if (rollNo==null 
				|| nameOfStudent==null
				|| batch== null
				||payments.size()==0) {
			return true;
		}
		return false;
	}
	
	
}
