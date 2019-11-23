/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.SinhVien;

import DAO.StudentQuery;
import Model.*;
import View.SinhVien.Panels.*;
import View.SinhVien.*;
import View.SinhVien.Panels.SVEditPanel;
import View.SinhVien.Panels.SVProfilePanel;
import javax.swing.JPanel;
import View.SinhVien.Panels.SinhVienTimetablePanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author LEGION
 */
public class SVViewController {

    SVMainFrame frame;
    private JPanel main;

    public SVViewController(SVMainFrame frame) {
        this.frame = frame;
        this.main = frame.getMainPanel();
    }

    public void setMainPanel(JPanel pn) {
        main.removeAll();
        main.setLayout(new FlowLayout());
        main.add(pn);
        main.revalidate();
        main.repaint();
    }

    public void setTimetableView() {
        SinhVienTimetablePanel svtp = setTimetableViewAction();
        main.removeAll();
        setMainPanel(svtp);
        main.revalidate();
        main.repaint();
    }

    public SinhVienTimetablePanel setTimetableViewAction() {
        SinhVienTimetablePanel svtp = new SinhVienTimetablePanel();
        // bắt sự kiện ở đây
        return svtp;
    }

    public void setProfileView() {
        SinhVien a = frame.getSv();
        System.out.println(a);
        SVProfilePanel svp = setProfileViewAction();
        main.removeAll();
        setMainPanel(svp);
        main.revalidate();
        main.repaint();
    }

    public SVProfilePanel setProfileViewAction() {
        SinhVien a = frame.getSv();
        System.out.println(a);
        SVProfilePanel svp = new SVProfilePanel(a);
        JButton edit = svp.getjButton1();
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setProfileEditView();
            }
        });
        return svp;
    }

    public void setProfileEditView() {
        SVEditPanel sep = setProfileEditViewAction();
        main.removeAll();
        setMainPanel(sep);
        main.revalidate();
        main.repaint();
    }

    public SVEditPanel setProfileEditViewAction() {
        SinhVien a = frame.getSv();
        SVEditPanel sep = new SVEditPanel(a);
        JButton ok = sep.getjButton1();
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SinhVien sv = new SinhVien();
                    sv.setMaSv(a.getMaSv());
                    sv.setAddress(sep.getAddressField().getText());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                    sv.setDob(sdf.parse(sep.getDobField().getText()));
                    sv.setSdt(sep.getPhoneField().getText());
                    sv.setTenSv(sep.getNameField().getText());
                    sv.setGioitinh(sep.getGenderIcon().getText());
                    StudentQuery sq = new StudentQuery();
                    sq.updateStudent(sv);
                    frame.setSv(sv);
                } catch (Exception f) {
                    f.printStackTrace();
                }

            }
        });
        return sep;
    }

    public void setRegisterView() throws SQLException {
        RegisterPanel a = setRegisterViewAction();
        main.removeAll();
        setMainPanel(a);
        main.revalidate();
        main.repaint();
    }

    public RegisterPanel setRegisterViewAction() throws SQLException {
        RegisterPanel rp = new RegisterPanel(frame);
        JButton show = rp.getShowButton();
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Lich> lich = rp.getListLich();
                frame.setListLich(lich);
                ListTimetableView();
            }
        });
        return rp;
    }

    public void ListTimetableView() {
        ArrayList<Lich> lich = frame.getListLich();
        ListPanel lp = new ListPanel(lich);
        main.removeAll();
        setMainPanel(lp);
        main.revalidate();
        main.repaint();
    }
}
