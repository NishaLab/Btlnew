/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.QuanLi.UtilityPanel;

import java.util.ArrayList;
import javax.swing.JComboBox;
import Model.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author LEGION
 */
public class CourseDetailAddPanel extends javax.swing.JPanel {

    /**
     * Creates new form CourseDetailPanel
     */
    public CourseDetailAddPanel() {
        initComponents();
    }

    public CourseDetailAddPanel(Lich a) {
        initComponents();
        getTimeField().setText(a.getTime());
        getDayField().setText(a.getDay()+"");
        getPeriodField().setText(a.getStart()+"");
        getRoomField().setText(a.getRoomNum());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gvCB = new javax.swing.JComboBox<>();
        okBtt = new javax.swing.JButton();
        dayLabel = new javax.swing.JLabel();
        periodLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        timeField = new javax.swing.JTextField();
        periodField = new javax.swing.JTextField();
        dayField = new javax.swing.JTextField();
        roomField = new javax.swing.JTextField();
        roomLabel = new javax.swing.JLabel();

        gvCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gvCBActionPerformed(evt);
            }
        });

        okBtt.setText("Confirm");

        dayLabel.setText("Day");

        periodLabel.setText("Start Period");

        timeLabel.setText("Time");

        timeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeFieldActionPerformed(evt);
            }
        });

        roomLabel.setText("Room");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(roomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(roomField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(periodLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(periodField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gvCB, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(okBtt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(gvCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(okBtt)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void gvCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gvCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gvCBActionPerformed

    private void timeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeFieldActionPerformed

    public JComboBox<String> getGvCB() {
        return gvCB;
    }

    public void setGvCB(JComboBox<String> gvCB) {
        this.gvCB = gvCB;
    }

    public JButton getOkBtt() {
        return okBtt;
    }

    public void setOkBtt(JButton okBtt) {
        this.okBtt = okBtt;
    }

    public JTextField getDayField() {
        return dayField;
    }

    public void setDayField(JTextField dayField) {
        this.dayField = dayField;
    }

    public JTextField getPeriodField() {
        return periodField;
    }

    public void setPeriodField(JTextField periodField) {
        this.periodField = periodField;
    }

    public JTextField getRoomField() {
        return roomField;
    }

    public void setRoomField(JTextField roomField) {
        this.roomField = roomField;
    }

    public JTextField getTimeField() {
        return timeField;
    }

    public void setTimeField(JTextField timeField) {
        this.timeField = timeField;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dayField;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JComboBox<String> gvCB;
    private javax.swing.JButton okBtt;
    private javax.swing.JTextField periodField;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JTextField roomField;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JTextField timeField;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
