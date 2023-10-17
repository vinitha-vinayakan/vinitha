package com.vinitha.certificaterequest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vinitha.certificaterequest.controller.CerStudentListRemoveController;
import com.vinitha.certificaterequest.controller.CertificateRequestGenerateController;
import com.vinitha.certificaterequest.controller.CertificateStudentListViewer;
import com.vinitha.certificaterequest.model.CertificateInfoModel;
import com.vinitha.requestgeneration.CancelButton;
import com.vinitha.requestgeneration.CourseController;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CertificateRequest extends JFrame {

	private JPanel contentPane;
	private JTextField reqNoTxt; 
	private JList<CertificateInfoModel> studentList;
	

	/**
	 * Create the frame.
	 */
	public CertificateRequest() {
		setResizable(false);
		setTitle("CERITICATE REQUEST");
		Image icon=null;
		try {
			icon=ImageIO
					.read(new File("src/main/resources/excel sheets/keltronicon.jpg"))
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(icon);
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)size.getWidth()/2-306,(int)size.getHeight()/2-236, 612, 472);
		contentPane = new JPanel();
		contentPane.setName("cer course contentpane");
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Course Name");
		label1.setName("lbl22");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label1.setBounds(30, 50, 110, 25);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Category");
		label2.setName("lbl23");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label2.setBounds(30, 90, 110, 25);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Requisition No");
		label3.setName("lbl24");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label3.setBounds(30, 130, 110, 25);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("Prepared By");
		label4.setName("lbl25");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label4.setBounds(325, 90, 110, 25);
		contentPane.add(label4);
		
		JLabel label5 = new JLabel("Verified By");
		label5.setName("lbl26");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label5.setBounds(325, 130, 110, 25);
		contentPane.add(label5);
		
		JComboBox<String> courseCB = new JComboBox<String>();
		DefaultComboBoxModel<String> model=new DefaultComboBoxModel<String>();
		model.addAll(CourseController.COURSE);
		courseCB.setModel(model);
		courseCB.setSelectedIndex(0);
		courseCB.setName("cer course");
		courseCB.setBounds(150, 50, 300, 25);
		contentPane.add(courseCB);
		final String category[]= {"A(CERTIFICATE:GENERAL)",
				"B(DIPLOMA:GENERAL)"};
		
		JComboBox<String>categoryCB = new JComboBox<String>();
		categoryCB.setModel(new DefaultComboBoxModel<String>(category));
		categoryCB.setSelectedIndex(0);
		categoryCB.setName("cer category");
		categoryCB.setBounds(150, 90, 130, 25);
		contentPane.add(categoryCB);
		
		reqNoTxt = new JTextField();
		reqNoTxt.setName("cer requisition");
		reqNoTxt.setBounds(150, 130, 130, 25);
		contentPane.add(reqNoTxt);
		reqNoTxt.setColumns(10);
		
		JButton addStudentBtn = new JButton("ADD STUDENT");
		addStudentBtn.setFocusPainted(false);
		addStudentBtn.setBackground(new Color(206, 157, 255));
		addStudentBtn.setName("cer add std");
		
		addStudentBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		addStudentBtn.setBounds(310, 250, 150, 25);
		contentPane.add(addStudentBtn);
		
		JButton generateBtn = new JButton("GENERATE");
		generateBtn.setFocusPainted(false);
		generateBtn.setBackground(new Color(206, 157, 255));
		generateBtn.setName("cer generate");
		generateBtn.addActionListener(new CertificateRequestGenerateController(contentPane));
		generateBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		generateBtn.setBounds(35, 380, 130, 25);
		contentPane.add(generateBtn);
		
		JButton cancelBtn = new JButton("CANCEL");
		cancelBtn.setBackground(new Color(206, 157, 255));
		cancelBtn.setFocusPainted(false);
		cancelBtn.addActionListener(new CancelButton(contentPane));
		cancelBtn.setName("cer course cancel");
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		cancelBtn.setBounds(425, 380, 100, 25);
		contentPane.add(cancelBtn);
		
		String Faculty[]= {"ANJU P S",
				"AJIMOL A V",
				"AJITH YESUDAS",
				"AKHILA",
				"RENJU"		
		};
		JComboBox<String> preparedCB = new JComboBox<String>();
		preparedCB.setModel(new DefaultComboBoxModel<String>(Faculty));
		preparedCB.setName("cer prepared");
		preparedCB.setSelectedIndex(0);
		preparedCB.setBounds(435, 90, 120, 25);
		contentPane.add(preparedCB);
		
		String Verifiedby[]= {"ANJU P S",
				"AJITH YESUDAS",
				"AKHILA"		
		};
		JComboBox<String> verifiedCB = new JComboBox<String>();
		verifiedCB.setName("cer verified");
		
		verifiedCB.setModel(new DefaultComboBoxModel<String>(Verifiedby));
		verifiedCB.setSelectedIndex(0);
		verifiedCB.setBounds(435, 130, 120, 25);
		contentPane.add(verifiedCB);
		
		JLabel label6 = new JLabel("Added Student List");
		label6.setName("lbl27");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label6.setBounds(57, 180, 223, 25);
		contentPane.add(label6);
		
		JScrollPane studentScroll = new JScrollPane();
		studentScroll.setName("cer scrollpane");
		studentScroll.setBounds(57, 216, 206, 140);
		contentPane.add(studentScroll);
		
		studentList = new JList<CertificateInfoModel>();
		studentList.setModel(new DefaultListModel<CertificateInfoModel>());
		studentList.setCellRenderer(new CertificateStudentListViewer());
		studentList.setName("cer list");
		studentScroll.setViewportView(studentList);
		addStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CertificateInformation frame = new CertificateInformation(studentList);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton removeBtn = new JButton("REMOVE");
		removeBtn.setFocusPainted(false);
		removeBtn.setBackground(new Color(206, 157, 255));
		removeBtn.addActionListener(new CerStudentListRemoveController(studentList));
		removeBtn.setName("course remove");
		removeBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		removeBtn.setBounds(310, 291, 150, 25);
		contentPane.add(removeBtn);
		
		JLabel mainHeading = new JLabel("CERTIFICATE REQUEST");
		mainHeading.setOpaque(true);
		mainHeading.setHorizontalAlignment(SwingConstants.CENTER);
		mainHeading.setHorizontalTextPosition(SwingConstants.CENTER);
		mainHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
		mainHeading.setBackground(new Color(206, 157, 255));
		mainHeading.setBounds(0, 0, 598, 39);
		contentPane.add(mainHeading);
	}
}
