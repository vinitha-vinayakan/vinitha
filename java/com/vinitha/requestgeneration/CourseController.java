package com.vinitha.requestgeneration;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseController extends WindowAdapter implements ItemListener {
	
	private static Map<String,String> courseMap=new HashMap<String, String>();
	public static List<String> COURSE_CODE=new ArrayList<String>();
	public static List<String> COURSE=new ArrayList<String>();
	private JTextField couresName=null;
	
	public CourseController() {
	}

	public CourseController(JTextField couresName) {
		this.couresName = couresName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		Session session=HibernateOperation.createSession(new Class[] {KeltronCourse.class});
		Transaction transaction=session.beginTransaction();
		COURSE_CODE.add("SELECT COURSE CODE");
		COURSE.add("SELECT COURSE");
		List<KeltronCourse> courses = HibernateOperation.loadAllData(KeltronCourse.class, session);
		for (KeltronCourse course : courses) {
			courseMap.put(course.getCourseCode(), course.getCourseName());
			COURSE_CODE.add(course.getCourseCode());
			COURSE.add(course.getCourseCode()+" "+ course.getCourseName());
		}
		transaction.commit();
		session.close();
			
	}

	@SuppressWarnings("unchecked")
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	   couresName.setText(courseMap.get(((JComboBox<String>)e.getItemSelectable()).getSelectedItem()));

	}

}
