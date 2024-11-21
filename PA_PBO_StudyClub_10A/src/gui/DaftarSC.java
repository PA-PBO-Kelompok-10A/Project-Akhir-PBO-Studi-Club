/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.sql.PreparedStatement;
import model.StudyClub;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import model.Database;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author adindasalsabillanaura
 */
public class DaftarSC extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    /**
     * Creates new form MenuAdmin
     */
    public DaftarSC() {
        initComponents();
        Database.connect();
        loadStudyClubData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSC = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        sortdesscendingButton = new javax.swing.JButton();
        sortasscendingButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchField.setBorder(null);
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, 320, 50));

        tabelSC.setBackground(new java.awt.Color(153, 204, 255));
        tabelSC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "jadwal", "nama", "kapasitas", "deskripsi", "jenis"
            }
        ));
        jScrollPane1.setViewportView(tabelSC);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 650, 400));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/daftarsc.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 780));

        homeButton.setText("jButton1");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 150, 60));

        searchButton.setText("jButton1");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, -1, 70));

        sortdesscendingButton.setText("jButton2");
        sortdesscendingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortdesscendingButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sortdesscendingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 220, 70, 60));

        sortasscendingButton.setText("jButton3");
        sortasscendingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortasscendingButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sortasscendingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 70, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        MenuMahasiswa menuMahasiswa = new MenuMahasiswa();
        menuMahasiswa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed

    }//GEN-LAST:event_searchFieldActionPerformed

    private void sortasscendingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortasscendingButtonActionPerformed
        loadStudyClubDataAscending();
    }//GEN-LAST:event_sortasscendingButtonActionPerformed

    private void sortdesscendingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortdesscendingButtonActionPerformed
        loadStudyClubDataDescending();
    }//GEN-LAST:event_sortdesscendingButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
       loadStudyClubDataSearching();
    }//GEN-LAST:event_searchButtonActionPerformed
    
    private void loadStudyClubDataAscending() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Jadwal");
        tableModel.addColumn("Nama");
        tableModel.addColumn("Kapasitas");
        tableModel.addColumn("Deskripsi");
        tableModel.addColumn("Jenis");
        try {
            Statement statement = Database.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM study_club ORDER BY nama_sc ASC");
            while (resultSet.next()) {                
                String jadwalSC = resultSet.getString("jadwal_sc");
                String namaSC = resultSet.getString("nama_sc");
                String kapasitasSC = resultSet.getString("kapasitas_sc");
                String deskripsiSC = resultSet.getString("deskripsi_sc");
                String jenisSC = resultSet.getString("jenis_sc");
                
                tableModel.addRow(new Object[]{
                    jadwalSC,
                    namaSC,
                    kapasitasSC,
                    deskripsiSC,
                    jenisSC});
                tabelSC.setModel(tableModel);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private void loadStudyClubDataDescending() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Jadwal");
        tableModel.addColumn("Nama");
        tableModel.addColumn("Kapasitas");
        tableModel.addColumn("Deskripsi");
        tableModel.addColumn("Jenis");
        try {
            Statement statement = Database.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM study_club ORDER BY nama_sc DESC");
            while (resultSet.next()) {                
                String jadwalSC = resultSet.getString("jadwal_sc");
                String namaSC = resultSet.getString("nama_sc");
                String kapasitasSC = resultSet.getString("kapasitas_sc");
                String deskripsiSC = resultSet.getString("deskripsi_sc");
                String jenisSC = resultSet.getString("jenis_sc");
                
                tableModel.addRow(new Object[]{
                    jadwalSC,
                    namaSC,
                    kapasitasSC,
                    deskripsiSC,
                    jenisSC});
                tabelSC.setModel(tableModel);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private void loadStudyClubDataSearching() {
        tableModel = new DefaultTableModel();
        tableModel.setRowCount(0);
        tableModel.addColumn("Jadwal");
        tableModel.addColumn("Nama");
        tableModel.addColumn("Kapasitas");
        tableModel.addColumn("Deskripsi");
        tableModel.addColumn("Jenis");
        try {
            String nama = searchField.getText();
            System.out.println(nama);
            String query = "SELECT * FROM study_club WHERE nama_sc = ?";
            PreparedStatement preparedStatement = Database.connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                String jadwalSC = resultSet.getString("jadwal_sc");
                String namaSC = resultSet.getString("nama_sc");
                String kapasitasSC = resultSet.getString("kapasitas_sc");
                String deskripsiSC = resultSet.getString("deskripsi_sc");
                String jenisSC = resultSet.getString("jenis_sc");
                
                tableModel.addRow(new Object[]{
                    jadwalSC,
                    namaSC,
                    kapasitasSC,
                    deskripsiSC,
                    jenisSC});
                tabelSC.setModel(tableModel);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private void loadStudyClubData() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setRowCount(0);
        tableModel.addColumn("Jadwal");
        tableModel.addColumn("Nama");
        tableModel.addColumn("Kapasitas");
        tableModel.addColumn("Deskripsi");
        tableModel.addColumn("Jenis");
        try {
            Statement statement = Database.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM study_club");
            while (resultSet.next()) {                
                String jadwalSC = resultSet.getString("jadwal_sc");
                String namaSC = resultSet.getString("nama_sc");
                String kapasitasSC = resultSet.getString("kapasitas_sc");
                String deskripsiSC = resultSet.getString("deskripsi_sc");
                String jenisSC = resultSet.getString("jenis_sc");
                
                tableModel.addRow(new Object[]{
                    jadwalSC,
                    namaSC,
                    kapasitasSC,
                    deskripsiSC,
                    jenisSC});
                tabelSC.setModel(tableModel);
            }
            
        } catch (Exception e) {
        }
        
    }

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
            java.util.logging.Logger.getLogger(DaftarSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarSC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton sortasscendingButton;
    private javax.swing.JButton sortdesscendingButton;
    private javax.swing.JTable tabelSC;
    // End of variables declaration//GEN-END:variables
}
