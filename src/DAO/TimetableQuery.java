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

    public void addTimetable(int C_id,String time,int period, int day,String phong,int p_id,String khoa) {
        try {
            String sql = "INSERT INTO realbtl.course_time (idCourse_time,time,tietBatdau, day,phong,P_ID, khoa) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setInt(1, C_id);
            ps.setString(2, time);
            ps.setInt(3, period);
            ps.setInt(4,day);
            ps.setString(5, phong);
            ps.setInt(6, p_id);
            ps.setString(7, khoa);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Them Lich thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lich khong hop le");
            e.printStackTrace();
        }
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
