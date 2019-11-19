/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuanLi;

import View.*;
import Model.*;
import View.QuanLi.QuanLiFrame;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author LEGION
 */
public class QLMainController {

    private QuanLiFrame frame ;

    public QLMainController(QuanLiFrame frame) {
       this.frame = frame;
    }

    public void init(){
        setStudentLabel();
    }
    void setStudentLabel() {
        JLabel student = frame.getStudetnLabel();
        student.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                QLViewController view = new QLViewController(frame);
                try {
                    view.setStudentView();
                } catch (SQLException ex) {
                    Logger.getLogger(QLMainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                student.setOpaque(true);
                student.setForeground(Color.red);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}
