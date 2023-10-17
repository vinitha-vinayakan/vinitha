package com.vinitha.examrequest.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.toedter.calendar.JDateChooser;
import com.vinitha.examrequest.model.Batch;
import com.vinitha.examrequest.model.PaymentModel;
import com.vinitha.examrequest.model.Student;
import com.vinitha.examrequest.model.StudentInfoModel;
import com.vinitha.requestgeneration.CancelButton;
import com.vinitha.requestgeneration.ComponentFinder;
import com.vinitha.requestgeneration.HibernateOperation;


public class ExamInfoAddController implements ActionListener {
	
	private Container container=null;
	private JList<StudentInfoModel> studentList=null;
	private Student student=null;
	private Batch batch=null;
	private StudentInfoModel studentInfo=null;

	public ExamInfoAddController(Container container,JList<StudentInfoModel> studentList) {
		super();
		this.container = container;
		this.studentList = studentList;	
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setData() {
		studentInfo=new StudentInfoModel();
		ComponentFinder finder=new ComponentFinder(container);
		
		batch=new Batch();
		batch.setBatchNumber(((JTextField) finder.findComponent("batch number")).getText());
		Date date=((JDateChooser)finder.findComponent("start date")).getDate();
		if(date!=null) {
			batch.setStartDate(date);
			date=null;
		}
		date=((JDateChooser)finder.findComponent("end date")).getDate();
		if(date!=null) {
			batch.setEndDate(date);
		}
		try {
			batch.setStudentsInBatch(Integer.parseInt(((JTextField) finder.findComponent("exm nsbatch"))
					.getText()));
		} finally {
		
		if (batch.checkEmpty()) {
			throw new NullPointerException();
		}
		}
		student=new Student();
		student.setNameOfStudent(((JTextField) finder.findComponent("exam name")).getText());
		student.setRollNo(((JTextField) finder.findComponent("roll no")).getText());
		student.setBatch(batch);
		Session session=HibernateOperation.createSession(
				new Class[] {Student.class,Batch.class,PaymentModel.class});
		Transaction transaction= session.beginTransaction();
	    DefaultListModel<PaymentModel> model=((DefaultListModel<PaymentModel>)((JList)finder
	    		.findComponent("payment list")).getModel());
		ArrayList<PaymentModel> list=new ArrayList<PaymentModel>();
		for (int i = 0; i < model.size(); i++) {
			list.add(model.getElementAt(i));
			session.save(model.getElementAt(i));
		}
		student.setPayments(list);
		
		if (student.checkEmpty()) {
			throw new NullPointerException();
			
		}
	     
		session.save(batch);
		session.save(student);
		
		transaction.commit();
		session.close();
		studentInfo.setStudent(student);
		studentInfo.setStudentsForExam(Integer.parseInt(((JTextField) finder.findComponent("exm nsexam"))
				.getText()));
		try {
		studentInfo.setBalance(Integer.parseInt(((JTextField) finder.findComponent("exm balance"))
				.getText()));
		}catch (Exception e) {
			// TODO: handle exception
		}
		studentInfo.setRemarks(((JTextArea) finder.findComponent("exm remarks")).getText());
		if (((JRadioButton) finder.findComponent("exm no")).isSelected()) {
			studentInfo.setNoDueClearance("No");
		}
		else {
			studentInfo.setNoDueClearance("");
		}
		if (studentInfo.checkEmpty()) {
			throw new NullPointerException();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			setData();
			// persist student class
			((DefaultListModel<StudentInfoModel>)(studentList.getModel())).addElement(studentInfo);
			new CancelButton(container).resetData();
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Couldn't create the student",
					"WARNING",JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		
	}

}
