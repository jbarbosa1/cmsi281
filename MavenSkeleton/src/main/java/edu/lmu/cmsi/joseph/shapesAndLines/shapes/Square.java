package edu.lmu.cmsi.joseph.shapesAndLines.shapes;

import edu.lmu.cmsi.joseph.shapesAndLines.line.Point;
import edu.lmu.cmsi.joseph.shapesAndLines.shapes.Rectangle;

public class Square{
    
    private double x;
    private double y;
    private int side;

    public Square(double x, double y, int side) {
        this.x = x;
        this.y = y;
        this.side = side;
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

    public int getArea(){
        return this.side * this.side;
    }

    public int getPerimeter(){
        return 4 * this.side;
    }

    public boolean containsPoint(double first, double second){
        double upper = x + this.side;
        double retainer = y + this.side;

        if((first >= this.x) && (first <= upper)){
            return((second >= this.y) && (second <= retainer));
        }

        return false;
    }

    public Rectangle getBoundingRectangle(){
        return(new Rectangle(x, y, ++side, ++side));
    }

    public void translate(double shift1, double shift2){
        this.x += shift1;
        this.y += shift2;
    }
}