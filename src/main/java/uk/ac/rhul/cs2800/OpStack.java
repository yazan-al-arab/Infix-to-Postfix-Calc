package uk.ac.rhul.cs2800;

public class OpStack {
  
  private MyStack stack;
  
  public OpStack() {
    stack = new MyStack();
  }

  public boolean isEmpty() {
    return stack.size() == 0 ? true : false;
  }

}
