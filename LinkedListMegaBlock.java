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
 * This class models and implements a linked list of MegaBlock objects
 * 
 * @author Zhengjia Mao
 *
 */
public class LinkedListMegaBlock {

  /**
   * private fields shared in this class
   */
  private LinkedMegaBlock head; // head of this list
  private LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of megablocks stored in this list)
  private int redCount; // number of RED megablocks stored in this list
  private int yellowCount; // number of YELLOW megablocks stored in this list
  private int blueCount; // number of BLUE megablocks stored in this list

  /**
   * Constructor Creates an empty linked list of mega blocks
   */
  public LinkedListMegaBlock() {
    head = null;
    tail = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }

  /**
   * Returns true if this list contains no elements.
   * 
   * @return true if this list is empty, and false otherwise.
   */
  public boolean isEmpty() {
    return (size == 0);
  }

  /**
   * Returns the size of this list
   * 
   * @return the number of megablocks stored in this list
   */
  public int size() {
    return size;
  }

  /**
   * Removes all of the elements from this list. The list will be empty after this call returns.
   */
  public void clear() {
    head = null;
    tail = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }

  /**
   * Adds a new object at the head of this list
   * 
   * @param redBlock - new element to be added to this list
   * @throws IllegalArgumentException - if redBlock is null or if its color does not equal to
   *                                  Color.RED
   */
  public void addRed(MegaBlock redBlock) {
    // detect the exception
    if (redBlock == null) {
      throw new IllegalArgumentException("null MegaBlock");
    }
    // detect the exception
    if (!redBlock.getColor().equals(Color.RED)) {
      throw new IllegalArgumentException("wrong color");
    }
    // convert the MegaBlock to a LinkedMegaBlock
    LinkedMegaBlock block = new LinkedMegaBlock(redBlock);
    if (head == null) { // adds to new node to an empty list
      head = block;
      tail = block;
    } else { // insert in the front
      block.setNext(head);
      head = block;
    }
    redCount++;
    size++;
  }

  /**
   * Adds the provided yellowBlock at the position index in this list
   * 
   * @param index       - index at which the specified yellow block is to be inserted
   * @param yellowBlock - new element to be added to this list
   * @throws IllegalArgumentException  - if yellowBlock is null or if it does not have a
   *                                   Color.YELLOW color
   * @throws IndexOutOfBoundsException - if the index is out of the range reserved for yellow blocks
   *                                   (index < redCount || index > size - blueCount)
   */
  public void addYellow(int index, MegaBlock yellowBlock) {
    // detect the first exception
    if (yellowBlock == null) {
      throw new IllegalArgumentException("null MegaBlock");
    }
    // detect the first exception
    if (!yellowBlock.getColor().equals(Color.YELLOW)) {
      throw new IllegalArgumentException("wrong color");
    }
    // detect the second exception
    if (index < redCount || index > size - blueCount) {
      throw new IndexOutOfBoundsException("index out of range");
    }
    // convert the MegaBlock to a LinkedMegaBlock
    LinkedMegaBlock block = new LinkedMegaBlock(yellowBlock);
    if (head == null) { // adds to new node to an empty list
      head = block;
      tail = block;
    } else {
      if (index == 0) { // insert in the front
        block.setNext(head);
        head = block;
      } else if (index == size) { // insert after the end
        tail.setNext(block);
        tail = block;
      } else { // insert in the middle of the list
        LinkedMegaBlock curPos = head; // iterate the current Position
        for (int i = 0; i < index - 1; i++) {
          curPos = curPos.getNext();
        }
        block.setNext(curPos.getNext());
        curPos.setNext(block);
      }
    }
    yellowCount++;
    size++;
  }

  /**
   * Adds a blueBlock at the end of this list
   * 
   * @param blueBlock - new element to be added to this list
   * @throws IllegalArgumentException - if blueBlock is null or if the color of the specific
   *                                  blueBlock is not equal to Color.BLUE
   */
  public void addBlue(MegaBlock blueBlock) {
    // detect the exception
    if (blueBlock == null) {
      throw new IllegalArgumentException("null MegaBlock");
    }
    // detect the exception
    if (!blueBlock.getColor().equals(Color.BLUE)) {
      throw new IllegalArgumentException("wrong color");
    }
    // convert the MegaBlock to a LinkedMegaBlock
    LinkedMegaBlock block = new LinkedMegaBlock(blueBlock);
    if (head == null) { // adds to new node to an empty list
      head = block;
      tail = block;
    } else {// insert in the end
      block.setNext(null);
      tail.setNext(block);
      tail = block;
    }
    blueCount++;
    size++;
  }

  /**
   * Returns the element stored at position index of this list without removing it.
   * 
   * @param index - position within this list
   * @return the megablock object stored at position index of this list
   * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
   */
  public MegaBlock get(int index) {
    // detect the exception
    if ((index < 0 || index >= size())) {
      throw new IndexOutOfBoundsException("index out of range");
    }
    if (size == 1) {// if only one element in the list
      return head.getBlock(); // return the only element
    } else if (index == size - 1) {// if the index indicates the last element in the list
      return tail.getBlock(); // return the last element
    } else {
      LinkedMegaBlock curPos = head;
      for (int i = 0; i < index; i++) { // iterate the current Position until reach the given index
        curPos = curPos.getNext();
      }
      return curPos.getBlock();
    }
  }

  /**
   * Replaces the megablock at the specified position in this list with the specified element if
   * they have the same Color
   * 
   * @param index - index of the block to replace
   * @param block - element to be stored at the specified position
   * @return the element previously at the specified position
   * @throws IllegalArgumentException  - if object is null or is not equal to the megablock already
   *                                   at at index position
   * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
   */
  public MegaBlock set(int index, MegaBlock block) {
    // detect the first exception
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("index out of range");
    }
    LinkedMegaBlock curPos = head;
    for (int i = 0; i < index; i++) {// iterate the current Position until reach the given index
      curPos = curPos.getNext();
    }
    // detect the second exception
    if (!block.getColor().equals(curPos.getBlock().getColor())) {
      throw new IllegalArgumentException("color not match");
    }
    MegaBlock returnBlock = curPos.getBlock();// the previously stored element
    curPos.setBlock(block);// set the current Position as the given block
    return returnBlock;// return the previously stored element

  }

  /**
   * Removes and returns the mega block at the head of this list if its color is red
   * 
   * @return a reference to the removed element
   * @throws NoSuchElementException - if this list does not contain any red mega block
   */
  public MegaBlock removeRed() {
    MegaBlock returnBlock;
    // detect the exception
    if (redCount == 0) {
      throw new NoSuchElementException("not red head");
    } else if (size == 1) {// if only one element in the list
      returnBlock = head.getBlock();// return the only element
      clear();// clear the list
    } else {
      returnBlock = head.getBlock();
      head = head.getNext();// remove the first element
      redCount--;
      size--;
    }
    return returnBlock;

  }

  /**
   * Removes and returns the element at the tail of this list if it has a blue color
   * 
   * @return a reference to the removed element
   * @throws NoSuchElementException - if this list does not contain any blue block
   */
  public MegaBlock removeBlue() {
    MegaBlock returnBlock;
    // detect the exception
    if (blueCount == 0) {
      throw new NoSuchElementException("not blue tail");
    } else if (size == 1) {// if only one element in the list
      returnBlock = tail.getBlock();// return the only element
      clear();// clear the list
    } else {
      returnBlock = tail.getBlock();
      LinkedMegaBlock curPos = head;
      // iterate the current Position until reach the element before tail
      for (int i = 0; i < size - 2; i++) {
        curPos = curPos.getNext();
      }
      tail = curPos; // set the new tail and remove the last element
      tail.setNext(null);
      blueCount--;
      size--;
    }
    return returnBlock;
  }

  /**
   * Removes and returns the element stored at index position in this list
   * 
   * @param index - position of the element to remove in this list
   * @return a reference to the removed element
   * @throws IndexOutOfBoundsException - if the index is out of range (index < redCount or index >=
   *                                   size - blueCount)
   */
  public MegaBlock removeYellow(int index) {
    MegaBlock returnBlock;
    // detect the exception
    if (index < redCount || index >= size - blueCount) {
      throw new IndexOutOfBoundsException("index out of range");
    } else if (size == 1) { // if only one element in the list
      returnBlock = head.getBlock(); // return the only element
      clear(); // clear the list
    } else {
      LinkedMegaBlock curPos = head;
      // iterate the current Position until reach the element before the index
      for (int i = 0; i < index - 1; i++) {
        curPos = curPos.getNext();
      }
      // link skips the index element
      returnBlock = curPos.getNext().getBlock();
      curPos.setNext(curPos.getNext().getNext());
      yellowCount--;
      size--;
    }
    return returnBlock;
  }

  /**
   * Returns the number of red mega bloks stored in this list
   * 
   * @return the redCount
   */
  public int getRedCount() {
    return redCount;
  }

  /**
   * Returns the number of yellow mega bloks stored in this list
   * 
   * @return the yellowCount
   */
  public int getYellowCount() {
    return yellowCount;
  }

  /**
   * Returns the number of blue mega bloks stored in this list
   * 
   * @return the blueCount
   */
  public int getBlueCount() {
    return blueCount;
  }

  /**
   * Returns a String representation of the contents of this list
   * 
   * @return a String representation of the content of this list. If this list is empty, an empty
   *         String ("") will be returned.
   */
  @Override
  public String toString() {
    String content = "";
    LinkedMegaBlock curPos = head;
    //keep adding content to the content string
    while (curPos != null) {
      content += curPos.toString();
      curPos = curPos.getNext();
    }
    //if empty, "" will be returned
    return content;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
