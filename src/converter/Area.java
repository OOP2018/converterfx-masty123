package converter;
/**
 * An enum class that contain area units.
 * @author Theeruth Borisuth
 *
 */
public enum Area implements Unit {
	SQUAREMETER(1.00),
	SQUAREKILOMETER(1000000.0),
	SQUARECENTIMETER(0.0001),
	SQUAREMILE(2589988.11),
	SQUAREFOOT(0.09290304),
	SQUAREWA(4.0),
	SQUAREINCH(0.00064516),
	NGAN(400.0),
	RAI(1600.0);
	
	//value of unit
	private final double value ;
		

		
	/**
	 * Constructor of Length initialize with value of unit.
	 * @param value
	 */
	private Area(double value){
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
	 * Unit an area unit to another area unit.
	 * @return result of the converted unit
	 */
	@Override
	public double convert(double amount, Unit convert) {
		return amount*this.getValue()/convert.getValue();
	}
}
