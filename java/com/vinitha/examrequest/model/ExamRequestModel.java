package com.vinitha.examrequest.model;

import java.util.ArrayList;
import java.util.Date;

public class ExamRequestModel {
	
	private String courseName=null;
	private String courseCode=null;
	private String semesterNo="";
	private String preparedBy=null;
	private String verifiedBy=null;
	private String examRequisitionNo=null;
	private Date date=null;
	private Date proposedExamDate=null;
	private ArrayList<StudentInfoModel> examStudentList=null;
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		if (!(courseName.equals(""))) {
			this.courseName = courseName;
		}
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		if (!(courseCode.equals(""))) {
			this.courseCode = courseCode;
		}
	}

	public String getSemesterNo() {
		return semesterNo;
	}

	public void setSemesterNo(String semesterNo) {
		this.semesterNo = semesterNo;
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

	public String getExamRequisitionNo() {
		return examRequisitionNo;
	}

	public void setExamRequisitionNo(String examRequisitionNo) {
		this.examRequisitionNo = examRequisitionNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getProposedExamDate() {
		return proposedExamDate;
	}

	public void setProposedExamDate(Date proposedExamDate) {
		this.proposedExamDate = proposedExamDate;
	}

	public ArrayList<StudentInfoModel> getExamStudentList() {
		return examStudentList;
	}

	public void setExamStudentList(ArrayList<StudentInfoModel> examStudentList) {
		this.examStudentList = examStudentList;
	}
	public boolean checkEmpty() {
		if(courseCode==null
				|| courseCode==null
				|| examStudentList.size()==0) {
			return true;
		}
		return false;
		
	}
	
	

}
