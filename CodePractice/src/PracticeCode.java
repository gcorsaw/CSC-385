import java.util.Random;

public class PracticeCode {
	
	String[] arrayOfStrings = new String[20];
	int[] arrayOfIntegers = new int[20];
	
	
	public PracticeCode() {
		arrayOfStrings[0] = "a";
		arrayOfStrings[1] = "b";
		arrayOfStrings[2] = "c";
		arrayOfStrings[3] = "d";
		arrayOfStrings[4] = "e";
		arrayOfStrings[5] = "f";
		arrayOfStrings[6] = "g";
		arrayOfStrings[7] = "h";
		arrayOfStrings[8] = "i";		
		arrayOfStrings[9] = "j";
		arrayOfStrings[10] = "l";
		arrayOfStrings[11] = "m";
		arrayOfStrings[12] = "n";
		arrayOfStrings[13] = "o";
		arrayOfStrings[14] = "p";
		arrayOfStrings[15] = "q";
		arrayOfStrings[16] = "r";
		arrayOfStrings[17] = "s";
		arrayOfStrings[18] = "t";
		arrayOfStrings[19] = "u";
		
		
		
//		System.out.println(toString());
	}
	public char randomChar() {
		Random randomValue = new Random();
		float randomNumber = randomValue.nextFloat();
		int randomLetterInt = (int)(65 + randomNumber * 57); 
		System.out.println(randomLetterInt);
		char ch = Character.forDigit(randomLetterInt, 10);
		System.out.println(ch);
		return ch;
	}
	
	
	public String toString() {
		String newStringArray = "";
		for(int i = 0; i < arrayOfStrings.length; i ++) {
			newStringArray += "Letter: " + arrayOfStrings[i] + "\n";
		}
		
		return newStringArray;
	}
}
