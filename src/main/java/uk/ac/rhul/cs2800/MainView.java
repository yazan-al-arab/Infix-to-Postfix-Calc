package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The main stage where the whole calculator exists.
 * 
 * @author yazan
 *
 */
public class MainView extends Application implements ViewInterface {

  @FXML
  private Button calculateButton;

  @FXML
  private TextField expressionField;

  @FXML
  private Label expressionLabel;

  @FXML
  private Pane mainPane;

  @FXML
  private TextField resultField;

  @FXML
  private Label resultLabel;

  @FXML
  private RadioButton postfixRadio;

  @FXML
  private RadioButton infixRadio;

//  /**
//   * Calculates and outputs the expression.
//   * 
//   * @param event calculate button pressed
//   */
//  @FXML
//  public void calculateIsPressed(ActionEvent event) {
//    try {
//      // If expression is a float value, double it and output it
//      Float input = 2 * Float.parseFloat(expressionField.getText());
//      resultField.setText(String.valueOf(input));
//
//    } catch (Exception e) {
//      // otherwise copy the contents of expression over to result
//      resultField.setText(expressionField.getText());
//    }
//  }
  
  private volatile static MainView instance = null;
  
  @FXML
  void initialize() {
    instance = this;
  }
  
  // Inspired from Dave's code
  public synchronized static MainView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(MainView.class)).start();
      // Wait until the instance is ready since initialize has executed.
      while (instance == null) {// empty body
      }
    }
    return instance;
  }

  @Override
  public void addCalculateObserver(Observer f) {
    calculateButton.setOnAction(event -> f.notifyObservers());
  }

  @Override
  public String getExpression() {
    return expressionField.getText();
  }

  @Override
  public void menu() {
    calculateButton.setDisable(false);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("MainView.fxml"));
    Scene scene = new Scene(pane);

    primaryStage.setTitle("CS2800 Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();

  }

}
