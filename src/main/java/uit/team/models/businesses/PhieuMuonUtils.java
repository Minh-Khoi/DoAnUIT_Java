/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.businesses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import uit.team.models.mssql.dao.MuonSachDAO;
import uit.team.models.mssql.dao.PhieuMuonDAO;
import uit.team.models.mssql.entities.MuonSach;
import uit.team.models.mssql.entities.PhieuMuon;

/**
 *
 * @author USER
 */
public class PhieuMuonUtils {
    
    public static String getTrangThaiPhieuMuon(String maPhieu){
        PhieuMuon phieu = PhieuMuonDAO.readByPrimaryKey(maPhieu);
        if(Objects.isNull(phieu)){
            return "Không tìm thấy";
        } else {
            Map mapMuonSach = new HashMap();
            mapMuonSach.put("MAPHIEU", maPhieu);
            List<MuonSach> muonDet = MuonSachDAO.readByCols(mapMuonSach);
            if (Objects.isNull(muonDet) || muonDet.isEmpty()) {
                return "Vô hiệu";
            } else {
                return muonDet.get(0).getTrangThaiTra();
            }
        }
    }
    
    
    public static void saveInstance(PhieuMuon instance, boolean modifyMode) {
        if(modifyMode){
            PhieuMuonDAO.update(instance);
        } else {
            String newPrV = PhieuMuonDAO.generateNewPrimaryValue();
            instance.setMaPhieu(newPrV);
            PhieuMuonDAO.insert(instance);
        }
    }
}
