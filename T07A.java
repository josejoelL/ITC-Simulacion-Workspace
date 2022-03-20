package Simulacion;

import java.util.ArrayList;

public class T07A {

	public static void main(String[] args) {
		double SU = 0, Media, SDDE = 0;
		T07B T7 = new T07B();
		ArrayList <Double> NG = T7.getNG();
		ArrayList <Integer> V = T7.getV();
		int N = T7.getN(), C = T7.getC();
		System.out.println("N | Numero generado | Vendidos | Devueltos | Costo de compra | Obtencion de venta | Obtencion por devolucion | Utilidad");
		for(int x = 0; x < N; x++) {
			System.out.println((x+1) + " | " + NG.get(x) + " | " + V.get(x) + " | " +  (C-V.get(x)) + " | " + (75*C) + " | " + (100*V.get(x)) + " | " + (25*(C-V.get(x))) + " | " +  ( (100*V.get(x)) + (25*(C-V.get(x))) - (75*C)) );
			SU = SU + ((100*V.get(x)) + (25*(C-V.get(x))) - (75*C));
		}
		Media = SU / N;
		System.out.println("Media = " + Media);
		for(int x = 0; x < N; x++) {
			SDDE = SDDE + Math.pow((( (100*V.get(x)) + (25*(C-V.get(x))) - (75*C)) - Media ),2);
		}
		System.out.println("Desviacion estandar = " + Math.sqrt(SDDE/(N-1)));
	}

}
