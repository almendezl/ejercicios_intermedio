/**
 * 
 */
package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.geom.Line2D;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import world.Circle;
import world.Quadrilateral;
import world.Triangle;
import world.Point;

/**
 * @author Jorge A. Arevalo A. - Docente de Planta - Universidad Piloto de Colombia
 *
 */
@SuppressWarnings("serial")
public class ShapesInterface extends JFrame {
    // ---------------------------------------------------------------------------------------
    // Constants
    // ---------------------------------------------------------------------------------------
    /** Shape selected option*/
    private static final int CIRCLE = 1;
	
    /** Shape selected option*/
    private static final int QUAD = 2;
	
    /** Shape selected option*/
    private static final int TRIANGLE = 3;

    // ---------------------------------------------------------------------------------------
    // Attributes
    // ---------------------------------------------------------------------------------------
    /** A circle */
    private Circle circle;
	
    /** A triangle */
    private Triangle triangle;
	
    /** A quadrilateral */
    private Quadrilateral quad;
	
    /** Shape selected reference */
    private int shapeSelected;

    // ---------------------------------------------------------------------------------------
    // Interface Attributes
    // ---------------------------------------------------------------------------------------
    /** Buttons Panel */
    private ButtonsPanel buttonsPanel;
	
    /** Shape Panel */
    private ShapePanel shapePanel;
	
    /** Options Panel */
    private OptionsPanel optionsPanel;
    
    /** Image Panel */
    private ImagePanel imagePanel;
    
    /** Points Dialog */
    private PointsDialog pointsDialog;
    
    /** Shapes Dialog */
    private ShapesDialog shapesDialog;

    // ---------------------------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------------------------
    /**
     * Constructor. Initializes the main interface
     */
    public ShapesInterface() {
    	shapeSelected = CIRCLE;
    	circle = new Circle();
    	quad = new Quadrilateral();
    	triangle = new Triangle();
    	
    	//Fill color
    	world.Color fillColor = new world.Color();
    	fillColor.setRed(0);
    	fillColor.setGreen(0);
    	fillColor.setBlue(170);
    	
    	//Line color
    	world.Color lineColor = new world.Color();
    	lineColor.setRed(0);
    	lineColor.setGreen(0);
    	lineColor.setBlue(0);
    	
    	//Points for shapes
    	Point point1 = new Point();
    	Point point2 = new Point();
    	Point point3 = new Point();
    	Point point4 = new Point();
    	
    	//Shapes
    	switch (shapeSelected) {
            case CIRCLE :
                point1.setX(50);
                point1.setY(50);
                double radius = 80;

                circle = new Circle(point1, radius, fillColor, lineColor);
                setTitle("Shapes");
                getContentPane().setLayout(new BorderLayout());
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                buttonsPanel = new ButtonsPanel(this);
                getContentPane().add(buttonsPanel, BorderLayout.WEST);
                shapePanel = new ShapePanel(circle);
                getContentPane().add(shapePanel, BorderLayout.CENTER);

            break;
            case QUAD :
                point1.setX(220);
                point1.setY(20);

                point2.setX(30);
                point2.setY(20);

                point3.setX(20);
                point3.setY(200);

                point4.setX(240);
                point4.setY(200);

                quad = new Quadrilateral(point1, point2, point3, point4, fillColor, lineColor);
                setTitle("Shapes");
                getContentPane().setLayout(new BorderLayout());
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                buttonsPanel = new ButtonsPanel(this);
                getContentPane().add(buttonsPanel, BorderLayout.WEST);
                shapePanel = new ShapePanel(quad);
                getContentPane().add(shapePanel, BorderLayout.CENTER);

            break;
            case TRIANGLE :
                point1.setX(120);
                point1.setY(20);

                point2.setX(220);
                point2.setY(200);

                point3.setX(20);
                point3.setY(200);

                triangle = new Triangle(point1, point2, point3, fillColor, lineColor);
                setTitle("Shapes");
                getContentPane().setLayout(new BorderLayout());
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                buttonsPanel = new ButtonsPanel(this);
                getContentPane().add(buttonsPanel, BorderLayout.WEST);
                shapePanel = new ShapePanel(triangle);
                getContentPane().add(shapePanel, BorderLayout.CENTER);

            break;
    	}

    	optionsPanel = new OptionsPanel(this);
        getContentPane().add(optionsPanel, BorderLayout.SOUTH);

        imagePanel = new ImagePanel();
        getContentPane().add(imagePanel, BorderLayout.NORTH);

        pack();

        repaint();
    }

    // ---------------------------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------------------------
    /**
     * Method for shows a shapesDialog
     */
    public void setShape() {
        shapesDialog = new ShapesDialog(this);
        shapesDialog.setLocationRelativeTo(this);
        shapesDialog.setVisible(true);
        setEnabled(false);
    }

