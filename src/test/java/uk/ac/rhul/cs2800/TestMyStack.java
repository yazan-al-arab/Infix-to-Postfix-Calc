package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the MyStack class.
 * 
 * @author yazan
 *
 */
class TestMyStack {

  private MyStack myStack;


  /*
   * Test 1
   * 
   * Create MyStack class with constructor.
   * 
   */
  @BeforeEach
  void setUp() {
    myStack = new MyStack();
  }

  /*
   * Test 2
   * 
   * Created a size() method which returns 0 (faked).
   * 
   */
  @Test
  void testEmptyStackSize() {
    assertEquals(0, myStack.size(), "An empty stack should have size zero.");
  }

  /*
   * Test 3
   * 
   * Created a private int field called size, initialised to 0. Created a push() method which sets
   * size to 1 (faked result). Modified size() to make it return size instead of 0.
   * 
   */
  @Test
  void testPush() {
    myStack.push(3);
    assertEquals(myStack.size(), 1, "Pushing onto an empty stack should mean the size becomes 1.");
  }


  /*
   * Test 4
   * 
   * Modified push() method to increment size each time it's called (rather than setting the value
   * to 1).
   * 
   */
  @Test
  void pushFiveThings() {
    for (int i = 1; i <= 5; i++) {
      myStack.push(i);
      assertEquals(myStack.size(), i, "Every push should increment the size by one.");
    }
  }


  /*
   * Test 5
   * 
   * Created a top() method which returns 3 (faked result).
   * 
   * 
   * Update 1: Created method push() inside Entry class to store the float value inside
   * 
   * Update 2: Added "throws BadTypeException" (This error occurred after completing the TestEntry
   * class)
   * 
   */
  @Test
  void testTop() throws BadTypeException {
    myStack.push(3);
    assertEquals(myStack.top().getValue(), 3, "The top value should be three.");
  }


  /*
   * Test 6
   *
   * Created a pop() method which returns 5 (faked result).
   * 
   * 
   * Update 1: myStack.pop() changed to myStack.pop().getValue()
   * 
   * Update 2: Added "throws BadTypeException" (This error occurred after completing the TestEntry
   * class)
   * 
   */
  @Test
  void testPop() throws BadTypeException {
    myStack.push(5);
    assertEquals(myStack.pop().getValue(), 5,
        "The stack should return five as it was the last number pushed.");
  }


  /*
   * Test 7
   * 
   * Created a class Entry Created a private field of type Entry to store the most recent push.
   * 
   * Refactored pop() to return Entry type instead of Integer.
   * 
   * Created method getValue() inside Entry class to return the float number.
   * 
   * Refactored push() method (inside of the Stack class) to do ent.push() instead of storing it in
   * a private field in the Stack class.
   * 
   * What changes were made to previous tests?: Test testTop() -> Update 1
   * 
   * 
   */
  @Test
  void pushFiveThingsThenTop() {
    for (int i = 1; i <= 5; i++) {
      myStack.push(i);
    }
    assertTrue(myStack.top().getClass() == MyEntry.class);
  }


  /*
   * Test 8
   * 
   * Refactored pop() return type to Entry instead of Integer.
   * 
   * Refactored pop() to return the field ent.
   * 
   * What changes were made to previous tests?: Test 'testPop()' -> Update 1
   * 
   */
  @Test
  void pushFiveThingsThenPop() {
    for (int i = 1; i <= 5; i++) {
      myStack.push(i);
    }
    assertTrue(myStack.pop().getClass() == MyEntry.class);
  }


  /*
   * Test 9
   * 
   * Refactored MyStack to use an array of Entry rather than a single one.
   * 
   * Update 1: Added "throws BadTypeException" (This error occurred after completing the TestEntry
   * class)
   * 
   */
  @Test
  void pushTenThenPopPopTop() throws BadTypeException {
    for (int i = 1; i <= 10; i++) {
      myStack.push(i);
      assertEquals(myStack.size(), i, "Pushing should increase size by one each time.");
    }

    for (int i = 10; i >= 8; i--) {
      assertEquals(myStack.pop().getValue(), i,
          "Popping should go through a list in order of most recently popped.");
    }

  }

