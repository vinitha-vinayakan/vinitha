package com.vinitha.examrequest.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.vinitha.examrequest.model.PaymentModel;

public class PayListRemoveController implements ActionListener {
	
	private JList<PaymentModel> paymentList=null;

	public PayListRemoveController(JList<PaymentModel> paymentList) {
		super();
		this.paymentList = paymentList;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		((DefaultListModel<PaymentModel>)paymentList.getModel()).removeElement(paymentList.getSelectedValue());
		

	}

}
