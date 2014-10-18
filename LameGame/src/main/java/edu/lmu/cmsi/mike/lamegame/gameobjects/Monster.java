package edu.lmu.cmsi.mike.lamegame.gameobjects;


import edu.lmu.cmsi.mike.lamegame.core.Coordinate;
import edu.lmu.cmsi.mike.lamegame.core.Displacement;

import edu.lmu.cmsi.mike.lamegame.gameobjects.Wall;

public class Monster {

  private Coordinate location;
  private Displacement displacement;
  private char[] monsterArray = {'z', 'x', 'a', 's', 'o', 'k'};

  public Monster(int x, int y, int dx, int dy) {
    this.location = new Coordinate(x, y);
    this.displacement = new Displacement(dx, dy);
  }

  public int getX() {
    return this.location.getX();
  }

  public int getY() {
    return this.location.getY();
  }

  public char getRenderedCharacter(int num) {
    return monsterArray[num];
  }

  public void update() {
    this.location.setX(this.location.getX() + this.displacement.getXDisplacement());
    this.location.setY(this.location.getY() + this.displacement.getYDisplacement());
  }

  public void checkCollision(Wall w) {
    if (this.getX() == w.getX() && this.getY() == w.getY()) {
      displacement.invert();
    }
  }


  public boolean checkCollision(Rock r){
    if (this.getX() == r.getX() && this.getY() == r.getY()) {
      displacement.invert();
    }
    return (this.getX() == r.getX() && this.getY() == r.getY());
  }


  public boolean checkCollision(Tree t){
    if (this.getX() == t.getX() && this.getY() == t.getY()) {
      displacement.invert();
    }
    return (this.getX() == t.getX() && this.getY() == t.getY());
  }

  // You need to know about all this if you want to continue down this path
  //public void checkCollision(Player m);
  //public void checkCollision(Boss b);
}