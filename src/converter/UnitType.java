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
	 * 
	 * @param name
	 */
	private UnitType(String name) {
		this.name = name ;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName(){
		return name ;
	}

}
