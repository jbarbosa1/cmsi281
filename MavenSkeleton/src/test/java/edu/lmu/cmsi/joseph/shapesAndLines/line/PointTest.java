package edu.lmu.cmsi.joseph.shapesAndLines.line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import edu.lmu.cmsi.joseph.shapesAndLines.line.Point;

public class PointTest{
	
	Point one = new Point(0.0, 0.0);
	Point two = new Point(1.0, 1.0);
	Point three = new Point(2.0, 2.0);
	Point four = new Point(4.0, 4.0);
	Point five = new Point(3.0, 4.0);

	@Test
	public void getDistance1(){
		assertEquals(5.0, one.getDistance(five), 0.00);
	}

	@Test
	public void getDistance2(){
		assertEquals(Math.sqrt(2), one.getDistance(two), 0.00);
	}

	@Test
	public void checkEquality1(){
		assertEquals("failure", true, one.checkEquality(one));
	}

	@Test
	public void checkEquality2(){
		assertEquals("failure", false, three.checkEquality(four));
	}
}