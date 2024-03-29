package edu.lmu.cmsi.mike.lamegame.engine;

import edu.lmu.cmsi.mike.lamegame.gameobjects.Wall;
import edu.lmu.cmsi.mike.lamegame.gameobjects.Player;
import edu.lmu.cmsi.mike.lamegame.gameobjects.Monster;
import edu.lmu.cmsi.mike.lamegame.gameobjects.Rock;
import edu.lmu.cmsi.mike.lamegame.gameobjects.Tree;


public class GameEngine {

  private int frame;
  private int size;
  private int counterP;
  private int counterZ;
  private int counterX;
  private int counterA;
  private int counterS;
  private int counterO;
  private int counterK;
  private int[] counter = {counterP, counterZ, counterX, counterA, counterS, counterO, counterK};
  

  // Game Objects
  private Wall[] walls;
  private Player player;
  private Monster[] monsters;
  private Rock[] rocks;
  private Tree[] trees;

  public GameEngine(int size) {

    if (size < 1) {
      throw new IllegalArgumentException("The world should exist");
    }
    this.frame = 0;
    this.size = size;

    // do this in a separate method to keep the constructor clean
    this.createWalls();

    this.player = new Player(3, 4);
    this.rocks = new Rock[2];
    this.rocks[0] = new Rock(6, 3);
    this.rocks[1] = new Rock(15, 6);
    this.trees = new Tree[2];
    this.trees[0] = new Tree(19, 16);
    this.trees[1] = new Tree(4, 2);
    this.monsters = new Monster[6];
    this.monsters[0] = new Monster(4, 3, 0, 1);
    this.monsters[1] = new Monster(10, 12, 1, 1);
    this.monsters[2] = new Monster(8, 17, 1, 1);
    this.monsters[3] = new Monster(2, 1, 1, 1);
    this.monsters[4] = new Monster(7, 5, 0, 1);
    this.monsters[5] = new Monster(12, 3, 0, 1);
  }

  private void createWalls() {
    // Let's create walls
    //for now, we only care about putting walls on the edges

    int wallCount = 0;
    // calculate the amount of walls we'll need
    this.walls = new Wall[this.size * 4 - 4];

    for (int x = 0; x < this.size; x++) {
      Wall x1 = new Wall(x, 0);
      walls[wallCount++] = x1;
      Wall x2 = new Wall(x, this.size - 1);
      walls[wallCount++] = x2;
    }

    for (int y = 1; y < size - 1; y++) {
      Wall y1 = new Wall(0, y);
      walls[wallCount++] = y1;
      Wall y2 = new Wall(this.size - 1, y);
      walls[wallCount++] = y2;
    }
  }

  // the main update loop
  public void update() {
    this.frame++;
    this.render();
    this.updateObjects();
    this.checkCollisions();
  }

  private void render() {
    // Strings are a bit overkill here but easier to represent a String as a null than a character
    String[][] renderedWorld = new String[this.size][this.size];

    //walls
    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      renderedWorld[w.getY()][w.getX()] = Character.toString(w.getRenderedCharacter());
    }

    renderedWorld[this.player.getY()][this.player.getX()] =
        Character.toString(this.player.getRenderedCharacter());

    // monster
    for (int i = 0; i < this.monsters.length; i++) {
      Monster m = this.monsters[i];
      renderedWorld[m.getY()][m.getX()] = Character.toString(m.getRenderedCharacter(i));
    }

    //rocks
    for (int i = 0; i < this.rocks.length; i++) {
      Rock r = this.rocks[i];
      renderedWorld[r.getY()][r.getX()] = Character.toString(r.getRenderedCharacter());
    }    

    //trees
    for (int i = 0; i < this.trees.length; i++) {
      Tree t = this.trees[i];
      renderedWorld[t.getY()][t.getX()] = Character.toString(t.getRenderedCharacter());
    }

    System.out.println("=========================");
    System.out.println("Frame: " + this.frame);  // book keeping

    for (int row = 0; row < renderedWorld.length; row++) {
      String[] rowOfWorld = renderedWorld[row];
      for (int col = 0; col < rowOfWorld.length; col++) {
        String w = rowOfWorld[col];
        // If our string is null
        if (w == null) {
          w = ".";
        }
        System.out.print(w + " ");
      }
      System.out.println(""); // print a new line between each scene
    }

    System.out.println("=========================");

    System.out.println("Player has been hit: " + counter[0] + " times");
    System.out.println("Monster Z has been hit: " + counter[1] + " times");
    System.out.println("Monster X has been hit: " + counter[2] + " times");
    System.out.println("Monster A has been hit: " + counter[3] + " times");
    System.out.println("Monster S has been hit: " + counter[4] + " times");
    System.out.println("Boss O has been hit: " + counter[5] + " times");
    System.out.println("Boss K has been hit: " + counter[6] + " times");
  }

  private void updateObjects() {
    // everytime we add a new game object, we've got to go back through
    // every other place and add in more code - such duplication
    this.player.update();
    for (int i = 0; i < this.monsters.length; i++) {
      this.monsters[i].update();
    }
  }

  private void chancesZOrX(int c){
    int num1 = (int)Math.ceil(Math.random() * 2);
    int num2 = (int)Math.ceil(Math.random() * 2);
    if(num1 == 1){
      counter[0]++;
    }
    if(num2 == 1){
     counter[c + 1]++;
    }
  }

  private void chancesAOrS(int c){
    int num1 = (int)Math.ceil(Math.random() * 5);
    int num2 = (int)Math.ceil(Math.random() * 2);
    if( num1 < 4){
      counter[0]++;
    }
    if( num2 == 1){
      counter[c + 1]++;
    }
  }

  private void chancesOOrK(int c){
    int num1 = (int)Math.ceil(Math.random() * 10);
    int num2 = (int)Math.ceil(Math.random() * 10);
    if( num1 < 8){
      counter[0]++;
    }
    if( num2 < 4){
      counter[c + 1]++;
    }
  }

  private void checkCollisions() {
    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      this.player.checkCollision(w);
    }
    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      for (int j = 0; j < this.monsters.length; j++) {
        this.monsters[j].checkCollision(w);
      }
    }
    for (int i = 0; i < this.rocks.length; i++) {
      Rock r = this.rocks[i];
      this.player.checkCollision(r);
      if(this.player.checkCollision(r) == true){
        counter[0]++;
      }
    }
    for (int i = 0; i < this.rocks.length; i++) {
      Rock r = this.rocks[i];
      for (int j = 0; j < this.monsters.length; j++) {
        this.monsters[j].checkCollision(r);
        if(this.monsters[j].checkCollision(r) == true) {
          counter[j + 1]++;
        }
      }
    }
    for (int i = 0; i < this.trees.length; i++) {
      Tree t = this.trees[i];
      this.player.checkCollision(t);
      if(this.player.checkCollision(t) == true){
        counter[0]++;
      }
    }
    for (int i = 0; i < this.trees.length; i++) {
      Tree t = this.trees[i];
      for (int j = 0; j < this.monsters.length; j++) {
        this.monsters[j].checkCollision(t);
        if(this.monsters[j].checkCollision(t) == true) {
          counter[j + 1]++;
        }
      }
    }
    for(int i = 0; i < this.monsters.length; i++){
      Monster m = this.monsters[i];
      if(this.player.checkCollision(m) == true){
        if(i < 2){
          chancesZOrX(i);
        }else if((i >= 2) && (i < 4)){
          chancesAOrS(i);
        }else{
          chancesOOrK(i);
        }
      }
    }
  }
}