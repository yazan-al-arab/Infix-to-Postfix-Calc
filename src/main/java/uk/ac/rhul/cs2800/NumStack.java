package uk.ac.rhul.cs2800;

/**
 * A stack which only operates with float values.
 * 
 * @author yazan
 * 
 */
public class NumStack {

  private MyStack stack;

  /**
   * Constructs a NumStack object.
   */
  public NumStack() {
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
   * Pushes a float value onto the stack.
   * 
   * @param value the value to be pushed.
   */
  public void push(float value) {
    stack.push(value);
  }

  /**
   * Pops a float value off the stack.
   * 
   * @return the popped value from the stack.
   */
  public float pop() {
    float value = 0;
    try {
      value = stack.pop().getValue();
    } catch (BadTypeException e) {
      // never enters this area because only floats are pushed.
    }
    return value;
  }

}
