/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import View.QuanLi.QuanLiFrame;
import View.SinhVien.SVFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.sql.*;
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

    public void setActionLogin() {
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
                    if (user.equals("admin") && pass.equals("123456")) {
                        QuanLiFrame form = new QuanLiFrame();
                        form.setVisible(true);
                        form.setLocationRelativeTo(null);
                        frame.dispose();
                        
                    } else {
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
    }
}
