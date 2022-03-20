package Simulacion;

import java.util.ArrayList;

public class T09A {
	public static void main(String args[]) {
		T09B T9 = new T09B();
		ArrayList<ArrayList> A = T9.getBorrachos();
		int C = 1;
		String D = "";
		for(int x = 0; x<A.size(); x = x+3) {
			System.out.println("Borracho #" + C);
			for(int y = 0; y < A.get(x).size(); y++) {
				D = "";
				if((int)(A.get(x+2).get(y)) > 0) {
					D = "N";
				}
				if((int)(A.get(x+2).get(y)) < 0) {
					D = "S";
				}
				if((int)(A.get(x+1).get(y)) > 0) {
					D = D + "E";
				}
				if((int)(A.get(x+1).get(y)) < 0) {
					D = D + "O";
				}
				System.out.println((y+1)  + " | " + (A.get(x).get(y)) + " | " + (A.get(x+1).get(y)) + " | " + (A.get(x+2).get(y)) + " | " + D);
			}
			C++;
		}
	}
}
