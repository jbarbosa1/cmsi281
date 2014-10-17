package edu.lmu.cmsi.mike.lamegame.gameobjects;


import edu.lmu.cmsi.mike.lamegame.core.Coordinate;

public class Tree {

  private Coordinate location;

  public Tree(int x, int y) {
    this.location = new Coordinate(x, y);
  }

  public int getX() {
    return this.location.getX();
  }

  public int getY() {
    return this.location.getY();
  }

  public char getRenderedCharacter() {
    return 't';
  }

}