/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.*;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author LEGION
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        LoginController a = new LoginController(this);
        a.init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        registerBtt = new javax.swing.JButton();
        loginBtt = new javax.swing.JButton();
        pswrd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usr.setText("username");
        usr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usrFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usrFocusLost(evt);
            }
        });
        usr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        jLabel3.setText("UserName");

        registerBtt.setText("Dang Ky");

        loginBtt.setText("Dang Nhap");
        loginBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBttActionPerformed(evt);
            }
        });

        pswrd.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usr, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(pswrd)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginBtt)
                        .addGap(52, 52, 52)
                        .addComponent(registerBtt)))
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usr, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswrd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usrActionPerformed

    private void loginBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginBttActionPerformed

    private void usrFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usrFocusGained
        // TODO add your handling code here:
           if (usr.getText().trim().toLowerCase().equals("username")) {
                    usr.setText("");
                }
    }//GEN-LAST:event_usrFocusGained

    private void usrFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usrFocusLost
        // TODO add your handling code here:
           if (usr.getText().trim().toLowerCase().equals("username")
                        || usr.getText().trim().toLowerCase().equals("")) {
                    usr.setText("username");
                }
    }//GEN-LAST:event_usrFocusLost

    public JButton getLoginBtt() {
        return loginBtt;
    }

    public void setLoginBtt(JButton loginBtt) {
        this.loginBtt = loginBtt;
    }

    public JPasswordField getPswrd() {
        return pswrd;
    }

    public void setPswrd(JPasswordField pswrd) {
        this.pswrd = pswrd;
    }





    public JButton getRegisterBtt() {
        return registerBtt;
    }

    public void setRegisterBtt(JButton registerBtt) {
        this.registerBtt = registerBtt;
    }

    public JTextField getUsr() {
        return usr;
    }

    public void setUsr(JTextField usr) {
        this.usr = usr;
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginBtt;
    private javax.swing.JPasswordField pswrd;
    private javax.swing.JButton registerBtt;
    private javax.swing.JTextField usr;
    // End of variables declaration//GEN-END:variables
}
