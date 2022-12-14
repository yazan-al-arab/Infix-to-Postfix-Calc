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
    assertThrows(NullPointerException.class, () -> calc.evaluate(null), "Null value should not be accepted.");
  }

  @Test
  void unbalancedExpressions() throws InvalidExpression {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("0 0"), "It is an unbalanced expression.");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("0 0 + +"), "It is an unbalanced expression.");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("1 2 2 1 +"), "It is an unbalanced expression.");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("0 + / /"), "It is an unbalanced expression.");
    assertEquals(0, calc.evaluate("0 0 +"), "It is an unbalanced expression.");

  }

  @Test
  void checkOrder() throws InvalidExpression {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("1 + 2"), "It is an incorreclty ordered expression.");
  }

  @Test
  void checkWrongOperator() throws InvalidExpression {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("1 2 £"), "It should return InvalidExpression.");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("1 2 abcd"), "It should return InvalidExpression.");
    // all other potential unrecognised operators don't need to be tested for
    // because the only accepted operators are defined in the checkBalance method.
  }

//  @Test
//  void additionExpressions() throws InvalidExpression {
//    assertEquals(7, calc.evaluate("4 3 +"), "Should be equal to 7.");
//  }

}
