package converter;
/**
 * This interface represent a unit.
 * @author Theeruth Borisuth
 *
 */
public interface Unit {

	/**
	 * get the value of unit
	 * @return value
	 */
	public double getValue();
	
	/**
	 * return the string result of the unit.
	 * @return String
	 */
	public String toString();
	
	/**
	 * convert the unit into another unit
	 * @return String result of that unit
	 */
	public double convert(double amount, Unit input, Unit convert);

}
