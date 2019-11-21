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
    private String khoa;


    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
    public MonHoc(int maMon, String tenMon, int sotinchi,String khoa) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.sotinchi = sotinchi;
        this.khoa = khoa;
    }
    
    @Override
    public String toString() {
        return "MonHoc{" + "maMon=" + maMon + ", tenMon=" + tenMon + ", sotinchi=" + sotinchi + ", khoa=" + khoa + '}';
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


    


}
