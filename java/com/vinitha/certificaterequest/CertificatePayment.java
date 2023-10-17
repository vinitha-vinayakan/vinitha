package com.vinitha.certificaterequest;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vinitha.certificaterequest.controller.CertificatePaymentAddController;
import com.vinitha.examrequest.model.PaymentModel;
import com.vinitha.requestgeneration.CancelButton;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class CertificatePayment extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField amountTxt;
	private JTextField dbaTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Create the dialog.
	 */
	public CertificatePayment(JList<PaymentModel> paymenList) {
		
		Image icon=null;
		try {
			icon=ImageIO
					.read(new File("src/main/resources/excel sheets/keltronicon.jpg"))
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(icon);
		setName("pay dialog");
		getContentPane().setName("cer payment contentPane");
		setTitle("PAYMENT");
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)size.getWidth()/2-225, (int)size.getHeight()/2-138, 450, 277);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setName("cer pay contentpane");
		contentPanel.setBackground(new Color(255, 192, 203));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label1 = new JLabel("Amount");
			label1.setName("lbl19");
			label1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label1.setBounds(45, 45, 110, 25);
			contentPanel.add(label1);
		}
		{
			JLabel label2 = new JLabel("Mode");
			label2.setName("lbl20");
			label2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label2.setBounds(45, 85, 110, 25);
			contentPanel.add(label2);
		}
		{
			JLabel label3 = new JLabel("DBA No");
			label3.setName("lbl21");
			label3.setBackground(new Color(176, 224, 230));
			label3.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label3.setBounds(45, 125, 110, 25);
			contentPanel.add(label3);
		}
		{
			amountTxt = new JTextField();
			amountTxt.setName("cer amount");
			amountTxt.setBounds(165, 45, 120, 25);
			contentPanel.add(amountTxt);
			amountTxt.setColumns(10);
		}
		{
			dbaTxt = new JTextField();
			dbaTxt.setName("cer dba");
			dbaTxt.setBounds(165, 130, 165, 25);
			contentPanel.add(dbaTxt);
			dbaTxt.setColumns(10);
		}
		{
			JRadioButton onlineRB = new JRadioButton("Online");
			onlineRB.setSelected(true);
			onlineRB.setOpaque(false);
			onlineRB.setName("cer online");
			onlineRB.setFont(new Font("Tahoma", Font.PLAIN, 13));
			buttonGroup.add(onlineRB);
			onlineRB.setBounds(165, 85, 85, 25);
			contentPanel.add(onlineRB);
		}
		{
			JRadioButton cashRB = new JRadioButton("Cash");
			cashRB.setOpaque(false);
			cashRB.setName("cer cash");
			cashRB.setFont(new Font("Tahoma", Font.PLAIN, 13));
			buttonGroup.add(cashRB);
			cashRB.setBounds(264, 85, 85, 25);
			contentPanel.add(cashRB);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setName("cer pay btnpane");
			buttonPane.setBackground(new Color(255, 192, 203));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addBtn = new JButton("ADD");
				addBtn.setFocusPainted(false);
				addBtn.setBackground(new Color(255, 105, 180));
				addBtn.addActionListener(new CertificatePaymentAddController(contentPanel,paymenList));
				addBtn.setName("cer pay add ");
				addBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
				addBtn.setActionCommand("OK");
				buttonPane.add(addBtn);
				getRootPane().setDefaultButton(addBtn);
			}
			{
				JButton Cancel_Btn = new JButton("CANCEL");
				Cancel_Btn.setFocusPainted(false);
				Cancel_Btn.setBackground(new Color(240, 128, 128));
				Cancel_Btn.addActionListener(new CancelButton(getContentPane()));
				Cancel_Btn.setName("cer pay cancel");
				Cancel_Btn.setFont(new Font("Tahoma", Font.BOLD, 15));
				Cancel_Btn.setActionCommand("Cancel");
				buttonPane.add(Cancel_Btn);
			}
		}
	}

}
