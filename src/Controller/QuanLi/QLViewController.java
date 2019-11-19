/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuanLi;

import View.*;
import View.QuanLi.QuanLiFrame;
import View.QuanLi.SvDisplayPanel;
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

    public QLViewController(QuanLiFrame frame) {
        this.frame = frame;
        this.main = frame.getDisplayPanel();
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
        System.out.println("through");
        ArrayList<SinhVien> sv = qr.getSinhVien();
        SvDisplayPanel sdp = new SvDisplayPanel(sv);
        main.removeAll();
        setMainPanel(sdp);
        main.revalidate();
    }

}
