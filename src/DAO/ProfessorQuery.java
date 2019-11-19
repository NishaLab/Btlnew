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
public class ProfessorQuery {

    private DBQuery qr;

    public ProfessorQuery() {
        this.qr = new DBQuery();
    }

    public void addProfessor(GiangVien a) {
        String sql = "INSERT INTO realbtl.user(username,password) VALUES (?,?)";
        try {
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            sql = "INSERT INTO realbtl.professor (name, dob, address, sđt, sex, falcuty) VALUES(?,?,?,?,?,?)";
            ps = qr.getConnection().prepareStatement(sql);
            ps.setString(1, a.getTenGv());
            ps.setDate(2, new Date(a.getDob().getTime()));
            ps.setString(3, a.getAddress());
            ps.setString(4, a.getSdt());
            ps.setString(5, a.getGioitinh());
            ps.setString(6, a.getKhoa());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Them Giang Vien thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Giang Vien khong hop le");
            e.printStackTrace();
        }
    }

    ;
    
    public ArrayList<GiangVien> getGiangVien() throws SQLException {
        ArrayList<GiangVien> res = new ArrayList();
        String sql = "SELECT * FROM realbtl.professor";
        ResultSet rs = qr.query(sql);
        while (rs.next()) {
            GiangVien s = new GiangVien();
            s.setMaGv(rs.getInt(1));
            s.setTenGv(rs.getString(2));
            s.setDob(rs.getDate(3));
            s.setAddress(rs.getString(4));
            s.setSdt(rs.getString(5));
            s.setGioitinh(rs.getString(6));
            s.setKhoa(rs.getString(7));
            res.add(s);
        }
        return res;

    }
}
