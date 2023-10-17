package com.vinitha.resultrequest.model;

import java.util.ArrayList;

public class ResultModel {
	
	private String courseName=null;
	private String courseCode=null;
	private String examHeldIn=null;
	private String enteredBy=null;
	private String verifiedBy=null;
	private ArrayList<StudentMarkModel> studentList=null;
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getExamHeldIn() {
		return examHeldIn;
	}
	public void setExamHeldIn(String examHeldIn) {
		this.examHeldIn = examHeldIn;
	}
	public String getEnteredBy() {
		return enteredBy;
	}
	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}
	public String getVerifiedBy() {
		return verifiedBy;
	}
	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}
	public ArrayList<StudentMarkModel> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<StudentMarkModel> studentList) {
		this.studentList = studentList;
	}
	public boolean checkEmpty() {
		if(courseCode==null || courseName== null
				|| studentList.size()==0) {
			return true;
		}
		return false;
			
	}
	
	

}
