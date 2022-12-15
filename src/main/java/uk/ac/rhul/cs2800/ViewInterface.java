package uk.ac.rhul.cs2800;

/**
 * Defines attributes and methods needed for a View.
 * 
 * @author yazan
 *
 */
public interface ViewInterface {

  /**
   * Links the calculate button onAction event to notify specific observers.
   * 
   * @param f the observer to be hooked.
   */
  void addCalculateObserver(Observer f);

  /**
   * Activates the calculate button.
   */
  public void menu();

  /**
   * Displays the result of the expression to the user.
   * 
   * @param newResult the calculated result of the expression.
   */
  public void setResult(String newResult);

  /**
   * Getter for the expression field.
   * 
   * @return the expression which has been entered by the user.
   */
  String getExpression();
}
