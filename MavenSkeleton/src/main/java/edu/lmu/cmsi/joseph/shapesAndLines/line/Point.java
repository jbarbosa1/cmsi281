package edu.lmu.cmsi.joseph.shapesAndLines.line;

    public class Point{

	private double x;
	private double y;

	public Point(double x, double y) {
    this.setX(x);
    this.setY(y);
    }

    public void setX(double x){
    	this.x = x;
    }

    public void setY(double y){
    	this.y = y;
    }

    public double getX(){
    	return this.x;
    }

    public double getY(){
    	return this.y;
    }

	public double getDistance(Point second){
 		double x1 = this.x;
 		double y1 = this.y;
 		double x2 = second.getX();
 	    double y2 = second.getY();

 	    double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));

 	    return(distance);
 	}

 	public boolean checkEquality(Point twoPoint){
 		return((getDistance(twoPoint)) == 0.0);
 	}
}