package uk.ac.rhul.cs2800;

public interface ViewInterface {
  
  void addCalculateObserver(Observer f);

  String getExpression();

  public void menu();

}
