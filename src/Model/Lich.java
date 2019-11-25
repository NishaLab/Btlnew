/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author LEGION
 */
public class Lich extends HashSet<Object> {

    public int getIdLich() {
        return idLich;
    }

    public Lich() {
    }

    @Override
    public String toString() {
        return "Lich{" + "idLich=" + idLich + ", ten=" + ten + ", time=" + time + ", start=" + start + ", day=" + day + ", roomNum=" + roomNum + ", gv=" + gv + ", khoa=" + khoa + '}';
    }

    public void setIdLich(int idLich) {
        this.idLich = idLich;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public GiangVien getGv() {
        return gv;
    }

    public void setGv(GiangVien gv) {
        this.gv = gv;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public Lich(int idLich, String ten, String time, int start, int day, String roomNum, GiangVien gv, String khoa) {
        this.idLich = idLich;
        this.ten = ten;
        this.time = time;
        this.start = start;
        this.day = day;
        this.roomNum = roomNum;
        this.gv = gv;
        this.khoa = khoa;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    private int idMon;

    public int getIdMon() {
        return idMon;
    }

    public void setIdMon(int idMon) {
        this.idMon = idMon;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            System.out.println("YEs 1");
//            return true;
//        }
//        if (obj == null) {
//            System.out.println("yes 2");
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            System.out.println("yes 3");
//            return false;
//        }
//        Lich other = (Lich) obj;
//        if (this.time == null) {
//            if (other.time != null) {
//                System.out.println("yes 4");
//                return false;
//            }
//        } else if (!this.time.equalsIgnoreCase(other.time)) {
//            if (this.day == other.day && this.start == other.start) {
//                for (int i = 0; i < time.length(); i++) {
//                    if (this.time.charAt(i) != 'x' && other.time.charAt(i)!='x') {
//                        System.out.println(i + " " + this.time.charAt(i) + " " + other.time.charAt(i));
//                        return true;
//                    }
//                }
//                return false;
//            }
//        }
//        if (this.day != other.day) {
//            System.out.println("yes 5");
//            return false;
//        }
//        if (this.start != other.start) {
//            System.out.println("yes 6");
//            return false;
//        }
//        return true;
//    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.time);
        hash = 53 * hash + this.start;
        hash = 53 * hash + this.day;
        hash = 53 * hash + this.idLich;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            System.out.println("yes 1");
            return true;
        }
        if (obj == null) {
            System.out.println("yes 2");

            return false;
        }
        if (getClass() != obj.getClass()) {
            System.out.println("yes 3");

            return false;
        }
        final Lich other = (Lich) obj;
        if (this.start != other.start) {
            System.out.println("yes 4");

            return false;
        }
        if (this.day != other.day) {
            System.out.println("yes 5");

            return false;
        }

        if (!Objects.equals(this.time, other.time)) {
            System.out.println("yes 7");
            for (int i = 0; i < time.length(); i++) {
                if (time.charAt(i) != 'x' && other.time.charAt(i) != 'x') {
                    System.out.println(i + " " + time.charAt(i) + " " + other.time.charAt(i));
                    return true;
                }
            }
            return false;
        }
        if (this.idLich != other.idLich) {
            System.out.println("yes 6");

            return false;
        }
        System.out.println("yes 8");

        return true;
    }

    private String ten;
    private String time;
    private int start;
    private int day;
    private int idLich;
    private String roomNum;
    private GiangVien gv;
    private String khoa;
}
