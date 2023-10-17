package com.vinitha.examrequest.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.poi.EncryptedDocumentException;

import com.toedter.calendar.JDateChooser;
import com.vinitha.examrequest.model.ExamExcel;
import com.vinitha.examrequest.model.ExamRequestModel;
import com.vinitha.examrequest.model.StudentInfoModel;
import com.vinitha.requestgeneration.CancelButton;
import com.vinitha.requestgeneration.ComponentFinder;
import com.vinitha.requestgeneration.Generated_Request;

public class ExamRequestGenerateController implements ActionListener {
	
	private Container container=null;
	private ExamRequestModel examRequest=null;

	public ExamRequestGenerateController(Container container) {
		super();
		this.container = container;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setData() {
		ComponentFinder finder=new ComponentFinder(container);
		examRequest=new ExamRequestModel();
		examRequest.setCourseName(((JTextField) finder.findComponent("exam cname")).getText());
		examRequest.setCourseCode((String)((JComboBox) finder.findComponent("exam ccode")).getSelectedItem());
		examRequest.setSemesterNo((String)((JComboBox) finder.findComponent("exam semno")).getSelectedItem());
		examRequest.setPreparedBy((String)((JComboBox) finder.findComponent("exam prepared")).getSelectedItem());
		examRequest.setVerifiedBy((String)((JComboBox) finder.findComponent("exam verified")).getSelectedItem());
		examRequest.setExamRequisitionNo(((JTextField) finder.findComponent("exam erno")).getText());
		Date date=((JDateChooser)finder.findComponent("date chooser")).getDate();
		if(date!=null) {
			examRequest.setDate(date);
			date=null;
		}
		date=((JDateChooser)finder.findComponent("proposed date")).getDate();
			if(date!=null) {
				examRequest.setProposedExamDate(date);
			}
	    DefaultListModel<StudentInfoModel> model=((DefaultListModel<StudentInfoModel>)((JList)finder
			    		.findComponent("examStudentList")).getModel());
		ArrayList<StudentInfoModel> list=new ArrayList<StudentInfoModel>();
		for (int i = 0; i < model.size(); i++) {
			list.add(model.getElementAt(i));	
		}
		examRequest.setExamStudentList(list);
		if (examRequest.checkEmpty()) {
			throw new NullPointerException();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			setData();
			ExamExcel excel=new ExamExcel();
			try {
				excel.createExamSheet(examRequest);
				try {
				     Generated_Request frame = new Generated_Request(excel.getExcel().getOutputFile());		
				     frame.setVisible(true);
			          } 
				catch (Exception f) {	
					f.printStackTrace();
					JOptionPane.showMessageDialog(null, "Couldn't load",
							"WARNING",JOptionPane.WARNING_MESSAGE);
			           
				}
			} catch (EncryptedDocumentException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Couldn't create the file",
						"WARNING",JOptionPane.WARNING_MESSAGE);
				
			}
			new CancelButton(container).resetData();
			
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Couldn't create the file",
					"WARNING",JOptionPane.WARNING_MESSAGE);
		}
		
		
	}

}
