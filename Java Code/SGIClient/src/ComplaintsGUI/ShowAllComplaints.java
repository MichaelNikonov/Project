

package ComplaintsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import sgi.entities.Complaint;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import client.controllers.ComplaintController;


public class ShowAllComplaints extends javax.swing.JPanel {

    /**
     * Creates new form ShowAllComplaints
     */
	
	protected ComplaintController controller;
    public ShowAllComplaints(ComplaintController controller) {
    	this.controller = controller;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblComplaints = new javax.swing.JTable();
        btnViewSelected = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        message = new javax.swing.JLabel();

        tblComplaints.setAutoCreateRowSorter(true);
        tblComplaints.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CostumerID", "User Name", "Title ", "Date Opened", "Date Closed", "Worker ID", "Worker Name", "Compensation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblComplaints.setColumnSelectionAllowed(true);
        tblComplaints.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblComplaints);
        tblComplaints.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblComplaints.getColumnModel().getColumn(0).setResizable(false);
        tblComplaints.getColumnModel().getColumn(1).setResizable(false);
        tblComplaints.getColumnModel().getColumn(2).setResizable(false);
        tblComplaints.getColumnModel().getColumn(3).setResizable(false);
        tblComplaints.getColumnModel().getColumn(4).setResizable(false);
        tblComplaints.getColumnModel().getColumn(5).setResizable(false);
        tblComplaints.getColumnModel().getColumn(6).setResizable(false);
        tblComplaints.getColumnModel().getColumn(7).setResizable(false);

        btnViewSelected.setText("View Selected Complaint");
        btnViewSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSelectedActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new CancelAction(controller,this));

        message.setForeground(new java.awt.Color(255, 0, 0));
        message.setText("message line");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(183)
        					.addComponent(message, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 891, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(196, Short.MAX_VALUE)
        			.addComponent(btnViewSelected)
        			.addGap(196)
        			.addComponent(btnCancel)
        			.addGap(310))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 598, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(message)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnViewSelected)
        				.addComponent(btnCancel))
        			.addContainerGap(21, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSelectedActionPerformed
        message.setText("");
        DefaultTableModel model = (DefaultTableModel) tblComplaints.getModel();
        if(tblComplaints.getSelectedRow()==-1)
        {
            if(tblComplaints.getRowCount()==0){
                message.setText("There is no complaints");
            }else{
                message.setText("No Complaint selected ");
            }
        }
        else{
        	ViewComplaintGUI showComplaint = new ViewComplaintGUI((String)model.getValueAt(tblComplaints.getSelectedRow(), 1), //UserName
        			                                              (String)model.getValueAt(tblComplaints.getSelectedRow(), 2), //Title 
        			                                              (String)controller.getComplaitBuffer().get(tblComplaints.getSelectedRow()).getContent(),//Content
        			                                              (Date)model.getValueAt(tblComplaints.getSelectedRow(),   3 ),   //date opened
        			                                              (Date)model.getValueAt(tblComplaints.getSelectedRow(),   4 ),   //date closed
        			                                              (float)model.getValueAt(tblComplaints.getSelectedRow(),   5), //compensation
        			                                              (int)model.getValueAt(tblComplaints.getSelectedRow(),   6), //Worker id
        			                                              (String)model.getValueAt(tblComplaints.getSelectedRow(),   7),//Worker name 
        			                                              this                                                          //transfer complaint list instance
        			       			       			
        			        			);
        	showComplaint.setVisible(true);//display selected complaint
        	controller.getAllComplaintsList().setVisible(false);//make all complaints list invisible 
        	
        }
    }//GEN-LAST:event_btnViewSelectedActionPerformed
   class  CancelAction implements ActionListener{
      private ShowAllComplaints allComplaints;
      ComplaintController controller;
	public CancelAction(ComplaintController controller, ShowAllComplaints allComplaintsList){
		this.allComplaints = allComplaintsList;
		this.controller = controller;
	}
	public void actionPerformed(ActionEvent arg0) {
		allComplaints.setVisible(false);//make all complaints list invisible 
		controller.setComplaintBuffer(null);//empty Complaint buffer
		controller.getComplaintWorkerGUI().setVisible(true);//make complaint Worker GUI visible.
	}
	   
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnViewSelected;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel message;
    private javax.swing.JTable tblComplaints;
    // End of variables declaration//GEN-END:variables
	public javax.swing.JTable getTblComplaints() {
		return tblComplaints;
	}
}