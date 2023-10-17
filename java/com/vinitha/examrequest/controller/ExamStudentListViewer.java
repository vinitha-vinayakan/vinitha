package com.vinitha.examrequest.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.vinitha.examrequest.model.StudentInfoModel;

@SuppressWarnings("serial")
public class ExamStudentListViewer extends JLabel implements ListCellRenderer<StudentInfoModel> {
	
	public ExamStudentListViewer()
	{
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends StudentInfoModel> list, StudentInfoModel value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
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
		setText(value.getStudent().getRollNo()+"    "+value.getStudent(). getNameOfStudent());
		
		return this;
	}
	
	

}
