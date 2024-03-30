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
import uit.team.HomeFrame;
import uit.team.QLFrame;

/**
 *
 * @author USER
 */
public class QLController {
    public static void initDatas(JTable jTable1){};
    
    public static void gotoHomeFrameAfterDispose(JFrame jFrame){
        jFrame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                QLFrame targ = (QLFrame)e.getComponent();
                if (targ.returnHomeFrame){
                    new HomeFrame().setVisible(true);                    
                }
            }
        });
    }
}
