/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.GiangVien;
import Model.MonHoc;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LEGION
 */
public class CourseQuery {
    
    private DBQuery qr;
    
    public CourseQuery() {
        this.qr = new DBQuery();
    }
    
    public void addCourse(MonHoc a) {
        try {
            String sql = "INSERT INTO realbtl.course (name, sotinchi, khoa) VALUES(?,?,?)";
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps = qr.getConnection().prepareStatement(sql);
            ps.setString(1, a.getTenMon());
            ps.setInt(2, a.getSotinchi());
            ps.setString(3, a.getKhoa());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Them Mon Hoc thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mon Hoc khong hop le");
            e.printStackTrace();
        }
    }
    
    public void updateCourse(MonHoc a) {
        try {
            String sql = "UPDATE realbtl.course SET name = ?, sotinchi = ?,khoa = ? WHERE idCourse = ?";
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps = qr.getConnection().prepareStatement(sql);
            ps.setString(1, a.getTenMon());
            ps.setInt(2, a.getSotinchi());
            ps.setString(3, a.getKhoa());
            ps.setInt(4, a.getMaMon());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Mon Hoc thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Mon Hoc that bai");
            e.printStackTrace();
        }
    }
    
    public void deleteCourse(MonHoc a) {
        try {
            TimetableQuery tq = new TimetableQuery();
            tq.deleteCourseDetailByCourse(a);
            String sql = "Delete FROM realbtl.course WHERE idCourse = ?";
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setInt(1, a.getMaMon());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoa Mon Hoc Thanh Cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xoa Moc Hoc That Bai");
            
            e.printStackTrace();
        }
    }
    
    public ArrayList<MonHoc> getMonHoc() throws SQLException {
        ArrayList<MonHoc> res = new ArrayList();
        String sql = "SELECT * FROM realbtl.course";
        ResultSet rs = qr.query(sql);
        while (rs.next()) {
            MonHoc s = new MonHoc();
            s.setMaMon(rs.getInt(1));
            s.setTenMon(rs.getString(2));
            s.setSotinchi(rs.getInt(3));
            s.setKhoa(rs.getString(4));
            res.add(s);
        }
        return res;
        
    }
}
