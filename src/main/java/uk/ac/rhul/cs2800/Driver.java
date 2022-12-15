package uk.ac.rhul.cs2800;

/**
 * Drives the whole program. It is the starting point.
 * 
 * @author yazan
 *
 */
public class Driver {

  /**
   * Starting point of the program. Sets up the model, view, controller, then
   * displays the GUI.
   * 
   * @param args the arguments entered by a user when running this program from a
   *             terminal.
   */
  public static void main(String[] args) {
    // builds GUI
    ViewInterface view = MainView.getInstance();
    CalcModel model = new CalcModel();

    new CalcController(model, view);

    // Calls this once JavaFX is complete and initialise is called.
    view.menu();
  }
}