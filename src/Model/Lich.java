/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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


    private int idLich;
    private String ten;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    private String time;
    private int start;
    private int day;
    private String roomNum;
    private GiangVien gv;
    private String khoa;    
}
