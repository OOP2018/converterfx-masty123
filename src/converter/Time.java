package converter;
/**
 * An enum class that contain Time units.
 * @author Theeruth Borisuth
 *
 */
public enum Time implements Unit {
	
		SECOND(1.0),
		MINUTE(60.0),
		HOUR(3600.0),
		DAY(86400.0),
		WEEK(604800.0),
		MONTH(2629743.83),
		YEAR(31556926.0),
		OLYMPIAD(126230400.0),
		MILLENNIUM(3.1556926E10),
		YAM(10800.0);
		
		/** value of unit */
		private final double value;
		
		/** Store name and value in attribute */
		private Time(double value){
			this.value = value;
		}

		/**
		 * Return value of Time unit with second as standard unit.
		 * @return
		 */
		@Override
		public double getValue() {
			return value;
		}

		@Override
		public double convert(double amount, Unit input, Unit convert) {
			return amount*input.getValue()/convert.getValue();
		}

}
