package edu.lmu.cmsi.joseph.shapesAndLines.shapes;

import edu.lmu.cmsi.joseph.shapesAndLines.line.Point;
import edu.lmu.cmsi.joseph.shapesAndLines.shapes.Rectangle;

public class Circle{

    private double x;
    private double y;
    private double radius;
    private double diameter;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        if(radius >= 0){
            this.radius = radius;
            this.diameter = radius * 2;
        }else{
            throw new IllegalArgumentException("Can't be negative radius");
        }
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getDiameter(){
        return this.diameter;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }

    public double getCircumference(){
        return 2 * Math.PI * this.radius;
    }

    public boolean containsPoint(double inputX, double inputY){
        double firstX = this.x;
        double firstY = this.y;

        double distance = Math.sqrt((firstX - inputX)*(firstX - inputX) + (firstY - inputY)*(firstY - inputY));

        return(distance <= this.radius);
    }

    public void translate(double shift1, double shift2){
        this.x += shift1;
        this.y += shift2;
    }

    public Rectangle getBoundingRectangle(){
        double bound = Math.ceil(radius);
        double side = bound * 2;
        double xOrigin = (x - bound);
        double yOrigin = (y - bound);       
        return(new Rectangle(xOrigin, yOrigin, side, side));
    }
}