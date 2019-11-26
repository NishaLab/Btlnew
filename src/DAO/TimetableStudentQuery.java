/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import Model.*;
import java.sql.*;

/**
 *
 * @author LEGION
 */
public class TimetableStudentQuery {

    private DBQuery qr;

    public TimetableStudentQuery() {
        this.qr = new DBQuery();
    }

    public void addTimetable(int S_id, int L_id) {
        try {
            String sql = "INSERT INTO realbtl.timetable VALUES (?,?)";
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setInt(1, S_id);
            ps.setInt(2, L_id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Them Lich " + L_id + " thanh cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lich " + L_id + " khong hop le");
            e.printStackTrace();
        }
    }

    public ArrayList<Lich> getTimeTable(ArrayList<GiangVien> gv, ArrayList<MonHoc> mh, int svId) {
        ArrayList<Lich> res = new ArrayList<>();
        try {
            String sql = "SELECT * FROM realbtl.timetable WHERE idS = ?";
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setInt(1, svId);
            ResultSet rs = ps.executeQuery();
            TimetableQuery tq = new TimetableQuery();
            while (rs.next()) {
                int lichID = rs.getInt(2);
                res.add(tq.get1Lich(mh, gv, lichID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void deleteTimeTable(Lich a, SinhVien sv) {
        try {
            String sql = "DELETE  FROM realbtl.timetable WHERE idS = ? AND idC=?";
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setInt(1, sv.getMaSv());
            ps.setInt(2, a.getIdLich());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoa Lich " + a.getIdLich() + " thanh cong");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xoa Lich " + a.getIdLich() + " thanh cong");

        }
    }

    public void deleteTimeTableById(int idC) {
        try {
            String sql = "DELETE  FROM realbtl.timetable WHERE idC=?";
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setInt(1, idC);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void deleteTimeTableByIdStudent(int idS) {
        try {
            String sql = "DELETE  FROM realbtl.timetable WHERE idS=?";
            PreparedStatement ps = qr.getConnection().prepareStatement(sql);
            ps.setInt(1, idS);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
