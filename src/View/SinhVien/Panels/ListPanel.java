/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.SinhVien.Panels;

import Model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import View.SinhVien.SVMainFrame;
import javax.swing.JLabel;

/**
 *
 * @author LEGION
 */
public class ListPanel extends javax.swing.JPanel {

    /**
     * Creates new form ListPanel
     */
    public ListPanel(HashSet<Lich> lich, SVMainFrame frame) {
        initComponents();
        JScrollPane sp = new JScrollPane(pn(lich, frame));
        JPanel p1 = new JPanel();
        p1.add(sp);
        setMainPanel(p1);

    }

    public JPanel pn(HashSet<Lich> lich, SVMainFrame frame) {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(lich.size()+1, 1, 0, 0));
        LichHocComponent a = new LichHocComponent();
        p1.add(a);
        for (Lich lich1 : lich) {
            LichHocComponent tmp = new LichHocComponent(lich1);
            tmp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    frame.setLichChon(lich1);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    tmp.setOpaque(true);
                    tmp.setColorCustom(Color.CYAN);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    tmp.setOpaque(false);
                    tmp.setColorCustom(Color.BLACK);
                }
            });
            p1.add(tmp);
        }
        return p1;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel.removeAll();
        this.mainPanel.setLayout(new FlowLayout());
        this.mainPanel.add(mainPanel);
        this.mainPanel.revalidate();
        this.mainPanel.repaint();
    }

    public JLabel getDeleteLabel() {
        return deleteLabel;
    }

    public void setDeleteLabel(JLabel deleteLabel) {
        this.deleteLabel = deleteLabel;
    }

    public JLabel getSaveLabel() {
        return saveLabel;
    }

    public void setSaveLabel(JLabel saveLabel) {
        this.saveLabel = saveLabel;
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
        mainPanel = new javax.swing.JPanel();
        deleteLabel = new javax.swing.JLabel();
        saveLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        deleteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/QuanLi/ImageIcon/delete.png"))); // NOI18N
        deleteLabel.setText("Xóa Lịch");

        saveLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/QuanLi/ImageIcon/course.png"))); // NOI18N
        saveLabel.setText("Lưu Lịch");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel saveLabel;
    // End of variables declaration//GEN-END:variables
}
