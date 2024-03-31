/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.businesses;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import uit.team.models.mssql.dao.DauSachDAO;
import uit.team.models.mssql.entities.DauSach;

/**
 *
 * @author USER
 */
public class DauSachUtils {
    public static List<String> getDauSachInfos(JComboBox dauSachCombobox) {
        List<DauSach> listDS = DauSachDAO.readAll();
        List infosList = new ArrayList();
        for(DauSach ds : listDS){
            String infos = ds.getMaDauSach() + " - " + ds.getTenDauSach();
            infosList.add(infos);
        }
        return infosList;
    }
}
