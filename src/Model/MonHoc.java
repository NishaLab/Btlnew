/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author LEGION
 */
public class MonHoc implements Serializable{


    private int maMon;
    private String tenMon;
    private int sotinchi;
    private int maGv;
    private String phong;
    private String thoigian;
    private String tietbd;
    private String ngay;

    public MonHoc(int maMon, String tenMon, int sotinchi, int maGv) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.sotinchi = sotinchi;
        this.maGv = maGv;
    }

    public MonHoc() {
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSotinchi() {
        return sotinchi;
    }

    public void setSotinchi(int sotinchi) {
        this.sotinchi = sotinchi;
    }

    public int getMaGv() {
        return maGv;
    }

    public void setMaGv(int maGv) {
        this.maGv = maGv;
    }
        public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getTietbd() {
        return tietbd;
    }

    public void setTietbd(String tietbd) {
        this.tietbd = tietbd;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public MonHoc(int maMon, String tenMon, int sotinchi, int maGv, String phong, String thoigian, String tietbd, String ngay) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.sotinchi = sotinchi;
        this.maGv = maGv;
        this.phong = phong;
        this.thoigian = thoigian;
        this.tietbd = tietbd;
        this.ngay = ngay;
    }
}
