/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import uit.team.QLDauSachJFrame1;
import uit.team.QLHocVienJFrame;
import uit.team.QLPhieuMuonJFrame11;
import uit.team.QLSachJFrame1;
import uit.team.forms.FormDauSach;
import uit.team.forms.FormHocVien;
import uit.team.forms.FormPhieuMuon;
import uit.team.forms.FormSach;

/**
 *
 * @author USER
 */
public class FormController {
    
    public static void setFunctionClose(JFrame jFrame){
        if (jFrame instanceof FormPhieuMuon) {
            jFrame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    new QLPhieuMuonJFrame11().setVisible(true);
                }
            });
        } else if (jFrame instanceof FormHocVien) {
            jFrame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    new QLHocVienJFrame().setVisible(true);
                }
            });
        } else if (jFrame instanceof FormSach) {
            jFrame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    new QLSachJFrame1().setVisible(true);
                }
            });
        } else if (jFrame instanceof FormDauSach) {
            jFrame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    new QLDauSachJFrame1().setVisible(true);
                }
            });
        } 
    }
     
}
