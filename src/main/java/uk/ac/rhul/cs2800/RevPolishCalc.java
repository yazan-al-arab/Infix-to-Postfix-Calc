package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Calculates a Reverse Polish (also known as PostFix) expression.
 * 
 * @author yazan
 */
public class RevPolishCalc implements Calculator {
  
  private static final String plus = "+";
  private static final String minus = "-";
  private static final String times = "*";
  private static final String divide = "/";

  /**
   * Creates a RevPolishCalc object.
   */
  public RevPolishCalc() {
  }

  /**
   * Checks if the expression is Reverse Polish and computes the solution.
   * 
   * @param exp The reverse polish expression.
   * @return The result of the expression.
   * @throws InvalidExpression when the expression is unbalanced or is not reverse polish.
   */
  @Override
  public float evaluate(String exp) throws InvalidExpression {

    if (exp.equals("") || exp == null) {
      throw new InvalidExpression("No expression was provided.");
    }

    NumStack stack = new NumStack();
    Scanner sc = new Scanner(exp.trim());

    while (sc.hasNext()) {
      String curr = new String();
      curr = sc.next();

      try {
        // float value
        stack.push(Float.parseFloat(curr));
        
        // not a float value
      } catch (Exception e) {
        
        float operand1;
        float operand2;
        float immediateResult;

        try {
          operand2 = stack.pop();
          operand1 = stack.pop();
          
          // if there aren't enough numbers for operations
        } catch (EmptyStackException e1) {
          throw new InvalidExpression("Unbalanced expression.");
        }

        // checks if it's a valid operator
        switch (curr) {
          case plus:
            immediateResult = operand1 + operand2;
            break;
          case minus:
            immediateResult = operand1 - operand2;
            break;
          case times:
            immediateResult = operand1 * operand2;
            break;
          case divide:
            if (operand2 == 0) {
              throw new InvalidExpression("Cannot divide a number by zero.");
            }
            immediateResult = operand1 / operand2;
            break;
          default:
            throw new InvalidExpression("A symbol in the expression is not recognised.");
        }   
        stack.push(immediateResult);
      }
    }

    float result = stack.pop();

    // if there are numbers left without operators
    if (!(stack.isEmpty())) {
      throw new InvalidExpression("Unbalanced expression.");
    }
    return result;
  }
}