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
            listReturned.add(hocvien.getMaHV().trim() +" - " + hocvien.getTenHV().trim());
        }
        return listReturned;
    }
    
    public static String queryFullInfos(String maHV) {
        HocVien hv = HocVienDAO.readByPrimaryKey(maHV);
        return hv.getMaHV().trim() + " - " + hv.getTenHV().trim() + " - " + hv.getDonVi().trim() + " - " + hv.getSoDT().trim();
    }
    
    
    public static void saveInstance(HocVien instance, boolean modifyMode) {
        if(modifyMode){
            HocVienDAO.update(instance);
        } else {
            String newPrV = HocVienDAO.generateNewPrimaryValue();
            instance.setMaHV(newPrV);
            HocVienDAO.insert(instance);
        }
    }
}
