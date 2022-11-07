package uk.ac.rhul.cs2800;

/**
 * Describes the types of acceptable symbols. Not related to the Type class.
 * 
 * @author yazan
 *
 */
public enum Symbol {

  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "invalid");

  /**
   * The String format corresponding to the specific Type.
   */
  final String symbol;

  /**
   * Sets the String symbol field to equal to it's corresponding String value.
   * 
   * @param string sets the corresponding String.
   */
  private Symbol(String string) {
    symbol = string;
  }

  /**
   * Returns the Symbol in a String format.
   */
  public String toString() {
    return symbol;
  }

}
