package com.vinitha.examrequest;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import com.vinitha.examrequest.controller.ExamRequestGenerateController;
import com.vinitha.examrequest.controller.ExamStudentListViewer;
import com.vinitha.examrequest.controller.StudentListRemoveController;
import com.vinitha.examrequest.model.StudentInfoModel;
import com.vinitha.requestgeneration.CancelButton;
import com.vinitha.requestgeneration.CourseController;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class Exam_Request extends JFrame {

	private JPanel contentPane;
	private JTextField requestNoTxt;
	private JList<StudentInfoModel> studentList;
	private JTextField courseNameTxt;
	

	/**
	 * Create the frame.
	 */
	public Exam_Request() {

		Image icon=null;
		try {
			icon=ImageIO
					.read(new File("src/main/resources/excel sheets/keltronicon.jpg"))
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(icon);
		setTitle("KELTRON EXAM REQUEST");
		
		setBounds(100, 70, 659, 577);
		contentPane = new JPanel();
		contentPane.setName("exm course contentpane");
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel label1 = new JLabel("Course Name");
		label1.setName("lbl45");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label2 = new JLabel("Course Code");
		label2.setName("lbl46");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label3 = new JLabel("Semester Number");
		label3.setName("lbl47");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> courseCodeCB = new JComboBox<String>();
		courseCodeCB.setName("exam ccode");
		DefaultComboBoxModel<String> model=new DefaultComboBoxModel<String>();
		model.addAll(CourseController.COURSE_CODE);
		courseCodeCB.setModel(model);
		courseCodeCB.setSelectedIndex(0);
		
		String Semester[]= {"","1","2"};
		JComboBox<String> semesterCB = new JComboBox<String>();
		semesterCB.setModel(new DefaultComboBoxModel<String>(Semester));
		semesterCB.setSelectedIndex(0);
		semesterCB.setName("exam semno");
		semesterCB.setEditable(true);
		
		JButton generateBtn = new JButton("GENERATE");
		generateBtn.setBackground(new Color(100, 149, 237));
		generateBtn.setFocusPainted(false);
		generateBtn.setName("exam generate");
		generateBtn.addActionListener(new ExamRequestGenerateController(contentPane));
		generateBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton cancelBtn = new JButton("CANCEL");
		cancelBtn.setFocusPainted(false);
		cancelBtn.setBackground(new Color(100, 149, 237));
		cancelBtn.addActionListener(new CancelButton(contentPane,this));
		cancelBtn.setName("exam cancel");
		cancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton addStudentBtn = new JButton("ADD STUDENT");
		addStudentBtn.setBackground(new Color(100, 149, 237));
		addStudentBtn.setFocusPainted(false);
		addStudentBtn.setName("exam std add");
		addStudentBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label4 = new JLabel("Exam Requisition No");
		label4.setName("lbl48");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		requestNoTxt = new JTextField();
		requestNoTxt.setName("exam erno");
		requestNoTxt.setColumns(10);
		
		JLabel label5 = new JLabel("Prepared By");
		label5.setName("lbl49");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label6 = new JLabel("Verified By");
		label6.setName("lbl50");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		String Faculty[]= {"ANJU P S",
				"AJIMOL A V",
				"AJITH YESUDAS",
				"AKHILA",
				"RENJU"		
		};
		JComboBox<String> preparedCB = new JComboBox<String>();
		preparedCB.setModel(new DefaultComboBoxModel<String>(Faculty));
		preparedCB.setName("exam prepared");
		preparedCB.setSelectedIndex(0);
		preparedCB.setEditable(true);
		
		String Verifiedby[]= {"ANJU P S",
				"AJITH YESUDAS",
				"AKHILA"		
		};
		JComboBox<String> verifiedCB = new JComboBox<String>();
		verifiedCB.setModel(new DefaultComboBoxModel<String>(Verifiedby));
		verifiedCB.setSelectedIndex(0);
		verifiedCB.setName("exam verified");
		verifiedCB.setEditable(true);
		
		JLabel label7 = new JLabel("Added Student List");
		label7.setName("lbl51");
		label7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label8 = new JLabel("Date");
		label8.setName("lbl52");
		label8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JScrollPane studentScroll = new JScrollPane();
		studentScroll.setName("student scroll");
		
		studentList = new JList<StudentInfoModel>();
		studentList.setModel(new DefaultListModel<StudentInfoModel>());
		studentList.setCellRenderer(new ExamStudentListViewer());
		studentList.setName("examStudentList");
		studentScroll.setViewportView(studentList);
		studentList.setBorder(new LineBorder(new Color(0, 0, 0)));
		studentList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		JButton removeBtn = new JButton("REMOVE");
		removeBtn.setName("remove button");
		removeBtn.setBackground(new Color(100, 149, 237));
		removeBtn.setFocusPainted(false);
		removeBtn.addActionListener(new StudentListRemoveController(studentList));
		removeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JDateChooser date = new JDateChooser();
		date.setDateFormatString("dd-MM-y");
		date.getCalendarButton().setName("date calender");
		date.setName("date chooser");
		
		JDateChooser proposedDate = new JDateChooser();
		proposedDate.setDateFormatString("dd-MM-y");
		proposedDate.getCalendarButton().setName("proposed calender");
		proposedDate.setName("proposed date");
		
		JTextArea txtAreaLbl = new JTextArea();
		txtAreaLbl.setName("labletext");
		txtAreaLbl.setOpaque(false);
		txtAreaLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAreaLbl.setLineWrap(true);
		txtAreaLbl.setWrapStyleWord(true);
		txtAreaLbl.setText("Proposed date for Examination");
		
		JLabel heading = new JLabel("EXAM REQUEST");
		heading.setName("name");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setHorizontalTextPosition(SwingConstants.CENTER);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBackground(new Color(102, 205, 170));
		heading.setOpaque(true);
		
		courseNameTxt = new JTextField();
		courseNameTxt.setName("exam cname");
		courseNameTxt.setColumns(10);
		courseCodeCB.addItemListener(new CourseController(courseNameTxt));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(label5, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(preparedCB, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addComponent(label7, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(345)
					.addComponent(removeBtn, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addComponent(generateBtn, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
					.addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
				.addComponent(heading, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtAreaLbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(label8, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
										.addComponent(label6, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(verifiedCB, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(0)
									.addComponent(proposedDate, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addComponent(date, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
							.addComponent(studentScroll, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(345)
							.addComponent(addStudentBtn, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)))
					.addGap(55))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(courseNameTxt, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(courseCodeCB, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(semesterCB, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(label4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(requestNoTxt, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(heading, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label2, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addComponent(courseCodeCB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(courseNameTxt, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label3, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(semesterCB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(1))
						.addComponent(label4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(requestNoTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(preparedCB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(label5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(10))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(label7, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(verifiedCB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(label6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(22)
									.addComponent(proposedDate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(txtAreaLbl, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(date, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(label8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(8))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(studentScroll, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(addStudentBtn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(removeBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(generateBtn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelBtn, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addGap(3))
		);
		contentPane.setLayout(gl_contentPane);
		addStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ExamInformation frame = new ExamInformation(studentList);
					frame.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
	}
}
