/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.SinhVien;

import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controller.SinhVien.*;
import Model.*;
import java.util.ArrayList;
import java.util.HashSet;
import DAO.*;

/**
 *
 * @author ducnam
 */
public class SVMainFrame extends javax.swing.JFrame {

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public ArrayList<Lich> getListLich() {
        return listLich;
    }

    public void setListLich(ArrayList<Lich> listLich) {
        this.listLich = listLich;
    }

    public ArrayList<MonHoc> getListMon() {
        return listMon;
    }

    /**
     * Creates new form MainFrame
     */
    public void setListMon(ArrayList<MonHoc> listMon) {
        this.listMon = listMon;
    }

    private SinhVien sv;
    private Lich lichChon;

    public Lich getLichChon() {
        return lichChon;
    }

    public void setLichChon(Lich lichChon) {
        this.lichChon = lichChon;
    }
    private ArrayList<Lich> listLich = new ArrayList<>();
    private ArrayList<Lich> listLichMoi = new ArrayList<>();

    public ArrayList<Lich> getListLichMoi() {
        return listLichMoi;
    }

    public void setListLichMoi(ArrayList<Lich> listLichMoi) {
        this.listLichMoi = listLichMoi;
    }
    private ArrayList<MonHoc> listMon = new ArrayList<>();
    private ArrayList<GiangVien> listGV = new ArrayList<>();
    private HashSet<Lich> setLich = new HashSet<>();

    public HashSet<Lich> getSetLich() {
        return setLich;
    }

    public void setSetLich(HashSet<Lich> setLich) {
        this.setLich = setLich;
    }

    public ArrayList<GiangVien> getListGV() {
        return listGV;
    }

    public void setListGV(ArrayList<GiangVien> listGV) {
        this.listGV = listGV;
    }

    public SVMainFrame() {
        initComponents();
        SVMainController sv = new SVMainController(this);
        sv.init();
    }

    public SVMainFrame(SinhVien a) {
        this.sv = a;
        initComponents();
        try {
            CourseQuery cq = new CourseQuery();
            this.listMon = cq.getMonHoc();
            ProfessorQuery pq = new ProfessorQuery();
            this.listGV = pq.getGiangVien();
            TimetableStudentQuery tsq = new TimetableStudentQuery();
            this.listLich = tsq.getTimeTable(listGV, listMon, a.getMaSv());
            for (int i = 0; i < this.listLich.size(); i++) {
                this.setLich.add(this.listLich.get(i));
            }
            getProfileLabel().setText(a.getTenSv());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SVMainController svctr = new SVMainController(this);
        svctr.init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        timetableLabel = new javax.swing.JLabel();
        lecturesLabel = new javax.swing.JLabel();
        homeLabel = new javax.swing.JLabel();
        registerLabel = new javax.swing.JLabel();
        StudentLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        logoutLabel = new javax.swing.JLabel();
        profileLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(223, 217, 242));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(130, 210, 234));

        timetableLabel.setFont(new java.awt.Font("aakar", 0, 20)); // NOI18N
        timetableLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timetableLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/SinhVien/ImageIcon/timetable.png"))); // NOI18N
        timetableLabel.setText("TimeTable");

        lecturesLabel.setFont(new java.awt.Font("aakar", 0, 20)); // NOI18N
        lecturesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lecturesLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/QuanLi/ImageIcon/lecture.png"))); // NOI18N
        lecturesLabel.setText("Lectures");

        homeLabel.setFont(new java.awt.Font("aakar", 0, 20)); // NOI18N
        homeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/SinhVien/ImageIcon/menu.png"))); // NOI18N
        homeLabel.setText("Home");
        homeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                homeLabelMouseMoved(evt);
            }
        });

        registerLabel.setFont(new java.awt.Font("aakar", 0, 20)); // NOI18N
        registerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/SinhVien/ImageIcon/register.png"))); // NOI18N
        registerLabel.setText("Register");

        StudentLabel.setFont(new java.awt.Font("aakar", 0, 20)); // NOI18N
        StudentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/QuanLi/ImageIcon/student.png"))); // NOI18N
        StudentLabel.setText("Students");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timetableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lecturesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StudentLabel)
                .addGap(0, 496, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {StudentLabel, homeLabel, lecturesLabel, registerLabel});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(registerLabel)
                .addComponent(timetableLabel)
                .addComponent(lecturesLabel)
                .addComponent(StudentLabel))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {StudentLabel, homeLabel, lecturesLabel, registerLabel, timetableLabel});

        logoutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/SinhVien/ImageIcon/logout.png"))); // NOI18N
        logoutLabel.setText("Log out");

        profileLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/SinhVien/ImageIcon/profile.png"))); // NOI18N
        profileLabel.setText("Nguyễn Đức Nam");
        profileLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutLabel)
                    .addComponent(profileLabel))
                .addContainerGap())
        );

        mainPanel.setBackground(new java.awt.Color(255, 250, 245));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profileLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_profileLabelMouseClicked

    private void homeLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeLabelMouseMoved
        // TODO add your handling code here:
        Cursor handCuror = new Cursor(Cursor.HAND_CURSOR);
        homeLabel.setCursor(handCuror);
    }//GEN-LAST:event_homeLabelMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SVMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SVMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SVMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SVMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SVMainFrame().setVisible(true);
            }
        });
    }

    public JLabel getStudentLabel() {
        return StudentLabel;
    }

    public void setStudentLabel(JLabel StudentLabel) {
        this.StudentLabel = StudentLabel;
    }

    public JLabel getHomeLabel() {
        return homeLabel;
    }

    public void setHomeLabel(JLabel homeLabel) {
        this.homeLabel = homeLabel;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JLabel getLecturesLabel() {
        return lecturesLabel;
    }

    public void setLecturesLabel(JLabel lecturesLabel) {
        this.lecturesLabel = lecturesLabel;
    }

    public JLabel getLogoutLabel() {
        return logoutLabel;
    }

    public void setLogoutLabel(JLabel logoutLabel) {
        this.logoutLabel = logoutLabel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JLabel getProfileLabel() {
        return profileLabel;
    }

    public void setProfileLabel(JLabel profileLabel) {
        this.profileLabel = profileLabel;
    }

    public JLabel getRegisterLabel() {
        return registerLabel;
    }

    public void setRegisterLabel(JLabel registerLabel) {
        this.registerLabel = registerLabel;
    }

    public JLabel getTimetableLabel() {
        return timetableLabel;
    }

    public void setTimetableLabel(JLabel timetableLabel) {
        this.timetableLabel = timetableLabel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StudentLabel;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lecturesLabel;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel timetableLabel;
    // End of variables declaration//GEN-END:variables
}
