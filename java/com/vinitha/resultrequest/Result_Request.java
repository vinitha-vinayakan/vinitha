package com.vinitha.resultrequest;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.vinitha.requestgeneration.CancelButton;
import com.vinitha.requestgeneration.CourseController;
import com.vinitha.resultrequest.controller.RemoveBtnController;
import com.vinitha.resultrequest.controller.ResultRequestGenerateController;
import com.vinitha.resultrequest.controller.StudentListViewer;
import com.vinitha.resultrequest.model.StudentMarkModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Cursor;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Result_Request extends JFrame {

	private JPanel contentPane;
	JList<StudentMarkModel> Std_list=null;
	private JTextField courseNameTxt;

	/**
	 * Create the frame.
	 */
	public Result_Request() {

		Image icon=null;
		try {
			icon=ImageIO
					.read(new File("src/main/resources/excel sheets/keltronicon.jpg"))
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(icon);
		setTitle("KLETRON RESULT");
		setResizable(false);
		setBounds(100, 100, 631, 489);
		contentPane = new JPanel();
		contentPane.setName("result contentpane");
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Course Code");
		lblNewLabel_1.setName("lbl59");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_2 = new JLabel("Examination Held in");
		lblNewLabel_2.setName("lbl60");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox<String> Ccode_Combo = new JComboBox<String>();
		Ccode_Combo.setName("result ccode ");
		Ccode_Combo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Ccode_Combo.setEditable(true);
		DefaultComboBoxModel<String> model=new DefaultComboBoxModel<String>();
		model.addAll(CourseController.COURSE_CODE);
		Ccode_Combo.setModel(model);
		Ccode_Combo.setSelectedIndex(0);
		
		JLabel lblNewLabel_3 = new JLabel("Entered By");
		lblNewLabel_3.setName("lbl61");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_4 = new JLabel("Verified By");
		lblNewLabel_4.setName("lbl62");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		String Faculty[]= {"ANJU P S",
				"AJIMOL A V",
				"AJITH YESUDAS",
				"AKHILA",
				"RENJU"		
		};
		JComboBox<String> Entered_Combo = new JComboBox<String>();
		Entered_Combo.setModel(new DefaultComboBoxModel<String>(Faculty));
		Entered_Combo.setName("result entered");
		Entered_Combo.setEditable(true);
		
		String Verifiedby[]= {"ANJU P S",
				"AJITH YESUDAS",
				"AKHILA"		
		};
		JComboBox<String> Verified_Combo = new JComboBox<String>();
		Verified_Combo.setModel(new DefaultComboBoxModel<String>(Verifiedby));
		Verified_Combo.setName("result verified");
		Verified_Combo.setEditable(true);
		
		JButton Mark_Btn = new JButton("Add Mark Details");
		Mark_Btn.setFocusPainted(false);
		Mark_Btn.setName("result add mark");
		
		Mark_Btn.setForeground(new Color(0, 0, 0));
		Mark_Btn.setBackground(new Color(176, 196, 222));
		Mark_Btn.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JButton Generate_Btn = new JButton("Generate");
		Generate_Btn.setFocusPainted(false);
		Generate_Btn.setName("result generate");
		Generate_Btn.addActionListener(new ResultRequestGenerateController(contentPane));
		Generate_Btn.setForeground(new Color(0, 0, 0));
		Generate_Btn.setBackground(new Color(176, 196, 222));
		Generate_Btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton Cancel_Btn = new JButton("Cancel");
		Cancel_Btn.setFocusPainted(false);
		Cancel_Btn.setName("result cancel");
		Cancel_Btn.addActionListener(new CancelButton(contentPane));
		Cancel_Btn.setForeground(new Color(0, 0, 0));
		Cancel_Btn.setBackground(new Color(176, 196, 222));
		Cancel_Btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_5 = new JLabel("Added Students List");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setName("lbl63");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setName("scroll pane");
		
		Std_list = new JList<StudentMarkModel>();
		Std_list.setModel(new DefaultListModel<StudentMarkModel>());
		Std_list.setCellRenderer(new StudentListViewer());
		Std_list.setName("result list");
		scrollPane.setViewportView(Std_list);
		Std_list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Std_list.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton Remove_Btn = new JButton("Remove");
		Remove_Btn.setFocusPainted(false);
		Remove_Btn.addActionListener(new RemoveBtnController(Std_list));
		Remove_Btn.setBackground(new Color(176, 196, 222));
		Remove_Btn.setFont(new Font("Bell MT", Font.BOLD, 13));
		Remove_Btn.setName("removeBtn");
		
		JLabel lblNewLabel = new JLabel("Course Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setName("cname");
		
		JDateChooser examDate = new JDateChooser();
		examDate.setName("exam date");
		examDate.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		examDate.getCalendarButton().setName("calender");
		examDate.setDateFormatString("dd-MMMM-y");
		((JTextFieldDateEditor)examDate.getDateEditor()).setEditable(false);
		
		courseNameTxt = new JTextField();
		courseNameTxt.setName("result cname");
		courseNameTxt.setColumns(10);
		Ccode_Combo.addItemListener(new CourseController(courseNameTxt));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(74)
					.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(303))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(74)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Mark_Btn, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(Remove_Btn, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
					.addGap(87))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(Generate_Btn, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(285)
					.addComponent(Cancel_Btn, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(52))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
							.addGap(40))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addGap(15)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(3)
								.addComponent(examDate, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addGap(45)
								.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
								.addGap(10)
								.addComponent(Verified_Combo, 0, 130, Short.MAX_VALUE)
								.addGap(17))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(Ccode_Combo, 0, 130, Short.MAX_VALUE)
								.addGap(45)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
								.addGap(10)
								.addComponent(Entered_Combo, 0, 130, Short.MAX_VALUE)
								.addGap(17)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(courseNameTxt, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(courseNameTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(Ccode_Combo, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(Entered_Combo, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(examDate, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(Verified_Combo, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addGap(46)
					.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(Mark_Btn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(Remove_Btn, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
							.addGap(46)))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Generate_Btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Cancel_Btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(7))
		);
		contentPane.setLayout(gl_contentPane);
		Mark_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Result_Information dialog = new Result_Information(Std_list);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
	}
}
