/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cs.ia.music_mng_sys;


import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lakshya
 */
public class products_page extends javax.swing.JFrame {

Connection con=null;
PreparedStatement pst=null;
ResultSet rs=null;
Statement stmt=null;

    /**
     * Creates new form products_page
     */
    public products_page() {
        initComponents();
        show1();
     try

        {
            Class.forName("java.sql.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","abc123456");
            String sql="select * from suppliers";

            PreparedStatement pst=con.prepareStatement(sql);

            rs=pst.executeQuery();
            int i=0;
           while(rs.next())
            {
                String name= rs.getString("supplier_name");
                supplierbox.addItem(name);
                    
         }
           }
            catch(Exception e)

        {

            JOptionPane.showMessageDialog(null,e);

        
        }
    }
    
public void search_product(){
              DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                 model.setRowCount(0);
              String D=productsearchtext1.getText();
        try
        {

            Class.forName("java.sql.Driver");

            ResultSet rs=null;
            ResultSet rs2=null;

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","abc123456");
            if (D.startsWith("id:")){
                String sql="select * from products where product_id=?";
                String query = D.substring(3);
             PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,query);
              rs=pst.executeQuery();
             int i=0;
           while(rs.next())
            {
            Object[] row = new Object[6];
             row[0] = rs.getInt("product_id");
            row[1]= rs.getString("prod_name");
             row[2]= rs.getString("costprice");
             row[3]= rs.getString("saleprice");
             String suppid= rs.getString("supplier_id");
             String sql2="select suppliers.supplier_name from suppliers where suppliers.supplier_id=?";
             PreparedStatement pst2=con.prepareStatement(sql2);
             pst2.setString(1,suppid);
             rs2=pst2.executeQuery();
                 String suppname= rs2.getString(1);
                 row[4]= suppname;
                 row[5]= rs.getString("quantity");
                     model.addRow(row);     
             }   
            }
            else if (D.startsWith("name:")){
                String sql="select * from products where prod_name=?";
                String query = D.substring(5);
                PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1,query);
                rs=pst.executeQuery();
                            int i=0;
           while(rs.next())
            {
            Object[] row = new Object[6];
             row[0] = rs.getInt("product_id");
            row[1]= rs.getString("prod_name");
             row[2]= rs.getString("costprice");
             row[3]= rs.getString("saleprice");
             row[4]= rs.getString("supplier_id");
             row[5]= rs.getString("quantity");
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

            String sql="select products.product_id, products.prod_name, products.costprice, products.saleprice, suppliers.supplier_name, "
                    + "products.quantity from products inner join suppliers where products.supplier_id=suppliers.supplier_id;";

            PreparedStatement pst=con.prepareStatement(sql);
           // pst.setString(1, product_id);
       
          

            rs=pst.executeQuery();
            int i=0;
           while(rs.next())
            {
            Object[] row = new Object[6];
        
         
             row[0] = rs.getInt("product_id");
            row[1]= rs.getString("prod_name");
            row[2]= rs.getString("costprice");
            row[3]= rs.getString("saleprice");
             row[4]= rs.getString("supplier_name");
            row[5]= rs.getString("quantity");
                   
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

        suppliersearchtext = new javax.swing.JTextField();
        suppliersearchbox = new javax.swing.JButton();
        userlabel2 = new javax.swing.JLabel();
        userlabel3 = new javax.swing.JLabel();
        userlabel1 = new javax.swing.JLabel();
        userlabel4 = new javax.swing.JLabel();
        costpricetext = new javax.swing.JTextField();
        saveprods = new javax.swing.JButton();
        updateprods = new javax.swing.JButton();
        deleteprods = new javax.swing.JButton();
        prodID = new javax.swing.JTextField();
        prodName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        salepricetext = new javax.swing.JTextField();
        supplierbox = new javax.swing.JComboBox<>();
        quantitytext = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        backbutton1 = new javax.swing.JButton();
        productsearchtext1 = new javax.swing.JTextField();
        productsearchbox = new javax.swing.JButton();
        userlabel5 = new javax.swing.JLabel();
        userlabel6 = new javax.swing.JLabel();
        userlabel7 = new javax.swing.JLabel();
        userlabel8 = new javax.swing.JLabel();
        userlabel9 = new javax.swing.JLabel();
        userlabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        suppliersearchtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersearchtextActionPerformed(evt);
            }
        });

