package converter;

public class TestClass {
	public static void main(String[] args) {
		Length[] length = Length.values();
		
		for (Length x : length){
			System.out.println(x.toString()+" ="+x.getValue());
		}
	}
}
