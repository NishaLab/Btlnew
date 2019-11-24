/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.QuanLi;

import Model.*;
import View.QuanLi.SinhVien.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author LEGION
 */
public class LichDisplayPanel extends javax.swing.JPanel {

    /**
     * Creates new form LichDisplayPanel
     */
    public LichDisplayPanel() {
        initComponents();
    }

    public LichDisplayPanel(ArrayList<Lich> lich,QuanLiFrame frame) {
        initComponents();
                setLayout(new FlowLayout());

        JScrollPane sp = new JScrollPane(createLichList(lich,frame));
        add(sp);
    }

    public JPanel createLichList(ArrayList<Lich> lich,QuanLiFrame frame) {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(lich.size() + 1, 1, 0, 0));
        ArrayList<LichHocComponent> list = new ArrayList<>();
        LichCollumPanel a = new LichCollumPanel();
        p1.add(a);
        for (Lich li:lich) {
            LichHocComponent tmp = new LichHocComponent(li);
            p1.add(tmp);
            tmp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    frame.setLich(li);
                    tmp.setOpaque(true);
                    tmp.setColorCustom(Color.RED);
                }
            });
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
