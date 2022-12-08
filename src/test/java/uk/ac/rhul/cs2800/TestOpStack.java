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

  @Test
  void push() {
    opStack.push(Symbol.DIVIDE);
    assertEquals(opStack.isEmpty(), false, "The opstack shouldn't be empty because a value was pushed to it.");
  }

  @Test
  void pop() {
    opStack.push(Symbol.LEFT_BRACKET);
    assertEquals(opStack.pop(), Symbol.LEFT_BRACKET,
        "The return value should be a Left Bracket because this is what was initially pushed.");
    assertEquals(opStack.isEmpty(), true, "The opstack should be empty because all the values have been popped.");
  }

  @Test
  void pushManyThenPopMany() {

    for (Symbol symbol : Symbol.values()) {
      opStack.push(symbol);
    }
    assertEquals(opStack.isEmpty(), false, "The opstack shouldn't be empty because many values was pushed to it.");

    Symbol[] symbol = Symbol.values();

    for (int i = symbol.length - 1; i >= 0; i--) {
      assertEquals(opStack.pop(), symbol[i], "The popped value is not correct");
    }
    assertEquals(opStack.isEmpty(), true, "The opstack should now be empty after popping all it's values.");
  }

  // There are no more tests required as all the remaining functionality relies on
  // the Stack class.bb  

}
