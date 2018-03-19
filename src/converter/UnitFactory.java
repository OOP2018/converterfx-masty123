package converter;

public class UnitFactory {
	
	public static UnitFactory instance = new UnitFactory();
	
	/**
	 * For initialize
	 */
	private UnitFactory(){}
	
	/**
	 * Get the string of the unit
	 * @return
	 */
	public String[] getUnitTypes(){
		String[] temp = {UnitType.LENGTH.getName(), UnitType.AREA.getName(), UnitType.WEIGHT.getName(), UnitType.TIME.getName(), UnitType.TEMPERATURE.getName()};
		return temp;
	}
	
	/**
	 * Get the array of the unit.
	 * @param unitType
	 * @return
	 */
	public Unit[] getUnits(String unitType) {
		if(unitType.equalsIgnoreCase("Temperature")) return Temperature.values();
		if(unitType.equalsIgnoreCase("Area")) return Area.values();
		if(unitType.equalsIgnoreCase("Weight")) return Weight.values();
		if(unitType.equalsIgnoreCase("Time")) return Time.values();
		return Length.values();	
	}
	
	/**
	 * 
	 * @return instance
	 */
	public static UnitFactory getInstance() {
		return instance;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UnitFactory test = new UnitFactory();
		for(String temp : test.getUnitTypes()) {
			System.out.println(temp);
		}
	}
}
