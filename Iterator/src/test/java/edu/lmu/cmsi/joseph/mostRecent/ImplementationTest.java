package edu.lmu.cmsi.joseph.mostRecent;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import edu.lmu.cmsi.joseph.mostRecent.IterableArray;
import edu.lmu.cmsi.joseph.mostRecent.LinkedAllocation;
import edu.lmu.cmsi.joseph.mostRecent.HasArrayList;

public class ImplementationTest{
    String place1 = "hey";
    String place2 = "there";
    String place3 = "mr";
    String place4 = "tester";
    String place5 = "man";
    String place6 = "joseph";
    String place7 = "barbosa";
    LinkedAllocation tester1;
    IterableArray tester2;
    HasArrayList tester3;


  public ImplementationTest(){
    tester1 = new LinkedAllocation(5);
    tester2 = new IterableArray(5);
    tester3 = new HasArrayList(5);
  }

  @Test
  public void lessThanOldestTest1(){

    tester1.add(place1);
    tester1.add(place2);
    tester1.add(place3);
    tester1.add(place4);

    assertEquals("failure - didn't match", "hey", tester1.getOldest());
  }

  @Test
  public void lessThanOldestTest2(){

    tester2.add(place1);
    tester2.add(place2);
    tester2.add(place3);
    tester2.add(place4);

    assertEquals("failure - didn't match", "hey", tester2.getOldest());
  }

  @Test
  public void lessThanOldestTest3(){

    tester3.add(place1);
    tester3.add(place2);
    tester3.add(place3);
    tester3.add(place4);

    assertEquals("failure - didn't match", "hey", tester3.getOldest());
  }

  @Test
  public void moreThanOldestTest1(){

    tester1.add(place1);
    tester1.add(place2);
    tester1.add(place3);
    tester1.add(place4);
    tester1.add(place5);
    tester1.add(place6);
    tester1.add(place7);

    assertEquals("failure - didn't match", "mr", tester1.getOldest());
  }

  @Test
  public void moreThanOldestTest2(){

    tester2.add(place1);
    tester2.add(place2);
    tester2.add(place3);
    tester2.add(place4);
    tester2.add(place5);
    tester2.add(place6);
    tester2.add(place7);

    assertEquals("failure - didn't match", "mr", tester2.getOldest());
  }

  @Test
  public void moreThanOldestTest3(){

    tester3.add(place1);
    tester3.add(place2);
    tester3.add(place3);
    tester3.add(place4);
    tester3.add(place5);
    tester3.add(place6);
    tester3.add(place7);

    assertEquals("failure - didn't match", "mr", tester3.getOldest());
  }

  @Test
  public void lessThanNewestTest1(){

    tester1.add(place1);
    tester1.add(place2);
    tester1.add(place3);
    tester1.add(place4);

    assertEquals("failure - didn't match", "tester", tester1.getNewest());
  }

  @Test
  public void lessThanNewestTest2(){

    tester2.add(place1);
    tester2.add(place2);
    tester2.add(place3);
    tester2.add(place4);

    assertEquals("failure - didn't match", "tester", tester2.getNewest());
  }

  @Test
  public void lessThanNewestTest3(){

    tester3.add(place1);
    tester3.add(place2);
    tester3.add(place3);
    tester3.add(place4);

    assertEquals("failure - didn't match", "tester", tester3.getNewest());
  }

  @Test
  public void moreThanNewestTest1(){

    tester1.add(place1);
    tester1.add(place2);
    tester1.add(place3);
    tester1.add(place4);
    tester1.add(place5);
    tester1.add(place6);
    tester1.add(place7);

    assertEquals("failure - didn't match", "barbosa", tester1.getNewest());
  }

  @Test
  public void moreThanNewestTest2(){

    tester2.add(place1);
    tester2.add(place2);
    tester2.add(place3);
    tester2.add(place4);
    tester2.add(place5);
    tester2.add(place6);
    tester2.add(place7);

    assertEquals("failure - didn't match", "barbosa", tester2.getNewest());
  }

  @Test
  public void moreThanNewestTest3(){

    tester3.add(place1);
    tester3.add(place2);
    tester3.add(place3);
    tester3.add(place4);
    tester3.add(place5);
    tester3.add(place6);
    tester3.add(place7);
    
    assertEquals("failure - didn't match", "barbosa", tester3.getNewest());
  }

  @Test
  public void checkSize1(){

    tester1.add(place1);
    tester1.add(place2);
    tester1.add(place3);
    tester1.add(place4);

    assertEquals("failure - didn't match", 4 , tester1.getSize());
  }

  @Test
  public void checkSize2(){

    tester2.add(place1);
    tester2.add(place2);
    tester2.add(place3);
    tester2.add(place4);

    assertEquals("failure - didn't match", 4 , tester2.getSize());
  }

  @Test
  public void checkSize3(){

    tester3.add(place1);
    tester3.add(place2);
    tester3.add(place3);
    tester3.add(place4);

    assertEquals("failure - didn't match", 4 , tester3.getSize());
  }

  @Test
  public void resetCheckSize1(){

    tester1.add(place1);
    tester1.add(place2);
    tester1.add(place3);
    tester1.add(place4);
    tester1.reset();

    assertEquals("failure - didn't match", 0 , tester1.getSize());
  }

  @Test
  public void resetCheckSize2(){

    tester2.add(place1);
    tester2.add(place2);
    tester2.add(place3);
    tester2.add(place4);
    tester2.reset();

    assertEquals("failure - didn't match", 0 , tester2.getSize());
  }
  @Test
  public void resetCheckSize3(){

    tester3.add(place1);
    tester3.add(place2);
    tester3.add(place3);
    tester3.add(place4);
    tester3.reset();

    assertEquals("failure - didn't match", 0 , tester3.getSize());
  }

  @Test
  public void iterative1(){

    for(int i = 0; i < 21; i++){
      tester1.add(i);
    }

    assertEquals("failure - didn't match", 16 , tester1.getOldest());
    assertEquals("failure - didn't match", 20 , tester1.getNewest());
  }

  @Test
  public void iterative2(){

    for(int i = 0; i < 21; i++){
      tester2.add(i);
    }

    assertEquals("failure - didn't match", 16 , tester2.getOldest());
    assertEquals("failure - didn't match", 20 , tester2.getNewest());
  }

  @Test
  public void iterative3(){

    for(int i = 0; i < 21; i++){
      tester3.add(i);
    }

    assertEquals("failure - didn't match", 16 , tester3.getOldest());
    assertEquals("failure - didn't match", 20 , tester3.getNewest());
  }

  @Test(expected = NullPointerException.class)
  public void checkNull1(){

    tester1.add(null);
  }

  @Test(expected = NullPointerException.class)
  public void checkNull2(){

    tester2.add(null);
  }

  @Test(expected = NullPointerException.class)
  public void checkNull3(){

    tester3.add(null);
  }
}