package com.vinitha.certificaterequest.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.vinitha.examrequest.model.PaymentModel;

@SuppressWarnings("serial")
public class CertificatePayListViewer extends JLabel implements ListCellRenderer<PaymentModel> {
	
	public CertificatePayListViewer()
	{
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends PaymentModel> list, PaymentModel value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		Color background;
		Color foreground;
		
		JList.DropLocation dropLocation=list.getDropLocation();
		if(dropLocation !=null
				&& !dropLocation.isInsert()
				&& dropLocation.getIndex()==index) {
			
			background=Color.BLUE;
			foreground=Color.WHITE;
		}
		else if(isSelected) {
			
			background=Color.BLUE;
			foreground=Color.WHITE;
		}
		else {
			
			background=Color.WHITE;
			foreground=Color.BLACK;
		};
		
		setBackground(background);
		setForeground(foreground);
		setFont((new Font("Lucida Fax", Font.BOLD, 12)));
		setText(value.getDbaNumDate()+"    "+value.getAmount());
		
		
		return this;
	}
	

}