  /*
   * Test 10
   * 
   * Received an index out of bounds exception, so I refactored array of Entry into an ArrayList of
   * Entry.
   * 
   * Rather than creating a new larger array, transferring over the data, then making it be pointed
   * to as the new array, implementing ArrayList is simpler.
   */
  @Test
  void pushOneHundred() {
    for (int i = 1; i <= 100; i++) {
      myStack.push(i);
    }
  }

  /*
   * Test 11
   * 
   * Added an if statement inside pop() to check if size == 0 (to know whether to throw an exception
   * or not).
   * 
   */
  @Test
  void popException() {
    assertThrows(EmptyStackException.class, () -> myStack.pop(),
        "Popping an empty stack should throw an exception");
  }

  /*
   * Test 12
   * 
   * Added an if statement inside top() to check if size == 0 (to know whether to throw an exception
   * or not).
   * 
   */
  @Test
  void topException() {
    assertThrows(EmptyStackException.class, () -> myStack.top(),
        "Calling top on an empty stack should throw an exception.");
  }


  /*
   * Test 13
   * 
   * Both MyStack push() and Entry constructor() methods were refactored to accept a float argument
   * instead of an integer argument.
   * 
   * Previous tests weren't affected by this change.
   * 
   * Update 2: Added "throws BadTypeException" (This error occurred after completing the TestEntry
   * class)
   * 
   */
  @Test
  void pushFloat() throws BadTypeException {
    myStack.push(0.1f);
    assertEquals(myStack.top().getValue(), 0.1f, 0.001f, "The top value should be 0.1 (float).");
  }

  /*
   * The next tests are in TestEntry.java class
   */


  /*
   * Test 28
   * 
   * Continuation of testing
   * 
   * I created a new Entry constructor with parameter of type Object
   * 
   * The contents of the other constructors were put into it, but sorted using if statements. This
   * way, I could filter the type of input being received and allocate it a type and/or symbol.
   * 
   */
  @Test
  void testTypes() throws BadTypeException {
    myStack.push("Hello");
    assertEquals(myStack.pop().getString(), "Hello", "The pop should return a string \"Hello\""); // "Hello"
  }

  /*
   * Test 29 is in TestEntry class.
   * 
   */

  
  /*
   * Test 30 Part 1
   * 
   * I wanted to be able to pass an entry as an argument to push().
   * 
   * No additional code was needed to make this test pass.
   * 
   */
  @Test
  void testPassEntryArgument() throws BadTypeException {
    MyEntry myEntry = new MyEntry(Symbol.MINUS);
    myStack.push(myEntry);
    assertTrue(myStack.pop().getType() == Type.SYMBOL, "The type should be SYMBOL.");
  }

  /*
   * Test 30 Part 2
   * 
   * No additional code was needed to make this test pass.
   */
  @Test
  void testPassEntryArgument_2() {
    MyEntry myEntry = new MyEntry("Test String");
    myStack.push(myEntry);
    assertTrue(myStack.pop().getType() == Type.STRING, "The type should be STRING.");
  }

  /*
   * Test 30 Part 3
   * 
   * No additional code was needed to make this test pass.
   * 
   */
  @Test
  void testPassEntryArgument_3() {
    MyEntry myEntry = new MyEntry(5);
    myStack.push(myEntry);
    assertTrue(myStack.top().getType() == Type.NUMBER, "The type should be NUMBER.");
  }

  /*
   * Test 31
   * 
   * The return statement of the pop() method (in the stack class) was modified to use .remove().
   * 
   */
  @Test
  void testPushPopPushPop() throws BadTypeException {
    myStack.push("Hello");
    assertEquals(myStack.pop().getString(), "Hello", "Should return the string \"Hello\"."); // returns
                                                                                             // "Hello"
    myStack.push(6.9f);
    assertEquals(myStack.pop().getValue(), 6.9f, 0.001f, "Should return 6.9 as a float.");

  }

  /*
   * Test 32
   * 
   * No additional code was needed to make this test pass.
   */
  @Test
  void testingPopAndPushMore() throws BadTypeException {
    myStack.push("First String");
    assertEquals(myStack.pop().getString(), "First String",
        "Should return the first value pushed.");

    myStack.push("Second String");
    myStack.push("Third String");
    assertEquals(myStack.pop().getString(), "Third String",
        "Should return the third value pushed.");
    assertEquals(myStack.pop().getString(), "Second String",
        "Should return the last value pushed.");
  }
  
  /*
   * Test 33 is in TestEntry class.
   * 
   */
}
