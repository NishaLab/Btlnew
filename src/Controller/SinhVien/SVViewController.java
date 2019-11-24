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
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import DAO.*;
import java.util.HashSet;

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
        ArrayList<Lich> list = new ArrayList<>(frame.getSetLich());
        SinhVienTimetablePanel svtp = new SinhVienTimetablePanel(list, frame.getSv());
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
                ArrayList<Lich> moi = rp.getListLich();
                frame.setListLichMoi(moi);
//                ArrayList<Lich> lich2 = frame.getListLich();
                HashSet<Lich> lich = rp.getSetLich();
                HashSet<Lich> lich2 = frame.getSetLich();
                lich2.addAll(lich);
                frame.setSetLich(lich2);
                ListTimetableView();
            }
        });
        return rp;
    }

    public void ListTimetableView() {
        HashSet<Lich> lich = frame.getSetLich();
        ListPanel lp = setListTimetableViewAction(lich);
        main.removeAll();
        setMainPanel(lp);
        main.revalidate();
        main.repaint();
    }

    public ListPanel setListTimetableViewAction(HashSet<Lich> lich) {
        ListPanel lp = new ListPanel(lich, frame);
        JLabel delete = lp.getDeleteLabel();
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Lich tmp = frame.getLichChon();
                if (lich.contains(tmp)) {
                    lich.remove(tmp);
                    System.out.println(tmp);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                delete.setOpaque(true);
                delete.setBackground(Color.DARK_GRAY);
                delete.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                delete.setOpaque(false);
                delete.setBackground(Color.WHITE);
                delete.setForeground(Color.BLACK);
            }
        });
        JLabel save = lp.getSaveLabel();
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TimetableStudentQuery tsq = new TimetableStudentQuery();
                for (Lich lich1 : frame.getListLichMoi()) {
                    tsq.addTimetable(frame.getSv().getMaSv(), lich1.getIdLich());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                save.setOpaque(true);
                save.setBackground(Color.DARK_GRAY);
                save.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                save.setOpaque(false);
                save.setBackground(Color.WHITE);
                save.setForeground(Color.BLACK);
            }
        });
        return lp;

    }
}
