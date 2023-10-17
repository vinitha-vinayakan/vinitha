package com.vinitha.resultrequest.controller;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.vinitha.requestgeneration.CancelButton;
import com.vinitha.requestgeneration.ComponentFinder;
import com.vinitha.resultrequest.model.StudentMarkModel;

public class MarkAddController implements ActionListener {

	private Container container=null;
	private ComponentFinder finder=null;
	private JList<StudentMarkModel> markList=null;

	public MarkAddController(Container container,JList<StudentMarkModel> markList) {
		
		this.container = container;
		this.markList=markList;
		finder=new ComponentFinder(container);
	}

	// read student marks and set student in list
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		StudentMarkModel student=new StudentMarkModel();
		student.setStudentId(((JTextField) finder.findComponent("mark id")).getText());
	    student.setStudentName(((JTextField)finder.findComponent("mark name")).getText());
	    try {
	    	student.setTheoryMark(Integer.parseInt(((JTextField)finder.findComponent("theory mark"))
	    			.getText().trim()));
			student.setPracticalMark(Integer.parseInt(((JTextField)finder.findComponent("practical mark"))
					.getText().trim()));
			try {
				if (student.checkEmpty()) {
					throw new NullPointerException();	
				}
			}
			 catch (NullPointerException e) {
					// TODO: handle exception
			    	JOptionPane.showMessageDialog(null, "Please enter all fields\n mark should be between 0 and 100",
			    			"WARNING",JOptionPane.WARNING_MESSAGE);
			    	
				}
			((DefaultListModel<StudentMarkModel>)(markList.getModel())).addElement(student);
			new CancelButton(container).resetData();
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	    catch (Exception e2) {
			// TODO: handle exception
	    	e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Please enter number","WARNING",
					JOptionPane.WARNING_MESSAGE);
		}
		
	}

}