    /**
     * Method for shows a pointsDialog
     */
    public void setPoints() {
        pointsDialog = new PointsDialog(this);
        pointsDialog.setLocationRelativeTo(this);
        pointsDialog.setVisible(true);
        setEnabled(false);
    }

    /**
     * Method for update the fill color of a shape
     */
    public void setFillColor() {
        switch (shapeSelected) {
            case CIRCLE :
                Color presentColor1 = new Color(circle.getFillColor().getRed(), circle.getFillColor().getGreen(),
                                circle.getFillColor().getBlue());
                Color newColor1 = JColorChooser.showDialog(this, "Fill Color", presentColor1);
                if(newColor1 != null) {
                    //set values
                        circle.setFillColor(newColor1.getRed(), newColor1.getGreen(), newColor1.getBlue());
                }
            break;
            case QUAD :
                Color presentColor2 = new Color(quad.getFillColor().getRed(), quad.getFillColor().getGreen(),
                                quad.getFillColor().getBlue());
                Color newColor2 = JColorChooser.showDialog(this, "Fill Color", presentColor2);
                if(newColor2 != null) {
                    //set values
                        quad.setFillColor(newColor2.getRed(), newColor2.getGreen(), newColor2.getBlue());
                }
            break;
            case TRIANGLE :
                Color presentColor3 = new Color(triangle.getFillColor().getRed(), triangle.getFillColor().getGreen(),
                                triangle.getFillColor().getBlue());
                Color newColor3 = JColorChooser.showDialog(this, "Fill Color", presentColor3);
                if(newColor3 != null) {
                    //set values
                        triangle.setFillColor(newColor3.getRed(), newColor3.getGreen(), newColor3.getBlue());
                }
            break;
        }
        repaint();
    }

    /**
     * Method for update the line color of a shape
     */
    public void setLineColor() {
        switch (shapeSelected) {
            case CIRCLE :
                Color presentColor1 = new Color(circle.getLineColor().getRed(), circle.getLineColor().getGreen(),
                                circle.getLineColor().getBlue());
                Color newColor1 = JColorChooser.showDialog(this, "Line Color", presentColor1);
                if(newColor1 != null){
                    //set values
                        circle.setLineColor(newColor1.getRed(), newColor1.getGreen(), newColor1.getBlue());
                }
            break;
            case QUAD :
                Color presentColor2 = new Color(quad.getLineColor().getRed(), quad.getLineColor().getGreen(),
                                quad.getLineColor().getBlue());
                Color newColor2 = JColorChooser.showDialog(this, "Line Color", presentColor2);
                if(newColor2 != null){
                    //set values
                        quad.setLineColor(newColor2.getRed(), newColor2.getGreen(), newColor2.getBlue());
                }
            break;
            case TRIANGLE :
                Color presentColor3 = new Color(triangle.getLineColor().getRed(), triangle.getLineColor().getGreen(),
                                triangle.getLineColor().getBlue());
                Color newColor3 = JColorChooser.showDialog(this, "Line Color", presentColor3);
                if(newColor3 != null){
                    //set values
                        triangle.setLineColor(newColor3.getRed(), newColor3.getGreen(), newColor3.getBlue());
                }
            break;
        }
        repaint();
    }

    /**
     * Method for get the shape selected
     * @return shape selected reference
     */
    public int getShapeSeleted() {
        return shapeSelected;
    }

    /**
     * Method for update the shape selected reference
     * @param shapeSelected New shape selected reference
     */
    public void setShapeSelected(int shapeSelected) {
        this.shapeSelected = shapeSelected;
    }

    /**
     * Returns a triangle
     * @return a triangle
     */
    public Triangle getTriangle() {
        return triangle;
    }

    /**
     * Returns a circle
     * @return a circle
     */
    public Circle getCircle() {
        return circle;
    }

    /**
     * Returns a quadrilateral
     * @return a quadrilateral
     */
    public Quadrilateral getQuadrilateral() {
        return quad;
    }

    /**
     * Overrides the repaint method of super class
     */
    public void repaint() {
        shapePanel.repaint();
        switch(shapeSelected) {
            case CIRCLE :
                buttonsPanel.updateData("Circle", circle.getPerimeter(), circle.getArea());
            break;
            case QUAD :
                buttonsPanel.updateData("Quadrilateral", quad.getPerimeter(), quad.getArea());
            break;
            case TRIANGLE :
                buttonsPanel.updateData("Triangle", triangle.getPerimeter(), triangle.getArea());
            break;
        }
    }

