/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import uit.team.models.businesses.DauSachUtils;
import uit.team.models.mssql.dao.DauSachDAO;
import uit.team.models.mssql.entities.DauSach;

/**
 *
 * @author USER
 */
public class FormSachController extends FormController{
    public static void populateDauSachCombobox(JComboBox dauSachCombobox) {
        List datas = DauSachUtils.getDauSachInfos(dauSachCombobox);
        DefaultComboBoxModel model = new DefaultComboBoxModel<>(datas.toArray());
        dauSachCombobox.setModel(model);
    }
}
