/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
import View.QuanLi.QuanLiFrame;
import View.SinhVien.SVFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import java.sql.*;
import java.text.SimpleDateFormat;
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
                    + "?useUnicode=true&characterEncoding=utf-8", "root", "0963063105");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void init() {
        setActionLogin();
    }

    public void setActionLogin() {  // xu ly dang nhap
//        JTextField tf1 = frame.getPassword();
//        tf1.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                if (tf1.getText().trim().toLowerCase().equals("username")) {
//                    tf1.setText("");
//                }
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if (tf1.getText().trim().toLowerCase().equals("username")
//                        || tf1.getText().trim().toLowerCase().equals("")) {
//                    tf1.setText("username");
//                }
//            }
//        });

        JButton login = frame.getLoginBtt();

        login.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                String sql = "SELECT username, password FROM realbtl.user WHERE username = ? AND password = ?";
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs;
                    String user = frame.getUsr().getText();
                    String pass = String.valueOf(frame.getPswrd().getPassword());
                    if (user.equals("admin") && pass.equals("123456")) {  // neu nhap admin thi vao form quan li(them sua xoa)
                        QuanLiFrame form = new QuanLiFrame();
                        form.setVisible(true);
                        form.setLocationRelativeTo(null);
                        frame.dispose();

                    } else {   // con neu nhap nguoi dung thi vao frame nguoi dung(pick tkb)
                        ps.setString(1, user);
                        ps.setString(2, pass);
                        rs = ps.executeQuery();

                        if (rs.next()) {
                            SVFrame form = new SVFrame();
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
        }
        );
        JLabel register = frame.getRegisterLabel();
        register.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterFrame reg = new RegisterFrame();
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
//        register.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                RegisterFrame reg = new RegisterFrame();
//                reg.setVisible(true);
//                frame.setVisible(false);
//                JButton ok = reg.getOkBtt();
//                ok.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        String usr = reg.getUsr().getText();
//                        String pswrd = String.valueOf(reg.getPwrd().getPassword());
//                        String pswrd2 = String.valueOf(reg.getPsrd2().getPassword());
//                        if (pswrd.equalsIgnoreCase(pswrd2)) {
//                            try {
//                                SinhVien sv = new SinhVien();
//                                sv.setTenSv(reg.getTenSV().getText());
//                                String address = reg.getAddress().getText();
//                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                                sv.setDob(sdf.parse(reg.getDob().getText()));
//                                sv.setSdt(reg.getPhoneNUM().getText());
//                                sv.setGioitinh(reg.getGenderCB().getSelectedItem().toString());
//                                addSV(usr, pswrd, sv);
//                                frame.setVisible(true);
//                                reg.dispose();
//                            } catch (Exception f) {
//                                f.printStackTrace();
//                            }
//
//                        }
//
//                    }
//                });
//            }
//        });

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
            System.out.println("Through");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SinhVien khong hop le");
            e.printStackTrace();
        }

    }
}
