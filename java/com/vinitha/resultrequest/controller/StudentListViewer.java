package com.vinitha.resultrequest.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import com.vinitha.resultrequest.model.StudentMarkModel;

@SuppressWarnings("serial")
public class StudentListViewer extends  DefaultListCellRenderer {
	
	public StudentListViewer()
	{
		setOpaque(true);
	}

	
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
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
		setText(((StudentMarkModel)value).getStudentId()+"        "+
		         ((StudentMarkModel)value).getStudentName());
		
		return this;
	}
	
}
