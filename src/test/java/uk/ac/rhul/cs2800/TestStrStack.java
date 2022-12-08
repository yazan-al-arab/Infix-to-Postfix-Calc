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

}
