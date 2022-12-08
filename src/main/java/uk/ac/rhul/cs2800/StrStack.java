package uk.ac.rhul.cs2800;

public class StrStack {
  
  private MyStack stack;

  public StrStack() {
    stack = new MyStack();
  }

  public boolean isEmpty() {
    return stack.size() == 0 ? true : false;
  }

}
