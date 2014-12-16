package edu.lmu.cmsi.joseph.shapesAndLines.line;

import edu.lmu.cmsi.joseph.shapesAndLines.line.Point;
import java.lang.*;
import java.awt.geom.Line2D;

public class Line{
	private double xStart;
	private double xFinish;
	private double yStart;
	private double yFinish;
 

	public Line(Point num1, Point num2){
		this.xStart = num1.getX();
		this.xFinish = num2.getX();
		this.yStart = num1.getY();
		this.yFinish = num2.getY();
	}

	public Point getMidPoint(){
		double xDifference = (xFinish - xStart);
		double yDifference = (yFinish - yStart);
		Point result = new Point(0.0,0.0);

		result.setX(xDifference/2);
		result.setY(yDifference/2);

		return(result);
	}

	public boolean checkEquality(Line one){
		return((this.xStart == one.xStart) && (this.xFinish == one.xFinish) && (this.yStart == one.yStart) && (this.yFinish == one.yFinish));
	}

	public double getLength(){
			double x1 = this.xStart;
	 		double y1 = this.yStart;
	 		double x2 = this.xFinish;
	 	    double y2 = this.yFinish;

	 	    double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));

	 	    return(distance);
	}

	public boolean doesIntersect(Line line2){
		double first1 = this.xStart;
		double first2 = line2.xStart;
		double second1 = this.yStart;
		double second2 = line2.yStart;
		double third1 = this.xFinish;
		double third2 = line2.xFinish;
		double fourth1 = this.yFinish;
		double fourth2 = line2.yFinish;
		Line2D first = new Line2D.Double(first1, second1, third1, fourth1);
		Line2D second = new Line2D.Double(first2, second2, third2, fourth2);
		return(second.intersectsLine(first));
	}
}