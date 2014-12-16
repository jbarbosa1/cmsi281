package edu.lmu.cmsi.joseph.shapesAndLines.shapes;

import edu.lmu.cmsi.joseph.shapesAndLines.line.Point;

public class Rectangle{
    
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getArea(){
        return (this.width * this.height);
    }

    public double getPerimeter(){
        return ((2 * this.width)+(2 * this.height));
    }

    public boolean containsPoint(double x1, double y1){
        double upper = x + this.width;
        double retainer = y + this.height;

        if((x1 > this.x) && (x1 < upper)){
            return((y1 > this.y) && (y1 < retainer));
        }

        return false;
    }

    public void translate(double shift1, double shift2){
        this.x += shift1;
        this.y += shift2;
    }

    public Rectangle getBoundingRectangle(){
        return(new Rectangle(x, y, ++width, ++height));
    }

}