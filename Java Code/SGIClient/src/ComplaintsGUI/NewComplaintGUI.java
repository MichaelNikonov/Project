package ComplaintsGUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class NewComplaintGUI extends JPanel {
	private JTextField textTitle;

	/**
	 * Create the panel.
	 */
	public NewComplaintGUI() {
		setLayout(null);
		
		JTextArea textContent = new JTextArea();
		textContent.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textContent.setBackground(Color.WHITE);
		textContent.setWrapStyleWord(true);
		textContent.setLineWrap(true);
		textContent.setBounds(77, 71, 346, 369);
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
		
		JButton btnOK = new JButton("OK");
		btnOK.setBounds(104, 466, 89, 23);
		add(btnOK);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(284, 466, 89, 23);
		add(btnCancel);

	}
}
class SendNewComplaint implements ActionListener
{

	public void actionPerformed(ActionEvent e) {
		//TODO connect this listener to send message at complaint controller 
		
	}
	
}
