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
public class DauSach {
    String maDauSach;
    String tenDauSach;

    public DauSach() {
    }

    public DauSach(String maDauSach, String tenDauSach) {
        this.maDauSach = maDauSach;
        this.tenDauSach = tenDauSach;
    }

    public String getMaDauSach() {
        return maDauSach;
    }

    public void setMaDauSach(String maDauSach) {
        this.maDauSach = maDauSach;
    }

    public String getTenDauSach() {
        return tenDauSach;
    }

    public void setTenDauSach(String tenDauSach) {
        this.tenDauSach = tenDauSach;
    }

    @Override
    public String toString() {
        return "DauSach{" + "maDauSach=" + maDauSach + ", tenDauSach=" + tenDauSach + '}';
    }
    
    
    
    
}
