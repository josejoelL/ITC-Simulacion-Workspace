package Simulacion;

import java.util.ArrayList;

public class T08A {

	public static void main(String[] args) {
		T08C T8 = new T08C();
		ArrayList <Double> NG = T8.getNG(); 
		ArrayList <Integer> ZR = T8.getZR();
		System.out.println("N | Numero Generado | Zona de ruleta");
		for(int x = 0; x<NG.size(); x++) {
			System.out.println((x+1) + " | " + NG.get(x) + " | " + ZR.get(x));
		}
	}

}
