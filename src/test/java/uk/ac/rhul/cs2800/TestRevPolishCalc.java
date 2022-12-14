package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  
  private Calculator calc;

  @BeforeEach
  void setUp() throws Exception {
    calc = new RevPolishCalc();
  }

  @Test
  void emptyString() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate(""));
  }
  
  @Test
  void singleNumber() throws InvalidExpression {
    assertEquals(0, calc.evaluate("0"), "The result should be 0.");
  }
  
  @Test
  void nullArgument() throws InvalidExpression {
    assertThrows(NullPointerException.class, () -> calc.evaluate(null));
  }
//
//  @Test
//  void addition() throws InvalidExpression {
//    assertEquals(2, calc.evaluate("0 0 +"), "Should equal 2.");
//  }
}
