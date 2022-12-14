package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
  private TextField resultField;

  @FXML
  private RadioButton postfixButton;

  @FXML
  private RadioButton infixButton;

  
  // Inspired from Prof Dave's MVCJavaFX project
  
  // Makes it a JavaFX Singleton.
  private volatile static MainView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }
  
  public synchronized static MainView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(MainView.class)).start();
      // Wait until the instance is ready since initialize has executed.
      while (instance == null) {// empty body
      }
    }
    return instance;
  }
  // end of singleton code

  
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

  @Override
  public void setResult(String newResult) {
    resultField.setText(newResult);

  }

}
