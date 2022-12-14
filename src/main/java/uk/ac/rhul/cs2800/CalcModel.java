package uk.ac.rhul.cs2800;

public class CalcModel {
  private RevPolishCalc revPolish;
  
  public CalcModel() {
    revPolish = new RevPolishCalc();
  }
  
  public String evaluate(String exp) {
    try {
      return String.valueOf(revPolish.evaluate(exp));
    } catch (InvalidExpression e) {
      return e.getMessage();
    }
  }
  
}
