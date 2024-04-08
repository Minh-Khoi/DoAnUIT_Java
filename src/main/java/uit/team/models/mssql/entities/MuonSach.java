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
public class MuonSach implements EntityInterface {
    String maPhieu;
    String maSach;
    String trangThai;
    Date ngayHenTra;
    Date ngayTra;
    String trangThaiTra;

    public MuonSach() {
    }

    public MuonSach(String maPhieu, String maSach, String trangThai, Date ngayHenTra, Date ngayTra, String trangThaiTra) {
        this.maPhieu = maPhieu;
        this.maSach = maSach;
        this.trangThai = trangThai;
        this.ngayHenTra = ngayHenTra;
        this.ngayTra = ngayTra;
        this.trangThaiTra = trangThaiTra;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayHenTra() {
        return ngayHenTra;
    }

    public void setNgayHenTra(Date ngayHenTra) {
        this.ngayHenTra = ngayHenTra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getTrangThaiTra() {
        return trangThaiTra;
    }

    public void setTrangThaiTra(String trangThaiTra) {
        this.trangThaiTra = trangThaiTra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MuonSach{maPhieu=").append(maPhieu);
        sb.append(", maSach=").append(maSach);
        sb.append(", trangThai=").append(trangThai);
        sb.append(", ngayHenTra=").append(ngayHenTra);
        sb.append(", ngayTra=").append(ngayTra);
        sb.append(", trangThaiTra=").append(trangThaiTra);
        sb.append('}');
        return sb.toString();
    }
    
    
    @Override
    public Object[] toPropertiesArray() {
        return new Object[] {this.maPhieu,this.maSach,this.trangThai,this.ngayHenTra,this.ngayTra,this.trangThaiTra};
    }
}
