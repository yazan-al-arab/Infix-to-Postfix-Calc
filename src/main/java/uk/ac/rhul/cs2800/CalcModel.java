package uk.ac.rhul.cs2800;

/**
 * Defines how to solve the expression.
 * 
 * @author yazan
 *
 */
public class CalcModel {

  private RevPolishCalc revPolish;

  /**
   * Constructs a CalcModel only holds Reverse Polish.
   */
  public CalcModel() {
    revPolish = new RevPolishCalc();
  }

  /**
   * Uses RevPolishCalc to solve the expression.
   * 
   * @param exp the expression to be solved.
   * @return the result or an error message.
   */
  public String evaluate(String exp) {
    try {
      return String.valueOf(revPolish.evaluate(exp));
    } catch (InvalidExpression e) {
      return e.getMessage();
    }
  }

}
