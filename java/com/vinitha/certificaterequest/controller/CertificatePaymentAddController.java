package com.vinitha.certificaterequest.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.vinitha.examrequest.model.PaymentModel;
import com.vinitha.requestgeneration.CancelButton;
import com.vinitha.requestgeneration.ComponentFinder;

public class CertificatePaymentAddController implements ActionListener {
	
	private Container container=null;
	private JList<PaymentModel> paymentList=null;
	private PaymentModel payment=null;

	
	public CertificatePaymentAddController(Container container, JList<PaymentModel> paymentList) {
		super();
		this.container = container;
		this.paymentList = paymentList;
	}
	private void setData() {
		ComponentFinder finder=new ComponentFinder(container);
		payment=new PaymentModel();
		try {
			payment.setAmount(Integer.parseInt(((JTextField) finder.findComponent("cer amount")).getText()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (((JRadioButton) finder.findComponent("cer cash")).isSelected()) {
			payment.setMode("CASH");
		}
		payment.setDbaNumDate(((JTextField) finder.findComponent("cer dba")).getText());
		if (payment.checkEmpty()) {
			throw new NullPointerException();
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			setData();
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
