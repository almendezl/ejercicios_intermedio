/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Angie Mendez
 */
public class PanelDibujo extends JPanel {
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int anchura = getWidth();
        int altura = getHeight();
        
        g.drawLine(0, 0, anchura, altura);
        g.drawLine(20, 5, anchura, 20);
    }
}
