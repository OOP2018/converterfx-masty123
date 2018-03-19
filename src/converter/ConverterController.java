package converter;

import javafx.event.EventHandler;

import java.awt.event.KeyListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
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
	ComboBox<Unit> unitbox1 ;	
	@FXML
	ComboBox<Unit> unitbox2 ;
	@FXML
	Menu menu;
	@FXML
	MenuItem length;
	@FXML
    MenuItem weight;
	@FXML
	MenuItem area;
	@FXML
	MenuItem time;
	@FXML
	MenuItem temperature;
	@FXML
	MenuItem exit;
	
	//variables
	private final String  DEFAULT_TYPE = "Length";
	private UnitFactory factory = UnitFactory.getInstance();
	private boolean isLeft = true;
	
	
	
	
	/**
	 * Initialize units into the comboBox
	 */
	@FXML
	public void initialize(){

		//set the default unit
		setBox(unitbox1, DEFAULT_TYPE);
		setBox(unitbox2, DEFAULT_TYPE);
		
		//Change to weight converter.
		weight.setOnAction(new EventListener("Weight"));
		//Change to time converter.
		time.setOnAction(new EventListener("Time"));
		//Change to Area converter.
		area.setOnAction(new EventListener("Area"));
		//Change to Temperature converter.
		temperature.setOnAction(new EventListener("Temperature"));
		//Change to Length converter.
		length.setOnAction(new EventListener("Length"));
	}
	
	/**
	 * Convert a unit to another unit
	 * 
	 */
	@FXML
	public void handleConvert(){
		//read values from textfield(s)
		String box1 = textfield1.getText();
		String box2 = textfield2.getText();
		Unit u1 = unitbox1.getValue();
		Unit u2 = unitbox2.getValue();
		try
		{
		if(!box1.isEmpty() && box2.isEmpty() || isLeft){
			double left = Double.parseDouble(box1.trim());			
			double result = u1.convert(left, unitbox2.getValue());
			textfield2.setText(String.format("%.5g", result));
		}
		
		if(!box2.isEmpty() && box1.isEmpty() || !isLeft){
			double right = Double.parseDouble(box2.trim());			
			double result = u2.convert(right, unitbox1.getValue());
			System.out.println(result);
			textfield1.setText(String.format("%.5g", result));
		
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
	}
	
	/**
	 * Exit the unit converter program
	 * @param event
	 */
	@FXML
	public void handleExit(ActionEvent event){
		System.exit(0);
	}
	
	/**
	 * Set focus to the left side
	 * @param event
	 */
	@FXML
	public void handleLeftFocus(KeyEvent event) {
		isLeft = true ;
	}
	
	/**
	 * Set focus to the right side
	 * @param event
	 */
	@FXML
	public void handleRightFocus(KeyEvent event) {
		isLeft = false ;
	}
	
	/**
	 * This method setting up the combo box of the unit converter.
	 * @param unitbox : combBox box of the program.
	 * @param type : type of the unit.
	 */
	public void setBox(ComboBox<Unit> unitbox, String type) {
		if (unitbox != null) {
			unitbox.getItems().clear();
			unitbox.getItems().addAll(factory.getUnits(type));
			unitbox.getSelectionModel().select(0); // select an item to show
		}
	}
	
	/**
	 * this anonymous class is for setting up the comboBox
	 * @author Theeruth Borisuth
	 *
	 */
	class EventListener implements EventHandler<ActionEvent> {
		
		//variables
		private String type ;
		
		//constructor
		public EventListener(String type) {
			this.type = type ;
		}
		
		/**
		 * A method for setting up comboBox.
		 */
		@Override
		public void handle(ActionEvent event) {
			setBox(unitbox1, type);
			setBox(unitbox2, type);

		}	
	}
}
