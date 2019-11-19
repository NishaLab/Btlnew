/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author LEGION
 */
public class StudentQuery {

    private DBQuery qr;

    public StudentQuery() {
        this.qr = new DBQuery();
    }

    public void addStudent(String usr, String pswrd, SinhVien a) {
        String sql = "INSERT INTO realbtl.user(username,password) VALUES (?,?)";
        try {
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setString(1, usr);
            ps.setString(2, pswrd);
            ps.executeUpdate();
            System.out.println("Through");
            sql = "INSERT INTO realbtl.student (name, dob, address, sdt, Sex) VALUES(?,?,?,?,?)";
            ps = qr.getConnection().prepareStatement(sql);
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

    ;
    
    public ArrayList<SinhVien> getSinhVien() throws SQLException{
        ArrayList<SinhVien> res = new ArrayList();
        String sql = "SELECT * FROM realbtl.student";
        ResultSet rs = qr.query(sql);
        while(rs.next()){
           SinhVien s = new SinhVien();
           s.setMaSv(rs.getInt(1));
           s.setTenSv(rs.getString(2));
           s.setDob(rs.getDate(3));
           s.setAddress(rs.getString(4));
           s.setSdt(rs.getString(5));
           s.setGioitinh(rs.getString(6));
           res.add(s);
        }
        return res;

    }
}
