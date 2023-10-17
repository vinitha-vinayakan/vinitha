package com.vinitha.certificaterequest.model;

import java.util.Date;

import com.vinitha.examrequest.model.Student;

public class CertificateInfoModel {
	
	private String SSLCName="YES";
	private Date examHeldOn=null;
	private String grade=null;
	private String resultCode=null;
	private int attend=90;
	private Student student=null;
	public String getSSLCName() {
		return SSLCName;
	}
	public void setSSLCName(String sSLCName) {
		SSLCName = sSLCName;
	}
	public Date getExamHeldOn() {
		return examHeldOn;
	}
	public void setExamHeldOn(Date examHeldOn) {
		this.examHeldOn = examHeldOn;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public int getAttend() {
		return attend;
	}
	public void setAttend(int attend) {
		if (attend<=100 && attend>=0) {
			this.attend = attend;
		}
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public boolean checkEmpty() {
		if(student==null 
				|| examHeldOn==null
				|| grade==null) {
			return true;
		}	
		return false;
	}

}
