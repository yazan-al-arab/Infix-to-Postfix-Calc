package uk.ac.rhul.cs2800;

/**
 * Allows communication between a model and a view.
 * 
 * @author yazan
 *
 */
public class CalcController {

  // can only be PostFix model
  private CalcModel myModel;

  // can only be GUI view
  private ViewInterface myView;

  /**
   * Constructs a Calculator Controller object which defines how to communicate
   * between the model and view. It also initialises all observers.
   * 
   * @param model the current calculator model (Infix or PostFix).
   * @param view  the current view (GUI or ASCII).
   */
  CalcController(CalcModel model, ViewInterface view) {
    this.myModel = model;
    this.myView = view;
    view.addCalculateObserver(this::handleCalculate);
  }

  /**
   * An observer which uses model and view to calculate the expression and display
   * the result. This method is an observer of when the user presses the calculate
   * button.
   */
  private void handleCalculate() {
    String exp = myView.getExpression();
    String result = myModel.evaluate(exp);
    myView.setResult(result);
  }

}
