package uk.ac.rhul.cs2800;

public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  
  CalcController(CalcModel model, ViewInterface view) {
    this.myModel = model;
    this.myView = view;
    view.addCalculateObserver(this::handleCalculate);
  }
  
  private void handleCalculate() {
    String exp = myView.getExpression();
    String result = myModel.evaluate(exp);
    myView.setResult(result);
  }

}
