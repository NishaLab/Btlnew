/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.SinhVien;

import View.LoginFrame;
import View.SinhVien.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
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
        setLogoutLabelAction();
        setProfileLabelAction();
        setRegisterLabelAction();
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

    public void setLogoutLabelAction() {
        JLabel logout = frame.getLogoutLabel();
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                logout.setOpaque(true);
                logout.setBackground(Color.DARK_GRAY);
                logout.setForeground(Color.CYAN);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                LoginFrame a = new LoginFrame();
                a.setVisible(true);
                a.setLocationRelativeTo(null);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logout.setOpaque(false);
                logout.setBackground(Color.WHITE);
                logout.setForeground(Color.BLACK);
            }
        });
    }

    public void setProfileLabelAction() {
        JLabel profile = frame.getProfileLabel();
        profile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                profile.setOpaque(true);
                profile.setBackground(Color.DARK_GRAY);
                profile.setForeground(Color.CYAN);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                SVViewController ctr = new SVViewController(frame);
                ctr.setProfileView();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                profile.setOpaque(false);
                profile.setBackground(Color.WHITE);
                profile.setForeground(Color.BLACK);
            }
        });
    }

    public void setRegisterLabelAction() {
        JLabel register = frame.getRegisterLabel();
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                register.setOpaque(true);
                register.setBackground(Color.DARK_GRAY);
                register.setForeground(Color.CYAN);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                SVViewController ctr = new SVViewController(frame);
                try {
                    ctr.setRegisterView();
                } catch (Exception f) {
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                register.setOpaque(false);
                register.setBackground(Color.WHITE);
                register.setForeground(Color.BLACK);
            }
        });
    }
    
    
}
