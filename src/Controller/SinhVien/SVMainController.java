/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.SinhVien;

import View.SinhVien.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author LEGION
 */
public class SVMainController {

    private SVMainFrame frame;

    public SVMainController(SVMainFrame a) {
        this.frame = a;
    }

    public void init() {
        setTimetableLabelAction();
    }

    public void setTimetableLabelAction() {
        JLabel timetable = frame.getTimetableLabel();
        timetable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SVViewController sv = new SVViewController(frame);
                sv.setTimetableView();
            }

            @Override
            public void mousePressed(MouseEvent e) {
           }

            @Override
            public void mouseReleased(MouseEvent e) {
           }

            @Override
            public void mouseEntered(MouseEvent e) {
                timetable.setOpaque(true);
                timetable.setBackground(Color.DARK_GRAY);
                timetable.setForeground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                timetable.setOpaque(false);
                timetable.setBackground(Color.WHITE);
                timetable.setForeground(Color.BLACK);
            }
        });
    }
}
