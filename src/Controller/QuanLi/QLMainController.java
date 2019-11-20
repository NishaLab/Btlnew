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

    private QuanLiFrame frame;

    public QLMainController(QuanLiFrame frame) {
        this.frame = frame;
    }

    public void init() {
        setStudentLabelAction();
        setProfessorLabelAction();
        setCourseLabelAction();
    }

    void setStudentLabelAction() {
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
                student.setBackground(Color.DARK_GRAY);
                student.setForeground(Color.CYAN);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                student.setOpaque(false);
                student.setBackground(Color.WHITE);
                student.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    void setProfessorLabelAction() {
        JLabel professor = frame.getLectureLabel();
        professor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                QLViewController view = new QLViewController(frame);
                try {
                    view.setProfessorView();
                } catch (SQLException ex) {
                    Logger.getLogger(QLMainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                professor.setOpaque(true);
                professor.setBackground(Color.DARK_GRAY);
                professor.setForeground(Color.CYAN);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                professor.setOpaque(false);
                professor.setBackground(Color.WHITE);
                professor.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    void setCourseLabelAction() {
        JLabel course = frame.getCourseLabel();
        course.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                QLViewController view = new QLViewController(frame);
                try {
                    view.setCouresView();
                } catch (SQLException ex) {
                    Logger.getLogger(QLMainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                course.setOpaque(true);
                course.setBackground(Color.DARK_GRAY);
                course.setForeground(Color.CYAN);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
                course.setOpaque(false);
                course.setBackground(Color.WHITE);
                course.setForeground(Color.BLACK);
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
