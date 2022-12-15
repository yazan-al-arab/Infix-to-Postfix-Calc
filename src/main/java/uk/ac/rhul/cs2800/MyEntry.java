package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * This class stores an instance of either a number, string, or a symbol. Note
 * that this also stores it's type in a separate field.
 * 
 * @author yazan
 *
 */
public class MyEntry {

  /**
   * Stores the float value.
   */
  private float number;

  /**
   * Stores the string value.
   */
  private String str;

  /**
   * Stores which type of value it is. It can be either float, string, symbol, or
   * invalid.
   */
  private Type type;

  /**
   * Stores the symbol value.
   */
  private Symbol other;

  /**
   * Constructs an Entry instance. This is where the program decides whether this
   * instance is an entry of float, or an entry of string, or an entry of symbol
   * (exclusively).
   * 
   * @param obj the args entered when constructing an Entry object.
   */
  public MyEntry(Object obj) {
    if (obj instanceof Symbol) {
      type = Type.SYMBOL;
      other = (Symbol) obj;

    } else if (obj instanceof String) {
      type = Type.STRING;
      str = (String) obj;

    } else {

      try {
        // An attempt to check if obj is a float or can be made into one.
        number = Float.parseFloat((String.valueOf(obj)));
        type = Type.NUMBER;
      } catch (Exception e) {
        type = Type.INVALID; // The other fields are defaulted as null.
      }

    }
  }

  /**
   * Checks to see if it's a float entry before returning it's float value.
   * 
   * @return the float value of an entry.
   * @throws BadTypeException when a non-float entry calls this method.
   */
  public float getValue() throws BadTypeException {
    if (type != Type.NUMBER) {
      throw new BadTypeException("You cannot get a float value from a non-float entry.");
    }
    return number;
  }

  /**
   * Checks to see if it's a String entry before returning it's String value.
   * 
   * @return the String value of an entry.
   * @throws BadTypeException when a non-String entry calls this method.
   */
  public String getString() throws BadTypeException {
    if (type != Type.STRING) {
      throw new BadTypeException("You cannot get a String value from a non-String entry.");
    }
    return str;
  }

  /**
   * Checks to see if it's a Symbol entry before returning it's Symbol value.
   * 
   * @return the Symbol value of an entry.
   * @throws BadTypeException when a non-Symbol entry calls this method.
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type != Type.SYMBOL) {
      throw new BadTypeException("You cannot get a Symbol value from a non-Symbol entry.");
    }
    return other;
  }

  /**
   * A getter for the entry's type. It will always have a type no matter if it's a
   * string, float, or symbol.
   * 
   * @return the type of entry.
   */
  public Type getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Entry [number=" + number + ", str=" + str + ", type=" + type + ", other=" + other + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    MyEntry other = (MyEntry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number) 
        && this.other == other.other
        && Objects.equals(str, other.str) && type == other.type;
  }

}
