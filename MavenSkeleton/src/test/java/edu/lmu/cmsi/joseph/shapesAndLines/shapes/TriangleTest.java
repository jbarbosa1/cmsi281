package edu.lmu.cmsi.joseph.shapesAndLines.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import edu.lmu.cmsi.joseph.shapesAndLines.shapes.*;

public class TriangleTest{

	@Test
	public void rightTester1(){
		Triangle tester1 = new Triangle(0.0, 0.0, 3, 4, 5);
		assertEquals("failure", true, tester1.isRight());
	}

	@Test
	public void rightTester2(){
		Triangle tester2 = new Triangle(0.0, 0.0, 5, 12, 13);
		assertEquals("failure", true, tester2.isRight());
	}

	@Test
	public void area1(){
		Triangle tester3 = new Triangle(0.0, 0.0, 0, 0, 0);
		assertEquals(0.0, tester3.getArea(), 0.00);
	}

	@Test
	public void area2(){
		Triangle tester4 = new Triangle(1.0, 2.0, 3, 4, 5);
		assertEquals(6.0, tester4.getArea(), 0.00);
	}

	@Test
	public void perimeter1(){
		Triangle tester5 = new Triangle(4.0, 4.0, 5, 12, 13);
		assertEquals(30, tester5.getPerimeter(), 0.0);
	}

	@Test
	public void perimeter2(){
		Triangle tester6 = new Triangle(0.0, 0.0, 3, 4, 5);
		assertEquals(12, tester6.getPerimeter(), 0.0);
	}

	@Test
	public void contains1(){
		Triangle tester7 = new Triangle(1.0, 1.0, 3, 4, 5);
		assertEquals("failure", true, tester7.containsPoint(2.0, 2.0));
	}

	@Test
	public void contains2(){
		Triangle tester8 = new Triangle(0.0, 0.0, 5, 12, 13);
		assertEquals("failure", true, tester8.containsPoint(8.0, 1.0));
	}
}