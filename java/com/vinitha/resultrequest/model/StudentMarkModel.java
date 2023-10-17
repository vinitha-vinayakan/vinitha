package com.vinitha.resultrequest.model;

public class StudentMarkModel {

	private String studentId=null;
	private String studentName=null;
	private int theoryMark=-1;
	private int practicalMark=-1;
	
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getTheoryMark() {
		return theoryMark;
	}
	public void setTheoryMark(int theoryMark) {
		if (theoryMark>=0 && theoryMark<=100) {
			this.theoryMark = theoryMark;
		}
	}
	public int getPracticalMark() {
		return practicalMark;
	}
	public void setPracticalMark(int practicalMark) {
		if (practicalMark>=0 && practicalMark<=100) {
			this.practicalMark = practicalMark;
		}
		
	}
	public boolean checkEmpty() {
		if(studentId==null || studentName==null ||
				theoryMark==-1 || practicalMark==-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
