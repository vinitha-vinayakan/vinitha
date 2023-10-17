package com.vinitha.certificaterequest.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import com.toedter.calendar.JDateChooser;
import com.vinitha.certificaterequest.model.CertificateInfoModel;
import com.vinitha.examrequest.model.Batch;
import com.vinitha.examrequest.model.PaymentModel;
import com.vinitha.examrequest.model.Student;
import com.vinitha.requestgeneration.ComponentFinder;

public class CertificateInfoAddController implements ActionListener {
	
	private Container container=null;
	private JList<CertificateInfoModel> studentList=null;
	private CertificateInfoModel studentInfo=null;

	public CertificateInfoAddController(Container container, JList<CertificateInfoModel> studentList) {
		super();
		this.container = container;
		this.studentList = studentList;
		
		}
	@SuppressWarnings("unchecked")
	private void setData() {
		 ComponentFinder finder=new ComponentFinder(container); 
		 studentInfo=new CertificateInfoModel();
		 Student student=new Student();
		 
		 student.setRollNo(((JTextField)finder.findComponent("roll no")).getText());
		 student.setNameOfStudent(((JTextField)finder.findComponent("cer std name")).getText());
		 
		 Batch batch= new Batch();
		 batch.setBatchNumber(((JTextField)finder.findComponent("batch")).getText());
		 Date date=((JDateChooser)finder.findComponent("start date")).getDate();
			if(date!=null) {
				batch.setStartDate(date);
				date=null;
			}
			date=((JDateChooser)finder.findComponent("end date")).getDate();
			if(date!=null) {
				batch.setEndDate(date);
				date=null;
			}
			if (batch.checkEmpty2()) {
				throw new NullPointerException();
			}
			 @SuppressWarnings("rawtypes")
			DefaultListModel<PaymentModel> model=((DefaultListModel<PaymentModel>)((JList)finder
			    		.findComponent("paylist")).getModel());
				ArrayList<PaymentModel> list=new ArrayList<PaymentModel>();
				for (int i = 0; i < model.size(); i++) {
					list.add(model.getElementAt(i));	
				}
				student.setPayments(list);
				student.setBatch(batch);
				if (student.checkEmpty()) {
					throw new NullPointerException();
				}
		
		studentInfo.setStudent(student);
		try {
			studentInfo.setAttend(Integer.parseInt(((JTextField)finder.findComponent("cer attend")).getText()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		studentInfo.setGrade(((JTextField)finder.findComponent("cer grade")).getText());
		studentInfo.setResultCode(((JTextField)finder.findComponent("cer result")).getText());
		date=((JDateChooser)finder.findComponent("exam date")).getDate();
		if(date!=null) {
			studentInfo.setExamHeldOn(date);
			date=null;
		}
		if (((JRadioButton)finder.findComponent("cer no")).isSelected()) {
			studentInfo.setSSLCName("NO");	
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			 setData();
			 ((DefaultListModel<CertificateInfoModel>)(studentList.getModel())).addElement(studentInfo);
				
			} catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Couldn't create the student",
						"WARNING",JOptionPane.WARNING_MESSAGE);
			}
		
		 
	}

}
