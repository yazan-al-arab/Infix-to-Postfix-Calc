package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {

  private StrStack strStack;

  @BeforeEach
  void setUp() {
    strStack = new StrStack();
  }
  
  @Test
  void isEmpty() {
    assertEquals(strStack.isEmpty(), true, "The strstack should be empty.");
  }
  
  @Test
  void push() {
    strStack.push("test");
    assertEquals(strStack.isEmpty(), false, "The strstack shouldn't be empty because a string value was pushed to it");
  }
  
  @Test
  void pop() {
    strStack.push("test");
    assertEquals(strStack.pop(), "test", "The return value should equal \"test\" because that is what was initially.");
    assertEquals(strStack.isEmpty(), true, "The strstack should be empty because all the values were popped.");
  }
  
  @Test
  void pushManyThenPopMany() {
    strStack.push("Hello");
    strStack.push("there.");
    
    assertEquals(strStack.pop(), "there.", "The return value should equal \"test\" because that is the most recent push.");
    
    strStack.push("How are you?");
    
    assertEquals(strStack.pop(), "How are you?", "The return value should equal \"How are you?\" because that is the most recent push. It maybe didn't pop properly.");
    assertEquals(strStack.isEmpty(), false, "The stack shouldn't be empty. It has 1 item left inside.");
    
    assertEquals(strStack.pop(), "Hello", "The return value should equal \"Hello\" because that is what was initially pushed.");
    assertEquals(strStack.isEmpty(), true, "The stack should be empty. All the items should've been popped.");
  }

  // There are no more tests required as all the remaining functionality relies on
  // the Stack class.

}
