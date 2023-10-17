package com.vinitha.certificaterequest.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.poi.EncryptedDocumentException;

import com.vinitha.certificaterequest.model.CertificateExcel;
import com.vinitha.certificaterequest.model.CertificateInfoModel;
import com.vinitha.certificaterequest.model.CertificateRequestModel;
import com.vinitha.requestgeneration.CancelButton;
import com.vinitha.requestgeneration.ComponentFinder;
import com.vinitha.requestgeneration.Generated_Request;

public class CertificateRequestGenerateController implements ActionListener {
	
	private Container container=null;
	private CertificateRequestModel certificate=null;

	public CertificateRequestGenerateController(Container container) {
		super();
		this.container = container;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setData() {
		ComponentFinder finder=new ComponentFinder(container);
		certificate=new CertificateRequestModel();
		certificate.setCourseName((String)((JComboBox) finder.findComponent("cer course")).getSelectedItem());
		certificate.setCategory((String)((JComboBox) finder.findComponent("cer category")).getSelectedItem());
		certificate.setPreparedBy((String)((JComboBox) finder.findComponent("cer prepared")).getSelectedItem());
		certificate.setVerifiedBy((String)((JComboBox) finder.findComponent("cer verified")).getSelectedItem());
		certificate.setRequisitionNo(((JTextField) finder.findComponent("cer requisition")).getText());
		DefaultListModel<CertificateInfoModel> model=((DefaultListModel<CertificateInfoModel>)((JList)finder
	    		.findComponent("cer list")).getModel());
		ArrayList<CertificateInfoModel> list=new ArrayList<CertificateInfoModel>();
		for (int i = 0; i < model.size(); i++) {
			list.add(model.getElementAt(i));	
		}
		certificate.setStudentList(list);
		if (certificate.checkEmpty()) {
			throw new NullPointerException();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			setData();
			CertificateExcel excel=new CertificateExcel();
			try {
				excel.createCertificateSheet(certificate);
				try {
				     Generated_Request frame = new Generated_Request(excel.getExcel().getOutputFile());		
				     frame.setVisible(true);
			          } 
				catch (Exception f) {	
					f.printStackTrace();
					JOptionPane.showMessageDialog(null, "Couldn't load",
							"WARNING",JOptionPane.WARNING_MESSAGE);
			           
				}
			} catch (EncryptedDocumentException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Couldn't create the file",
						"WARNING",JOptionPane.WARNING_MESSAGE);
				
			}
			new CancelButton(container).resetData();
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Couldn't create the request",
					"WARNING",JOptionPane.WARNING_MESSAGE);
		}
		
		
	}

}
