package gameBasics;

import cards.*;

public class testRunner {
//WON"T BE ACTUALLY USED JUST TO TEST BACKEND
	public static void main(String[] args) {
		Boolean[] x = new Boolean[4];
		for (Boolean c : x)
			System.out.println(c);
		x[1] = !x[1];
		for (Boolean c : x)
			System.out.println(c);
		
		

	}

}
