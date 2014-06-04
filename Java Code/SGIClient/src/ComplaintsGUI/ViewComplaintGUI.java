package ComplaintsGUI;

import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import sgi.entities.Complaint;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewComplaintGUI extends JPanel {
	private JTextField txtUsename;
	private JTextField txtComplainttitle;
	private JTextField txtDateadded;
	private JTextField txtDateclosed;
	private JTextField txtCompensation;
	private JTextField txtWorkerId;
	private JTextField txtWorkerName;
    private ShowAllComplaints parentList;
	/**
	 * Create the panel.
	 */
	public ViewComplaintGUI(String userName,String title,String content,Date dateAdded,Date dateClosed,float compensation,int workerID,String workerName ,ShowAllComplaints ComplaintsList) {
		setLayout(null);
		this.parentList = ComplaintsList;
		JTextArea complaintContent = new JTextArea(content);
		complaintContent.setBounds(10, 84, 454, 447);
		add(complaintContent);
		
		JLabel lblComplaintTitle = new JLabel("Complaint Title:");
		lblComplaintTitle.setBounds(58, 31, 135, 14);
		add(lblComplaintTitle);
		
		JButton btnCompensate = new JButton("Compensate/Reply");
		btnCompensate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
			}
		});
		btnCompensate.setBounds(490, 375, 149, 23);
		add(btnCompensate);
		
		JButton btnCloseComplaint = new JButton("Close Complaint");
		btnCloseComplaint.setBounds(509, 409, 117, 23);
		add(btnCloseComplaint);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(509, 443, 117, 23);
		add(btnBack);
		
		JLabel lblUsename = new JLabel("Usename");
		lblUsename.setBounds(529, 31, 70, 14);
		add(lblUsename);
		
		txtUsename = new JTextField();
		txtUsename.setText(userName);
		txtUsename.setBounds(529, 56, 86, 20);
		add(txtUsename);
		txtUsename.setColumns(10);
		
		txtComplainttitle = new JTextField();
		txtComplainttitle.setText(title);
		txtComplainttitle.setBounds(165, 28, 238, 20);
		add(txtComplainttitle);
		txtComplainttitle.setColumns(10);
		
		JLabel lblDateAdded = new JLabel("Date Added");
		lblDateAdded.setBounds(529, 89, 70, 14);
		add(lblDateAdded);
		
		txtDateadded = new JTextField();
		txtDateadded.setText(dateAdded.toString());
		txtDateadded.setBounds(529, 114, 86, 20);
		add(txtDateadded);
		txtDateadded.setColumns(10);
		
		JLabel lblDateClosed = new JLabel("Date Closed");
		lblDateClosed.setBounds(529, 145, 70, 14);
		add(lblDateClosed);
		
		txtDateclosed = new JTextField();
		txtDateclosed.setText(dateClosed.toString());
		txtDateclosed.setBounds(529, 170, 86, 20);
		add(txtDateclosed);
		txtDateclosed.setColumns(10);
		
		JLabel lblCompensation = new JLabel("Compensation");
		lblCompensation.setBounds(529, 201, 70, 14);
		add(lblCompensation);
		
		txtCompensation = new JTextField();
		txtCompensation.setText(""+compensation+"");
		txtCompensation.setBounds(529, 228, 86, 20);
		add(txtCompensation);
		txtCompensation.setColumns(10);
		
		JLabel lblWorkerId = new JLabel("Worker ID");
		lblWorkerId.setBounds(529, 259, 70, 14);
		add(lblWorkerId);
		
		txtWorkerId = new JTextField();
		txtWorkerId.setText(""+workerID);
		txtWorkerId.setBounds(529, 284, 86, 20);
		add(txtWorkerId);
		txtWorkerId.setColumns(10);
		
		JLabel lblWorkerName = new JLabel("Worker Name");
		lblWorkerName.setBounds(529, 315, 86, 14);
		add(lblWorkerName);
		
		txtWorkerName = new JTextField();
		txtWorkerName.setText(workerName);
		txtWorkerName.setBounds(529, 340, 86, 20);
		add(txtWorkerName);
		txtWorkerName.setColumns(10);

	}
}
