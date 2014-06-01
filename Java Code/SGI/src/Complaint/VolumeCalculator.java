package Complaint;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VolumeCalculator extends JFrame implements ActionListener
{
    private JTabbedPane jtabbedPane;
    private JPanel options;
    JTextField poolLengthText, poolWidthText, poolDepthText, poolVolumeText, hotTub,
            hotTubLengthText, hotTubWidthText, hotTubDepthText, hotTubVolumeText, temp, results,
            myTitle;
    JTextArea labelTubStatus;

    public VolumeCalculator()
    {
        setSize(400, 250);
        setVisible(true);
        setSize(400, 250);
        setVisible(true);
        setTitle("Volume Calculator");
        setSize(300, 200);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        createOptions();

        jtabbedPane = new JTabbedPane();

        jtabbedPane.addTab("Options", options);
        jtabbedPane.addTab("Complaints",null);

        topPanel.add(jtabbedPane, BorderLayout.CENTER);
    }
    /* CREATE OPTIONS */

    public void createOptions()
    {
        options = new JPanel();
        //options.setLayout(null);
        JLabel labelOptions = new JLabel("Change Company Name:");
        labelOptions.setBounds(120, 10, 150, 20);
        options.add(labelOptions);
        JTextField newTitle = new JTextField("Some Title");
        //newTitle.setBounds(80, 40, 225, 20);    
        options.add(newTitle);
        myTitle = new JTextField(20);
        // myTitle WAS NEVER ADDED to the GUI!
        options.add(myTitle);
        //myTitle.setBounds(80, 40, 225, 20);
        //myTitle.add(labelOptions);
        JButton newName = new JButton("Set New Name");
        //newName.setBounds(60, 80, 150, 20);
        newName.addActionListener(this);
        options.add(newName);
        JButton Exit = new JButton("Exit");
        //Exit.setBounds(250, 80, 80, 20);
        Exit.addActionListener(this);
        options.add(Exit);
    }

    public void actionPerformed(ActionEvent event)
    {
        JButton button = (JButton) event.getSource();
        String buttonLabel = button.getText();
        if ("Exit".equalsIgnoreCase(buttonLabel))
        {
            Exit_pressed();
            return;
        }
        if ("Set New Name".equalsIgnoreCase(buttonLabel))
        {
            New_Name();
            return;
        }
    }

    private void Exit_pressed()
    {
        System.exit(0);
    }

    private void New_Name()
    {
        System.out.println("'" + myTitle.getText() + "'");
        this.setTitle(myTitle.getText());
    }

    private void Options()
    {
    }

    public static void main(String[] args)
    {
        JFrame frame = new VolumeCalculator();
        frame.pack();
        frame.setSize(380, 350);
        frame.setVisible(true);
    }
}