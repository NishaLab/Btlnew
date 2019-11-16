/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author LEGION
 */
public class SinhVien implements Serializable {

    public SinhVien() {
    }

    public SinhVien(int maSv,String s, Date dob, String address, String sdt, String gioitinh) {
        this.tenSv = new Name(s);
        this.maSv = maSv;
        this.dob = dob;
        this.address = address;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "tenSv=" + tenSv + ", maSv=" + maSv + ", dob=" + dob + ", address=" + address + ", sdt=" + sdt + ", gioitinh=" + gioitinh + '}';
    }

    public String getTenSv() {
        return tenSv.toString();
    }

    public void setTenSv(String tenSv) {
        Name a = new Name(tenSv);
        this.tenSv = a;
    }

    public int getMaSv() {
        return maSv;
    }

    public void setMaSv(int maSv) {
        this.maSv = maSv;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSdt() {
        return sdt;
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
    private Name tenSv;
    private int maSv;
    private Date dob;
    private String address;
    private String sdt;
    private String gioitinh;
}

class Name {

    public Name() {
    }

    public Name(String s) {
        StringTokenizer strtok = new StringTokenizer(s);
        String ho = "";
        String ten = "";
        while (strtok.hasMoreTokens()) {
            String tmp = strtok.nextToken();
            if (strtok.hasMoreTokens() == false) {
                ten += tmp;
            } else {
                ho += tmp + " ";
            }
        }
        this.ho = ho;
        this.ten = ten;
    }

    private String ho, ten;

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return ho + ten;
    }

}
