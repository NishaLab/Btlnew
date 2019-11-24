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

    public GiangVien searchGv(ArrayList<GiangVien> gv, int id) {
        GiangVien res = new GiangVien();
        for (int i = 0; i < gv.size(); i++) {
            if (gv.get(i).getMaGv() == id) {
                return gv.get(i);
            }
        }
        return res;
    }

    public ArrayList<Lich> getTimeTable(ArrayList<GiangVien> gv) {
        ArrayList<Lich> res = new ArrayList<>();
        return res;
    }

}
