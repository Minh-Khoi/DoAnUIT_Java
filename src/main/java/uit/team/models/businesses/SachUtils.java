/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.businesses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uit.team.models.mssql.dao.SachDAO;
import uit.team.models.mssql.entities.Sach;

/**
 *
 * @author USER
 */
public class SachUtils {
    
    public static void saveInstance(Sach instance, boolean modifyMode) {
        if(modifyMode){
            SachDAO.update(instance);
        } else {
            String newPrV = SachDAO.generateNewPrimaryValue();
            instance.setMaSach(newPrV);
            SachDAO.insert(instance);
        }
    }
    
    public static List<String> queryAllForCombobox(){
        List<Sach> listSachs = SachDAO.readAll();
        List<String> listResults = new ArrayList<>();
        for(Sach sach : listSachs){
            String infos = formatSachMuonForCbbox(sach);
            listResults.add(infos);
        }
        return listResults;
    }
    public static String formatSachMuonForCbbox(Sach sach){
        return sach.getMaSach().trim()+"-"+sach.getTenSach()+"-"+sach.getTenNXB()+"-"+sach.getTenTG();
    }
}
