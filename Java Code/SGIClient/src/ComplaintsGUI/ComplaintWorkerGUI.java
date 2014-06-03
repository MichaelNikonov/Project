package ComplaintsGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import client.controllers.ComplaintController;

import sgi.entities.Complaint;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComplaintWorkerGUI extends JPanel {
	/**
	 * Create the panel.
	 */
	
	public ComplaintWorkerGUI(ComplaintController controller) {
		setLayout(null);
		
		JButton btnShowAllComplaint = new JButton("Show All Complaints");
		btnShowAllComplaint.setBounds(120, 56, 230, 53);
		add(btnShowAllComplaint);
		btnShowAllComplaint.addActionListener(new SearchGUI(controller));//connect the search button to search menu.
		
		JButton btnGetNotClosedComplaints = new JButton("Get all unadressed complaints");
		btnGetNotClosedComplaints.setBounds(120, 165, 230, 62);
		add(btnGetNotClosedComplaints);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(120, 279, 230, 23);
		add(btnCancel);

	}
}
class SearchGUI implements ActionListener {
	ComplaintController controller;
	public SearchGUI(ComplaintController controller){
	 this.controller = controller;}

	public void actionPerformed(ActionEvent e){
	     controller.getAllComplaints();
		
	}
	
}