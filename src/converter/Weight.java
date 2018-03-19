package converter;
/**
 * An enum class that contain Weight units.
 * @author Theeruth Borisuth
 *
 */
public enum Weight implements Unit {
	GRAM(0.001),
	KILOGRAM(1.0),
	MILLIGRAM(0.000001),
	TONNNE(1000.0),
	OUNCE(0.02834952),
	POUND(0.45359237),
	STONE(6.35029),
	QUARTER(12.70058),
	HUNDREDWEIGHT(50.8023),
	BAHT(0.015),
	TALUNG(0.06),
	CHANG(0.012),
	HAB(0.06);
	
	
	//value of unit
	private final double value ;
	
	/**
	 * Constructor of Weight initialize with value of unit.
	 * @param value
	 */
	private Weight(double value){
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
	 * Unit an weight unit to another weight unit.
	 * @return result of the converted unit
	 */
	@Override
	public double convert(double amount,  Unit convert) {
		return amount*this.getValue()/convert.getValue();
	}
}
