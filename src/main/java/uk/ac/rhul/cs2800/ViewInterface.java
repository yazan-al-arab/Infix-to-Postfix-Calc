package uk.ac.rhul.cs2800;

public interface ViewInterface {
  
  void addCalculateObserver(Observer f);
  
  public void menu();
  
  public void setResult(String newResult);
  
  String getExpression();
}
