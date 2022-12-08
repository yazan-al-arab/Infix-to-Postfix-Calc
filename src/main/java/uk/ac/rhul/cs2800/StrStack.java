package uk.ac.rhul.cs2800;

public class StrStack {
  
  private MyStack stack;

  public StrStack() {
    stack = new MyStack();
  }

  public boolean isEmpty() {
    return stack.size() == 0 ? true : false;
  }

  public void push(String s) {
    stack.push(s);
  }

  public String pop() {
    try {
      return stack.pop().getString();
    } catch (BadTypeException e) {
      // never enters this area because only strings can be pushed and popped.
    }
    return "";
  }

}
