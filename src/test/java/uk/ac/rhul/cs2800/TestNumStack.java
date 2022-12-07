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
    assertEquals(numStack.isEmpty(), false, "The numstack shouldn't be empty because a value was pushed to it.");
  }

  @Test
  void pop() {
    numStack.push(5.0f);
    assertEquals(numStack.pop(), 5.0f, "The return value should equal 5.0 because that is what was initially.");
    assertEquals(numStack.isEmpty(), true, "The numstack should be empty because all the values were popped.");
  }

  @Test
  void pushMany() {
    for (float i = 0; i < 5; i++) {
      numStack.push(i);
    }
    assertEquals(numStack.isEmpty(), false, "The numstack shouldn't be empty because many values was pushed to it.");

    for (float i = 4; i >= 0; i--) {
      assertEquals(numStack.pop(), i, "The popped value is not correct");
    }
    assertEquals(numStack.isEmpty(), true, "The numstack should now be empty after popping all it's values.");
  }

  // There are no more tests required as all the remaining functionality relies on
  // the Stack class.

}
