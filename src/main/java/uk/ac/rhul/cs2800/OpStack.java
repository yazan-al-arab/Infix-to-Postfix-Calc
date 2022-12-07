package uk.ac.rhul.cs2800;

public class OpStack {
  
  private MyStack stack;
  
  public OpStack() {
    stack = new MyStack();
  }

  public boolean isEmpty() {
    return stack.size() == 0 ? true : false;
  }

  public void push(Symbol symbol) {
    stack.push(symbol);
  }

  public Symbol pop() {
    try {
      return stack.pop().getSymbol();
    } catch (BadTypeException e) {
      // never enters this area because only symbols can be pushed (hence popped).
    }
    return null;
  }

}
