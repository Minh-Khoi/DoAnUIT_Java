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
    
    public static List<MuonSach>  findRecsByPhieuMuon(String maPhieuMuon){
        Map map = new HashMap();
        map.put("MAPHIEU", maPhieuMuon);
        List<MuonSach> instances = MuonSachDAO.readByCols(map);
        return instances;
    }
    
    public static void saveInstance(MuonSach instance, boolean modifyMode_) {
        if(modifyMode_){
            MuonSachDAO.update(instance);
        } else {
//            String newPrV = HocVienDAO.generateNewPrimaryValue();
//            instance.setMaHV(newPrV);
            MuonSachDAO.insert(instance);
        }
    }
    
    public static void updateTrangThaiTraByPhieuMuon(String maPhieuMuon, String trangThaiTra){
        if(trangThaiTra.equals("OK") || trangThaiTra.equals("CHƯA TRẢ")){
            MuonSachDAO.updateTrangThaiTraByPhieuMuon(maPhieuMuon, trangThaiTra);
        } else if(trangThaiTra.equals("Vô hiệu")){
            MuonSachDAO.deleteByForeignKey("MAPHIEU", maPhieuMuon);
        } else { // trangThaiTra.equals("CHƯA TRẢ HẾT")
            // do nothing
        }
    }
}