    /**
     * Method to repaint a shape according with a user selection
     * @param shape selection reference
     */
    public void repaint(int shape) {
    	world.Color fillColor = new world.Color();
    	fillColor.setRed(0);
    	fillColor.setGreen(0);
    	fillColor.setBlue(170);
    	
    	world.Color lineColor = new world.Color();
    	lineColor.setRed(0);
    	lineColor.setGreen(0);
    	lineColor.setBlue(0);
    	
    	Point point1 = new Point();
    	Point point2 = new Point();
    	Point point3 = new Point();
    	Point point4 = new Point();
    	
    	switch(shape) {
            case CIRCLE :
                point1.setX(50);
                point1.setY(50);

                double radius = 80;

                circle = new Circle(point1, radius, fillColor, lineColor);

                getContentPane().remove(shapePanel);
                shapePanel = new ShapePanel(circle);
                getContentPane().add(shapePanel, BorderLayout.CENTER);

                buttonsPanel.updateData("Circle", circle.getPerimeter(), circle.getArea());
            break;
            case QUAD :
                point1.setX(220);
                point1.setY(20);

                point2.setX(30);
                point2.setY(20);

                point3.setX(20);
                point3.setY(200);

                point4.setX(240);
                point4.setY(200);

                quad = new Quadrilateral(point1, point2, point3, point4, fillColor, lineColor);

                getContentPane().remove(shapePanel);
                shapePanel = new ShapePanel(quad);
                getContentPane().add(shapePanel, BorderLayout.CENTER);

                buttonsPanel.updateData("Quadrilateral", quad.getPerimeter(), quad.getArea());
            break;
            case TRIANGLE :
                point1.setX(120);
                point1.setY(20);

                point2.setX(220);
                point2.setY(200);

                point3.setX(20);
                point3.setY(200);

                triangle = new Triangle(point1, point2, point3, fillColor, lineColor);

                getContentPane().remove(shapePanel);
                shapePanel = new ShapePanel(triangle);
                getContentPane().add(shapePanel, BorderLayout.CENTER);

                buttonsPanel.updateData("Triangle", triangle.getPerimeter(), triangle.getArea());
            break;
        }
    }

    /**
     * Checks if the points of a triangle are collinear
     * @param p1x x coordinate of point 1
     * @param p1y y coordinate of point 1
     * @param p2x x coordinate of point 2
     * @param p2y y coordinate of point 2
     * @param p3x x coordinate of point 3
     * @param p3y y coordinate of point 3
     * @return validation of collinearity of points 
     */
    public boolean collinear(double p1x, double p1y, double p2x, double p2y,
                    double p3x, double p3y) {
        //checks using Line2D
        Line2D line = new Line2D.Double(p1x, p1y, p2x, p2y);
        return (line.ptLineDist(p3x, p3y) == 0);
    }

    /**
     * Checks if the points of a quadrilateral are collinear
     * @param p1x x coordinate of point 1
     * @param p1y y coordinate of point 1
     * @param p2x x coordinate of point 2
     * @param p2y y coordinate of point 2
     * @param p3x x coordinate of point 3
     * @param p3y y coordinate of point 3
     * @param p4x x coordinate of point 4
     * @param p4y y coordinate of point 4
     * @return validation of collinearity of points
     */
    public boolean collinear(double p1x, double p1y, double p2x, double p2y,
                    double p3x, double p3y, double p4x, double p4y) {
        //checks using Line2D
        Line2D line = new Line2D.Double(p1x, p1y, p2x, p2y);
        return (line.ptLineDist(p3x, p3y) == 0 || line.ptLineDist(p4x, p4y) == 0);
    }

    // ---------------------------------------------------------------------------------------
    // Extension Points
    // ---------------------------------------------------------------------------------------
    /**
     * Extension method 1
     */
    public void reqFuncOption1() {
        String response="";
        switch(shapeSelected){
            case CIRCLE:
                    response = circle.method1();
                    break;
            case QUAD:
                    response= quad.method1();
                    break;
            case TRIANGLE:
                    response=triangle.method1();
                    break;
        }
        JOptionPane.showMessageDialog(this,response,"Response",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Extension method 2
     */
    public void reqFuncOption2() {
        String response="";
        switch(shapeSelected){
            case CIRCLE:
                    response = circle.method2();
                    break;
            case QUAD:
                    response= quad.method2();
                    break;
            case TRIANGLE:
                    response=triangle.method2();
                    break;
        }
        JOptionPane.showMessageDialog(this,response,"Response",JOptionPane.INFORMATION_MESSAGE);
    }

    // ---------------------------------------------------------------------------------------
    // Main
    // ---------------------------------------------------------------------------------------
    /**
     * Starts the application
     * @param args parameters to be used
     */
	public static void main(String[] args) {
        ShapesInterface interf = new ShapesInterface();
        interf.setVisible(true);
    }

}
