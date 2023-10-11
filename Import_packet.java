/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mimt_honeypot;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Duration;
import java.util.Date;

import java.util.concurrent.TimeUnit;


/**
 *
 * @author EGC
 */
public class Import_packet extends javax.swing.JFrame {

    /**
     * Creates new form Import_packet
     */
    public static String filepath,filepath1;
    public Import_packet() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        view = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        size = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        path1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Packet Details");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 622, 80));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 156, -1));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Attach");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        view.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        view.setText("view");
        view.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMouseClicked(evt);
            }
        });
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        jPanel3.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("File Size:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("File Name:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date Created:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        jPanel4.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 179, -1));
        jPanel4.add(size, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 179, -1));
        jPanel4.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 179, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("File Path:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        jPanel4.add(path1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 179, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_phishing.jpg"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 260));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 110, 420, 260));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Proceed");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 292, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Loaddata.jpg"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 380));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 84, 620, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser("./Files");

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {

            this.filepath = jfc.getSelectedFile().getAbsolutePath();
//             file1=filepath;
            this.filepath1 = jfc.getSelectedFile().getName(); //Get a complete path of the selected file

            jTextField1.setText(jfc.getSelectedFile().getName());
            // ext = getExtension(jfc.getSelectedFile()); //Set a filename to the jTextField1
            //Get a extension of the selected file

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseClicked
        
        // TODO add your handling code here:
//        File fi=new File(filepath);
//        try{
//
//            Scanner inputStream=new Scanner(fi);
//            inputStream.next();
//            while(inputStream.hasNext())
//            {
//                String data=inputStream.next();
//                //String []value=data.split("\\t");
//                jTextArea1.append(data+"\n");
//            }
//            inputStream.close();
//
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//
//        }
    }//GEN-LAST:event_viewMouseClicked

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        // TODO add your handling code here:
        File fi=new File(filepath);
         Path path = FileSystems.getDefault().getPath(filepath);
        BasicFileAttributes attributes = null;
        // System.out.print();
        try{
            try
        {
            attributes =Files.readAttributes(path, BasicFileAttributes.class);
           
        }
        catch (Exception e)
        {
            System.out.println("Exception handled when trying to get file " +
                    "attributes: " + e.getMessage());
        }
        long milliseconds = attributes.creationTime().to(TimeUnit.MILLISECONDS);
        if((milliseconds > Long.MIN_VALUE) && (milliseconds < Long.MAX_VALUE))
        {
            Date creationDate =
                    new Date(attributes.creationTime().to(TimeUnit.MILLISECONDS));

            System.out.println(" created " +
                    creationDate.getDate() + "/" +
                    (creationDate.getMonth() + 1) + "/" +
                    (creationDate.getYear() + 1900));
           date.setText(creationDate.getDate() + "/" +(creationDate.getMonth() + 1) + "/" +
                    (creationDate.getYear() + 1900));
          
//         
//            long time12=attributes.creationTime().to(TimeUnit.DAYS);
//            System.out.println(time12);
//            long HH = time12 / 3600;
//            System.out.println("Hour "+HH);
//            long MM = (time12 % 3600) / 60;
//            System.out.println("min "+MM);
//          
        }
    
//           
               String file_name=fi.getName();
                System.out.println(fi.getName());
                name.setText(file_name);
//                long file_size=fi.getTotalSpace();
//                System.out.println(file_size);
                 long file_size1=fi.length();
                 Long size1=file_size1/1000;
                System.out.print(file_size1/1000);
                size.setText(String.valueOf(size1)+" KB");
                path1.setText(String.valueOf(path));
        }
        catch(Exception e){
         //   JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_viewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Browse().setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(Import_packet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Import_packet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Import_packet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Import_packet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Import_packet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField path1;
    private javax.swing.JTextField size;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}