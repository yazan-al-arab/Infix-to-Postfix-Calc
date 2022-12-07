package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {
  
  private OpStack opStack;
  
  @BeforeEach
  void setUp() {
    opStack = new OpStack();
  }
  
  @Test
  void isEmpty() {
    assertEquals(opStack.isEmpty(), true, "The opstack should be empty.");
  }

}
