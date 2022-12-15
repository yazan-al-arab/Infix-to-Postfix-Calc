package uk.ac.rhul.cs2800;

/**
 * A stack which only operates with Symbol (enum) values.
 * 
 * @author yazan
 *
 */
public class OpStack {

  private MyStack stack;

  /**
   * Constructs an OpStack object.
   */
  public OpStack() {
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
   * Pushes an operator onto the stack.
   * 
   * @param symbol the value to be pushed.
   */
  public void push(Symbol symbol) {
    stack.push(symbol);
  }

  /**
   * Pops an operator off the stack.
   * 
   * @return the popped value from the stack.
   */
  public Symbol pop() {
    try {
      return stack.pop().getSymbol();
    } catch (BadTypeException e) {
      // never enters this area because only symbols can be pushed (hence popped).
    }
    return null;
  }

}
