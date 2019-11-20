/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuanLi;

import View.QuanLi.QuanLiFrame;
import View.QuanLi.SvDisplayPanel;
import View.QuanLi.*;
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

    private QuanLiFrame frame;
    private JPanel main;

    public QLViewController(QuanLiFrame frame) {
        this.frame = frame;
        this.main = frame.getDisplayPanel();
    }

    public void setMainPanel(JPanel p) {
        main.removeAll();
        main.setLayout(new BorderLayout());
        main.add(p);
        main.revalidate();
        main.repaint();
    }

    public void setStudentView() throws SQLException {
        StudentQuery qr = new StudentQuery();
        System.out.println(
                "through");
        ArrayList<SinhVien> sv = qr.getSinhVien();
        SvDisplayPanel sdp = new SvDisplayPanel(sv);
        main.removeAll();
        setMainPanel(sdp);
        main.revalidate();
    }

    public void setProfessorView() throws SQLException {
        ProfessorQuery qr = new ProfessorQuery();
        System.out.println("through");
        ArrayList<GiangVien> gv = qr.getGiangVien();
        GvDisplayPanel gdp = new GvDisplayPanel(gv);
        main.removeAll();
        setMainPanel(gdp);
        main.revalidate();
    }
    
    public void setCouresView() throws SQLException{
        CourseQuery qr = new CourseQuery();
        ArrayList<MonHoc> mh = qr.getMonHoc();
        MhDisplayPanel mdp = new MhDisplayPanel(mh);
        main.removeAll();
        setMainPanel(mdp);
        main.revalidate();
    }
}
