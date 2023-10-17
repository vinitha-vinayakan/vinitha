package com.vinitha.resultrequest.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.poi.EncryptedDocumentException;

import com.toedter.calendar.JDateChooser;
import com.vinitha.requestgeneration.ComponentFinder;
import com.vinitha.requestgeneration.Generated_Request;
import com.vinitha.resultrequest.model.ResultExcel;
import com.vinitha.resultrequest.model.ResultModel;
import com.vinitha.resultrequest.model.StudentMarkModel;

public class ResultRequestGenerateController implements ActionListener {
	
	private ComponentFinder finder=null;
	private ResultModel result=null;
	public ResultRequestGenerateController(Container container) {
		super();
		finder=new ComponentFinder(container);
	}
	
	// set data in ResultModel object
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setData() {
		result=new ResultModel();
		result.setCourseName(((JTextField) finder.findComponent("result cname")).getText());
		result.setCourseCode( (String)((JComboBox) finder.findComponent("result ccode ")).getSelectedItem());
		result.setEnteredBy((String)((JComboBox) finder.findComponent("result entered")).getSelectedItem());
		result.setVerifiedBy((String)((JComboBox) finder.findComponent("result verified")).getSelectedItem());
		
		Date date=((JDateChooser)finder.findComponent("exam date")).getDate();
		Formatter formatter=new Formatter();
		if(date!=null) {
			formatter.format("%td %tB %tY", date,date,date);
			result.setExamHeldIn(formatter.toString());
			formatter.close();
		}
		
	    DefaultListModel<StudentMarkModel> model=((DefaultListModel<StudentMarkModel>)((JList)finder
	    		.findComponent("result list")).getModel());
		ArrayList<StudentMarkModel> list=new ArrayList<StudentMarkModel>();
		for (int i = 0; i < model.size(); i++) {
			list.add(model.getElementAt(i));	
		}
		result.setStudentList(list);
		if(result. checkEmpty()) {
			throw new NullPointerException();
		}
		}
	
	
	// event handling for the generate button
	// as a response create an excel file with given data
	// throws exception if excel sheet couldn't create
	// forward to the preview section
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			setData();
			ResultExcel excel=new ResultExcel();
			try {
				excel.basicInformation(result);
				excel.resultSheet(result);
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
		}
		catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot be empty",
					"WARNING EMPTY",JOptionPane.WARNING_MESSAGE);
		}
		

	}

}
