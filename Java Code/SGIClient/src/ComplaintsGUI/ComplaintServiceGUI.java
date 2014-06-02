package ComplaintsGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import sgi.entities.Complaint;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComplaintServiceGUI extends JPanel {
	/**
	 * Create the panel.
	 */
	
	public ComplaintServiceGUI() {
		setLayout(null);
		
		JButton btnShowAllComplaint = new JButton("Show All Complaints");
		btnShowAllComplaint.setBounds(120, 56, 230, 53);
		add(btnShowAllComplaint);
		btnShowAllComplaint.addActionListener(new SearchGUI());//connect the search button to search menu.
		
		JButton btnGetNotClosedComplaints = new JButton("Get all unadressed complaints");
		btnGetNotClosedComplaints.setBounds(120, 165, 230, 62);
		add(btnGetNotClosedComplaints);

	}
}
class SearchGUI implements ActionListener {

	public void actionPerformed(ActionEvent e){
	
		ShowAllComplaints searchGUI = new ShowAllComplaints();
		
	}
	
}