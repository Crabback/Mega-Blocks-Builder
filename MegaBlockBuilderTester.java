//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P06 Mega Blocks Builder
// Files: MegaBlockBuilderTester.java, LinkedMegaBlock.java, LinkedListMegaBlock.java
// Course: CS 300
//
// Author: Zhengjia Mao
// Email: zmao27@wisc.edu
// Lecturer's Name: Gary DAHL
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: NONE
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _YES__ Write-up states that pair programming is allowed for this assignment.
// _YES__ We have both read and understand the course Pair Programming Policy.
// _YES__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: ULC tutors
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.NoSuchElementException;

/**
 * Tester Class Verify whether the methods work correctly
 * 
 * @author ZhengjiaMao
 *
 */
public class MegaBlockBuilderTester {

  /**
   * checks for the correctness of the MegaBlock.equals() method
   * 
   * @return true if the method works correctly
   */
  public static boolean testMegaBlockEquals() {
    MegaBlock block1 = new MegaBlock(Color.RED, 'A');
    MegaBlock block2 = new MegaBlock(Color.RED, 'B');
    MegaBlock block3 = new MegaBlock(Color.BLUE, 'A');
    if (!block1.equals(block2)) {
      return false;
    }
    if (block1.equals(block3)) {
      return false;
    }
    return true;
  }

  /**
   * checks for the correctness of the MegaBlock.toString() method
   * 
   * @return true if the method works correctly
   */
  public static boolean testMegaBlockToString() {
    MegaBlock block1 = new MegaBlock(Color.RED, 'A');
    if (!block1.toString().equals("RED A")) {
      return false;
    }
    return true;
  }

  /**
   * checks for the correctness of the constructors, accessors, and mutators in LinkedMegaBlock
   * 
   * @return true if the methods work correctly
   */
  public static boolean testLinkedMegaBlock() {
    MegaBlock block1 = new MegaBlock(Color.RED, 'A');
    MegaBlock block2 = new MegaBlock(Color.RED, 'B');
    // test the Constructor
    LinkedMegaBlock linkedBlock1 = new LinkedMegaBlock(block1);

    if (!linkedBlock1.getBlock().getColor().equals(Color.RED)) {
      return false;
    }
    if (linkedBlock1.getBlock().getLabel() != 'A') {
      return false;
    }
    // test the accessor
    if (!linkedBlock1.getBlock().equals(block1)) {
      return false;
    }
    // test the mutator
    linkedBlock1.setNext(new LinkedMegaBlock(block2));
    if (!linkedBlock1.getNext().getBlock().equals(block2)) {
      return false;
    }

    return true;
  }

  /**
   * checks for the correctness of the LinkedListMegaBlock.addRed() method
   * 
   * @return true if the method works correctly
   */
  public static boolean testLinkedMegaBlockListAddRed() {
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    MegaBlock redBlock = new MegaBlock(Color.RED, 'A');
    list.addRed(redBlock);
    if (list.getRedCount() != 1) {
      return false;
    }
    if (!list.get(0).equals(redBlock)) {
      return false;
    }
    return true;
  }

  /**
   * checks for the correctness of the LinkedListMegaBlock.addYellow() method
   * 
   * @return true if the method works correctly
   */
  public static boolean testLinkedMegaBlockListAddYellow() {
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    MegaBlock yellowBlock = new MegaBlock(Color.YELLOW, 'A');
    list.addYellow(0, yellowBlock);
    if (list.getYellowCount() != 1) {
      return false;
    }
    if (!list.get(0).equals(yellowBlock)) {
      return false;
    }
    return true;
  }

  /**
   * checks for the correctness of the LinkedListMegaBlock.addBlue() method
   * 
   * @return true if the method works correctly
   */
  public static boolean testLinkedMegaBlockListAddBlue() {
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    MegaBlock blueBlock = new MegaBlock(Color.BLUE, 'A');
    list.addBlue(blueBlock);
    if (list.getBlueCount() != 1) {
      return false;
    }
    if (!list.get(0).equals(blueBlock)) {
      return false;
    }
    return true;
  }

  /**
   * checks for the correctness of the LinkedListMegaBlock.removeRed() method
   * 
   * @return true if the method works correctly
   */
  public static boolean testLinkedListMegaBlockRemoveRed() {
    boolean result = true;
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    MegaBlock redBlock = new MegaBlock(Color.RED, 'B');
    try {
      list.removeRed();
    } catch (NoSuchElementException e) {
      result = true;
    }
    list.addRed(redBlock);
    list.removeRed();
    if (list.getRedCount() != 0) {
      result = false;
    }
    return result;
  }

  /**
   * checks for the correctness of the LinkedListMegaBlock.removeYellow() method
   * 
   * @return true if the method works correctly
   */
  public static boolean testLinkedListMegaBlockRemoveYellow() {
    boolean result = true;
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    MegaBlock yellowBlock = new MegaBlock(Color.YELLOW, 'B');
    try {
      list.removeYellow(1);
    } catch (IndexOutOfBoundsException e) {
      result = true;
    }
    list.addYellow(0, yellowBlock);
    list.removeYellow(0);
    if (list.getYellowCount() != 0) {
      result = false;
    }
    return result;
  }

