package com.vinitha.examrequest.model;


public class StudentInfoModel {
	
	private Student student=null;
	private int studentsForExam=0;
	private int balance=0;
	private String noDueClearance=null;
	private String remarks=null;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getStudentsForExam() {
		return studentsForExam;
	}
	public void setStudentsForExam(int studentsForExam) {
		this.studentsForExam = studentsForExam;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getNoDueClearance() {
		return noDueClearance;
	}
	public void setNoDueClearance(String noDueClearance) {
		this.noDueClearance = noDueClearance;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public boolean checkEmpty() {
		if (student==null || studentsForExam==0) {
			return true;
		}
		return false;
		
	}
	

	
	

}
