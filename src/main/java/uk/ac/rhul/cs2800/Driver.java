package uk.ac.rhul.cs2800;

/**
 * Drives the whole program. It is the starting point.
 * 
 * @author yazan
 *
 */
public class Driver {
  
  public static void main(String[] args) {
    ViewInterface view = MainView.getInstance();
    CalcModel model = new CalcModel();
    
    new CalcController(model, view);
    view.menu();
  }
}