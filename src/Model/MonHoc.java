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
public class MonHoc {
    private int maMon;
    private String tenMon;
    private int sotinchi;
    private int maGv;

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
}
