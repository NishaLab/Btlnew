/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author LEGION
 */
public class GiangVien implements Serializable {

    public int getMaGv() {
        return maGv;
    }

    public String getTenGv() {
        return tenGv.toString();
    }

    public String getAddress() {
        return address;
    }

    public String getSdt() {
        return sdt;
    }

    public GiangVien() {
    }

    public GiangVien(int maGv, String tenGv, String address, String sdt) {
        this.maGv = maGv;
        this.tenGv = new Name(tenGv);
        this.address = address;
        this.sdt = sdt;

    }

    public void setMaGv(int maGv) {
        this.maGv = maGv;
    }

    public void setTenGv(String tenGv) {
        this.tenGv = new Name(tenGv);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
    private int maGv;
    private Name tenGv;
    private String khoa;
    private String gioitinh;
    private String address;
    private String sdt;
    private Date dob;
}
