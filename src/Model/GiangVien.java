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
public class GiangVien implements Serializable{

    public int getMaGv() {
        return maGv;
    }

    public Name getTenGv() {
        return tenGv;
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
    private int maGv;
    private Name tenGv;
    private String address;
    private String sdt;
}
