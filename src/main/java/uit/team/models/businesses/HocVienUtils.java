/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.businesses;

import java.util.ArrayList;
import java.util.List;
import uit.team.models.mssql.dao.HocVienDAO;
import uit.team.models.mssql.entities.HocVien;

/**
 *
 * @author USER
 */
public class HocVienUtils {
    public static List queryForComboboz() {
        List<HocVien> listAll = HocVienDAO.readAll();
        List<String> listReturned = new ArrayList<String>();
        for(HocVien hocvien:listAll){
            listReturned.add(hocvien.getMaHV() +" - " + hocvien.getTenHV());
        }
        return listReturned;
    }
    
    public static String queryFullInfos(String maHV) {
        HocVien hv = HocVienDAO.readByPrimaryKey(maHV);
        return hv.getMaHV() + " - " + hv.getTenHV() + " - " + hv.getDonVi() + " - " + hv.getSoDT();
    }
}
