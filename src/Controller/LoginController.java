/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
import View.QuanLi.QuanLiFrame;
import DAO.*;
import View.SinhVien.SVFrame;
import View.SinhVien.SVMainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author LEGION
 */
public class LoginController {

    private LoginFrame frame;
    private Connection conn;

    public LoginController(LoginFrame frame) {
        this.frame = frame;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/realbtl"
                    + "?useUnicode=true&characterEncoding=utf-8", "newuser", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void init() {
        setActionLogin();
    }

    public void setActionLogin() {  // xu ly dang nhap
        JButton login = frame.getLoginBtt();
        AbstractAction logPressed = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String user = frame.getUsr().getText();
                    String pass = String.valueOf(frame.getPswrd().getPassword());
                    System.out.println(pass);
                    String sql = "SELECT * FROM realbtl.user WHERE usr = '" + user + "' AND pswd = '" + pass + "'";
                    PreparedStatement ps = conn.prepareStatement(sql);

                    if (user.equals("admin") && pass.equals("123456")) {  // neu nhap admin thi vao form quan li(them sua xoa)
                        QuanLiFrame form = new QuanLiFrame();
                        form.setVisible(true);
                        form.setLocationRelativeTo(null);
                        frame.dispose();

                    } else {   // con neu nhap nguoi dung thi vao frame nguoi dung(pick tkb)
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            int ma = rs.getInt(1);
                            StudentQuery sq = new StudentQuery();
                            SinhVien a = sq.getSinhVien2(ma);
                            System.out.println(a);
                            SVMainFrame form = new SVMainFrame(a);
                            form.setVisible(true);
                            form.pack();
                            form.setLocationRelativeTo(null);
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "username/password Khong hop le", "Loi Dang Nhap", 2);
                        }
                    }

                } catch (Exception f) {
                    f.printStackTrace();
                }
            }
        };
        login.addActionListener(logPressed);
        JLabel register = frame.getRegisterLabel();
        register.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterFrame reg = setException();
                //wwut
                reg.setVisible(true);
                frame.setVisible(false);
                JButton ok = reg.getOkBtt();
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String usr = reg.getUsr().getText();
                        String pswrd = String.valueOf(reg.getPwrd().getPassword());
                        String pswrd2 = String.valueOf(reg.getPsrd2().getPassword());
                        if (pswrd.equalsIgnoreCase(pswrd2)) {
                            try {
                                SinhVien sv = new SinhVien();
                                sv.setTenSv(reg.getTenSV().getText());
                                String address = reg.getAddress().getText();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                sv.setDob(sdf.parse(reg.getDob().getText()));
                                sv.setSdt(reg.getPhoneNUM().getText());
                                String gioitinh;
                                if (reg.getMaleCheckbox().isSelected()) {
                                    gioitinh = "M";
                                } else {
                                    gioitinh = "F";

                                }
                                sv.setGioitinh(gioitinh);
                                if (reg.getTermAccept().isSelected()) {
                                    addSV(usr, pswrd, sv);
                                    frame.setVisible(true);
                                    reg.dispose();
                                }

                            } catch (Exception f) {
                            }

                        }
                    }
                });
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }

    public RegisterFrame setException() {
        RegisterFrame register = new RegisterFrame();
        register.getTenSV().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (register.getTenSV().getText().trim().equals("")) {
                    register.getNameLabel().setText("Vui Long Nhap ten Sinh Vien");
                }
            }
        });
        return register;
    }

    public void addSV(String usr, String pswrd, SinhVien a) {
        String sql = "INSERT INTO realbtl.user(username,password) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usr);
            ps.setString(2, pswrd);
            ps.executeUpdate();
            System.out.println("Through");
            sql = "INSERT INTO realbtl.student (name, dob, address, sdt, Sex) VALUES(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, a.getTenSv());
            ps.setDate(2, new Date(a.getDob().getTime()));
            ps.setString(3, a.getAddress());
            ps.setString(4, a.getSdt());
            ps.setString(5, a.getGioitinh());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Them Sinh Vien thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SinhVien khong hop le");
            e.printStackTrace();
        }

    }
}
