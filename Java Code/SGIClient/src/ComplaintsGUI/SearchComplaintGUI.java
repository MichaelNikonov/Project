package ComplaintsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SearchComplaintGUI extends JPanel {
	private JTextField textDate;
	private JTextField textTitle;

	/**
	 * Create the panel.
	 */
	public SearchComplaintGUI() {
		setLayout(null);
		
		textDate = new JTextField();
		textDate.setBounds(159, 11, 150, 20);
		add(textDate);
		textDate.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 14, 46, 14);
		add(lblDate);
		
		textTitle = new JTextField();
		textTitle.setBounds(159, 64, 150, 20);
		add(textTitle);
		textTitle.setColumns(10);
		
		JLabel lblTitleoptional = new JLabel("Title (optional)");
		lblTitleoptional.setBounds(10, 67, 82, 14);
		add(lblTitleoptional);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(95, 132, 89, 23);
		add(btnSearch);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(281, 132, 108, 23);
		add(btnCancel);
		btnCancel.addActionListener(new CancelAction());

	}

}
class CancelAction implements ActionListener {

	public void actionPerformed(ActionEvent e){
	
		//TODO : ADD Switching to previous Complaint relationship GUI
		
	}
	
}
