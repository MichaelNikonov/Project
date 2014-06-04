package server.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ServerGUI extends JFrame {
    
	private static final long serialVersionUID = 7111534598719330859L;
    private JButton _btnConfiguration;
    private JButton _btnServerActivation;
    private JLabel _lblServerStatus;
    private JLabel jLabel1;
	
	public ServerGUI(ActionListener al) {
        initComponents(al);
    }

    private void initComponents(ActionListener al) {

        jLabel1 = new JLabel();
        _lblServerStatus = new JLabel();
        _btnServerActivation = new JButton();
        _btnConfiguration = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SGI Server");

        _lblServerStatus.setText("Server status: off-line");
        _lblServerStatus.setForeground(new Color(255,0,0));
        
        _btnServerActivation.setText("Start server");

        _btnConfiguration.setText("Server configuration");

        _btnServerActivation.addActionListener(al);
        _btnConfiguration.addActionListener(al);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(_lblServerStatus)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(_btnServerActivation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_btnConfiguration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_btnServerActivation, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_lblServerStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_btnConfiguration)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setResizable(false);
    }                       

    public void setServerStart() {
    	_btnServerActivation.setText("Start server");
    	_lblServerStatus.setText("Server status: off-line");
        _lblServerStatus.setForeground(new Color(255,0,0));
    }

    public void setServerStop() {
    	_btnServerActivation.setText("Stop server");
    	_lblServerStatus.setText("Server status: on-line");
        _lblServerStatus.setForeground(new Color(0,255,0));
    }
     
}
