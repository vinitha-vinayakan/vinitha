package com.vinitha.examrequest;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.vinitha.examrequest.controller.ExamInfoAddController;
import com.vinitha.examrequest.controller.ExamPayListViewer;
import com.vinitha.examrequest.controller.PayListRemoveController;
import com.vinitha.examrequest.model.StudentInfoModel;
import com.vinitha.examrequest.model.PaymentModel;
import com.vinitha.requestgeneration.CancelButton;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.BorderLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class Exam_InformationPanel extends JPanel {

	private JPanel contentPane;
	private JTextField nameText;
	private JTextField batchStudentNoTxt;
	private JTextField examStudentNoTxt;
	private JTextField balanceTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JList<PaymentModel> paymentList;
	private JTextField batchNoTxt;
	private JTextField rollnoTxt;

	
	/**
	 * Create the frame.
	 */
	public Exam_InformationPanel(JList<StudentInfoModel> studentList) {
		
		setBounds(0,0, 660, 798);
		contentPane = new JPanel();
		contentPane.setName("exam info contentpane");
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setPreferredSize(new Dimension(660,798));
		
		JLabel mainHeading = new JLabel("ADDITIONAL INFORMATION");
		mainHeading.setOpaque(true);
		mainHeading.setBackground(new Color(128, 255, 128));
		mainHeading.setHorizontalTextPosition(SwingConstants.CENTER);
		mainHeading.setHorizontalAlignment(SwingConstants.CENTER);
		mainHeading.setName("lbl28");
		mainHeading.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel subHeading1 = new JLabel("STUDENT DETAILES");
		subHeading1.setName("lbl29");
		subHeading1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JSeparator separator2 = new JSeparator();
		separator2.setName("sep10");
		
		JLabel label1 = new JLabel("Roll No");
		label1.setName("lbl30");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label2 = new JLabel("Name of Student");
		label2.setName("lbl31");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nameText = new JTextField();
		nameText.setName("exam name");
		nameText.setColumns(10);
		
		JLabel subHeading2 = new JLabel("BATCH DETAILES");
		subHeading2.setName("lbl32");
		subHeading2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JSeparator separator4 = new JSeparator();
		separator4.setName("sep12");
		
		JSeparator separator3 = new JSeparator();
		separator3.setName("sep13");
		
		JSeparator separator1 = new JSeparator();
		separator1.setName("sep14");
		
		JLabel label3 = new JLabel("Batch Number");
		label3.setName("lbl33");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label4 = new JLabel("Start Date");
		label4.setName("lbl34");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label5 = new JLabel("End Date");
		label5.setName("lbl35");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label6 = new JLabel("No of Students in Batch");
		label6.setName("lbl36");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		batchStudentNoTxt = new JTextField();
		batchStudentNoTxt.setName("exm nsbatch");
		batchStudentNoTxt.setColumns(10);
		
		examStudentNoTxt = new JTextField();
		examStudentNoTxt.setName("exm nsexam");
		examStudentNoTxt.setColumns(10);
		
		JLabel subHeading3 = new JLabel("FEE DETAILES");
		subHeading3.setName("lbl38");
		subHeading3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JSeparator separator5 = new JSeparator();
		separator5.setName("sep17");
		
		JSeparator separator6 = new JSeparator();
		separator6.setName("sep18");
		
		JLabel label8 = new JLabel("Balance");
		label8.setName("lbl39");
		label8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label9 = new JLabel("No Due Clearance");
		label9.setName("lbl40");
		label9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label10 = new JLabel("Remarks");
		label10.setName("lbl41");
		label10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		balanceTxt = new JTextField();
		balanceTxt.setText("0");
		balanceTxt.setName("exm balance");
		balanceTxt.setColumns(10);
		
		JRadioButton dueYesRB = new JRadioButton("Yes");
		dueYesRB.setSelected(true);
		dueYesRB.setOpaque(false);
		dueYesRB.setName("exm yes");
		dueYesRB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(dueYesRB);
		
		JRadioButton dueNoRB = new JRadioButton("No");
		dueNoRB.setOpaque(false);
		dueNoRB.setName("exm no");
		dueNoRB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(dueNoRB);
		
		JTextArea remarkTxtArea = new JTextArea();
		remarkTxtArea.setLineWrap(true);
		remarkTxtArea.setName("exm remarks");
		remarkTxtArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label7 = new JLabel("Payment Details");
		label7.setName("lbl42");
		label7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton paymentBtn = new JButton("ADD");
		paymentBtn.setFocusPainted(false);
		paymentBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		paymentBtn.setBackground(new Color(0, 139, 139));
		paymentBtn.setName("exm payment");
		paymentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Exam_Payment dialog = new Exam_Payment(paymentList);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		setLayout(new BorderLayout(0, 0));
		paymentBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JSeparator separator7 = new JSeparator();
		separator7.setName("sep19");
		
		JButton addBtn = new JButton("ADD");
		addBtn.setBackground(new Color(0, 128, 128));
		
	
		addBtn.addActionListener(new ExamInfoAddController(contentPane,studentList));
		addBtn.setName("exm info add");
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton cancelBtn = new JButton("CANCEL");
		cancelBtn.setBackground(new Color(0, 128, 128));
		cancelBtn.addActionListener(new CancelButton(contentPane));
		cancelBtn.setName("exm info cancel");
		cancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JScrollPane paymentScroll = new JScrollPane();
		paymentScroll.setName("payment scroll");
		
		paymentList = new JList<PaymentModel>();
		paymentList.setModel(new DefaultListModel<PaymentModel>());
		paymentList.setCellRenderer(new ExamPayListViewer());
		paymentList.setName("payment list");
		paymentScroll.setViewportView(paymentList);
		paymentList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label11 = new JLabel("Added Payment Details");
		label11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label11.setName("lbl90");
		
		JButton removeBtn = new JButton("REMOVE");
		removeBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		removeBtn.setBackground(new Color(0, 139, 139));
		removeBtn.setFocusPainted(false);
		removeBtn.addActionListener(new PayListRemoveController(paymentList));
		removeBtn.setName("removing");
		removeBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(contentPane);
		
		JTextArea txtAreaLbl = new JTextArea();
		txtAreaLbl.setName("labeltxt");
		txtAreaLbl.setEditable(false);
		txtAreaLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAreaLbl.setText("Number of students for Exam");
		txtAreaLbl.setOpaque(false);
		txtAreaLbl.setLineWrap(true);
		txtAreaLbl.setWrapStyleWord(true);
		
		JDateChooser startDate = new JDateChooser();
		startDate.setDateFormatString("dd-MM-y");
		startDate.getCalendarButton().setName("start calender");
		startDate.setName("start date");
		((JTextFieldDateEditor)startDate.getDateEditor()).setEditable(false);
		
		JDateChooser endDate = new JDateChooser();
		endDate.setDateFormatString("dd-MM-y");
		endDate.getCalendarButton().setName("end calender");
		endDate.setName("end date");
		((JTextFieldDateEditor)endDate.getDateEditor()).setEditable(false);
		
		batchNoTxt = new JTextField();
		batchNoTxt.setName("batch number");
		batchNoTxt.setColumns(10);
		
		rollnoTxt = new JTextField();
		rollnoTxt.setName("roll no");
		rollnoTxt.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(mainHeading, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(separator1, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(subHeading1, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addGap(490)))
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(separator2, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(separator3, GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(subHeading2, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addGap(482)))
					.addGap(18))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(separator4, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(subHeading3, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
							.addGap(520))
						.addComponent(separator5, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
					.addGap(20))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(separator6, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(label10, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(label9, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(10)
								.addComponent(label7, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addGap(50)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label8, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(paymentBtn, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(balanceTxt, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(dueYesRB, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(dueNoRB, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(remarkTxtArea)
							.addGap(55)))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label11, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
							.addGap(47))
						.addComponent(paymentScroll, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
							.addComponent(removeBtn, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
					.addGap(47))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(separator7, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
					.addGap(20))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(400)
					.addComponent(addBtn, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(cancelBtn, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtAreaLbl)
							.addGap(18)
							.addComponent(examStudentNoTxt, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label6, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(batchStudentNoTxt, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
					.addGap(350))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(label4, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(batchNoTxt,GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(startDate, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
							.addComponent(endDate, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
					.addContainerGap(236, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(rollnoTxt)
						.addComponent(nameText, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
					.addContainerGap(237, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(mainHeading, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(separator1, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
							.addGap(15))
						.addComponent(subHeading1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addComponent(separator2, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(label1, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rollnoTxt, GroupLayout.DEFAULT_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(25))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(nameText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(separator3, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
							.addGap(19))
						.addComponent(subHeading2, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addComponent(separator4, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label3, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
						.addComponent(batchNoTxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(startDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label4, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label5, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addComponent(endDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label6, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(batchStudentNoTxt, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAreaLbl, GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
						.addComponent(examStudentNoTxt, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(subHeading3, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(separator5, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
							.addGap(19)))
					.addComponent(separator6, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(label7, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
							.addGap(164))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(paymentBtn, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(balanceTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(label8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(dueYesRB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(dueNoRB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(remarkTxtArea, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
								.addComponent(label10, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(paymentScroll, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(removeBtn, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)))
					.addGap(6)
					.addComponent(separator7, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(addBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cancelBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
