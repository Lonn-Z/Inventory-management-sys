/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cs.ia.music_mng_sys;

import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

/**
 *
 * @author lakshya
 */
public class Suppliers extends javax.swing.JFrame {
Connection con=null;
PreparedStatement pst=null;
ResultSet rs=null;
Statement stmt=null;
    /**
     * Creates new form Suppliers
     */
    public Suppliers() {
        initComponents();
        show1();
    }
public void search_supplier(){
              DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                 model.setRowCount(0);
              String D=suppliersearchtext.getText();
        try
        {
            Class.forName("java.sql.Driver");

            ResultSet rs=null;

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","abc123456");
            if (D.startsWith("id:")){
              String sql="select * from suppliers where supplier_id=?";
                String query = D.substring(3);
             PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,query);
              rs=pst.executeQuery();
             int i=0;
           while(rs.next())
            {
            Object[] row = new Object[4];
             row[0] = rs.getInt("supplier_id");
            row[1]= rs.getString("supplier_name");
             row[2]= rs.getString("address");
             row[3]= rs.getString("phone");
                     model.addRow(row);             
         }
            }
            else if (D.startsWith("name:")){
                String sql="select * from suppliers where supplier_name=?";
                String query = D.substring(5);
                PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,query);
                rs=pst.executeQuery();
                            int i=0;
           while(rs.next())
            {
            Object[] row = new Object[4];
             row[0] = rs.getInt("supplier_id");
            row[1]= rs.getString("supplier_name");
             row[2]= rs.getString("address");
             row[3]= rs.getString("phone");
                     model.addRow(row);             
         }
            }
            else {
            JOptionPane.showMessageDialog(this,"Please input a valid search query.");
            }
        }
            catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }       
         }
