package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The main stage where the whole calculator exists. Inspired by Dave's
 * MVCJavaFX code.
 * 
 * @author yazan
 *
 */
public class MainView extends Application implements ViewInterface {

  /**
   * The calculate button displayed on the GUI.
   */
  @FXML
  private Button calculateButton;

  /**
   * The expression to be evaluated, provided by the user.
   */
  @FXML
  private TextField expressionField;

  /**
   * Where the result is displayed to the user.
   */
  @FXML
  private TextField resultField;

  // minimum width of GUI window
  private static final int MIN_WIDTH = 700;

  // minimum height of GUI window
  private static final int MIN_HEIGHT = 237;

  /**
   * Called by JavaFX when the toolkit is initialised. Used to instantiate the
   * scene and create the view.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("MainView.fxml"));
    Scene scene = new Scene(pane);

    primaryStage.setMinHeight(MIN_HEIGHT);
    primaryStage.setMinWidth(MIN_WIDTH);
    primaryStage.setTitle("CS2800 Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Activates the calculate button.
   */
  @Override
  public void menu() {
    calculateButton.setDisable(false);
  }

  /**
   * Links the calculate button onAction event to notify specific observers.
   */
  @Override
  public void addCalculateObserver(Observer f) {
    calculateButton.setOnAction(event -> f.notifyObservers());
  }

  /**
   * Getter for expression field.
   * 
   * @return the expression which has been entered by the user.
   */
  @Override
  public String getExpression() {
    return expressionField.getText();
  }

  /**
   * Displays the result of the expression to the user.
   * 
   * @param newResult the calculated result of the expression.
   */
  @Override
  public void setResult(String newResult) {
    resultField.setText(newResult);
  }
  
  

  // Makes it a JavaFX Singleton.
  private static volatile MainView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * Uses a thread to wait until JavaFX has initialised toolkits then allows the
   * creation of GUI.
   * 
   * @return mainview object used to setup the GUI from the Driver.
   */
  public static synchronized MainView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(MainView.class)).start();
      // Wait until the instance is ready since initialize has executed.
      while (instance == null) {// empty body
      }
    }
    return instance;
  }

}
