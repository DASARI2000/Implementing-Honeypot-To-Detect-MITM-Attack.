/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mimt_honeypot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author EGC
 */
public class Split extends javax.swing.JFrame {

    /**
     * Creates new form Split
     */
     Connection con = null;
    Statement stmt,stmt1,stmt2,stmt3 = null;
    ResultSet rs,rs1,rs2;
    ResultSetMetaData rsmd;
    Vector columnNames =new Vector();
    Vector data=new Vector();
    Vector columnNames1 = new Vector();
    Vector data1 = new Vector();
    
     String[] s_no=new String[1000000];
  String[] time_created=new String[1000000];
   String[] source_ip=new String[1000000];
   String[] destination_ip=new String[1000000];
   String[] protocol=new String[1000000];
   String[] length=new String[1000000];
   String[] info=new String[1000000];
   String[] target=new String[1000000];

    public Split() {
        initComponents();
    }
     int i=0;
                int i1=2;
                int i2=1;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Trained Data", jScrollPane1);

        jTable2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Test Data", jScrollPane2);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 503, 308));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Split");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 229, -1, -1));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Proceed");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 352, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 520));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Split Dataset");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Loaddata.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 590, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        try
//        {
//
//            // System.out.println(s1);
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/honeypot_mimt", "root", "");
//            Statement stmt = con.createStatement();
//            Statement stmt1 = con.createStatement();
//
//            ResultSet rs = stmt.executeQuery("select * from preprocess");
//            // ResultSet rs1 = stmt.executeQuery("select count(*) as rowcount  from preprocess ");
//            //where label= '"+s1+"' ");
//
//            while(rs.next())
//            {
//
//                /* i=i/100*20;
//                System.out.println(i);*/
//                // int size = rs.getRow();
//                 s_no[i]=rs.getString("s_no");
//                time_created[i]=rs.getString("time_created");
//                source_ip[i]=rs.getString("source_ip");
//                destination_ip[i]=rs.getString("destination_ip");
//                protocol[i]=rs.getString("protocol");
//                length[i]=rs.getString("length");
//                info[i]=rs.getString("info");
//                target[i]=rs.getString("target");
//                
//                // System.out.println("Value:"+rs.getString(1));
//                i++;
//                i1=i/100*80;
//            }
//            DefaultTableModel model=new DefaultTableModel();
//            jTable1.setModel(model);
//            model.addColumn("S No.");
//            model.addColumn("time_created");
//            model.addColumn("source_ip");
//            model.addColumn("destination_ip");
//            model.addColumn("protocol");
//            model.addColumn("length");
////            mode2.addColumn("paket_rate");
//            model.addColumn("info");
//           model.addColumn("target");
//           
//
//            //model.addColumn("duration");
//            PrintWriter out = new PrintWriter("Train.txt");
//
//            for(int j=1;j<i1+1;j++)
//            {
//                
//                model.addRow(new Object[] {s_no[j],time_created[j],source_ip[j],destination_ip[j],
//                    protocol[j],length[j], info[j], target[j]});
//
//                if(target[j].equals("2")){
//
//                    out.println(time_created[j]+","+source_ip[j]+","+destination_ip[j]+","+protocol[j]+","
//                        + ""+length[j]+","+info[j]+","+target[j]);
//                }
//                if(target[j].equals("1")){
//
//                     out.println(time_created[j]+","+source_ip[j]+","+destination_ip[j]+","+protocol[j]+","+length[j]+","+info[j]+","+target[j]);
//                }
//            }
//
//            out.close();
//
//        }catch(Exception e)
//        {
//
//            System.out.println(e.getMessage());
//        }
//
//        try
//        {
//            /* int i=0;
//            int i1=0;*/
//
//            // System.out.println(s1);
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/honeypot_mimt", "root", "");
//            Statement stmt = con.createStatement();
//            Statement stmt1 = con.createStatement();
//            ResultSet rs = stmt1.executeQuery("select COUNT(*) from preprocess");
//            rs.next();
//            String count=rs.getString(1);
//            //System.out.println(i1);
//            //System.out.println(count);
//            ResultSet rs1 = stmt1.executeQuery("select * from preprocess limit "+i1+","+count+"");
//            // ResultSet rs1 = stmt1.executeQuery("select * from preprocess limit 1600,2");
//            while(rs1.next())
//            {
//                //System.out.println(xFlow_ID[i]);
//                //System.out.println(rs1.getString("Scr_pkts"));
//               s_no[i2]=rs1.getString("s_no");
//                time_created[i2]=rs1.getString("time_created");
//                source_ip[i2]=rs1.getString("source_ip");
//                destination_ip[i2]=rs1.getString("destination_ip");
//                protocol[i2]=rs1.getString("protocol");
//                length[i2]=rs1.getString("length");
//                info[i2]=rs1.getString("info");
//                target[i2]=rs1.getString("target");
//                i2++;
//            }
//            DefaultTableModel mode2=new DefaultTableModel();
//            jTable2.setModel(mode2);
//            mode2.addColumn("S No.");
//            mode2.addColumn("time_created");
//            mode2.addColumn("source_ip");
//            mode2.addColumn("destination_ip");
//            mode2.addColumn("protocol");
//            mode2.addColumn("length");
////            mode2.addColumn("paket_rate");
//            mode2.addColumn("info");
//           mode2.addColumn("target");
//
//            PrintWriter out = new PrintWriter("Test.txt");
//            //PrintWriter out = new PrintWriter("./");
//            for(int j=1;j<i2+1;j++)
//            {
//
//               mode2.addRow(new Object[] {s_no[j],time_created[j],source_ip[j],destination_ip[j],
//                    protocol[j],length[j], info[j], target[j]});
//
//
//                if(target[j].equals("2")){
//
//                    out.println(time_created[j]+","+source_ip[j]+","+destination_ip[j]+","+protocol[j]+","
//                       +length[j]+","+info[j]+","+target[j]);
//                }
//                if(target[j].equals("1")){
//
//                   out.println(time_created[j]+","+source_ip[j]+","+destination_ip[j]+","+protocol[j]+","
//                        +length[j]+","+info[j]+","+target[j]);
//                }
//                //out.println(j);
//            }
//            out.close();
//        }catch(Exception e)
//        {
//
//            System.out.println(e.getMessage());
//        }
try{
Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/honeypot_mimt", "root", "");
            Statement stmt = con.createStatement();
            Statement stmt1 = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from preprocess");

              PrintWriter pw = new PrintWriter(new File("train.csv"));

            StringBuffer csvHeader = new StringBuffer("");
            StringBuffer csvData = new StringBuffer("");
            //csvHeader.append("AccX,AccY,AccZ,GyroX,GyroY,GyroZ,Class,Timestamp\n");
            // pw.write(csvHeader.toString());
            while(rs.next())
            {

                s_no[i]=rs.getString("s_no");
                time_created[i]=rs.getString("time_created");
                source_ip[i]=rs.getString("source_ip");
                destination_ip[i]=rs.getString("destination_ip");
                protocol[i]=rs.getString("protocol");
                length[i]=rs.getString("length");
                info[i]=rs.getString("info");
                target[i]=rs.getString("target");
                i++;
                i1=i/100*80;
            }
            DefaultTableModel model=new DefaultTableModel();
            jTable1.setModel(model);
           
            model.addColumn("S No.");
            model.addColumn("time_created");
            model.addColumn("source_ip");
            model.addColumn("destination_ip");
            model.addColumn("protocol");
            model.addColumn("length");
//            mode2.addColumn("paket_rate");
            model.addColumn("info");
           model.addColumn("target");

            // PrintWriter out = new PrintWriter("../src/Train.txt");
            System.out.println(i1);
            for(int j=1;j<i1+1;j++)
            {
             
            csvData.append(s_no[j]);
            csvData.append(',');
            csvData.append(time_created[j]);
            csvData.append(',');
            csvData.append(source_ip[j]);
            csvData.append(',');
            csvData.append(destination_ip[j]);
            csvData.append(',');
            csvData.append(protocol[j]);
            csvData.append(',');
            csvData.append(length[j]);
            csvData.append(',');
          
            csvData.append(info[j]);
           csvData.append(',');
              csvData.append(target[j]);
            
                csvData.append('\n');

                model.addRow(new Object[] {s_no[j],time_created[j],source_ip[j],destination_ip[j],protocol[j],length[j],info[j],target[j]});

            }
             pw.write(csvData.toString());
            pw.close();

            //out.close();

        }catch(Exception e)
        {

            System.out.println(e.getMessage());
        }

        try
        {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/honeypot_mimt", "root", "");
            Statement stmt = con.createStatement();
            Statement stmt1 = con.createStatement();
            ResultSet rs = stmt1.executeQuery("select COUNT(*) from preprocess");
            rs.next();
            String count=rs.getString(1);
            System.out.println(i1);
            System.out.println(count);
            ResultSet rs1 = stmt1.executeQuery("select * from preprocess limit "+i1+","+count+"");
            // ResultSet rs1 = stmt1.executeQuery("select * from preprocess limit 1600,2");
           PrintWriter pw = new PrintWriter(new File("test.csv"));
           BufferedWriter writer = new BufferedWriter(new FileWriter("../RealLabel.txt"));
            StringBuffer csvHeader = new StringBuffer("");
            StringBuffer csvData = new StringBuffer("");
           // csvHeader.append("AccX,AccY,AccZ,GyroX,GyroY,GyroZ,Timestamp\n");

      // write header
            // pw.write(csvHeader.toString());

      // write data
    
            while(rs1.next())
            {

                s_no[i2]=rs1.getString("s_no");
                time_created[i2]=rs1.getString("time_created");
                source_ip[i2]=rs1.getString("source_ip");
                destination_ip[i2]=rs1.getString("destination_ip");
                protocol[i2]=rs1.getString("protocol");
                length[i2]=rs1.getString("length");
                info[i2]=rs1.getString("info");
                target[i2]=rs1.getString("target");

                i2++;
            }
            DefaultTableModel mode2=new DefaultTableModel();
            jTable2.setModel(mode2);
            mode2.addColumn("S No.");
            mode2.addColumn("time_created");
            mode2.addColumn("source_ip");
            mode2.addColumn("destination_ip");
            mode2.addColumn("protocol");
            mode2.addColumn("length");
//            mode2.addColumn("paket_rate");
            mode2.addColumn("info");
           mode2.addColumn("target");

            // PrintWriter out = new PrintWriter("../src/Test.txt");
            for(int j=1;j<i2+1;j++)
            {
                
            csvData.append(s_no[j]);
            csvData.append(',');
            csvData.append(time_created[j]);
            csvData.append(',');
            csvData.append(source_ip[j]);
            csvData.append(',');
            csvData.append(destination_ip[j]);
            csvData.append(',');
            csvData.append(protocol[j]);
            csvData.append(',');
            csvData.append(length[j]);
            csvData.append(',');
          
            csvData.append(info[j]);
           csvData.append(',');
              csvData.append(target[j]);
            
                csvData.append('\n');
             
            
            
                mode2.addRow(new Object[] {s_no[j],time_created[j],source_ip[j],destination_ip[j],protocol[j],length[j],info[j],target[j]});

            }
            pw.write(csvData.toString());
            pw.close();
            writer.close();
            //out.close();
        }catch(Exception e)
        {

            System.out.println(e.getMessage());
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Classify().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Split.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Split.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Split.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Split.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Split().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
