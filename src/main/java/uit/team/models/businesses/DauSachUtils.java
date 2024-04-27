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
import javax.swing.JComboBox;
import uit.team.models.mssql.dao.DauSachDAO;
import uit.team.models.mssql.dao.SachDAO;
import uit.team.models.mssql.entities.DauSach;
import uit.team.models.mssql.entities.MuonSach;
import uit.team.models.mssql.entities.Sach;

/**
 *
 * @author USER
 */
public class DauSachUtils {
    public static List<String> getDauSachInfos(JComboBox dauSachCombobox) {
        List<DauSach> listDS = DauSachDAO.readAll();
        List infosList = new ArrayList();
        for(DauSach ds : listDS){
            String infos = ds.getMaDauSach().trim() + " - " + ds.getTenDauSach().trim();
            infosList.add(infos);
        }
        return infosList;
    }
    
    public static void saveInstance(DauSach instance, boolean modifyMode) {
        if(modifyMode){
            DauSachDAO.update(instance);
        } else {
            String newPrV = DauSachDAO.generateNewPrimaryValue();
            instance.setMaDauSach(newPrV);
            DauSachDAO.insert(instance);
        }
    }
    
    public static boolean isDuplicatePrV(String newPrV) {
        DauSach instance = DauSachDAO.readByPrimaryKey(newPrV);
        if(Objects.isNull(instance)){
            return false;
        } else {
            return true;
        }
    }
    
    public static List<MuonSach>  sachMuonChuaTra(String maDS) {
        Map map = new HashMap();
        map.put("MADAUSACH", maDS);
        List<Sach> sachs = SachDAO.readByCols(map);
        List<MuonSach> totalMsChuaTra = new ArrayList<>();
        for(Sach sach : sachs){
            List<MuonSach> muonSachChuaTra = SachUtils.sachChuaTraXong(sach.getMaSach());
            if(muonSachChuaTra.size() > 0){
                totalMsChuaTra.addAll(muonSachChuaTra);
            }
        }
        return totalMsChuaTra;
    }
}
