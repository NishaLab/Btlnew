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
    ArrayList<GiangVien> gv;
    ArrayList<SinhVien> sv;
    ArrayList<MonHoc> mh;

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
        sv = qr.getSinhVien();
        SvDisplayPanel sdp = new SvDisplayPanel(sv);
        main.removeAll();
        setMainPanel(sdp);
        main.revalidate();
    }

    public void setProfessorView() throws SQLException {
        ProfessorQuery qr = new ProfessorQuery();
        gv = qr.getGiangVien();
        GvDisplayPanel gdp = new GvDisplayPanel(gv);
        main.removeAll();
        setMainPanel(gdp);
        main.revalidate();
    }

    public void setCouresView() throws SQLException {
        CourseQuery qr = new CourseQuery();
        mh = qr.getMonHoc();
        MhDisplayPanel mdp = new MhDisplayPanel(mh,this.frame);
        main.removeAll();
        setMainPanel(mdp);
        main.revalidate();
    }

    public void setCourseDetail(MonHoc a) throws SQLException{
        ProfessorQuery qr = new ProfessorQuery();
        gv = qr.getGiangVien();
        TimetableQuery tq = new TimetableQuery();
        ArrayList<Lich> lich = tq.getLich(a,gv);
        LichDisplayPanel ldp = new LichDisplayPanel(lich);
        main.removeAll();
        setMainPanel(ldp);
        main.revalidate();
    }
}
