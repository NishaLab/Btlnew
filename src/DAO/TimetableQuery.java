/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LEGION
 */
public class TimetableQuery {

    private DBQuery qr;

    public TimetableQuery() {
        this.qr = new DBQuery();
    }

    public void addTimetable(Lich a) {
//        try {
//            String sql = "INSERT INTO realbtl.course (name, sotinchi, khoa) VALUES(?,?,?)";
//            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
//            ps = qr.getConnection().prepareStatement(sql);
//            ps.setString(1, a.getTenMon());
//            ps.setInt(2, a.getSotinchi());
//            ps.setString(3, a.getKhoa());
//            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Them Giang Vien thanh cong");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Giang Vien khong hop le");
//            e.printStackTrace();
//        }
    }

    ;
    
   public GiangVien searchGv(ArrayList<GiangVien> gv, int id) {
        GiangVien res = new GiangVien();
        for (int i = 0; i < gv.size(); i++) {
            if (gv.get(i).getMaGv() == id) {
                return gv.get(i);
            }
        }
        return res;
    }

    public ArrayList<Lich> getLich(MonHoc a, ArrayList<GiangVien> gv) throws SQLException {
        ArrayList<Lich> res = new ArrayList();
        int mhId = a.getMaMon();
        String sql = "SELECT * FROM realbtl.course_time WHERE idCourse_time = ? ; ";
        PreparedStatement ps = qr.getConnection().prepareStatement(sql);
        ps.setInt(1, mhId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Lich s = new Lich();
            s.setTen(a.getTenMon());
            s.setIdLich(rs.getInt(1));
            s.setTime(rs.getString(2));
            s.setStart(rs.getInt(3));
            s.setDay(rs.getInt(4));
            s.setRoomNum(rs.getString(5));
            s.setGv(searchGv(gv, rs.getInt(6)));
            s.setKhoa(rs.getString(7));
            res.add(s);
        }
        return res;

    }
}
