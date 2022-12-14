package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class RevPolishCalc implements Calculator {

  NumStack stack = new NumStack();
  
  public RevPolishCalc() {
  }

  @Override
  public float evaluate(String exp) throws InvalidExpression {
    checkBalance(exp);
    
    
//    Scanner sc = new Scanner(exp);
//    String next;
//    
//    while(sc.hasNext()) {
//      next = sc.next();
//      try {
//        stack.push(Float.parseFloat(next));
//      } catch (Exception e) {
//        // If operator is read
//        
//      }
//      
//    }

    return 0;
  }

  public void checkBalance(String exp) throws InvalidExpression {
    
    if (exp.equals("") || exp == null) {
      throw new InvalidExpression("No expression was provided.");
    }
    
    int numCount = 0, 
        opCount = 0;
    
    boolean scannedAllNumbers = false;
    
    try (Scanner sc = new Scanner(exp)) {
      String curr;
      
      while(sc.hasNext()) {
        curr = sc.next();
        try {
          Float.parseFloat(curr);
          
          if(!scannedAllNumbers) {
            numCount++;
          }
          
        } catch (Exception e) {
          scannedAllNumbers = true;
          
          switch(curr) {
          case "+":
            break;
          case "-":
            break;
          case "*":
            break;
          case "/":
            break;
          default:
            throw new InvalidExpression("A symbol in the expression is not recognised.");
          } 
          
          opCount++;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    if(numCount == 1 && opCount == 0) {
      return;
    }
    
    if(!(opCount == numCount-1)) {
      throw new InvalidExpression("Unbalanced expression1.");
    }
  }
  
  
  
}
