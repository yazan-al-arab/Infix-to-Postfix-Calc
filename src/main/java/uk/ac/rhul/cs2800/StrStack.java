package uk.ac.rhul.cs2800;

/**
 * A stack which only operates with String values.
 * 
 * @author yazan
 *
 */
public class StrStack {

  private MyStack stack;

  /**
   * Constructs a StringStack object.
   */
  public StrStack() {
    stack = new MyStack();
  }

  /**
   * Checks whether the stack is empty.
   * 
   * @return true if the boolean is empty and false if its not empty.
   */
  public boolean isEmpty() {
    return stack.size() == 0 ? true : false;
  }

  /**
   * Pushes a string value onto the stack.
   * 
   * @param s the value to be pushed.
   */
  public void push(String s) {
    stack.push(s);
  }

  /**
   * Pops a string value off the stack.
   * 
   * @return the popped value from the stack.
   */
  public String pop() {
    try {
      return stack.pop().getString();
    } catch (BadTypeException e) {
      // never enters this area because only strings can be pushed and popped.
    }
    return null;
  }

}
