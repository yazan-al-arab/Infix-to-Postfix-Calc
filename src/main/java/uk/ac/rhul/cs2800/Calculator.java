package uk.ac.rhul.cs2800;

/**
 * This Calculator interface specifies which attributes and methods all
 * Calculators must contain.
 * 
 * @author yazan
 *
 */
public interface Calculator {

  /**
   * Computes the result of a given expression.
   * 
   * @param what the expression from user input.
   * @return the result of the expression.
   * @throws InvalidExpression when the expression doesn't match PostFix (Reverse
   *                           Polish) notation.
   */
  public float evaluate(String what) throws InvalidExpression;

}
