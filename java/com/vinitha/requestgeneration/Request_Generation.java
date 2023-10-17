package com.vinitha.requestgeneration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vinitha.certificaterequest.CertificateRequest;
import com.vinitha.examrequest.Exam_Request;
import com.vinitha.resultrequest.Result_Request;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class Request_Generation extends JFrame implements ComponentListener {

	private JPanel contentPane;
	private JLabel lblNewLabel =null;
	private JLabel lblNewLabel_1 =null;
	private JButton Exam_Btn =null;
	private JButton Result_Btn =null;
	private JButton Certificate_Btn =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Request_Generation frame = new Request_Generation();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Request_Generation() {

		Image icon=null;
		try {
			icon=ImageIO
					.read(new File("src/main/resources/excel sheets/keltronicon.jpg"))
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(icon);
		addWindowListener(new CourseController());
		setTitle("KLETRON REQUEST GENERATOR");
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)size.getWidth()/2-240,(int)size.getHeight()/2-205 , 585, 417);
		contentPane = new JPanel();
		contentPane.setName("req_gen_contentpane");
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("KKC SPENCER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setName("lbl1");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblNewLabel.addComponentListener(this);
		
		lblNewLabel_1 = new JLabel("REQUEST GENERATION");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setName("lbl2");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setBackground(new Color(128, 128, 255));
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 19));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.addComponentListener(this);
		
		JPanel Requests_panel = new JPanel();
		Requests_panel.setName("req_gen_panel");
		Requests_panel.setBackground(new Color(0, 128, 128));
		
		Exam_Btn = new JButton("EXAM REQUEST");
		Exam_Btn.setFocusPainted(false);
		Exam_Btn.setName("exam request");
		Exam_Btn.addComponentListener(this);
		Exam_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Exam_Request frame = new Exam_Request();
					frame.setVisible(true);
					
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		Exam_Btn.setForeground(new Color(75, 0, 130));
		Exam_Btn.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		Exam_Btn.setBackground(new Color(255, 255, 255));
		
		Certificate_Btn = new JButton("CERTIFICATE REQUEST");
		Certificate_Btn.setFocusPainted(false);
		Certificate_Btn.setName("certificate request");
		Certificate_Btn.addComponentListener(this);
		Certificate_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CertificateRequest frame = new CertificateRequest();
					frame.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		Certificate_Btn.setForeground(new Color(75, 0, 130));
		Certificate_Btn.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		Certificate_Btn.setBackground(new Color(255, 255, 255));
		
		Result_Btn = new JButton("RESULT REQUEST");
		Result_Btn.setFocusPainted(false);
		Result_Btn.setName("result request");
		Result_Btn.setForeground(new Color(75, 0, 130));
		Result_Btn.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		Result_Btn.addComponentListener(this);
		Result_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Result_Request frame = new Result_Request();
					frame.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		Result_Btn.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
					.addGap(10)
					.addComponent(Requests_panel, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addGap(71))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(106)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addGap(8)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addGap(182))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(Requests_panel, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
					.addGap(60))
		);
		GroupLayout gl_Requests_panel = new GroupLayout(Requests_panel);
		gl_Requests_panel.setHorizontalGroup(
			gl_Requests_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Requests_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_Requests_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Requests_panel.createSequentialGroup()
							.addComponent(Exam_Btn, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(Certificate_Btn, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
						.addComponent(Result_Btn, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
					.addGap(25))
		);
		gl_Requests_panel.setVerticalGroup(
			gl_Requests_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Requests_panel.createSequentialGroup()
					.addGap(40)
					.addComponent(Exam_Btn, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(40)
					.addComponent(Certificate_Btn, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(40)
					.addComponent(Result_Btn, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(40))
		);
		Requests_panel.setLayout(gl_Requests_panel);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		int width=getWidth();
		if(lblNewLabel!=null 
				||lblNewLabel_1!=null
				||Exam_Btn!=null
				||Certificate_Btn!=null
				||Result_Btn!=null) {
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, width / 35));
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, width / 35));
			Exam_Btn.setFont(new Font("Arial", Font.BOLD, width / 35));
			Certificate_Btn.setFont(new Font("Arial", Font.BOLD, width / 35));
			Result_Btn.setFont(new Font("Arial", Font.BOLD, width / 35));
	        getContentPane().revalidate();
		}
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
