package com.vinitha.requestgeneration;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JViewport;

import com.toedter.calendar.JTextFieldDateEditor;

public class ComponentFinder {
	private Container container=null;
	private ArrayList<Component>allComponents=new ArrayList<Component>();

	public ComponentFinder(Container container) {
		super();
		this.container = container;
	}
	
	private void getAllComponents(Container chilContainer) {
		Component components[]=chilContainer.getComponents();
		for(Component component:components){
			if(component instanceof JPanel ||
			   component instanceof JScrollPane ||
			   component instanceof JTabbedPane ||
			   component instanceof JDialog ||
			   component instanceof JViewport ||
			   component instanceof JFrame) {
				
				allComponents.add(component);
				getAllComponents((Container)component);
			}
			else{
				allComponents.add(component);
			}
		}
	}
		
	public Component findComponent(String name) {
		getAllComponents(container);
		for (Component item: allComponents) {
			if(!(item instanceof JViewport 
					|| item instanceof JScrollBar
					|| item instanceof JTextFieldDateEditor
					|| item instanceof JLayeredPane)) {
			   if(item.getName().equals(name)) {
				  return item;
			      }
			}
			
		}
		return null;
		
	}
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		
		for(Enumeration<AbstractButton> buttons=buttonGroup.getElements();buttons.hasMoreElements();) {
			AbstractButton button=buttons.nextElement();
			
			if(button.isSelected()) {
				return button.getText();
			}
		}
		
		return null;
		
	}
}
