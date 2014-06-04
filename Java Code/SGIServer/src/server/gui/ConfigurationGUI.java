package server.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import server.models.ServerConfiguration;

public class ConfigurationGUI extends JFrame {

	private static final long serialVersionUID = 14727289628363430L;
    private JButton _btnSaveConfig;
    private JCheckBox _disconnectOnNoActivity;
    private JSlider _sldComplaintDeadlineTime;
    private JSlider _sldNoActivityThreshold;
    private JTextField _txtPortNumber;
    private JTextField _txtSqlDatabase;
    private JTextField _txtSqlHost;
    private JTextField _txtSqlPassword;
    private JTextField _txtSqlUserName;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;

	public ConfigurationGUI(ServerConfiguration current) {
        initComponents(current);
    }

    public void setConfiguration(ServerConfiguration current) {
        _txtPortNumber.setText(String.valueOf(current.getPort()));
        _txtSqlHost.setText(current.getHost());
        _txtSqlUserName.setText(current.getSqlUsername());
        _txtSqlPassword.setText(current.getSqlPassword());
        _txtSqlDatabase.setText(current.getDBName());    	
        _sldComplaintDeadlineTime.setValue(current.getComplaintReplyDeadline());
        _sldNoActivityThreshold.setValue(current.getMaxUnusedConnectionTime());
        _disconnectOnNoActivity.setSelected(current.getLogoffUnusedConnections());
    }
    
    public void addSaveButton(ActionListener e) {
    	_btnSaveConfig.addActionListener(e);
    }
    
    public ServerConfiguration getConfiguration() {
    	ServerConfiguration ret = new ServerConfiguration(
    			Integer.parseInt(_txtPortNumber.getText()),
    			_txtSqlHost.getText(),
    			_txtSqlDatabase.getText(),
    			_txtSqlUserName.getText(),
    			_txtSqlPassword.getText(),
    			_sldNoActivityThreshold.getValue(),
    			_disconnectOnNoActivity.isSelected(),
    			_sldComplaintDeadlineTime.getValue()
    			);
    	return ret;
    }
    
    private void initComponents(ServerConfiguration current) {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        _txtPortNumber = new JTextField();
        _txtSqlHost = new JTextField();
        _txtSqlUserName = new JTextField();
        _txtSqlPassword = new JTextField();
        _txtSqlDatabase = new JTextField();
        _sldComplaintDeadlineTime = new JSlider();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        _sldNoActivityThreshold = new JSlider();
        _disconnectOnNoActivity = new JCheckBox();
        _btnSaveConfig = new JButton();

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SGI Server Configuration");

        jLabel2.setText("Port:");

        jLabel3.setText("SQL Host:");

        jLabel4.setText("SQL Username:");

        jLabel5.setText("SQL Password:");

        jLabel6.setText("SQL Datebase:");

        _txtPortNumber.setText(String.valueOf(current.getPort()));
        // Limit input box to just numbers, and length of 5
        _txtPortNumber.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {
				if ((arg0.getKeyChar() < '0') || (arg0.getKeyChar() > '9'))
					arg0.consume();
				if (_txtPortNumber.getText().length() >= 5) arg0.consume();				
			}}
        );
        // Don't allow copy/paste
        _txtPortNumber.setTransferHandler(null);
        
        _txtSqlHost.setText(current.getHost());

        _txtSqlUserName.setText(current.getSqlUsername());

        _txtSqlPassword.setText(current.getSqlPassword());

        _txtSqlDatabase.setText(current.getDBName());

        _sldComplaintDeadlineTime.setMajorTickSpacing(1);
        _sldComplaintDeadlineTime.setMaximum(14);
        _sldComplaintDeadlineTime.setMinimum(1);
        _sldComplaintDeadlineTime.setPaintLabels(true);
        _sldComplaintDeadlineTime.setPaintTicks(true);
        _sldComplaintDeadlineTime.setValue(current.getComplaintReplyDeadline());

        jLabel7.setText("Dead line for complaint reply (in days) from day of complaint submition:");

        jLabel8.setText("Max time of no activity before disconnection of client - in minutes:");

        _sldNoActivityThreshold.setMajorTickSpacing(1);
        _sldNoActivityThreshold.setMaximum(10);
        _sldNoActivityThreshold.setMinimum(1);
        _sldNoActivityThreshold.setPaintLabels(true);
        _sldNoActivityThreshold.setPaintTicks(true);
        _sldNoActivityThreshold.setValue(current.getMaxUnusedConnectionTime());

        _disconnectOnNoActivity.setSelected(current.getLogoffUnusedConnections());
        _disconnectOnNoActivity.setText("Disconnect clients with no activity for the defined period of time");

        _btnSaveConfig.setText("Save configuration");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_sldComplaintDeadlineTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(_sldNoActivityThreshold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(_txtPortNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(_txtSqlHost, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(_txtSqlUserName)
                                    .addComponent(_txtSqlPassword)
                                    .addComponent(_txtSqlDatabase)))
                            .addComponent(_disconnectOnNoActivity))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(_btnSaveConfig)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(_txtPortNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(_txtSqlHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(_txtSqlUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(_txtSqlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(_txtSqlDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_sldComplaintDeadlineTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_sldNoActivityThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_disconnectOnNoActivity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_btnSaveConfig)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setResizable(false);
    }                        
}
