package edu.lmu.cmsi.tree;

import edu.lmu.cmsi.tree.node.BinaryTreeNode;
import edu.lmu.cmsi.tree.exception.*;
import java.util.ArrayList;

public class IntegerBinarySearchTree {

  protected BinaryTreeNode root;

  public IntegerBinarySearchTree() {
    this.root = null;
  }

  public BinaryTreeNode insertNode(int value, BinaryTreeNode input) {
    if(input == null) {
      return new BinaryTreeNode(value);
    } else {
      if(input.getValue() > value) {
        input.setLeft(insertNode(value, input.getLeft()));
      } else if (input.getValue() < value) {
        input.setRight(insertNode(value, input.getRight()));
      } else {
        throw new edu.lmu.cmsi.tree.exception.DuplicateItemException();
      }
    }
    return input;
  }

  /**
   * Insert into the tree.
   *
   * @param x the item to insert.
   * @throws edu.lmu.cmsi.tree.exception.DuplicateItemException if x exists.
   */
  public void insert(int x) {
    root = insertNode(x, root);
    //throw new UnsupportedOperationException("Insert needs to be implemented");
  }

  public int isSmallest(BinaryTreeNode small){
    if(small.getLeft() == null) {
      return small.getValue();
    } else {
      return isSmallest(small.getLeft());
    }
  }

  /**
   * Find the smallest item in the tree.
   *
   * @return smallest item or throws an exception if the tree is empty.
   * @throws edu.lmu.cmsi.tree.exception.ItemNotFoundException
   *
   */
  public int findSmallestValue() {
    if(root == null) {
      throw new edu.lmu.cmsi.tree.exception.ItemNotFoundException();
    } else {
      return isSmallest(root);
    }
    //throw new UnsupportedOperationException("findSmallestValue needs to be implemented");
  }

  public int isLargest(BinaryTreeNode large){
    if(large.getRight() == null) {
      return large.getValue();
    } else {
      return isLargest(large.getRight());
    }
  }

  /**
   * Find the largest item in the tree.
   *
   * @return the largest item or throws an exception if the tree is empty.
   * @throws edu.lmu.cmsi.tree.exception.ItemNotFoundException
   *
   */
  public int findLargestValue() {
    if(root == null) {
      throw new edu.lmu.cmsi.tree.exception.ItemNotFoundException();
    } else {
      return isLargest(root);
    }
    //throw new UnsupportedOperationException("findLargestValue needs to be implemented");
  }

  public boolean isEquals(int j, BinaryTreeNode here){
    if(here == null) {
      return(here != null); 
    } else if(here.getValue() > j) {
      return(isEquals(j, here.getLeft()));
    } else if(here.getValue() < j) {
      return(isEquals(j, here.getRight()));
    } else {
      return(here.getValue() == j);
    }
  }

  /**
   * Returns whether or not the value exists in the tree
   *
   * @return true if the value exists, false otherwise
   */
  public boolean contains(int number) {
    return(isEquals(number, root));
    //throw new UnsupportedOperationException("contains needs to be implemented");
  }

  /**
   * Returns an preorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */

  private ArrayList<Integer> thisArray = new ArrayList<Integer>();

  public BinaryTreeNode order(String condition, BinaryTreeNode instance) {
    if (instance != null) {
      if(condition == "pre") {
        thisArray.add(instance.getValue());
        order(condition, instance.getLeft());
        order(condition, instance.getRight());
      }else if(condition == "in") {
        order(condition, instance.getLeft());
        thisArray.add(instance.getValue());
        order(condition, instance.getRight());
      }else if(condition == "post") {
        order(condition, instance.getLeft());
        order(condition, instance.getRight());
        thisArray.add(instance.getValue());
      }
    }

    return instance;
  }
  
  public Integer[] toPreOrder() {
    thisArray.clear();
    order("pre", root);
    Integer[] pre = thisArray.toArray(new Integer[thisArray.size()]);
    return pre;
    //throw new UnsupportedOperationException("toPreOrder needs to be implemented");
  }

  /**
   * Returns an inorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toInOrder() {
    thisArray.clear();
    order("in", root);
    Integer[] in = thisArray.toArray(new Integer[thisArray.size()]);
    return in;
    //throw new UnsupportedOperationException("toInOrder needs to be implemented");
  }

  /**
   * Returns an postorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toPostOrder() {
    thisArray.clear();
    order("post", root);
    Integer[] post = thisArray.toArray(new Integer[thisArray.size()]);
    return post;
    //throw new UnsupportedOperationException("toPostOrder needs to be implemented");
  }

  /**
   * Returns an Breadth First-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */

  private ArrayList<BinaryTreeNode> q = new ArrayList<BinaryTreeNode>();

  //src = http://cs.nyu.edu/courses/spring05/V22.0102-003/mar23/Breadth.java
  //adapted from there
  private BinaryTreeNode breadth(BinaryTreeNode start) {
    if(start != null) {
      q.add(start);
      while(!q.isEmpty()) {
        start = (BinaryTreeNode)q.remove(0);
        thisArray.add(start.getValue());
        if(start != null) {
          if(start.getLeft() != null) {
            q.add(start.getLeft());
          }if(start.getRight() != null) {
            q.add(start.getRight());
          }
        }
      }
    }

    return start;
  }

  public Integer[] toBreadthFirstOrder() {
    thisArray.clear();breadth(root);
    Integer[] breadth = thisArray.toArray(new Integer[thisArray.size()]);
    return breadth;
    //throw new UnsupportedOperationException("toBreadthFirstOrder needs to be implemented");
  }
}