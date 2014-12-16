package edu.lmu.cmsi.joseph.shapesAndLines.line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import edu.lmu.cmsi.joseph.shapesAndLines.line.*;

public class LineTest{
	
	Point first = new Point(0.0, 0.0);
	Point second = new Point(1.0, 1.0);
	Point third = new Point(2.0, 2.0);
	Point fourth = new Point(4.0, 4.0);
	Point fifth = new Point(8.0, 8.0);
	Point sixth = new Point(0.0, 4.0);
	Point seventh = new Point(4.0, 0.0);

	@Test
	public void checkEquality1(){
		Line tester1 = new Line(third, fourth);
		Line tester2 = new Line(third, fifth);
		assertEquals("failure", false, tester2.checkEquality(tester1));
	}

	@Test
	public void checkEquality2(){
		Line tester3 = new Line(first, second);
		Line tester4 = new Line(first, second);
		assertEquals("failure", true, tester4.checkEquality(tester3));
	}

	@Test
	public void getLength1(){
		Line tester5 = new Line(first, second);
		double result1 = Math.sqrt(2);
		assertEquals(result1, tester5.getLength(), 0.01);
	}

	@Test
	public void getLength2(){
		Line tester6 = new Line(first, sixth);
		assertEquals(4.0, tester6.getLength(), 0.01);
	}

	@Test
	public void doesIntersect1(){
		Line tester7 = new Line(first, fourth);
		Line tester8 = new Line(sixth, seventh);
		assertEquals("failure", true, tester7.doesIntersect(tester8));
	}

	@Test
	public void doesIntersect2(){
		Line tester9 = new Line(first, fourth);
		Line tester10 = new Line(fourth, fifth);
		assertEquals("failure", true, tester9.doesIntersect(tester10));
	}
}