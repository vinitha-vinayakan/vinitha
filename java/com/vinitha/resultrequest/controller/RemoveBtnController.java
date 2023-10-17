package com.vinitha.resultrequest.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.vinitha.resultrequest.model.StudentMarkModel;

public class RemoveBtnController implements ActionListener {
	
	private JList<StudentMarkModel> markList=null;
	
	public RemoveBtnController(JList<StudentMarkModel> markList) {
		this.markList = markList;
	}
	
	//remove the selected student from the list

	@Override
	public void actionPerformed(ActionEvent e) {
		
		((DefaultListModel<StudentMarkModel>)markList.getModel()).removeElement(markList.getSelectedValue());
		
	}

}
