/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.businesses;

import java.util.ArrayList;
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
            List<MuonSach> muonDets = MuonSachDAO.readByCols(mapMuonSach);
            if (Objects.isNull(muonDets) || muonDets.isEmpty()) {
                return "Vô hiệu";
            } else {
                int soSachDaTra = 0;
                int soSachChuaTra = 0;
                for(MuonSach muon: muonDets){
                    if(muon.getTrangThaiTra().trim().equals("OK")){
                        soSachDaTra++;
                    } else {
                        soSachChuaTra++;
                    }
                }
                if (soSachDaTra == muonDets.size()){
                    return "OK";
                } else if (soSachChuaTra == muonDets.size()){
                    return "CHƯA TRẢ";
                } else {
                    return "CHƯA TRẢ HẾT";
                }
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
    
    public static List<PhieuMuon> hocVienChuaTraSach(String maHV) {
        Map map = new HashMap();
        map.put("MAHV", maHV);
        List<PhieuMuon> pms = PhieuMuonDAO.readByCols(map);
        List<PhieuMuon> pmChuaTra = new ArrayList<>();
        if( !pms.isEmpty() ){
            for(PhieuMuon pm : pms){
                String trangThaiPM = getTrangThaiPhieuMuon(pm.getMaPhieu());
                if(!trangThaiPM.equals("OK") && !trangThaiPM.equals("Vô hiệu")){
                    pmChuaTra.add(pm);
                }
            }
        }
        return pmChuaTra;
    }
    
}
