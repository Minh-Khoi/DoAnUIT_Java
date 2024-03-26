/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.mssql.entities;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class HocVien  implements EntityInterface{
    String maHV;
    String tenHV;
    String soDT;
    Date ngaySinh;
    String donVi;
    String gioiTinh;

    public HocVien() {
    }

    public HocVien(String maHV, String tenHV, String soDT, Date ngaySinh, String donVi, String gioiTinh) {
        this.maHV = maHV;
        this.tenHV = tenHV;
        this.soDT = soDT;
        this.ngaySinh = ngaySinh;
        this.donVi = donVi;
        this.gioiTinh = gioiTinh;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getTenHV() {
        return tenHV;
    }

    public void setTenHV(String tenHV) {
        this.tenHV = tenHV;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HocVien{maHV=").append(maHV);
        sb.append(", tenHV=").append(tenHV);
        sb.append(", soDT=").append(soDT);
        sb.append(", ngaySinh=").append(ngaySinh);
        sb.append(", donVi=").append(donVi);
        sb.append(", gioiTinh=").append(gioiTinh);
        sb.append('}');
        return sb.toString();
    }
    
    
    @Override
    public Object[] toPropertiesArray() {
        return new Object[] {maHV,tenHV,soDT,ngaySinh,donVi,gioiTinh};
    }
}
