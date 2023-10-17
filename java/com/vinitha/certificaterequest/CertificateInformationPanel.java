package com.vinitha.certificaterequest;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.vinitha.certificaterequest.controller.CerPayListRemoveController;
import com.vinitha.certificaterequest.controller.CertificateInfoAddController;
import com.vinitha.certificaterequest.controller.CertificatePayListViewer;
import com.vinitha.certificaterequest.model.CertificateInfoModel;
import com.vinitha.examrequest.model.PaymentModel;
import com.vinitha.requestgeneration.CancelButton;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

@SuppressWarnings("serial")
public class CertificateInformationPanel extends JPanel {

	private JTextField nameTxt;
	private JTextField gradeTxt;
	private JTextField resultTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField attendenceTxt;
	private JList<PaymentModel> paymentList;
	private JTextField rollNoTxt;
	private JTextField batchTxt;

	

	/**
	 * Create the frame.
	 */
	public CertificateInformationPanel(JList<CertificateInfoModel> studentList) {
		
		setBounds(0, 0, 617, 901);
		
		setName("cer_info_contentpane");
		setBackground(new Color(255, 245, 238));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel mainHeading = new JLabel("ADDITIONAL INFORMATION");
		mainHeading.setHorizontalTextPosition(SwingConstants.CENTER);
		mainHeading.setOpaque(true);
		mainHeading.setHorizontalAlignment(SwingConstants.CENTER);
		mainHeading.setBackground(new Color(255, 140, 85));
		mainHeading.setName("lbl3");
		mainHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel subHead1 = new JLabel("STUDENT DETAILES");
		subHead1.setName("lbl4");
		subHead1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JSeparator separator2 = new JSeparator();
		separator2.setName("sep1");
		
		JSeparator separator1 = new JSeparator();
		separator1.setName("sep2");
		
		JLabel label1 = new JLabel("Roll No");
		label1.setName("lbl5");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label2 = new JLabel("Name of Student");
		label2.setName("lbl6");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 13));
	
		nameTxt = new JTextField();
		nameTxt.setName("cer std name");
		nameTxt.setColumns(10);
		
		JLabel label3 = new JLabel("Verified the name w.r.t SSLC front page");
		label3.setName("lbl7");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton yesRB = new JRadioButton("Yes");
		yesRB.setSelected(true);
		yesRB.setOpaque(false);
		yesRB.setName("cer yes");
		yesRB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(yesRB);
		
		JRadioButton noRB = new JRadioButton("No");
		noRB.setOpaque(false);
		noRB.setName("cer no");
		noRB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(noRB);
		
		JSeparator separator3 = new JSeparator();
		separator3.setName("sep3");
		
		JLabel subHead2 = new JLabel("BATCH DETAILES");
		subHead2.setName("lbl8");
		subHead2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JSeparator separator4 = new JSeparator();
		separator4.setName("sep4");
		
		JLabel label7 = new JLabel("Batch No");
		label7.setName("lbl9");
		label7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label8 = new JLabel("Start Date");
		label8.setName("lbl10");
		label8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label9 = new JLabel("End Date");
		label9.setName("lbl11");
		label9.setFont(new Font("Tahoma", Font.PLAIN, 13));
	
		JSeparator separator5 = new JSeparator();
		separator5.setName("sep5");
		
		JLabel subHead3 = new JLabel("EXAM DETAILES");
		subHead3.setName("lbl12");
		subHead3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JSeparator separator6 = new JSeparator();
		separator6.setName("sep6");
		
		JLabel label11 = new JLabel("Exam Held On");
		label11.setName("lbl13");
		label11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label10 = new JLabel("Grade");
		label10.setName("lbl14");
		label10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label4 = new JLabel("Result Code");
		label4.setName("lbl15");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label5 = new JLabel("Attend %");
		label5.setName("lbl16");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		gradeTxt = new JTextField();
		gradeTxt.setName("cer grade");
		gradeTxt.setColumns(10);
		
		resultTxt = new JTextField();
		resultTxt.setName("cer result");
		resultTxt.setColumns(10);
		
		JSeparator separator7 = new JSeparator();
		separator7.setName("sep7");
		
		JLabel subHead4 = new JLabel(" FEE DETAILES");
		subHead4.setName("lbl17");
		subHead4.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JSeparator separator8 = new JSeparator();
		separator8.setName("sep8");
		
		JLabel label6 = new JLabel("Payment Details");
		label6.setName("lbl18");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton paymentBtn = new JButton("ADD PAYMENT");
		paymentBtn.setFocusPainted(false);
		paymentBtn.setName("cer payment add");
		
		paymentBtn.setBackground(new Color(255, 140, 85));
		paymentBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JSeparator separator9 = new JSeparator();
		separator9.setName("sep9");
		
		JButton addBtn = new JButton("ADD");
		addBtn.setFocusPainted(false);
		addBtn.setMaximumSize(new Dimension(175, 23));
		addBtn.addActionListener(new CertificateInfoAddController(this,studentList));
			
		addBtn.setName("cer add");
		addBtn.setBackground(new Color(255, 140, 85));
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton Cancel_Btn = new JButton("CANCEL");
		Cancel_Btn.setFocusPainted(false);
		Cancel_Btn.setMaximumSize(new Dimension(175, 23));
		Cancel_Btn.addActionListener(new CancelButton(this));
		Cancel_Btn.setName("cer cancel");
		Cancel_Btn.setBackground(new Color(255, 140, 85));
		Cancel_Btn.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		attendenceTxt = new JTextField();
		attendenceTxt.setName("cer attend");
		attendenceTxt.setColumns(10);
		
		JScrollPane paymentScroll = new JScrollPane();
		paymentScroll.setName("details scroll");
		
	    paymentList= new JList<PaymentModel>();
		paymentList.setModel(new DefaultListModel<PaymentModel>());
		paymentList.setCellRenderer(new CertificatePayListViewer());
		paymentList.setName("paylist");
		paymentList.setBorder(new LineBorder(new Color(0, 0, 0)));
		paymentList.setToolTipText("");
		paymentScroll.setViewportView(paymentList);
		paymentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CertificatePayment dialog = new CertificatePayment(paymentList);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		
		JButton removeBtn = new JButton("REMOVE");
		removeBtn.setFocusPainted(false);
		removeBtn.setBackground(new Color(255, 140, 85));
		removeBtn.addActionListener(new CerPayListRemoveController(paymentList));
		removeBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		removeBtn.setName("pay remove");
		
		rollNoTxt = new JTextField();
		rollNoTxt.setName("roll no");
		rollNoTxt.setColumns(10);
		
		batchTxt = new JTextField();
		batchTxt.setName("batch");
		batchTxt.setColumns(10);
		
		JDateChooser startDate = new JDateChooser();
		startDate.getCalendarButton().setName("start calender");
		startDate.setName("start date");
		startDate.setDateFormatString("dd-MMM-y");
		((JTextFieldDateEditor)startDate.getDateEditor()).setEditable(false);
		
		JDateChooser endDate = new JDateChooser();
		endDate.getCalendarButton().setName("end calender");
		endDate.setName("end date");
		endDate.setDateFormatString("dd-MMM-y");
		((JTextFieldDateEditor)endDate.getDateEditor()).setEditable(false);
		
		JDateChooser examDate = new JDateChooser();
		examDate.getCalendarButton().setName("exam calender");
		examDate.setName("exam date");
		examDate.setDateFormatString("dd-MMM-y");
		((JTextFieldDateEditor)examDate.getDateEditor()).setEditable(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(mainHeading, GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(separator2, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
					.addGap(26))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(label1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(rollNoTxt, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(label2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(label3, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(yesRB, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(noRB, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(separator4, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
					.addGap(26))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(separator6, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
					.addGap(26))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(label4, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(resultTxt, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addGap(392))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(label5, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(attendenceTxt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(label6, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(paymentBtn, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(removeBtn, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addComponent(paymentScroll, GroupLayout.PREFERRED_SIZE, 256, 300)
					.addContainerGap(118, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(separator9, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
					.addGap(26))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(218)
					.addComponent(addBtn, GroupLayout.PREFERRED_SIZE, 175, 175)
					.addPreferredGap(ComponentPlacement.RELATED, 80, 80)
					.addComponent(Cancel_Btn, GroupLayout.PREFERRED_SIZE, 175, 175)
					.addGap(89))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label7, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(label8, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(label9, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(batchTxt, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(endDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(startDate, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
					.addGap(337))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label10, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(label11, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(examDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(gradeTxt, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
					.addGap(337))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(subHead1)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator1, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
							.addGap(26))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(subHead2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator3, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
							.addGap(26))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(subHead3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator5, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
							.addGap(26))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(subHead4, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator7, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
							.addGap(26))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator8, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(mainHeading, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(rollNoTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(yesRB))
								.addComponent(noRB)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(subHead1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(separator4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(batchTxt, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addComponent(label9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(startDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(endDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(subHead2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(separator6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(examDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(gradeTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(resultTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(attendenceTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addComponent(subHead3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(subHead4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(206))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(separator8, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label6, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
									.addGap(112))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(paymentBtn)
									.addGap(11)
									.addComponent(removeBtn))
								.addComponent(paymentScroll, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addComponent(separator9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(addBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(Cancel_Btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(12))))
		);
		setLayout(groupLayout);
	}
}
