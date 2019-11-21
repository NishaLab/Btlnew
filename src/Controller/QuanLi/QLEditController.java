/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuanLi;

import DAO.ProfessorQuery;
import DAO.StudentQuery;
import Model.GiangVien;
import Model.MonHoc;
import Model.SinhVien;
import View.QuanLi.QuanLiFrame;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import View.QuanLi.UtilityPanel.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import javax.swing.Action;
import javax.swing.JButton;

/**
 *
 * @author LEGION
 */
public class QLEditController {

    private QuanLiFrame frame;
    private JPanel main;

    public QLEditController(QuanLiFrame frame) {
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

    public void setStudentEditView() {
        SinhVien a = frame.getSv();
        SvEditPanel sep = setStudentEditPanelAction(a);

        main.removeAll();
        setMainPanel(sep);
        main.revalidate();
        main.repaint();

    }

    public SvEditPanel setStudentEditPanelAction(SinhVien a) {
        SvEditPanel sep = new SvEditPanel(a);
        JButton bt = sep.getOkBtt();
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SinhVien sv = new SinhVien();
                    sv.setMaSv(a.getMaSv());
                    sv.setAddress(sep.getAddress().getText());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                    sv.setDob(sdf.parse(sep.getDob().getText()));
                    sv.setSdt(sep.getPhoneNUM().getText());
                    sv.setTenSv(sep.getTenSV().getText());
                    String gioitinh = "";
                    if (sep.getjCheckBox1().isSelected() && sep.getjCheckBox2().isSelected() == false) {
                        gioitinh = "M";
                    } else if (sep.getjCheckBox1().isSelected() == false && sep.getjCheckBox2().isSelected()) {
                        gioitinh = "F";
                    }
                    sv.setGioitinh(gioitinh);
                    StudentQuery sq = new StudentQuery();
                    sq.updateStudent(sv);
                } catch (Exception f) {
                    f.printStackTrace();
                }

            }
        });
        return sep;
    }

    public void setProfessorEditView() {
        GiangVien a = frame.getGv();
        GvEditPanel gep = setProfessorEditPanel(a);
        main.removeAll();
        setMainPanel(gep);
        main.revalidate();
        main.repaint();
    }

    public GvEditPanel setProfessorEditPanel(GiangVien a) {
        GvEditPanel gep = new GvEditPanel(a);
        JButton ok = gep.getOkBtt();
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GiangVien gv = new GiangVien();
                    gv.setMaGv(a.getMaGv());
                    gv.setAddress(gep.getAddress().getText());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                    gv.setDob(sdf.parse(gep.getDob().getText()));
                    gv.setSdt(gep.getPhoneNUM().getText());
                    gv.setTenGv(gep.getTenSV().getText());
                    String gioitinh = "";
                    if (gep.getjCheckBox1().isSelected() && gep.getjCheckBox2().isSelected() == false) {
                        gioitinh = "M";
                    } else if (gep.getjCheckBox1().isSelected() == false && gep.getjCheckBox2().isSelected()) {
                        gioitinh = "F";
                    }
                    gv.setGioitinh(gioitinh);
                    gv.setKhoa(gep.getFacultyField().getText());
                    ProfessorQuery pq = new ProfessorQuery();
                    pq.updateProfessor(gv);
                } catch (Exception f) {
                    f.printStackTrace();
                }
            }
        });
        return gep;

    }

    public void setCourseEditView() {
        System.out.println("course");

    }

    public void setCourseDetailEditView() {
        System.out.println("course detail");

    }

}
