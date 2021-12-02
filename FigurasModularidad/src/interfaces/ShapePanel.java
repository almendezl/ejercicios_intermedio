/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import world.Circle;
import world.Quadrilateral;
import world.Triangle;

/**
 *
 * @author Angie Mendez
 */
public class ShapePanel extends JPanel {

    private static final int CIRCLE = 1;
    private static final int QUAD = 2;
    private static final int TRIANGLE = 3;

    private Circle circle;
    private Quadrilateral quad;
    private Triangle triangle;
    private int shapeSelected;

    public ShapePanel(Circle circle) {
        this.circle = circle;
        this.shapeSelected = CIRCLE;
        setPreferredSize(new Dimension(270, 200));
    }

    public ShapePanel(Quadrilateral quad) {
        this.quad = quad;
        this.shapeSelected = QUAD;
        setPreferredSize(new Dimension(270, 200));
    }

    public ShapePanel(Triangle triangle) {
        this.triangle = triangle;
        this.shapeSelected = TRIANGLE;
        setPreferredSize(new Dimension(270, 200));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        switch (shapeSelected) {
            case CIRCLE:
                Ellipse2D.Float elipse = new Ellipse2D.Float((float) circle.getPoint().getX(),
                        (float) circle.getPoint().getY(), (float) circle.getDiameter(), (float) circle.getDiameter());

                g2d.setColor(new Color(circle.getFillColor().getRed(), circle.getFillColor().getGreen(), circle.getFillColor().getBlue()));
                g2d.setColor(new Color(circle.getFillColor().getRed(), circle.getFillColor().getGreen(),
                        circle.getFillColor().getBlue()));
                g2d.fill(elipse);
                g2d.setColor(new Color(circle.getLineColor().getRed(), circle.getLineColor().getGreen(),
                circle.getLineColor().getBlue()));
                g2d.draw(elipse);
                break;
            case QUAD:
                Polygon polygon1 = new Polygon ();
                polygon1.addPoint((int)quad.getPoints().get(0).getX(), (int)quad.getPoints().get(0).getY());
                polygon1.addPoint((int)quad.getPoints().get(1).getX(), (int)quad.getPoints().get(1).getY());
                polygon1.addPoint((int)quad.getPoints().get(2).getX(), (int)quad.getPoints().get(2).getY());
                polygon1.addPoint((int)quad.getPoints().get(3).getX(), (int)quad.getPoints().get(3).getY());
                g2d.setColor(new Color(quad.getFillColor().getRed(),quad.getFillColor().getGreen(), quad.getFillColor().getBlue()) );
                g2d.fill(polygon1);
                g2d.setColor(new Color(quad.getLineColor().getRed(),quad.getLineColor().getGreen(), quad.getLineColor().getBlue()) );
                g2d.draw(polygon1);
                break;
            case TRIANGLE:
                Polygon polygon2 = new Polygon();
                polygon2.addPoint((int)triangle.getPoints().get(0).getX(), (int)triangle.getPoints().get(0).getY());
                polygon2.addPoint((int)triangle.getPoints().get(1).getX(), (int)triangle.getPoints().get(1).getY());
                polygon2.addPoint((int)triangle.getPoints().get(2).getX(), (int)triangle.getPoints().get(2).getY());
                g2d.setColor(new Color(triangle.getFillColor().getRed(),triangle.getFillColor().getGreen(), triangle.getFillColor().getBlue() ));
                g2d.fill(polygon2);
                g2d.setColor(new Color(triangle.getLineColor().getRed(),triangle.getLineColor().getGreen(), triangle.getLineColor().getBlue() ));
                g2d.draw(polygon2);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Unavailable option", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
}
