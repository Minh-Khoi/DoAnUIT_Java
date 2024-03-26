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
public class PhieuMuon  implements EntityInterface{
    String maPhieu;
    Date ngayMuon;
    String maHV;

    public PhieuMuon() {
    }

    public PhieuMuon(String maPhieu, Date ngayMuon, String maHV) {
        this.maPhieu = maPhieu;
        this.ngayMuon = ngayMuon;
        this.maHV = maHV;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PhieuMuon{maPhieu=").append(maPhieu);
        sb.append(", ngayMuon=").append(ngayMuon);
        sb.append(", maHV=").append(maHV);
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public Object[] toPropertiesArray() {
        return new Object[] {maPhieu,ngayMuon,maHV};
    }
}
