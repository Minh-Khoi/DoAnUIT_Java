/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.models.businesses;

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
}
