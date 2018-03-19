package converter;
/**
 * An enum class that contain length units.
 * @author Theeruth Borisuth
 *
 */
public enum Length implements Unit {
	//All type of units
	METER(1), 
	KILLOMETER(1000), 
	CENTIMETER(0.01), 
	MILE(1609.344), 
	FOOT(0.30480), 
	WA(2), 
	AU(149597870700.0);
	
	//value of unit
	private final double value ;
	

	
	/**
	 * Constructor of Length initialize with value of unit.
	 * @param value
	 */
	private Length(double value){
		this.value = value;
	}

	/**
	 * get the value of unit
	 * @return value
	 */
	public double getValue(){
		return this.value;
	}
	
	/**
	 * Unit an length unit to another length unit.
	 * @return result of the converted unit
	 */
	@Override
	public double convert(double amount,  Unit convert) {
		return amount*this.getValue()/convert.getValue();
	}	
}
