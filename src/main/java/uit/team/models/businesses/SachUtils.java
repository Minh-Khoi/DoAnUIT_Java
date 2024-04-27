/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.businesses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uit.team.models.mssql.dao.MuonSachDAO;
import uit.team.models.mssql.dao.SachDAO;
import uit.team.models.mssql.entities.MuonSach;
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
    
    
    public static List<MuonSach> sachChuaTraXong(String maSach){
        Map map = new HashMap();
        map.put("MASACH", maSach);
        List<MuonSach> mss = MuonSachDAO.readByCols(map);
        List<MuonSach> mssChuaTra = new ArrayList<>();
        if(!mss.isEmpty()){
            for(MuonSach ms : mss){
                if (!ms.getTrangThaiTra().equals("OK")){
                    mssChuaTra.add(ms);
                }
            }
        }
        return mssChuaTra;
    }
}
