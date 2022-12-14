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

//  /**
//   * Starts the main JavaFX GUI.
//   * 
//   * @param args the user arguments from terminal
//   */
//  public static void main(String[] args) {
//    launch(args);
//  }

//  @Override
//  public void start(Stage primaryStage) {
//    Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("MainView.fxml"));
//    Scene scene = new Scene(pane);
//
//    primaryStage.setTitle("CS2800 Calculator");
//    primaryStage.setScene(scene);
//    primaryStage.show();
//    
//  }
}