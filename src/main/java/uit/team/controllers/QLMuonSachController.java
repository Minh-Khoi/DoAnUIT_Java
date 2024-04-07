/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.team.controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import uit.team.QLMuonSachJFrame;
import uit.team.QLPhieuMuonJFrame11;

/**
 *
 * @author USER
 */
public class QLMuonSachController {
    
    public static void gotoHomeFrameAfterDispose(JFrame jFrame){
        jFrame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                QLMuonSachJFrame targ = (QLMuonSachJFrame)e.getComponent();
                if (targ.returnBack){
                    new QLPhieuMuonJFrame11().setVisible(true);                    
                }
            }
        });
    }
}
