/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Angie Mendez
 */
public class PanelFiguras extends JPanel {
    //Seleccion de figura area
    private JRadioButton rbtCuadrado;
    private  JRadioButton rbtRectangulo;
    private  JRadioButton rbtParalelogramo;
    private  JRadioButton rbtTrapecio;
    private  JRadioButton rbtCirculo;
    private  JRadioButton rbtTriangulo;
    private  JRadioButton rbtElipse;
    private  JRadioButton rbtCubo;
    private  JRadioButton rbtEsfera;
    //volumen
    private JRadioButton rbtPrismaRect;
    private JRadioButton rbtCilindro;
    private JRadioButton rbtCono;
    private JRadioButton rbtElipsoide;
    
    
    
    public PanelFiguras() {
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Figuras")));
        GridLayout gl = new GridLayout(4,4);
        gl.setVgap(3);
        gl.setHgap(5);
        setLayout(gl);
        
        rbtCuadrado = new JRadioButton("Cuadrado");
       rbtCuadrado.setEnabled(false);
        rbtRectangulo = new JRadioButton("Rectangulo");
        rbtRectangulo.setEnabled(false);
        rbtParalelogramo = new JRadioButton("Paralelogramo");
        rbtParalelogramo.setEnabled(false);
        rbtTrapecio = new JRadioButton("Trapecio");
        rbtTrapecio.setEnabled(false);
        rbtCirculo = new JRadioButton("Circulo");
        rbtCirculo.setEnabled(false);
        rbtTriangulo = new JRadioButton("Triangulo");
        rbtTriangulo.setEnabled(false);
        rbtElipse = new JRadioButton("Elipse");
        rbtElipse.setEnabled(false);
        rbtCubo = new JRadioButton("Cubo");
        rbtCubo.setEnabled(false);
        rbtEsfera = new JRadioButton("Esfera");
        rbtEsfera.setEnabled(false);
        
        //volumen
        rbtPrismaRect = new JRadioButton ("Prisma rectangular");
        rbtPrismaRect.setEnabled(false);
        rbtCilindro = new JRadioButton("Cilindro");
        rbtCilindro.setEnabled(false);
        rbtCono = new JRadioButton("Cono");
        rbtCono.setEnabled(false);
        rbtElipsoide = new JRadioButton("Elipsoide");
        rbtElipsoide.setEnabled(false);
        //cono y elipse comparten boton de radio para area y volumen 
        
        add(rbtCuadrado);
        add(rbtRectangulo);
        add(rbtParalelogramo);
        add(rbtTrapecio);
        add(rbtCirculo);
        add(rbtTriangulo);
        add(rbtElipse);
        add(rbtCubo);
        add(rbtEsfera);
        add(rbtPrismaRect);
        add(rbtCilindro);
        add(rbtCono);
        add(rbtElipsoide);
    }
   
    public JRadioButton getRbtCuadrado() {
        return rbtCuadrado;
    }

    public JRadioButton getRbtRectangulo() {
        return rbtRectangulo;
    }

    public JRadioButton getRbtParalelogramo() {
        return rbtParalelogramo;
    }

    public JRadioButton getRbtTrapecio() {
        return rbtTrapecio;
    }

    public JRadioButton getRbtCirculo() {
        return rbtCirculo;
    }

    public JRadioButton getRbtTriangulo() {
        return rbtTriangulo;
    }

    public JRadioButton getRbtElipse() {
        return rbtElipse;
    }

    public JRadioButton getRbtCubo() {
        return rbtCubo;
    }

    public JRadioButton getRbtEsfera() {
        return rbtEsfera;
    }

    /**
     * @param rbtCuadrado the rbtCuadrado to set
     */
    public void setRbtCuadrado(JRadioButton rbtCuadrado) {
        this.rbtCuadrado = rbtCuadrado;
    }

    /**
     * @param rbtRectangulo the rbtRectangulo to set
     */
    public void setRbtRectangulo(JRadioButton rbtRectangulo) {
        this.rbtRectangulo = rbtRectangulo;
    }

    /**
     * @param rbtParalelogramo the rbtParalelogramo to set
     */
    public void setRbtParalelogramo(JRadioButton rbtParalelogramo) {
        this.rbtParalelogramo = rbtParalelogramo;
    }

    /**
     * @param rbtTrapecio the rbtTrapecio to set
     */
    public void setRbtTrapecio(JRadioButton rbtTrapecio) {
        this.rbtTrapecio = rbtTrapecio;
    }

    /**
     * @param rbtCirculo the rbtCirculo to set
     */
    public void setRbtCirculo(JRadioButton rbtCirculo) {
        this.rbtCirculo = rbtCirculo;
    }

    /**
     * @param rbtTriangulo the rbtTriangulo to set
     */
    public void setRbtTriangulo(JRadioButton rbtTriangulo) {
        this.rbtTriangulo = rbtTriangulo;
    }

    /**
     * @param rbtElipse the rbtElipse to set
     */
    public void setRbtElipse(JRadioButton rbtElipse) {
        this.rbtElipse = rbtElipse;
    }

    /**
     * @param rbtCubo the rbtCubo to set
     */
    public void setRbtCubo(JRadioButton rbtCubo) {
        this.rbtCubo = rbtCubo;
    }

    /**
     * @param rbtEsfera the rbtEsfera to set
     */
    public void setRbtEsfera(JRadioButton rbtEsfera) {
        this.rbtEsfera = rbtEsfera;
    }

    public JRadioButton getRbtPrismaRect() {
        return rbtPrismaRect;
    }

    public void setRbtPrismaRect(JRadioButton rbtPrismaRect) {
        this.rbtPrismaRect = rbtPrismaRect;
    }

    public JRadioButton getRbtCilindro() {
        return rbtCilindro;
    }

    public void setRbtCilindro(JRadioButton rbtCilindro) {
        this.rbtCilindro = rbtCilindro;
    }

    public JRadioButton getRbtCono() {
        return rbtCono;
    }

    public void setRbtCono(JRadioButton rbtCono) {
        this.rbtCono = rbtCono;
    }

    public JRadioButton getRbtElipsoide() {
        return rbtElipsoide;
    }

    public void setRbtElipsoide(JRadioButton rbtElipsoide) {
        this.rbtElipsoide = rbtElipsoide;
    }
    
}
