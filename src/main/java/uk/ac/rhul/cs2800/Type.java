package uk.ac.rhul.cs2800;

/**
 * Describes the different possible accepted input types.
 * 
 * @author yazan
 */
public enum Type {

  NUMBER("number"), SYMBOL("symbol"), STRING("string"), INVALID("invalid");

  /**
   * The String format corresponding to the specific Type.
   */
  final String type;

  /**
   * Sets the String type field to equal to it's corresponding String value.
   * 
   * @param string sets the corresponding String.
   */
  private Type(String string) {
    type = string;
  }

  /**
   * Returns the Type in a String format.
   */
  public String toString() {
    return type;
  }

}
