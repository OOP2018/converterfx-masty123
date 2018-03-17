package converter;

import javafx.event.EventHandler;
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
		
		//Change to weight converter
		weight.setOnAction(new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent event) {
				if (unitbox1 != null) {
					unitbox1.getItems().clear();
					unitbox1.getItems().addAll( Weight.values() );
					unitbox1.getSelectionModel().select(0); // select an item to show
				}
				if (unitbox2 != null) {
					unitbox2.getItems().clear();
				    unitbox2.getItems().addAll( Weight.values() );
					unitbox2.getSelectionModel().select(1); // select an item to show
				}
			}
		});
		
		//Change to area converter
		area.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if (unitbox1 != null) {
					unitbox1.getItems().clear();
					unitbox1.getItems().addAll( Area.values() );
					unitbox1.getSelectionModel().select(0); // select an item to show
				}
				if (unitbox2 != null) {
					unitbox2.getItems().clear();
				    unitbox2.getItems().addAll( Area.values() );
					unitbox2.getSelectionModel().select(1); // select an item to show
				}
			}
		});
		
		//Change to time converter
		time.setOnAction(new EventHandler<ActionEvent>() {
					
		@Override
		public void handle(ActionEvent event) {
		if (unitbox1 != null) {
		unitbox1.getItems().clear();
		unitbox1.getItems().addAll( Time.values() );
		unitbox1.getSelectionModel().select(0); // select an item to show
		}
		if (unitbox2 != null) {
			unitbox2.getItems().clear();
			unitbox2.getItems().addAll( Time.values() );
			unitbox2.getSelectionModel().select(1); // select an item to show
			}
		   }
		});
		
		//Change to temperature converter
		temperature.setOnAction(new EventHandler<ActionEvent>() {
			
		@Override
		public void handle(ActionEvent event) {
		if (unitbox1 != null) {
			unitbox1.getItems().clear();
			unitbox1.getItems().addAll( Temperature.values() );
			unitbox1.getSelectionModel().select(0); // select an item to show
		    }
		if (unitbox2 != null) {
			unitbox2.getItems().clear();
			unitbox2.getItems().addAll( Temperature.values() );
			unitbox2.getSelectionModel().select(1); // select an item to show
			}
		   }
		});
		
		
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
		if(!box1.isEmpty() && box2.isEmpty() || textfield1.isFocused()){
			double left = Double.parseDouble(box1.trim());			
			double result = u1.convert(left, unitbox1.getValue(), unitbox2.getValue());
			textfield2.setText(String.format("%.4g", result));
		}
		
		if(!box2.isEmpty() && box1.isEmpty() || textfield2.isFocused()){
			double right = Double.parseDouble(box2.trim());			
			double result = u2.convert(right, unitbox2.getValue(), unitbox1.getValue());
			System.out.println(result);
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
	}
	
	/**
	 * Exit the unit converter program
	 * @param event
	 */
	@FXML
	public void handleExit(ActionEvent event){
		System.exit(0);
	}
}
