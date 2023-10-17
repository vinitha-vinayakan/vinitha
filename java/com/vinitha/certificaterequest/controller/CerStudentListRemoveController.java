package com.vinitha.certificaterequest.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.vinitha.certificaterequest.model.CertificateInfoModel;

public class CerStudentListRemoveController implements ActionListener {
	
	private JList<CertificateInfoModel> studentList=null;

	public CerStudentListRemoveController(JList<CertificateInfoModel> studentList) {
		super();
		this.studentList = studentList;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		studentList.getSelectedValue();
		((DefaultListModel<CertificateInfoModel>)studentList.getModel()).removeElement(studentList.getSelectedValue());

	}

}
