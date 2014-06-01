package ComplaintsGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientRelationShipComplaintGUI extends JPanel {
	/**
	 * Create the panel.
	 */
	
	public ClientRelationShipComplaintGUI() {
		setLayout(null);
		
		JButton btnSearchComplaint = new JButton("Search Complaint");
		btnSearchComplaint.setBounds(146, 56, 129, 53);
		add(btnSearchComplaint);
		btnSearchComplaint.addActionListener(new SearchGUI());//connect the search button to search menu.
		
		JButton btnGetAllComplaints = new JButton("Get All Complaints");
		btnGetAllComplaints.setBounds(146, 148, 129, 53);
		add(btnGetAllComplaints);

	}
}
class SearchGUI implements ActionListener {

	public void actionPerformed(ActionEvent e){
	
		SearchComplaintGUI searchGUI = new SearchComplaintGUI();
		
	}
	
}