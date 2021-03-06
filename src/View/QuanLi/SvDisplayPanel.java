/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.QuanLi;

import Model.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import View.QuanLi.SinhVien.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author LEGION
 */
public class SvDisplayPanel extends javax.swing.JPanel {

    /**
     * Creates new form SvDisplayPanel
     */
    public SvDisplayPanel(ArrayList<SinhVien> sv, QuanLiFrame frame) {
        initComponents();
        setLayout(new BorderLayout());
        JScrollPane sp = new JScrollPane(createSvList(sv, frame),
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(sp);
    }

    public JPanel createSvList(ArrayList<SinhVien> sv, QuanLiFrame frame) {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(sv.size() + 1, 1, 0, 0));
        SinhVienComponent a = new SinhVienComponent();
        p1.add(a);
        ArrayList<SinhVienComponent> list = new ArrayList<>();
        for (SinhVien sinh : sv) {
            SinhVienComponent tmp = new SinhVienComponent(sinh);
            p1.add(tmp);
            tmp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (JOptionPane.showConfirmDialog(null, "Ban co muon Chon Mon Hoc " + sinh.getTenSv() + " " + sinh.getMaSv(),
                            "Pick", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION) == 0) {
                        frame.setSv(sinh);
                    }
                }

                public void mouseEntered(MouseEvent e) {
                    tmp.setOpaque(true);
                    tmp.setBackground(Color.DARK_GRAY);
                    tmp.setColorCustom(Color.CYAN);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    tmp.setOpaque(false);
                    tmp.setBackground(Color.WHITE);
                    tmp.setColorCustom(Color.BLACK);
                }

            }
            );
        }

        return p1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
