package uk.ac.rhul.cs2800;

/**
 * This exception is thrown when entries of one type call a method which is only
 * for entries of another type.
 * 
 * @author yazan
 *
 */
public class BadTypeException extends Exception {

  private static final long serialVersionUID = -7851054470129137004L;

  /**
   * Constructs a BadTypeException which can be thrown or handled.
   * 
   * @param s is a message to the developer detailing why this exception was
   *          thrown.
   */
  public BadTypeException(String s) {
    super(s);
  }

}
