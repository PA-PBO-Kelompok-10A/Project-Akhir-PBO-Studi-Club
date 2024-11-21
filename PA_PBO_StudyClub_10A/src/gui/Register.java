/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import javax.swing.JOptionPane;
import model.Mahasiswa;

/**
 *
 * @author adindasalsabillanaura
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
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

        nameField = new javax.swing.JTextField();
        idUserField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        RegistrasiButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameField.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, 380, 62));

        idUserField.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        getContentPane().add(idUserField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 380, 60));

        passwordField.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        passwordField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 480, 380, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/register.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        RegistrasiButton.setText("jButton1");
        RegistrasiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrasiButtonActionPerformed(evt);
            }
        });
        getContentPane().add(RegistrasiButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 590, 180, 50));

        LoginButton.setText("jButton2");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 653, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void RegistrasiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrasiButtonActionPerformed
    String idUser = idUserField.getText();
    String name =  nameField.getText();
    String password = new String(passwordField.getPassword()); // Gunakan getPassword() untuk JPasswordField

    Mahasiswa mahasiswa = new Mahasiswa(idUser, name, password); // Sesuaikan konstruktor Mahasiswa agar menerima nim, nama, dan password
    
    try {
        if (mahasiswa.daftarMahasiswa()) { // Pastikan metode ini melakukan proses registrasi
            JOptionPane.showMessageDialog(null, "Berhasil Daftar!");
            Login login = new Login();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Gagal Daftar");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
    }
    }//GEN-LAST:event_RegistrasiButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton RegistrasiButton;
    private javax.swing.JTextField idUserField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration//GEN-END:variables
}
