package com.vinitha.resultrequest;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;


import com.vinitha.requestgeneration.CancelButton;
import com.vinitha.resultrequest.controller.MarkAddController;
import com.vinitha.resultrequest.model.StudentMarkModel;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Result_Information extends JDialog {
	private JTextField Name_Txt;
	private JTextField Theorymrk_Txt;
	private JTextField Practmrk_Txt;
	private JTextField studentIdTxt;

	/**
	 * Create the dialog.
	 */
	public Result_Information(JList<StudentMarkModel> markList) {
		super();
		setResizable(false);

		Image icon=null;
		try {
			icon=ImageIO
					.read(new File("src/main/resources/excel sheets/keltronicon.jpg"))
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(icon);
		setTitle("STUDENT RESULT");
		getContentPane().setName("mark contentPane");
		getContentPane().setBackground(new Color(173, 216, 230));
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)size.getWidth()/2-225, (int)size.getHeight()/2-161, 450, 322);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setName("mark btnpane");
			buttonPane.setBackground(new Color(176, 224, 230));
			buttonPane.setBounds(0, 237, 434, 49);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton Markadd_Btn = new JButton("Add");
				Markadd_Btn.setFocusPainted(false);
				
				
				Markadd_Btn.setName("mark add");
				
				Markadd_Btn.addActionListener(new MarkAddController(getContentPane(),markList));
				Markadd_Btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
				Markadd_Btn.setBackground(new Color(230, 230, 250));
				Markadd_Btn.setBounds(262, 11, 80, 25);
				Markadd_Btn.setActionCommand("OK");
				buttonPane.add(Markadd_Btn);
				getRootPane().setDefaultButton(Markadd_Btn);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFocusPainted(false);
				cancelButton.addActionListener(new CancelButton(getContentPane()));
				cancelButton.setName("mark cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cancelButton.setBackground(new Color(230, 230, 250));
				cancelButton.setBounds(350, 11, 80, 25);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Student ID");
			lblNewLabel.setName("lbl54");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setBounds(40, 40, 120, 25);
			getContentPane().add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Student Name");
			lblNewLabel_1.setName("lbl55");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(40, 80, 120, 25);
			getContentPane().add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Theory Mark");
			lblNewLabel_2.setName("lbl56");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(40, 120, 120, 25);
			getContentPane().add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Practical Mark");
			lblNewLabel_3.setName("lbl57");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_3.setBounds(40, 160, 120, 25);
			getContentPane().add(lblNewLabel_3);
		}
		{
			Name_Txt = new JTextField();
			Name_Txt.setName("mark name");
			Name_Txt.setBounds(200, 80, 150, 25);
			getContentPane().add(Name_Txt);
			Name_Txt.setColumns(10);
		}
		{
			Theorymrk_Txt = new JTextField();
			Theorymrk_Txt.setName("theory mark");
			Theorymrk_Txt.setBounds(200, 120, 150, 25);
			getContentPane().add(Theorymrk_Txt);
			Theorymrk_Txt.setColumns(10);
		}
		{
			Practmrk_Txt = new JTextField();
			Practmrk_Txt.setName("practical mark");
			Practmrk_Txt.setBounds(200, 160, 150, 25);
			getContentPane().add(Practmrk_Txt);
			Practmrk_Txt.setColumns(10);
		}
		
		studentIdTxt = new JTextField();
		studentIdTxt.setName("mark id");
		studentIdTxt.setBounds(200, 40, 150, 26);
		getContentPane().add(studentIdTxt);
		studentIdTxt.setColumns(10);
	}
}
