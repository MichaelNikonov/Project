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
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public NewComplaintGUI() {
		setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBackground(Color.WHITE);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(77, 71, 346, 369);
		textArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		add(textArea);
		
		textField = new JTextField();
		textField.setBounds(77, 34, 346, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 37, 46, 20);
		add(lblTitle);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setBounds(10, 76, 46, 14);
		add(lblContent);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBounds(111, 451, 89, 23);
		add(btnOK);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(312, 451, 89, 23);
		add(btnCancel);

	}
}
