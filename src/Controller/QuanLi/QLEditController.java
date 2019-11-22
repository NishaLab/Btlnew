/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuanLi;

import DAO.CourseQuery;
import DAO.ProfessorQuery;
import DAO.StudentQuery;
import DAO.TimetableQuery;
import Model.GiangVien;
import Model.MonHoc;
import Model.SinhVien;
import Model.Lich;
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
import javax.swing.JComboBox;

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
        MonHoc a = frame.getMh();
        CourseAddPanel cep = setCourseEditPanelAction(a);
        main.removeAll();
        setMainPanel(cep);
        main.revalidate();
        main.repaint();
    }

    public CourseAddPanel setCourseEditPanelAction(MonHoc a) {
        CourseAddPanel cep = new CourseAddPanel(a);
        JButton ok = cep.getOkBtt();
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseQuery cq = new CourseQuery();
                MonHoc abc = new MonHoc();
                abc.setMaMon(a.getMaMon());
                abc.setTenMon(cep.getNameField().getText());
                abc.setKhoa(cep.getFacultyField().getText());
                abc.setSotinchi(Integer.parseInt(cep.getCreditsField().getText()));
                System.out.println(abc);
                cq.updateCourse(abc);
            }
        });
        return cep;
    }

    public void setCourseDetailEditView() {
        System.out.println("course detail");

    }

    public CourseDetailAddPanel setCourseDetailEditAction(Lich a) {
        CourseDetailAddPanel cdap = new CourseDetailAddPanel();
        JButton ok = cdap.getOkBtt();
        ArrayList<GiangVien> gv = frame.getGvList();
        JComboBox<String> cb = cdap.getGvCB();
        for (int i = 0; i < gv.size(); i++) {
            String res = "";
            String id = String.format("%3d", gv.get(i).getMaGv()).replace(' ', '0');
            res = id + " " + gv.get(i).getTenGv();
            cb.addItem(res);
        }
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String time = (String.format("%16s", cdap.getTimeField().getText()).replace(' ', 'x'));
                int start = (Integer.parseInt(cdap.getPeriodField().getText()));
                String room = (cdap.getRoomField().getText());
                String tmp = cb.getSelectedItem().toString();
                int day = Integer.parseInt(cdap.getDayField().getText());
                String P_id = tmp.substring(0, 3);
                int pid = Integer.parseInt(P_id);
                String khoa = a.getKhoa();
                int C_id = a.getIdMon();
                TimetableQuery tq = new TimetableQuery();
                tq.addTimetable(C_id, time, start, day, room, pid, khoa);
            }
        });
        return cdap;
    }

}
