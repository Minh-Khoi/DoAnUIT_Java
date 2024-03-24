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
public class TraSach {
    private String maSach;
    private String maHV;
    private String trangThai;
    private Date ngayTra;

    public TraSach() {
    }

    public TraSach(String maSach, String maHV, String trangThai, Date ngayTra) {
        this.maSach = maSach;
        this.maHV = maHV;
        this.trangThai = trangThai;
        this.ngayTra = ngayTra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TraSach{maSach=").append(maSach);
        sb.append(", maHV=").append(maHV);
        sb.append(", trangThai=").append(trangThai);
        sb.append(", ngayTra=").append(ngayTra);
        sb.append('}');
        return sb.toString();
    }
    
}
