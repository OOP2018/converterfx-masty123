package converter;
/**
 * This class is use for testing only, nothing else.
 * @author Theeruth Borisuth
 *
 */
public class TestClass {
	/**
	 * start tesing the enum class
	 * @param args
	 */
	public static void main(String[] args) {
		Length[] length = Length.values();
		
		for (Length x : length){
			System.out.println(x.toString()+" ="+x.getValue());
		}
	}
}
