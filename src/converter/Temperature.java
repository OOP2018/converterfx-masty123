package converter;

public enum Temperature implements Unit{
	CELCIUS(){
		
		public double toCelcius(double d){return 0;}
		
		public double toFahrenheit(double d){return (d-32)/1.8;}
		
		public double toKelvin(double d){return d - 273.15;}

		@Override
		public double convert(double amount, Unit convert) {
			try{
				
				return ((Temperature)convert).toCelcius(amount);
			}catch(Exception e){
				System.out.println("invalid input");
			}
			return -1;
		}
		
		public double getValue(){
			return 0;
		}
	},
	
	FAHRENHEIT(){
		
		public double toCelcius(double d) {return (d * 1.8) + 32; }
		public double toFahrenheit(double d) {return d;}
		public double toKelvin(double d) {return (d * 1.8) - 459.67;}
		public double convert(double amount, Unit convert) {
			try{
				return ((Temperature)convert).toFahrenheit(amount);
			}
			catch(Exception e){
				System.out.println("Invalid input");
				return -1;
			}
		}
		
		public double getValue(){
			return 32;
		}
		
	},
	
	KEVIN(){

	
		public double toCelcius(double d) {return d + 273.15;}
		public double toFahrenheit(double d) {return (d + 459.67)/1.8;}
		public double toKelvin(double d) {return d;}
		public double convert(double amount, Unit convert) {
			try{
				return ((Temperature)convert).toKelvin(amount);
			}
			catch(Exception e){
				System.out.println("Invalid input");
				return -1;
			}
		}
		
		 public double getValue(){
	        	return 273.15;
	     }
		
	};

	private double value;
	/**
	 * Constructor of Temperature enum.
	 */
	Temperature(){}
	
	
	@Override
	public double getValue() {
		return value;
	}
	
	
	public abstract double toCelcius(double d);
	public abstract double toFahrenheit(double d);
	public abstract double toKelvin(double d);
	
	

	
	
	
	
	


}
