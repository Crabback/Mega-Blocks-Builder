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

/**
 * This class implements a linked mega block data type
 * 
 * @author Zhengjia Mao
 *
 */
public class LinkedMegaBlock {

  /**
   * private fields shared in this class
   */
  private MegaBlock block; // data field of this linkedMegaBlock
  private LinkedMegaBlock next; // link to the next linkedMegaBlock

  /**
   * Constructor Creates a new LinkedMegaBlock that has a specific MegaBlock as data and null as
   * next reference
   * 
   * @param block - data field to be set for this new LinkedMegaBlock
   */
  public LinkedMegaBlock(MegaBlock block) {
    this.block = block;
  }

  /**
   * Constructor Creates a new LinkedMegaBlock with a specific data block and a specific reference
   * to the next LinkedMegaBlock
   * 
   * @param block - data field to be set for this newLinkedMegaBlock
   * @param next  - reference to the next LinkedMegaBlock of this LinkedMegaBlock
   */
  public LinkedMegaBlock(MegaBlock block, LinkedMegaBlock next) {
    this.block = block;
    this.next = next;
  }

  /**
   * Accessor Returns the block data field of this LinkedMegaBlock
   * 
   * @return the block data field of this LinkedMegaBlock
   */
  public MegaBlock getBlock() {
    return block;
  }

  /**
   * Mutator Sets the block instance field of this LinkedMegaBlock
   * 
   * @param block - the block to set
   */
  public void setBlock(MegaBlock block) {
    this.block = block;
  }

  /**
   * Accessor Returns the reference to the next field of this LinkedMegaBlock
   * 
   * @return the next
   */
  public LinkedMegaBlock getNext() {
    return next;
  }

  /**
   * Mutator Sets the reference to the next field of this LinkedMegaBlock
   * 
   * @param next - the next to set
   */
  public void setNext(LinkedMegaBlock next) {
    this.next = next;
  }

  /**
   * Returns a String representation of this Linked MegaBlock object.
   * 
   * @return a String representation of this Linked MegaBlock object
   */
  @Override
  public String toString() {
    if (next != null) {
      return block.toString() + " -> ";
    }
    return block.toString() + " -> END";
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
