/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuanLi;

import View.*;
import View.QuanLi.QuanLiFrame;
import javax.swing.*;
import java.awt.*;
import DAO.*;
import java.util.ArrayList;
import Model.*;
import java.sql.SQLException;
/**
 *
 * @author LEGION
 */
public class QLViewController {
    private StudentQuery qr;
    private QuanLiFrame frame;
    private JPanel main;
    private JScrollPane pane;

    public QLViewController(QuanLiFrame frame, JScrollPane pane) {
        this.frame = frame;
        this.pane = pane;
        this.qr =  new StudentQuery();
    }

    public void setMainPanel(JPanel p) {
        main.removeAll();
        main.setLayout(new BorderLayout());
        main.add(p);
        main.revalidate();
        main.repaint();
    }

    public void setStudentView() throws SQLException{
        ArrayList<SinhVien> sv = qr.getSinhVien();
        for (SinhVien sinhVien : sv) {
            System.out.println(sinhVien);
        }
    }
}
