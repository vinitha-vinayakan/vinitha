package com.vinitha.examrequest.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.vinitha.examrequest.model.PaymentModel;
import com.vinitha.requestgeneration.CancelButton;
import com.vinitha.requestgeneration.ComponentFinder;

public class ExamPaymentAddController implements ActionListener {
	
	private Container container=null;
	private JList<PaymentModel> paymentList=null;
	private PaymentModel payment=null;

	
	public ExamPaymentAddController(Container container, JList<PaymentModel> paymentList) {
		super();
		this.container = container;
		this.paymentList = paymentList;
	}
	public void setdata() {
		ComponentFinder finder=new ComponentFinder(container);
		payment=new PaymentModel();
		payment.setDbaNumDate(((JTextField)finder.findComponent("exam dba")).getText());
		try {
			payment.setAmount(Integer.parseInt(((JTextField)finder.findComponent("exam paid")).getText()));
		}
		finally {
			if (payment.checkEmpty()) {
				throw new NullPointerException();
			}
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			setdata();
			((DefaultListModel<PaymentModel>)(paymentList.getModel())).addElement(payment);
			new CancelButton(container).resetData();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Please enter valid data","WARNING",
					JOptionPane.WARNING_MESSAGE);
		}
		

	}

}
