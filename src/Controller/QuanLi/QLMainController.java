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
import java.awt.event.MouseAdapter;
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

    public QuanLiFrame getFrame() {
        return frame;
    }

    public void setFrame(QuanLiFrame frame) {
        this.frame = frame;
    }

    public QLMainController(QuanLiFrame frame) {
        this.frame = frame;
    }

    public void init() {
        setStudentLabelAction();
        setProfessorLabelAction();
        setCourseLabelAction();
        setAddLabelAction();
        setEditLableAction();
        setDeleteLableAction();
        setLogoutLabelAction();
    }

    void setStudentLabelAction() {
        JLabel student = frame.getStudetnLabel();
        student.addMouseListener(new MouseAdapter() {
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
                frame.setIsStudent(true);
                frame.setIsCourse(false);
                frame.setIsProfessor(false);
                frame.setIsCourseDetail(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                student.setOpaque(false);
                student.setBackground(Color.WHITE);
                student.setForeground(Color.BLACK);
            }
        });
    }

    void setProfessorLabelAction() {
        JLabel professor = frame.getLectureLabel();
        professor.addMouseListener(new MouseAdapter() {

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
                frame.setIsStudent(false);
                frame.setIsCourse(false);
                frame.setIsProfessor(true);
                frame.setIsCourseDetail(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                professor.setOpaque(false);
                professor.setBackground(Color.WHITE);
                professor.setForeground(Color.BLACK);
            }

        });
    }

    void setCourseLabelAction() {
        JLabel course = frame.getCourseLabel();
        course.addMouseListener(new MouseAdapter() {

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
                frame.setIsStudent(false);
                frame.setIsCourse(true);
                frame.setIsProfessor(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                course.setOpaque(false);
                course.setBackground(Color.WHITE);
                course.setForeground(Color.BLACK);
            }

        });
    }

    void setAddLabelAction() {
        JLabel addLabel = frame.getAddLabel();
        addLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                QLViewController qvc = new QLViewController(frame);
                if (frame.isIsCourse()) {
                    qvc.setAddCourseView();
                } else if (frame.isIsStudent()) {
                    qvc.setAddStudentView();
                } else if (frame.isIsProfessor()) {
                    qvc.setAddProfessorView();
                } else if (frame.isIsCourse()) {
                    qvc.setAddCourseView();
                } else if (frame.isIsCourseDetail()) {
                    qvc.setAddCourseDetailView();
                }
                addLabel.setOpaque(true);
                addLabel.setBackground(Color.DARK_GRAY);
                addLabel.setForeground(Color.CYAN);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                addLabel.setOpaque(false);
                addLabel.setBackground(Color.WHITE);
                addLabel.setForeground(Color.BLACK);
            }
        });

    }

    void setEditLableAction() {
        JLabel edit = frame.getChangeLabel();
        edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                QLEditController qvc = new QLEditController(frame);
                if (frame.isIsCourse()) {
                    qvc.setCourseEditView();
                } else if (frame.isIsStudent()) {
                    qvc.setStudentEditView();
                } else if (frame.isIsProfessor()) {
                    qvc.setProfessorEditView();
                } else if (frame.isIsCourseDetail()) {
                    qvc.setCourseDetailEditView();
                }
                edit.setOpaque(true);
                edit.setBackground(Color.DARK_GRAY);
                edit.setForeground(Color.CYAN);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                edit.setOpaque(false);
                edit.setBackground(Color.WHITE);
                edit.setForeground(Color.BLACK);
            }
        });
    }
    
    void setDeleteLableAction(){
        JLabel delete = frame.getDeleteLabel();
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                QLEditController qvc = new QLEditController(frame);
                if (frame.isIsCourse()) {
                    qvc.DeleteCourse();
                } else if (frame.isIsStudent()) {
                    qvc.DeleteStudent();
                } else if (frame.isIsProfessor()) {
                    qvc.DeleteProfessor();
                } else if (frame.isIsCourseDetail()) {
                    qvc.DeleteCourseDetail();
                }
                delete.setOpaque(true);
                delete.setBackground(Color.DARK_GRAY);
                delete.setForeground(Color.CYAN);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                delete.setOpaque(false);
                delete.setBackground(Color.WHITE);
                delete.setForeground(Color.BLACK);
            }
        });
    }
    public void setLogoutLabelAction() {
        JLabel logout = frame.getLogoutLabel1();
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
}
