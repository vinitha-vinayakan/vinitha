package com.vinitha.requestgeneration;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class KeltronCourse {

	@Id
	private String courseCode=null;
	private String courseName=null;
	public KeltronCourse() {}
	
	public KeltronCourse(String courseCode, String courseName) {
		// TODO Auto-generated constructor stub
		this.courseCode=courseCode;
		this.courseName=courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
