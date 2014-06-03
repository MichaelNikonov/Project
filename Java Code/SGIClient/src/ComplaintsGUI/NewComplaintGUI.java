package ComplaintsGUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

import sgi.entities.Complaint;

import client.controllers.ComplaintController;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

public class NewComplaintGUI extends JPanel {
	private JTextField textTitle;

	/**
	 * Create the panel.
	 */
	public NewComplaintGUI(ComplaintController controller,JPanel MainPanel) {//controller need to call addNewComplaint function that sends new compalint to server 
		setLayout(null);
		
		JTextArea textContent = new JTextArea();
		textContent.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textContent.setBackground(Color.WHITE);
		textContent.setWrapStyleWord(true);
		textContent.setLineWrap(true);
		textContent.setBounds(77, 71, 346, 328);
		textContent.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		add(textContent);
		
		textTitle = new JTextField();
		textTitle.setBounds(77, 34, 346, 26);
		add(textTitle);
		textTitle.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 37, 46, 20);
		add(lblTitle);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setBounds(10, 76, 46, 14);
		add(lblContent);
		JLabel lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(104, 424, 269, 14);
		add(lblMessage);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBounds(104, 466, 89, 23);
		btnOK.addActionListener(new SendNewComplaint(controller,textTitle,textContent,lblMessage));//sending new complaint to server
		add(btnOK);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(284, 466, 89, 23);
		btnCancel.addActionListener(new CancelAction(this,MainPanel));//adding cancel functionality
		add(btnCancel);
		
		
		

	}
}
class SendNewComplaint implements ActionListener
{
	private ComplaintController controller;
	private JTextField textTitle;
	private JTextArea textContent;
	

	public SendNewComplaint(ComplaintController controller,JTextField textTitle,JTextArea textContent,JLabel lblMessage){
		if(textTitle.getText()==null||textContent.getText()==null)
			lblMessage.setText("The title and content are required fields");
		    
		else
		{
		this.controller = controller;
		this.textTitle = textTitle;
		this.textContent = textContent;
		}
	}
	

	public void actionPerformed(ActionEvent e) {
		Calendar cal = Calendar.getInstance();
		while(controller.addNewComplaint()){}//wait to response from client that message has been sent 
		while(controller.getComplaintTemp()==null ){}//wait for response from server about id receive
		Complaint ComplaintData  = new Complaint(controller.getId(),
				                                 controller.getClient(),
				                                 controller.getType(),
				                                 textTitle.getText(),
				                                 textContent.getText(),
				                                 cal.getTime());
		
		controller.addNewComplaint(ComplaintData);
		controller.setComplaintTemp(null);
	}
	
	
		
}
class CancelAction implements ActionListener{
	private NewComplaintGUI newComplaint;
	private JPanel main;
	public CancelAction(NewComplaintGUI newComplaint,JPanel main){
		this.newComplaint=newComplaint;
		this.main = main;
		
	}
	public void actionPerformed(ActionEvent e)
	{
		newComplaint.setVisible(false);
		main.setVisible(true);
	}
}
