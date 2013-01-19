package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import component.Model3D;
import component.PerspectiveView;
import component.View;

import consts.Consts;

public class MainClass extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -2925627996414958852L;

	/**
	 * Private Fields
	 */
	private List<JInternalFrame> objListOfJInternalFrame
		= new ArrayList<JInternalFrame>();
	private JDesktopPane desktop = new JDesktopPane();
	private Model3D objModel3D = new Model3D();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MainClass frame = new MainClass();

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(10, 10, 900, 600);
	    frame.setTitle("タイトル JDesktopPane");
	    frame.setVisible(true);

	}

	/**
	 * @see Constructor
	 */
	public MainClass() {

		objListOfJInternalFrame.add(getJInternalFrame(Consts.View.INT_FRONT));

		for(JInternalFrame iframe : objListOfJInternalFrame) {
		    iframe.setJMenuBar(getJMenuBarInternalFrame());
		    desktop.add(iframe);
		}

	    this.setJMenuBar(getJMenuBarDesktopPane());

	    getContentPane().add(desktop, BorderLayout.CENTER);

	}

	private JMenuBar getJMenuBarDesktopPane() {

		JMenuBar menuBar = new JMenuBar();
	    JMenu menu1 = new JMenu("File");
	    JMenuItem item1 = new JMenuItem("Open New Perspective View");
	    JMenuItem item2 = new JMenuItem("Open New Front View");
	    JMenuItem item3 = new JMenuItem("Open New Side View");
	    JMenuItem item4 = new JMenuItem("Open New Top View");
	    menu1.add(item1);
	    menu1.add(item2);
	    menu1.add(item3);
	    menu1.add(item4);

	    menuBar.add(menu1);

	    item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame iframe = getJInternalFrame(Consts.View.INT_PERSPECTIVE);
				objListOfJInternalFrame.add(iframe);
				desktop.add(iframe);
			}
		});

	    item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame iframe = getJInternalFrame(Consts.View.INT_FRONT);
				objListOfJInternalFrame.add(iframe);
				desktop.add(iframe);
			}
		});

	    item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame iframe = getJInternalFrame(Consts.View.INT_SIDE);
				objListOfJInternalFrame.add(iframe);
				desktop.add(iframe);
			}
		});

	    item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame iframe = getJInternalFrame(Consts.View.INT_TOP);
				objListOfJInternalFrame.add(iframe);
				desktop.add(iframe);
			}
		});

	    return menuBar;

	}

	private JMenuBar getJMenuBarInternalFrame() {

	    JMenuBar menuBar = new JMenuBar();
	    JMenu menu1 = new JMenu("File");
	    JMenuItem item11 = new JMenuItem("Close");
	    JMenu menu2 = new JMenu("Edit");
	    JMenuItem item21 = new JMenuItem("Clear Line");
	    menu1.add(item11);

	    menuBar.add(menu1);
	    menuBar.add(menu2);

	    item11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	    item21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	    return menuBar;

	}

	private JInternalFrame getJInternalFrame(Integer intViewType) {

		JInternalFrame iframe = null;

	    switch (intViewType) {

	    	case Consts.View.INT_PERSPECTIVE:
			    iframe = new JInternalFrame(
			    		Consts.View.STR_PERSPECTIVE,
						    			true, true, true, true);
			    iframe.add(getPerspectiveView(intViewType), BorderLayout.CENTER);
		    	break;

	    	case Consts.View.INT_FRONT:
			    iframe = new JInternalFrame(
			    		Consts.View.STR_FRONT,
						    			true, true, true, true);
			    iframe.add(getView(intViewType), BorderLayout.CENTER);
		    	break;

	    	case Consts.View.INT_SIDE:
			    iframe = new JInternalFrame(
			    		Consts.View.STR_SIDE,
						    			true, true, true, true);
			    iframe.add(getView(intViewType), BorderLayout.CENTER);
		    	break;

	    	case Consts.View.INT_TOP:
			    iframe = new JInternalFrame(
			    		Consts.View.STR_TOP,
						    			true, true, true, true);
			    iframe.add(getView(intViewType), BorderLayout.CENTER);
		    	break;

	    }

	    iframe.setSize(300, 300);
	    iframe.setLocation(10, 10);
	    iframe.setVisible(true);

	    return iframe;

	}

	private View getView(Integer intViewType) {

		View objDrawLinePanel = new View(intViewType, this);
		objDrawLinePanel.setObjModel3D(objModel3D);
		return objDrawLinePanel;

	}

	private PerspectiveView getPerspectiveView(Integer intViewType) {

		PerspectiveView objDrawLinePanel = new PerspectiveView(intViewType, this);
		objDrawLinePanel.setObjModel(objModel3D);
		return objDrawLinePanel;

	}

}
