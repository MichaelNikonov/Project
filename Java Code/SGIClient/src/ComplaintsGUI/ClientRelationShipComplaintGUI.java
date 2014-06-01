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
	public static void main(String[] args){
		 JFrame ClientRelationShip = new JFrame("Client Realtion Ship Menu");
		 ClientRelationShip.setVisible(true);
		 ClientRelationShip.setSize(500,500);
		 ClientRelationShipComplaintGUI relationGUI = new ClientRelationShipComplaintGUI();
		 ClientRelationShip.add(relationGUI);
		
	}
	public ClientRelationShipComplaintGUI() {
		setLayout(null);
		
		JButton btnSearchComplaint = new JButton("Search Complaint");
		btnSearchComplaint.setBounds(146, 56, 129, 53);
		add(btnSearchComplaint);
		btnSearchComplaint.addActionListener(new SearchGUI());
		
		JButton btnGetAllComplaints = new JButton("Get All Complaints");
		btnGetAllComplaints.setBounds(146, 148, 129, 53);
		add(btnGetAllComplaints);

	}
}
class SearchGUI implements ActionListener {

	public void actionPerformed(ActionEvent e){
		JFrame Searchframe = new JFrame("Search Complaint");
		Searchframe.setVisible(true);
		Searchframe.setSize(500,500);
		SearchComplaintGUI searchGUI = new SearchComplaintGUI();
		Searchframe.add(searchGUI);
		
	}
	
}