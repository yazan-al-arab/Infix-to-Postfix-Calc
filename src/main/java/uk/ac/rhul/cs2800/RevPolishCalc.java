package uk.ac.rhul.cs2800;

public class RevPolishCalc implements Calculator {
  
  public RevPolishCalc() {
  }

  @Override
  public float evaluate(String exp) throws InvalidExpression {
    
    if(exp.equals("") || exp == null) {
      throw new InvalidExpression("No expression was provided.");
    }
    

    return 0;
  }
}













