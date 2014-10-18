package edu.lmu.cmsi.mike.lamegame.gameobjects;

import edu.lmu.cmsi.mike.lamegame.core.Coordinate;
import edu.lmu.cmsi.mike.lamegame.core.Displacement;
import edu.lmu.cmsi.mike.lamegame.gameobjects.Wall;
import edu.lmu.cmsi.mike.lamegame.gameobjects.Rock;
import edu.lmu.cmsi.mike.lamegame.gameobjects.Tree;
import edu.lmu.cmsi.mike.lamegame.gameobjects.Monster;


public class Player {

  private Coordinate location;
  private Displacement displacement;

  public Player(int x, int y) {
    this.location = new Coordinate(x, y);
    this.displacement = new Displacement(1, 0);
  }

  public int getX() {
    return this.location.getX();
  }

  public int getY() {
    return this.location.getY();
  }

  public char getRenderedCharacter() {
    return 'p';
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

  public boolean checkCollision(Monster m){
    return (this.getX() == m.getX() && this.getY() == m.getY());
  }
 
}