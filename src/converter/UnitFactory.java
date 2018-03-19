package converter;

public class UnitFactory {
	/**
	 * 
	 * @return
	 */
	public String[] getUnitTypes(){
		String[] temp = {UnitType.LENGTH.getName(), UnitType.AREA.getName(), UnitType.WEIGHT.getName(), UnitType.TIME.getName(), UnitType.TEMPERATURE.getName()};
		return temp;
	}
	
	/**
	 * 
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
	 * @param args
	 */
	public static void main(String[] args) {
		UnitFactory test = new UnitFactory();
		for(String temp : test.getUnitTypes()) {
			System.out.println(temp);
		}
	}
}