  /**
   * checks for the correctness of the LinkedListMegaBlock.removeBlue() method
   * 
   * @return true if the method works correctly
   */
  public static boolean testLinkedListMegaBlockRemoveBlue() {
    boolean result = true;
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    MegaBlock blueBlock = new MegaBlock(Color.BLUE, 'B');
    try {
      list.removeBlue();
    } catch (NoSuchElementException e) {
      result = true;
    }
    list.addBlue(blueBlock);
    list.removeBlue();
    if (list.getBlueCount() != 0) {
      result = false;
    }
    return result;
  }

  /**
   * checks for the correctness of the LinkedListMegaBlock.clear() method
   * 
   * @return true if the method works correctly
   */
  public static boolean testLinkedListMegaBlockClear() {
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    list.addRed(new MegaBlock(Color.RED, 'A'));
    list.addYellow(1, new MegaBlock(Color.YELLOW, 'A'));
    list.addBlue(new MegaBlock(Color.BLUE, 'A'));
    if (list.size() != 3)
      return false;
    list.clear();
    if (list.size() != 0) {
      return false;
    }
    return true;
  }

  /**
   * checks for the correctness of the LinkedListMegaBlock.get() method
   * 
   * @return true if the method works correctly
   */
  public static boolean testLinkedListMegaBlockGet() {
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    MegaBlock blueBlock = new MegaBlock(Color.BLUE, 'A');
    list.addRed(new MegaBlock(Color.RED, 'A'));
    list.addYellow(1, new MegaBlock(Color.YELLOW, 'A'));
    list.addBlue(blueBlock);
    if (!list.get(2).equals(blueBlock))
      return false;
    return true;
  }

  /**
   * Helper method to display the contents of a list of mega blocks
   * 
   * @param list a reference to a LinkedListMegaBlock object
   * @throws NullPointerException if list is null
   */
  private static void display(LinkedListMegaBlock list) {
    // display list content
    System.out.println("list content: " + list);
    // display information about the size of this list and the its blocks’ color counts
    System.out.println("Size: " + list.size() + ", redCount: " + list.getRedCount()
        + ", yellowCount: " + list.getYellowCount() + ", blueCount: " + list.getBlueCount());
    System.out.println();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(testMegaBlockEquals());
    System.out.println(testMegaBlockToString());
    System.out.println(testLinkedMegaBlock());
    System.out.println(testLinkedMegaBlockListAddRed());
    System.out.println(testLinkedMegaBlockListAddYellow());
    System.out.println(testLinkedMegaBlockListAddBlue());
    System.out.println(testLinkedListMegaBlockRemoveRed());
    System.out.println(testLinkedListMegaBlockRemoveYellow());
    System.out.println(testLinkedListMegaBlockRemoveBlue());
    System.out.println(testLinkedListMegaBlockClear());
    System.out.println(testLinkedListMegaBlockGet());

    // VISUALIZATION PART
    // Create a new empty LinkedListMegaBlocks list
    LinkedListMegaBlock list1 = new LinkedListMegaBlock();
    list1.addYellow(0, new MegaBlock(Color.YELLOW, 'A'));
    list1.addRed(new MegaBlock(Color.RED, 'B'));
    list1.addYellow(list1.size(), new MegaBlock(Color.YELLOW, 'C'));
    list1.addYellow(2, new MegaBlock(Color.YELLOW, 'D'));
    list1.addBlue(new MegaBlock(Color.BLUE, 'E'));

    System.out.println(list1.toString());
    System.out.println(list1.get(2).toString());

    // Create a new empty LinkedListMegaBlocks list
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    // display list’s content and size information
    display(list);
    // Add some blocks to list and display its contents and size information
    list.addBlue(new MegaBlock(Color.BLUE, 'C')); // add a blue mega block
    display(list);
    list.addBlue(new MegaBlock(Color.BLUE, 'S')); // add a blue mega block
    display(list);
    list.addYellow(0, new MegaBlock(Color.YELLOW, 'Y')); // add a yellow mega block
    // at index 0 of this list
    display(list);
    list.addRed(new MegaBlock(Color.RED, 'A')); // add a red mega block to this list
    list.addRed(new MegaBlock(Color.RED, 'B')); // add a red mega block to this list
    list.addYellow(3, new MegaBlock(Color.YELLOW, 'H')); // add a yellow mega block
    // at index 3 of this list
    display(list);
    // remove/add some blocks and display the list after each operation
    list.removeBlue(); // remove a blue block
    display(list);
    list.removeBlue(); // remove a blue block
    display(list);
    // add a yellow block at the end of list (the list contains zero blue blocks)
    list.addYellow(list.size(), new MegaBlock(Color.YELLOW, 'W'));
    display(list);
    list.removeRed(); // remove a red block
    display(list);
    list.removeYellow(list.size() - 1); // remove the yellow block at the end of list
    display(list);

    LinkedListMegaBlock linkedListMegaBlock = new LinkedListMegaBlock();
    linkedListMegaBlock.addRed(new MegaBlock(Color.RED, 'A'));
    linkedListMegaBlock.set(0, new MegaBlock(Color.RED, 'B'));
    display(linkedListMegaBlock);
    linkedListMegaBlock.addYellow(1, new MegaBlock(Color.YELLOW, 'B'));
    linkedListMegaBlock.removeRed();
    display(linkedListMegaBlock);
  }


}
