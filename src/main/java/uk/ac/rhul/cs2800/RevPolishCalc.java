package uk.ac.rhul.cs2800;

public class RevPolishCalc implements Calculator {

  public RevPolishCalc() {
  }

  @Override
  public float evaluate(String exp) throws InvalidExpression {
    if(exp.equals("")) {
      throw new InvalidExpression("The expression isn't valid.");
    }
    return Float.parseFloat(exp);
  }
}