        suppliersearchbox.setText("SEARCH");
        suppliersearchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersearchboxActionPerformed(evt);
            }
        });

        userlabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel2.setText("ID:");

        userlabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel3.setText("Name:");

        userlabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel1.setText("Address:");

        userlabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel4.setText("Phone:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 540));

        saveprods.setText("ADD");
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

        prodID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodIDActionPerformed(evt);
            }
        });

        prodName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodNameActionPerformed(evt);
            }
        });

        salepricetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salepricetextActionPerformed(evt);
            }
        });

        supplierbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierboxActionPerformed(evt);
            }
        });

        quantitytext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitytextActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product name", "Buying price", "Selling price", "Supplier", "Quantity"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        backbutton1.setText("BACK");
        backbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton1ActionPerformed(evt);
            }
        });

        productsearchtext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsearchtext1ActionPerformed(evt);
            }
        });

        productsearchbox.setText("SEARCH");
        productsearchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsearchboxActionPerformed(evt);
            }
        });

        userlabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel5.setText("ID:");

        userlabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel6.setText("Name:");

        userlabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel7.setText("Cost price:");

        userlabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel8.setText("Sale price:");

        userlabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel9.setText("Supplier:");

        userlabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userlabel10.setText("Quantity:");

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
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productsearchtext1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(productsearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(userlabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userlabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userlabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userlabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userlabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userlabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(prodID)
                                .addComponent(prodName)
                                .addComponent(costpricetext)
                                .addComponent(salepricetext, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(supplierbox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(quantitytext, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveprods, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(updateprods, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteprods, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productsearchbox)
                    .addComponent(productsearchtext1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveprods, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteprods, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateprods, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prodID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userlabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userlabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prodName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userlabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(costpricetext))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(salepricetext, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(userlabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userlabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(supplierbox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userlabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantitytext, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(179, 179, 179)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveprodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveprodsActionPerformed
        try {
            Class.forName("java.sql.Driver");
          Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","abc123456");
            /*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
            String sql="insert into products(product_id,prod_name,costprice, saleprice, supplier_id, quantity) "
                    + "values(?,?,?,?,(Select supplier_id from suppliers where supplier_name=?),?)";
           

            Statement stmt=con.createStatement();
           // ResultSet rs = pst.executeQuery(sql);
            pst = con.prepareStatement(sql);
            pst.setString(1, prodID.getText());
            pst.setString(2,prodName.getText());
            pst.setString(3,costpricetext.getText());
            pst.setString(4,salepricetext.getText());
            pst.setString(5,supplierbox.getSelectedItem().toString());
            pst.setString(6,quantitytext.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null,"Information Added");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();//To show the database change in the table alongside in the products window 
        model.setRowCount(0);
        show1();
        }

        catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }         // TODO add your handling code here:    // TODO add your handling code here:
    }//GEN-LAST:event_saveprodsActionPerformed
  
    private void updateprodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateprodsActionPerformed
        String Id = prodID.getText();
        String Name = prodName.getText();
        String costPrice = costpricetext.getText();
        String salePrice = salepricetext.getText();
        String supplier = supplierbox.getSelectedItem().toString();
        String quantity = quantitytext.getText();

      

        try {
            Class.forName("java.sql.Driver");
            Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","abc123456");
            /*As we are creating a connection on a local computer we will write the url as jdbc:mysql://localhost:3306 */
            String sql="update products set prod_name=?, costprice=?, saleprice=?, quantity=? where product_id=?;";

            //Statement stmt=con.createStatement();
            //ResultSet rs = stmt.executeQuery(sql);
            pst = con.prepareStatement(sql);
            //pst.setString(1, jTextField1.getText());
            pst.setString(1,Name);
            pst.setString(2,costPrice);
            pst.setString(3,salePrice);
         //   pst.setString(4,supplier);
            pst.setString(4,quantity);

            pst.setString(5,Id);
            int i=pst.executeUpdate();
            if(i>0)
            {
                JOptionPane.showMessageDialog(null,"Data updated successfully.");
                prodID.setText("");
                prodName.setText("");
                costpricetext.setText("");
                salepricetext.setText("");
                quantitytext.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error in updating data.");
            }
            //JOptionPane.showMessageDialog(null,"Database updated");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
          show1();  //new stable().setVisible(true);
        }

        catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }           // TODO add your handling code here:
        }

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

           // TODO add your handling code here:
    }//GEN-LAST:event_updateprodsActionPerformed

    private void deleteprodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteprodsActionPerformed

        try
        {
            Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","abc123456");
            String sql="delete from products where product_id=?;";
            pst=con.prepareStatement(sql);
            pst.setString(1, prodID.getText());
            int i=pst.executeUpdate();
            if(i>0)
            {
                JOptionPane.showMessageDialog(null,"Data Deleted Successfully!!!");
                prodID.setText("");
                prodName.setText("");
                costpricetext.setText("");

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error Deleting Data!!!");
            }
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        show1();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteprodsActionPerformed

    private void prodIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodIDActionPerformed

    private void salepricetextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salepricetextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salepricetextActionPerformed

    private void quantitytextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitytextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitytextActionPerformed

    private void supplierboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierboxActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
 DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
prodID.setText(model.getValueAt(i,0).toString());
prodName.setText(model.getValueAt(i,1).toString());
supplierbox.setSelectedItem(model.getValueAt(i,4).toString());
costpricetext.setText(model.getValueAt(i,2).toString());
salepricetext.setText(model.getValueAt(i,3).toString());
quantitytext.setText(model.getValueAt(i,5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void backbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton1ActionPerformed
        new Homepage().setVisible(true); this.dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_backbutton1ActionPerformed

    private void suppliersearchtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersearchtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppliersearchtextActionPerformed

    private void suppliersearchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersearchboxActionPerformed
 // TODO add your handling code here:
    }//GEN-LAST:event_suppliersearchboxActionPerformed

    private void productsearchtext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsearchtext1ActionPerformed
        
    }//GEN-LAST:event_productsearchtext1ActionPerformed

    private void productsearchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsearchboxActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        search_product();         // TODO add your handling code here:
    }//GEN-LAST:event_productsearchboxActionPerformed

    private void prodNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodNameActionPerformed

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
            java.util.logging.Logger.getLogger(products_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(products_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(products_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(products_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new products_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbutton1;
    private javax.swing.JTextField costpricetext;
    private javax.swing.JButton deleteprods;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField prodID;
    private javax.swing.JTextField prodName;
    private javax.swing.JButton productsearchbox;
    private javax.swing.JTextField productsearchtext1;
    private javax.swing.JTextField quantitytext;
    private javax.swing.JTextField salepricetext;
    private javax.swing.JButton saveprods;
    private javax.swing.JComboBox<String> supplierbox;
    private javax.swing.JButton suppliersearchbox;
    private javax.swing.JTextField suppliersearchtext;
    private javax.swing.JButton updateprods;
    private javax.swing.JLabel userlabel1;
    private javax.swing.JLabel userlabel10;
    private javax.swing.JLabel userlabel2;
    private javax.swing.JLabel userlabel3;
    private javax.swing.JLabel userlabel4;
    private javax.swing.JLabel userlabel5;
    private javax.swing.JLabel userlabel6;
    private javax.swing.JLabel userlabel7;
    private javax.swing.JLabel userlabel8;
    private javax.swing.JLabel userlabel9;
    // End of variables declaration//GEN-END:variables
}
