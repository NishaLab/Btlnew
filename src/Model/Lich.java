/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author LEGION
 */
public class Lich {

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idMon;
        hash = 59 * hash + this.idLich;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lich other = (Lich) obj;
        if (this.idMon == other.idMon) {
            return true;
        }
        if (Math.abs(this.start - other.start) < 2) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        if (this.idLich != other.idLich) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            if (this.day == other.day && this.start == other.start) {
                for (int i = 0; i < this.time.length(); i++) {
                    if (this.time.charAt(i) != 'x' && other.time.charAt(i) != 'x') {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
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
