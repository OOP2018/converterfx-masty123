package converter;



/**
 * Contain all unit type.
 * @author Theeruth Borisuth
 */
public enum UnitType {
	LENGTH("Length", Length.values() ),
	AREA("Area", Area.values() ),
	WEIGHT("Weight", Weight.values() ),
	TIME("Time", Time.values() );
	
	/** name of unit type */
	private final String name;
	/** value of all unit in the type */
	private final Unit[] type;
	
	/** Store name and unit array in the attribute */
	private UnitType(String name, Unit[] type) {
		this.name = name;
		this.type = type;
	}
	
	/**
	 * Return name of the unit type.
	 * @return name of unit type
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * Return value of all unit in the type.
	 * @return value of all unit in the type
	 */
	public Unit[] getType() {
		return type;
	}
}
