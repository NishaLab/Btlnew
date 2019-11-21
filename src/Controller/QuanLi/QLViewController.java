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
import View.QuanLi.UtilityPanel.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import javax.swing.plaf.synth.Region;

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
        MhDisplayPanel mdp = new MhDisplayPanel(mh, this.frame);
        main.removeAll();
        setMainPanel(mdp);
        main.revalidate();
    }

    public void setCourseDetail(MonHoc a) throws SQLException {
        frame.setIsCourseDetail(true);
        frame.setIsCourse(true);
        ProfessorQuery qr = new ProfessorQuery();
        gv = qr.getGiangVien();
        TimetableQuery tq = new TimetableQuery();
        ArrayList<Lich> lich = tq.getLich(a, gv);
        LichDisplayPanel ldp = new LichDisplayPanel(lich);
        main.removeAll();
        setMainPanel(ldp);
        main.revalidate();
    }

    public void setAddCourseView() {
        System.out.println("add course");

    }

    public void setAddStudentView() {
        SvRegisterPanel srp = setAddStudentAction();
        JScrollPane sp = new JScrollPane(srp);
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(sp);
        main.removeAll();
        setMainPanel(p1);
        main.revalidate();
        main.repaint();

    }

    public SvRegisterPanel setAddStudentAction() {
        SvRegisterPanel reg = new SvRegisterPanel();
        JButton ok = reg.getOkBtt();
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentQuery sq = new StudentQuery();
                String usr = reg.getUsr().getText();
                String pswrd = String.valueOf(reg.getPwrd().getPassword());
                String pswrd2 = String.valueOf(reg.getPsrd2().getPassword());
                if (pswrd.equalsIgnoreCase(pswrd2)) {
                    try {
                        SinhVien sv = new SinhVien();
                        sv.setTenSv(reg.getTenSV().getText());
                        String address = reg.getAddress().getText();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        sv.setAddress(address);
                        sv.setDob(sdf.parse(reg.getDob().getText()));
                        sv.setSdt(reg.getPhoneNUM().getText());
                        String gioitinh = "";
                        if (reg.getMaleCheckbox().isSelected() && reg.getFemaleChechbox().isSelected() == false) {
                            gioitinh = "M";
                        } else if (reg.getMaleCheckbox().isSelected() == false && reg.getFemaleChechbox().isSelected()) {
                            gioitinh = "F";

                        }
                        sv.setGioitinh(gioitinh);
                        if (reg.getTermAccept().isSelected()) {
                            sq.addStudent(usr, pswrd, sv);
                            frame.setVisible(true);
                        }
                    } catch (Exception f) {
                        f.printStackTrace();
                    }
                }
            }
        });
        JPasswordField pswrd = reg.getPwrd();
        pswrd.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(pswrd.getPassword()).trim().equals("jPasswordField1")) {
                    pswrd.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(pswrd.getPassword()).trim().equals("jPasswordField1")
                        || String.valueOf(pswrd.getPassword()).trim().equals("")) {
                    pswrd.setText("jPasswordField1");
                }
            }
        });
        JPasswordField pswrd2 = reg.getPsrd2();
        pswrd2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(pswrd2.getPassword()).trim().equals("jPasswordField2")) {
                    pswrd2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(pswrd2.getPassword()).trim().equals("jPasswordField2")
                        || String.valueOf(pswrd2.getPassword()).trim().equals("")) {
                    pswrd2.setText("jPasswordField1");
                }
            }
        });
        return reg;
    }

    public void setAddProfessorView() {
        System.out.println("add professor");

    }

    public void setAddCourseDetailView() {
        System.out.println("add course detail");

    }

}
