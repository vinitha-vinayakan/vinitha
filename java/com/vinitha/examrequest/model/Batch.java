package com.vinitha.examrequest.model;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Batch {

	@Id
	private String batchNumber=null;
	private Date startDate=null;
	private Date endDate=null;
	private int studentsInBatch=0;
	
	public Batch() {}
	public Batch(String batchNumber, Date startDate, Date endDate, int studentsInBatch) {
		this.batchNumber = batchNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentsInBatch = studentsInBatch;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		if (!(batchNumber.trim().equals(""))) {
			this.batchNumber = batchNumber;
		}
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getStudentsInBatch() {
		return studentsInBatch;
	}
	public void setStudentsInBatch(int studentsInBatch) {
		if (studentsInBatch>0) {
			this.studentsInBatch = studentsInBatch;
		}
	}
	public boolean checkEmpty() {
		if (batchNumber==null
				|| startDate==null
				|| endDate==null
				|| studentsInBatch==0) {
			return true;
		}
		return false;
		
	}
	public boolean checkEmpty2() {
		if (batchNumber==null
				|| startDate==null
				|| endDate==null) {
			return true;
		}
		return false;
		
	}
}
