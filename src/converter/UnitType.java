package converter;
/**
 * Contain all unit type.
 * @author Theeruth Borisuth
 */
public enum UnitType {
	LENGTH("Length"),
	AREA("Area"),
	WEIGHT("Weight"),
	TIME("Time"),
	TEMPERATURE("Temperature");
	
	//variable
	private String name ;
	
	/**
	 * constructor of UnitType class
	 * @param name
	 */
	private UnitType(String name) {
		this.name = name ;
	}
	
	/**
	 * return the name of the unit
	 * @return
	 */
	public String getName(){
		return name ;
	}

}
