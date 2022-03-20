package Simulacion;

import java.util.ArrayList;

public class T06A {

	public static void main(String[] args) {
		T06B B = new T06B();
		ArrayList<Double> R = B.getResultado();
		ArrayList<Integer> C = B.getConsultas();
		System.out.println("N | Numero generado | Numero de consultas");
		for(int x = 0; x<R.size(); x++) {
			System.out.println((x+1) + " | " + R.get(x) + " | " + C.get(x));
		}
	}

}
