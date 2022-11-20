package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MainView {

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
    void calculateIsPressed(ActionEvent event) {
    	try {
    		// If expression is a float value, double it and output it
    		Float input = 2 * Float.parseFloat(expressionField.getText());
    		resultField.setText(String.valueOf(input));
    		
    	} catch (Exception e) {
    		// otherwise copy the contents of expression over to result
    		resultField.setText(expressionField.getText());
    	}
    }

}
