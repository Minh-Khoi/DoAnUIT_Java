/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.mssql.entities;

/**
 *
 * @author USER
 */
public class Sach  implements EntityInterface{
    String maSach;
    String tenSach;
    String trangThai;
    int soLuong;
    String tenNXB;
    String tenTG;
    String maDauSach;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String trangThai, int soLuong, String tenNXB, String tenTG, String maDauSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.tenNXB = tenNXB;
        this.tenTG = tenTG;
        this.maDauSach = maDauSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getMaDauSach() {
        return maDauSach;
    }

    public void setMaDauSach(String maDauSach) {
        this.maDauSach = maDauSach;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sach{maSach=").append(maSach);
        sb.append(", tenSach=").append(tenSach);
        sb.append(", trangThai=").append(trangThai);
        sb.append(", soLuong=").append(soLuong);
        sb.append(", tenNXB=").append(tenNXB);
        sb.append(", tenTG=").append(tenTG);
        sb.append(", maDauSach=").append(maDauSach);
        sb.append('}');
        return sb.toString();
    }
    
    
    @Override
    public Object[] toPropertiesArray() {
        return new Object[] {maSach,tenSach,trangThai,soLuong,tenNXB,tenTG,maDauSach};
    }
}
