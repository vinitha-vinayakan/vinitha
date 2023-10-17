package com.vinitha.certificaterequest;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vinitha.certificaterequest.model.CertificateInfoModel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class CertificateInformation extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CertificateInformation(JList<CertificateInfoModel> list) {
		
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, (int)size.getWidth(),(int) size.getHeight()-60);
		contentPane = new JPanel();
		contentPane.setName("content");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setName("main scroll");
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension());
		contentPane.add(scrollPane, BorderLayout.CENTER);
		CertificateInformationPanel informationPanel=new CertificateInformationPanel(list);
		scrollPane.setViewportView(informationPanel);
	}

}
