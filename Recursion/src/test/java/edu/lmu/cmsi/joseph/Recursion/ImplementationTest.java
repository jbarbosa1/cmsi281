package edu.lmu.cmsi.joseph.Recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import edu.lmu.cmsi.joseph.Recursion.Fibonacci;
import edu.lmu.cmsi.joseph.Recursion.StringToInt;
import edu.lmu.cmsi.joseph.Recursion.Multiplier;

public class ImplementationTest{

  public ImplementationTest(){
  }

  @Test
  public void RecursionTest1(){
    Fibonacci f1 = new Fibonacci();
    assertEquals("failure - didn't match", 55, f1.fibonacci(10));
  }

  @Test
  public void RecursionTest2(){
    Fibonacci f2 = new Fibonacci();
    assertEquals("failure - didn't match", 13, f2.fibonacci(7));
  }

  @Test
  public void RecursionTest3(){
    Multiplier m1 = new Multiplier();
    assertEquals("failure - didn't match", 75, m1.multiply(5, 15));
  }

  @Test
  public void RecursionTest4(){
    Multiplier m2 = new Multiplier();
    assertEquals("failure - didn't match", 0, m2.multiply(73, 0));
  }


  @Test
  public void RecursionTest5(){
    StringToInt s1 = new StringToInt("19999");
    assertEquals("failure - didn't match", 19999 , s1.convert());
  }

  @Test
  public void RecursionTest6(){
    StringToInt s2 = new StringToInt("150");
    assertEquals("failure - didn't match", 150 , s2.convert());
  }

  @Test
  public void RecursionTest7(){
    BalancedParenthesis b1 = new BalancedParenthesis("([][])");
    assertEquals("failure - didn't match", true , b1.balanced());
  }

  @Test
  public void RecursionTest8(){
    BalancedParenthesis b2 = new BalancedParenthesis("[(])");
    assertEquals("failure - didn't match", false , b2.balanced());
  }
}