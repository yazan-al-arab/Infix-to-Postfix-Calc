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

}
