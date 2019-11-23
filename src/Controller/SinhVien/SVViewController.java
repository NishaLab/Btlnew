/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.SinhVien;

import Model.*;
import View.SinhVien.*;
import javax.swing.JPanel;
import View.SinhVien.Panels.SinhVienTimetablePanel;

/**
 *
 * @author LEGION
 */
public class SVViewController {

    SVMainFrame frame;
    private JPanel main;

    public SVViewController(SVMainFrame frame) {
        this.frame = frame;
        this.main = frame.getMainPanel();
    }

    public void setMainPanel(JPanel pn) {
        main.removeAll();
        main.add(pn);
        main.revalidate();
        main.repaint();
    }

    void setTimetableView() {
        SinhVienTimetablePanel svtp = setTimetableViewAction();
        main.removeAll();
        setMainPanel(svtp);
        main.revalidate();
        main.repaint();
    }

    public SinhVienTimetablePanel setTimetableViewAction() {
        SinhVienTimetablePanel svtp = new SinhVienTimetablePanel();
        // bắt sự kiện ở đây
        return svtp;
    }
}
