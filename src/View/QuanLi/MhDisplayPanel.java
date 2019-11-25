/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.QuanLi;

import Model.*;
import Controller.QuanLi.*;
import View.QuanLi.SinhVien.MonHocCollumPanel;
import View.QuanLi.SinhVien.MonHocComponent1;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LEGION
 */
public class MhDisplayPanel extends javax.swing.JPanel {

    /**
     * Creates new form MhDisplayPanel
     */
    public MhDisplayPanel(ArrayList<MonHoc> mh, QuanLiFrame frame) throws SQLException {
        initComponents();
        setLayout(new FlowLayout());
        JScrollPane sp = new JScrollPane(createMhList(mh, frame));
        add(sp);
        
    }

    public  JPanel createMhList(ArrayList<MonHoc> mh, QuanLiFrame frame) throws SQLException {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(mh.size()+1, 1, 0, 0));
        MonHocCollumPanel b = new MonHocCollumPanel();
        p1.add(b);
        for (MonHoc a : mh) {
            MonHocComponent1 tmp = new MonHocComponent1(a);
            p1.add(tmp);
            tmp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (tmp.isClick() == false) {
                        frame.setMh(a);
                        tmp.setColorCustom(Color.red);
                        tmp.setClick(true);
                    } else if (tmp.isClick()) {
                        QLViewController qvc = new QLViewController(frame);
                        try {
                            qvc.setCourseDetail(a);
                            frame.setIsStudent(false);
                            frame.setIsCourse(false);
                            frame.setIsProfessor(false);
                            frame.setIsCourseDetail(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(MhDisplayPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
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
