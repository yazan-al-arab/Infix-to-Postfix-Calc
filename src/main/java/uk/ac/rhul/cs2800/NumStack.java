package uk.ac.rhul.cs2800;

public class NumStack {
  
  private MyStack stack;
  
  public NumStack() {
    stack = new MyStack();
  }
  
  public boolean isEmpty() {
    return stack.size() == 0 ? true : false;
  }
  
  
  public void push(float value) {
    stack.push(value);
  }

  public float pop() {
    float value = 0;
    try {
      value = stack.pop().getValue();
    } catch (BadTypeException e) {
      // never enters this area because only floats are pushed.
    }
    return value;
  }
  
//  public float top() {
//    float value = 0;
//    try {
//      value = stack.top().getValue();
//    } catch (BadTypeException e) {
//      // never happens because we only put numbers into stack
//    }
//    
//    return value;
//  }

}
