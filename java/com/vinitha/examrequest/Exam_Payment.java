package com.vinitha.examrequest;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vinitha.examrequest.controller.ExamPaymentAddController;
import com.vinitha.examrequest.model.PaymentModel;
import com.vinitha.requestgeneration.CancelButton;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class Exam_Payment extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField dbaTxt;
	private JTextField amountTxt;
	private JLabel label1;
	private JLabel label2;

	
	/**
	 * Create the dialog.
	 */
	public Exam_Payment(JList<PaymentModel> paymentList) {
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
		setTitle("STUDENT PAYMENTS");
		getContentPane().setName("exam fee contentPane");
		setBackground(new Color(221, 160, 221));
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)size.getWidth()/2-225, (int)size.getHeight()/2-134, 450, 264);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 182, 193));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			label1 = new JLabel("DBA Num and Date");
			label1.setName("lbl43");
			label1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		{
			dbaTxt = new JTextField();
			dbaTxt.setName("exam dba");
			dbaTxt.setColumns(10);
		}
		{
			label2 = new JLabel("Paid");
			label2.setName("lbl44");
			label2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		{
			amountTxt = new JTextField();
			amountTxt.setName("exam paid");
			amountTxt.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 182, 193));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add");
				okButton.addActionListener(new ExamPaymentAddController(contentPanel,paymentList));
				GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
				gl_contentPanel.setHorizontalGroup(
					gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(label1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addGap(55)
									.addComponent(dbaTxt, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(label2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(65)
									.addComponent(amountTxt, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))))
				);
				gl_contentPanel.setVerticalGroup(
					gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(dbaTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(3)
									.addComponent(amountTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
				);
				contentPanel.setLayout(gl_contentPanel);
				okButton.setName("exam fee ok");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new CancelButton(getContentPane()));
				cancelButton.setName("exam fee cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
