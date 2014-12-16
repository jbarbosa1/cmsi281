package edu.lmu.cmsi.joseph.shapesAndLines.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import edu.lmu.cmsi.joseph.shapesAndLines.shapes.*;

public class CircleTest{
	Circle core = new Circle(5.0, 5.0, 2.0);

	@Test
	public void circleArea1(){
		Circle tester1 = new Circle(2.0, 2.0, 2.0);
		assertEquals((4*Math.PI), tester1.getArea(), 0.00);
	}

	@Test
	public void circleArea2(){
		Circle tester2 = new Circle(4.0, 4.0, 3.0);
		assertEquals((9*Math.PI), tester2.getArea(), 0.00);
	}

	@Test
	public void circleDiameter1(){
		Circle tester3 = new Circle(2.0, 2.0, 1.0);
		assertEquals(2.0, tester3.getDiameter(), 0.00);
	}

	@Test
	public void circleDiameter2(){
		Circle tester4 = new Circle(10.0, 10.0, 5.0);
		assertEquals(10.0, tester4.getDiameter(), 0.00);
	}

	@Test
	public void circleCircumference1(){
		Circle tester5 = new Circle(8.0, 8.0, 2.0);
		assertEquals((4.0 * Math.PI), tester5.getCircumference(), 0.00);
	}

	@Test
	public void circleCircumference2(){
		Circle tester6 = new Circle(5.0, 5.0, 2.5);
		assertEquals((5.0 * Math.PI), tester6.getCircumference(), 0.00);
	}

	@Test 
	public void containsPoint1(){
		Circle tester7 = new Circle(10.0, 10.0, 2.0);
		assertEquals("failure", false, tester7.containsPoint(8.0, 8.0));
	}

	 @Test 
	public void containsPoint2(){
		Circle tester8 = new Circle(4.0, 4.0, 2.0);
		assertEquals("failure", true, tester8.containsPoint(4.0, 2.0));
	}
}