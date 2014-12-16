package edu.lmu.cmsi.joseph.shapesAndLines.shapes;

import edu.lmu.cmsi.joseph.shapesAndLines.line.Point;
import edu.lmu.cmsi.joseph.shapesAndLines.shapes.Rectangle;

public class Triangle{

    private double x;
    private double y;
    private int side1;
    private int side2;
    private int side3;
    public int base;
    public int height;
    public int hypotenuse;

    public boolean isRight(){
        return((((side1*side1) == ((side2*side2) + (side3*side3))) ||
            ((side2*side2) == ((side1*side1) + (side3*side3))) ||
            ((side3*side3) == ((side1*side1) + (side2*side2)))));
    }

    public Triangle(double x1, double y1, int s1, int s2, int s3){
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
        this.setSides();
        if(isRight() == true){
            this.x = x1;
            this.y = y1;
        }else{
            throw new IllegalArgumentException("Not a Right Triangle");
        }
    }

    public double getArea(){
        return((base*height)/2);
    }

    public int getPerimeter(){
        return(side1 + side2 + side3);
    }

    public void setSides(){
        if(side1 < side2){
            if(side1 < side3){
                this.height = side1;
                if(side2 < side3){
                    this.base = side2;
                    this.hypotenuse = side3;
                }else{
                    this.base = side3;
                    this.base = side2;
                }
            }else{
                this.base = side1;
                this.height = side3;
                this.hypotenuse = side2;
            }
        }else{
            if(side2 < side3){
                this.height = side2;
                if(side1 < side3){
                    this.base = side1;
                }else{
                    this.base = side3;
                }
            }else{
                this.base = side2;
                this.height = side3;
                this.hypotenuse = side1;
            }
        }
    }

    public void translate(double shift1, double shift2){
        this.x += shift1;
        this.y += shift2;
    }

    public Rectangle getBoundingRectangle(){
        return(new Rectangle(x, y, base, height));
    }

    public boolean containsPoint(double x1, double y1){
        return( y + y1 + x + x1 - base * height < 0);
    }
}