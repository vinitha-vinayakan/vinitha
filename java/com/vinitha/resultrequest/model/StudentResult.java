package com.vinitha.resultrequest.model;

public class StudentResult {
	
	private StudentMarkModel mark=null;

	public StudentResult(StudentMarkModel mark) {
		super();
		this.mark = mark;
	}
	
    public  int totalMark() {
    	
    	return mark.getPracticalMark()+mark.getTheoryMark();
    	
    }
    public String grade() {
    	if(totalMark()>=90) {
    		return "A+";
    	}
    	else if (totalMark()>=80) {
    		return "A";
		}
    	else if(totalMark()>=70) {
    		return "B+";
    	}
    	else if (totalMark()>=60) {
    		return "B";
		}
    	else if (totalMark()>=50) {
    		return "C";
		}
    	else {
    		return "FAILED";
    	}
		
     }
    public String result() {
    	if(totalMark()>=50) {
    		return "PASSED";
    	}
		return "FAILED";
    }
}