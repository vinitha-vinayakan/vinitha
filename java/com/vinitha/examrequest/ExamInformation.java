package com.vinitha.examrequest;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vinitha.examrequest.model.StudentInfoModel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ExamInformation extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ExamInformation(JList<StudentInfoModel> studentList) {

		Image icon=null;
		try {
			icon=ImageIO
					.read(new File("src/main/resources/excel sheets/keltronicon.jpg"))
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(icon);
		setTitle("STUDENT INFORMATION");
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, (int)size.getWidth(),(int)size.getHeight()-60);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane mainScroll = new JScrollPane();
		mainScroll.setName("main scroll");
		mainScroll.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
		contentPane.add(mainScroll, BorderLayout.CENTER);
		Exam_InformationPanel informationPanel=new Exam_InformationPanel(studentList);
		informationPanel.setName("information");
		mainScroll.setViewportView(informationPanel);
	}

}
