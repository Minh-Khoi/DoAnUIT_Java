/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.businesses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uit.team.models.mssql.dao.MuonSachDAO;
import uit.team.models.mssql.entities.MuonSach;

/**
 *
 * @author USER
 */
public class MuonSachUtils {
    public static String checkTrangThaiPhieu(String maPhieu) {
        Map map = new HashMap();
        map.put("MAPHIEU", maPhieu);
        List<MuonSach> muonSachRecs = MuonSachDAO.readByCols(map);
        if (muonSachRecs.isEmpty()){
            return "Vô hiệu";
        }
        MuonSach firstRec = muonSachRecs.get(0);
        return firstRec.getTrangThai();
    }
    
    public static void saveInstance(String maPhieu) {
        
    }
}
