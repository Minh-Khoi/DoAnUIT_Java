/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import uit.team.forms.FormDauSach;
import uit.team.models.mssql.dao.DauSachDAO;
import uit.team.models.mssql.entities.DauSach;

/**
 *
 * @author USER
 */
public class FormDauSachController  extends FormController{
    
    public static void populateDatas(FormDauSach form, String prV) {
        DauSach instance = DauSachDAO.readByPrimaryKey(prV);
        form.tenTextField2.setText(instance.getTenDauSach());
    }
    
}
