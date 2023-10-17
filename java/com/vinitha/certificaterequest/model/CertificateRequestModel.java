package com.vinitha.certificaterequest.model;

import java.util.ArrayList;

public class CertificateRequestModel {

	private String courseName=null;
	private String category=null;
	private String preparedBy=null;
	private String verifiedBy=null;
	private String requisitionNo=null;
	private ArrayList<CertificateInfoModel> studentList=null;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public String getRequisitionNo() {
		return requisitionNo;
	}

	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
	}

	public ArrayList<CertificateInfoModel> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<CertificateInfoModel> studentList) {
		this.studentList = studentList;
	}	 
	public boolean checkEmpty() {
		if (studentList.size()==0 
				|| category==null
				|| courseName==null) {
			return true;
			
		}
		return false;
	}
}
