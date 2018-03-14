package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
/**
 * A javaFX class that control many method. This class is a link between GUI and codes.
 * @author Theeruth Borisuth
 *
 */
public class ConverterController {
	//Attributes for ConverterController class
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	ComboBox<Length> unitbox1 ;	
	@FXML
	ComboBox<Length> unitbox2 ;
	
	/**
	 * Initialize units into the comboBox
	 */
	@FXML
	public void initialize(){
		if (unitbox1 != null) {
		unitbox1.getItems().addAll( Length.values() );
		unitbox1.getSelectionModel().select(0); // select an item to show
		}
		if (unitbox2 != null) {
		unitbox2.getItems().addAll( Length.values() );
		unitbox2.getSelectionModel().select(1); // select an item to show
		}
	}
	
	
	
	
	/**
	 * Convert a distance from one unit to another
	 */
	@FXML
	public void handleConvert(){
		//read values from textfield(s)
		String box1 = textfield1.getText();
		String box2 = textfield2.getText();
		try
		{
		if(!box1.isEmpty() && box2.isEmpty() || textfield1.isFocused()){
			double left = Double.parseDouble(box1.trim());			
			double result = (left *unitbox1.getValue().getValue()/unitbox2.getValue().getValue());
			textfield2.setText(String.format("%.4g", result));
		}
		
		else if(!box2.isEmpty() && box1.isEmpty() || textfield2.isFocused()){
			double right = Double.parseDouble(box2.trim());			
			double result = (right *unitbox2.getValue().getValue()/unitbox1.getValue().getValue());
			textfield1.setText(String.format("%.4g", result));
		
		}
		
		} catch (Exception e) {
			textfield1.setStyle("-fx-text-fill: red");
			textfield1.setText("ERROR");
			textfield2.setStyle("-fx-text-fill: red");
			textfield2.setText("ERROR");
		}	
		
	}	
	
	
	/**
	 * This can listen the Enter button to convert to make it more convenient.
	 * @param event : listen the ENTER button
	 */
	public void convertOnEnter(KeyEvent event){
		if(event.getCode().equals(KeyCode.ENTER)){
			handleConvert();
		}
	}
	
	/**
	 * Handle clear event when you press clear button on the interface
	 * @param event : Listen clear button
	 */
	@FXML
	public void handleClear(ActionEvent event){
		textfield1.clear();
		textfield2.clear();
		textfield1.setStyle("-fx-text-fill: black");
		textfield2.setStyle("-fx-text-fill: black");

		System.out.println("CLEAR");
	}
}