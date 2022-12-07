package uk.ac.rhul.cs2800;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestNumStack {
  
  private NumStack numStack;
  
  @BeforeEach
  void setUp() {
    numStack = new NumStack();
  }
  
  @Test
  void isEmpty() {
    assertEquals(numStack.isEmpty(), true, "The numstack should be empty.");
  }
  
  @Test
  void push() {
    numStack.push(5.0f);
    assertEquals(numStack.isEmpty(), false, "The numstack shouldn't be empty becuase a value was pushed to it.");
  }

}
