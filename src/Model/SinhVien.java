/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
import java.util.StringTokenizer;
/**
 *
 * @author LEGION
 */
public class SinhVien {

    public SinhVien() {
    }

    public SinhVien(Name tenSv, int maSv, Date dob, String address, String sdt, String gioitinh) {
        this.tenSv = tenSv;
        this.maSv = maSv;
        this.dob = dob;
        this.address = address;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
    }
    private Name tenSv;
    private int maSv;
    private Date dob;
    private String address;
    private String sdt;
    private String gioitinh;
}
class Name{

    public Name() {
    }

    public Name(String ho, String ten, String dem) {
        this.ho = ho;
        this.ten = ten;
        this.dem = dem;
    }


    private String ho,ten,dem;

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

    public String getDem() {
        return dem;
    }

    public void setDem(String dem) {
        this.dem = dem;
    }
}