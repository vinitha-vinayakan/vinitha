package com.vinitha.examrequest.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.vinitha.examrequest.model.StudentInfoModel;


public class StudentListRemoveController implements ActionListener {
	
	private JList<StudentInfoModel> studentList=null;

	public StudentListRemoveController(JList<StudentInfoModel> studentList) {
		super();
		this.studentList = studentList;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		((DefaultListModel<StudentInfoModel>)studentList.getModel())
		.removeElement(studentList.getSelectedValue());
	}

}
