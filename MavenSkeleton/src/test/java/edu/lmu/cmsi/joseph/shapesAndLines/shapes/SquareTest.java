package edu.lmu.cmsi.joseph.shapesAndLines.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import edu.lmu.cmsi.joseph.shapesAndLines.shapes.*;

public class SquareTest{

	@Test
	public void area1(){
		Square tester1 = new Square(2.0, 2.0, 4);
		assertEquals(16, tester1.getArea(), 0.00);
	}

	@Test
	public void area2(){
		Square tester2 = new Square(0.0, 0.0, 5);
		assertEquals(25, tester2.getArea(), 0.00);
	}

	@Test
	public void perimeter1(){
		Square tester3 = new Square(5.0, 5.0, 2);
		assertEquals(8, tester3.getPerimeter(), 0.0);
	}

	@Test
	public void perimeter2(){
		Square tester4 = new Square(0.0, 0.0, 10);
		assertEquals(40, tester4.getPerimeter(), 0.0);
	}

	@Test
	public void contains1(){
		Square tester5 = new Square(0.0, 0.0, 10);
		assertEquals("failure", true, tester5.containsPoint(10.0, 10.0));
	}

	@Test
	public void contains2(){
		Square tester6 = new Square(1.0, 1.0, 5);
		assertEquals("failure", false, tester6.containsPoint(7.0, 7.0));
	}
}