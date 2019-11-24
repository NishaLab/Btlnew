/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.SinhVien.Panels;

import Model.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author LEGION
 */
public class SVProfilePanel extends javax.swing.JPanel {

    private BufferedImage img;

    /**
     * Creates new form SVProfilePanel
     */
    public SVProfilePanel() {
        initComponents();
    }

    public SVProfilePanel(SinhVien a) {
        initComponents();
        setLayout(new FlowLayout());
        getNameField().setText(a.getTenSv());
        getAddressField().setText(a.getAddress());
        getPhoneField().setText(a.getSdt());
        getDobField().setText(a.getDob().toString());
        getGenderIcon().setText(a.getGioitinh());
        img = profileImageLoader(Integer.toString(a.getMaSv()));
        setProfilePicture(img);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        genderIcon = new javax.swing.JLabel();
        ProfilePicture = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        addressField = new javax.swing.JLabel();
        dobField = new javax.swing.JLabel();
        phoneField = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/QuanLi/ImageIcon/student.png"))); // NOI18N
        jLabel1.setText("Students");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel5.setText("Address");

        jLabel4.setText("Name");

        jLabel8.setText("Gender");

        jLabel6.setText("Date Of Birth");

        jLabel7.setText("Phone Number");

        genderIcon.setText("Gender");

        ProfilePicture.setText("Profile");

        nameField.setText("Name");

        addressField.setText("Address");

        dobField.setText("Date Of Birth");

        phoneField.setText("Phone Number");

        jButton1.setText("Edit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(genderIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(dobField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phoneField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(addressField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dobField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(phoneField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(genderIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private BufferedImage profileImageLoader(String filename) {
        String imagePath = "\\View\\SinhVien\\ProfilePicture\\" + filename + ".png";            // create image path string
        try {
            InputStream in = getClass().getResourceAsStream(imagePath);                        // read file with input stream
            return ImageIO.read(in);                                                           //read image via imageio
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public void setProfilePicture(Image img){                                                  // only accept iconImage
        ImageIcon icon = new ImageIcon(img);                                                   //create icon from image file
        ProfilePicture.setIcon(icon);                                                          //just set 
    };
    
    public JLabel getAddressField() {
        return addressField;
    }

    public void setAddressField(JLabel addressField) {
        this.addressField = addressField;
    }

    public JLabel getDobField() {
        return dobField;
    }

    public void setDobField(JLabel dobField) {
        this.dobField = dobField;
    }

    public JLabel getGenderIcon() {
        return genderIcon;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public void setGenderIcon(JLabel genderIcon) {
        this.genderIcon = genderIcon;
    }

    public JLabel getNameField() {
        return nameField;
    }

    public void setNameField(JLabel nameField) {
        this.nameField = nameField;
    }

    public JLabel getPhoneField() {
        return phoneField;
    }

    public void setPhoneField(JLabel phoneField) {
        this.phoneField = phoneField;
    }

    public JLabel getProfileLabel() {
        return ProfilePicture;
    }

    public void setProfileLabel(JLabel profileLabel) {
        this.ProfilePicture = profileLabel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ProfilePicture;
    private javax.swing.JLabel addressField;
    private javax.swing.JLabel dobField;
    private javax.swing.JLabel genderIcon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameField;
    private javax.swing.JLabel phoneField;
    // End of variables declaration//GEN-END:variables
}
