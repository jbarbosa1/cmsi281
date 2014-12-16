package edu.lmu.cmsi.joseph.shapesAndLines.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import edu.lmu.cmsi.joseph.shapesAndLines.shapes.*;

public class RectangleTest{

	@Test
	public void area1(){
		Rectangle tester1 = new Rectangle(2.0, 2.0, 4, 6);
		assertEquals(24, tester1.getArea(), 0.00);
	}

	@Test
	public void area2(){
		Rectangle tester2 = new Rectangle(0.0, 0.0, 5, 8);
		assertEquals(40, tester2.getArea(), 0.00);
	}

	@Test
	public void perimeter1(){
		Rectangle tester3 = new Rectangle(5.0, 5.0, 2, 7);
		assertEquals(18, tester3.getPerimeter(), 0.0);
	}

	@Test
	public void perimeter2(){
		Rectangle tester4 = new Rectangle(0.0, 0.0, 10, 6);
		assertEquals(32, tester4.getPerimeter(), 0.0);
	}

	@Test
	public void contains1(){
		Rectangle tester5 = new Rectangle(0.0, 0.0, 12, 18);
		assertEquals("failure", true, tester5.containsPoint(10.0, 10.0));
	}

	@Test
	public void contains2(){
		Rectangle tester6 = new Rectangle(1.0, 1.0, 5, 6);
		assertEquals("failure", false, tester6.containsPoint(7.0, 7.0));
	}
}