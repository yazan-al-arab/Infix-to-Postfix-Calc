package uk.ac.rhul.cs2800;

/**
 * Is thrown when an expression does not resemble a PostFix expression.
 * 
 * @author yazan
 *
 */
public class InvalidExpression extends Exception {

  private static final long serialVersionUID = 2439740586584789903L;

  /**
   * Constructs an InvalidExpression exception which can be thrown or handled.
   * 
   * @param s is a message to the developer and the user detailing why this
   *          exception was thrown.
   */
  public InvalidExpression(String s) {
    super(s);
  }

}