public void show1()
    {
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
               
               
        try

        {

            Class.forName("java.sql.Driver");

            ResultSet rs=null;

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","abc123456");

            String sql="select * from suppliers";

            PreparedStatement pst=con.prepareStatement(sql);

       
          

            rs=pst.executeQuery();
            int i=0;
           while(rs.next())
            {
            Object[] row = new Object[5];
        
         
             row[0] = rs.getInt("supplier_id");
            row[1]= rs.getString("supplier_name");
            row[2]= rs.getString("address");
            row[3]= rs.getString("phone");
                   
                     model.addRow(row);
                    
         }
           }
            catch(Exception e)

        {

            JOptionPane.showMessageDialog(null,e);

        
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveprods = new javax.swing.JButton();
        updateprods = new javax.swing.JButton();
        deleteprods = new javax.swing.JButton();
        backbutton = new javax.swing.JButton();
        searchbutton = new javax.swing.JButton();
        searchbar = new javax.swing.JTextField();
        userlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editsupplierlistbutton = new javax.swing.JButton();
        deletesuppliersbutton = new javax.swing.JButton();
        backbutton1 = new javax.swing.JButton();
        suppliersearchbox = new javax.swing.JButton();
        suppliersearchtext = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        supp_phone = new javax.swing.JTextField();
        suppID = new javax.swing.JTextField();
        suppaddress = new javax.swing.JTextField();
        suppName = new javax.swing.JTextField();
        userlabel1 = new javax.swing.JLabel();
        userlabel2 = new javax.swing.JLabel();
        userlabel3 = new javax.swing.JLabel();
        userlabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        saveprods.setText("SAVE");
        saveprods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveprodsActionPerformed(evt);
            }
        });

        updateprods.setText("UPDATE");
        updateprods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateprodsActionPerformed(evt);
            }
        });

        deleteprods.setText("DELETE");
        deleteprods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteprodsActionPerformed(evt);
            }
        });

        backbutton.setText("BACK");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });

        searchbutton.setText("SEARCH");
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });

        searchbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbarActionPerformed(evt);
            }
        });

        userlabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel.setText("Username:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 540));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Supplier name", "Address", "Phone"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        editsupplierlistbutton.setText("UPDATE");
        editsupplierlistbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editsupplierlistbuttonActionPerformed(evt);
            }
        });

        deletesuppliersbutton.setText("DELETE");
        deletesuppliersbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletesuppliersbuttonActionPerformed(evt);
            }
        });

        backbutton1.setText("BACK");
        backbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton1ActionPerformed(evt);
            }
        });

        suppliersearchbox.setText("SEARCH");
        suppliersearchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersearchboxActionPerformed(evt);
            }
        });

        suppliersearchtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersearchtextActionPerformed(evt);
            }
        });

        addButton.setText("ADD");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        supp_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supp_phoneActionPerformed(evt);
            }
        });

        suppID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppIDActionPerformed(evt);
            }
        });

        suppaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppaddressActionPerformed(evt);
            }
        });

        suppName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppNameActionPerformed(evt);
            }
        });

        userlabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel1.setText("Address:");

        userlabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel2.setText("ID:");

        userlabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel3.setText("Name:");

        userlabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel4.setText("Phone:");

        jButton1.setText("SIGN OUT");
        jButton1.setPreferredSize(new java.awt.Dimension(72, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(suppliersearchtext, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(suppliersearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userlabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userlabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(supp_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(suppID, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suppName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suppaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(editsupplierlistbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(deletesuppliersbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editsupplierlistbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deletesuppliersbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suppID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userlabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(suppName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suppaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userlabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(supp_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suppliersearchbox)
                            .addComponent(suppliersearchtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveprodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveprodsActionPerformed
   
    }//GEN-LAST:event_saveprodsActionPerformed

    private void updateprodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateprodsActionPerformed

    }//GEN-LAST:event_updateprodsActionPerformed

    private void deleteprodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteprodsActionPerformed

        try
        {
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","abc123456");
            String sql="delete from suppliers where supplier_id=?;";
            pst=con.prepareStatement(sql);
            pst.setString(1, suppID.getText());
            int i=pst.executeUpdate();
            if(i>0)
            {
                JOptionPane.showMessageDialog(null,"Data Deleted Successfully!!!");
                suppID.setText("");
                suppName.setText("");
                suppaddress.setText("");

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error Deleting Data!!!");
            }
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                 model.setRowCount(0);
                 show1();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteprodsActionPerformed

    private void editsupplierlistbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editsupplierlistbuttonActionPerformed
        String Id = suppID.getText();
        String Name = suppName.getText();
        String Address = suppaddress.getText();
        String Phone = supp_phone.getText();

        //Bytes person_image=      lbl_img.getBytes();

        //String image= person_image.get

        try {
            Class.forName("java.sql.Driver");
            Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","abc123456");
            /*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
            String sql="update suppliers set supplier_name=?, address= ?, phone=? where supplier_id= ?;";

            //Statement stmt=con.createStatement();
            //ResultSet rs = stmt.executeQuery(sql);
            pst = con.prepareStatement(sql);
            //pst.setString(1, jTextField1.getText());
            pst.setString(1,Name);
            pst.setString(2,Address);
            pst.setString(3,Phone);
               
            pst.setString(4,Id);
            int i=pst.executeUpdate();
            if(i>0)
            {
                JOptionPane.showMessageDialog(null,"Data Updated Successfully!!!");
                suppID.setText("");
                suppName.setText("");
                suppaddress.setText("");
                supp_phone.setText("");

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error Updating Data!!!");
            }
            //JOptionPane.showMessageDialog(null,"Database updated");
 DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                 model.setRowCount(0);
                 show1();
            //new stable().setVisible(true);
        }

        catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }           // TODO add your handling code here:
        

        // TODO add your handling code here:
    }//GEN-LAST:event_editsupplierlistbuttonActionPerformed

    private void deletesuppliersbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletesuppliersbuttonActionPerformed

        try
        {
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","abc123456");
            String sql="delete from suppliers where supplier_id=?;";
            pst=con.prepareStatement(sql);
            pst.setString(1, suppID.getText());
            int i=pst.executeUpdate();
            if(i>0)
            {
                JOptionPane.showMessageDialog(null,"Data Deleted Successfully!!!");
                suppID.setText("");
                suppName.setText("");
                suppaddress.setText("");
                supp_phone.setText("");

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error Deleting Data!!!");
            }
             DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                 model.setRowCount(0);
                 show1();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_deletesuppliersbuttonActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        new Homepage().setVisible(true); this.dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_backbuttonActionPerformed

    private void backbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton1ActionPerformed
        new Homepage().setVisible(true); this.dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_backbutton1ActionPerformed

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
             // TODO add your handling code here:
    }//GEN-LAST:event_searchbuttonActionPerformed

    private void searchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarActionPerformed

    private void suppliersearchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersearchboxActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        search_supplier();         // TODO add your handling code here:
    }//GEN-LAST:event_suppliersearchboxActionPerformed


   
    
    private void suppliersearchtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersearchtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppliersearchtextActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String phon = supp_phone.getText();
        if ((phon.length() < 10) || (phon.length() > 10)) {
            JOptionPane.showMessageDialog(null,"Please input a valid phone number.");
        }
        try {
            Class.forName("java.sql.Driver");
          Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","abc123456");
            /*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
            String sql="insert into suppliers(supplier_id,supplier_name,address,phone) values(?,?,?,?)";

            Statement stmt=con.createStatement();
           // ResultSet rs = pst.executeQuery(sql);
            pst = con.prepareStatement(sql);
            pst.setString(1, suppID.getText());
            pst.setString(2,suppName.getText());
            pst.setString(3,suppaddress.getText());
            pst.setString(4,supp_phone.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null,"Information Added");
 DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                 model.setRowCount(0);
                 show1();
        }

        catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }   
    }//GEN-LAST:event_addButtonActionPerformed

    private void supp_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supp_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supp_phoneActionPerformed

    private void suppIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppIDActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int i = jTable1.getSelectedRow();
 DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
suppID.setText(model.getValueAt(i,0).toString());
suppName.setText(model.getValueAt(i,1).toString());
suppaddress.setText(model.getValueAt(i,2).toString());
supp_phone.setText(model.getValueAt(i,3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void suppNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppNameActionPerformed

    private void suppaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppaddressActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int opt = JOptionPane.showConfirmDialog(
            null,
            "<html>Are you sure you want to logout?<br>You will have to login again.<html>",
            "Confirmation",
            JOptionPane.YES_NO_OPTION);
        if (opt==JOptionPane.YES_OPTION){
            new Login().setVisible(true); this.dispose();
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Suppliers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backbutton;
    private javax.swing.JButton backbutton1;
    private javax.swing.JButton deleteprods;
    private javax.swing.JButton deletesuppliersbutton;
    private javax.swing.JButton editsupplierlistbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton saveprods;
    private javax.swing.JTextField searchbar;
    private javax.swing.JButton searchbutton;
    private javax.swing.JTextField suppID;
    private javax.swing.JTextField suppName;
    private javax.swing.JTextField supp_phone;
    private javax.swing.JTextField suppaddress;
    private javax.swing.JButton suppliersearchbox;
    private javax.swing.JTextField suppliersearchtext;
    private javax.swing.JButton updateprods;
    private javax.swing.JLabel userlabel;
    private javax.swing.JLabel userlabel1;
    private javax.swing.JLabel userlabel2;
    private javax.swing.JLabel userlabel3;
    private javax.swing.JLabel userlabel4;
    // End of variables declaration//GEN-END:variables
}