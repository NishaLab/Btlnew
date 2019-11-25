/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.SinhVien.Panels;

import Model.MonHoc;
import Controller.SinhVien.*;
import View.SinhVien.*;
import View.SinhVien.Panels.Components.CourseComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author LEGION
 */
public class CoursePanel extends javax.swing.JPanel {

    /**
     * Creates new form CoursePanel
     */
    public CoursePanel(ArrayList<MonHoc> mh, RegisterPanel reg) throws SQLException {
        initComponents();
        setLayout(new BorderLayout());
        add(createMhList(mh, reg));
    }

    public static JPanel createMhList(ArrayList<MonHoc> mh, RegisterPanel reg) throws SQLException {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(mh.size(), 1, 1, 1));
        for (MonHoc a : mh) {
            CourseComponent tmp = new CourseComponent(a);
            p1.add(tmp);
            tmp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    reg.createMainPanel(a);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    tmp.setOpaque(true);
                    tmp.setBackground(Color.DARK_GRAY);
                    tmp.setForeground(Color.CYAN);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    tmp.setOpaque(false);
                    tmp.setBackground(Color.WHITE);
                    tmp.setForeground(Color.BLACK);
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
