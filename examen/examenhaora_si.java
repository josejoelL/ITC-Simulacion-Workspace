package examen;

import java.util.Scanner;
import java.util.Vector;

public class examenhaora_si {

	static Vector<semilla> V = new Vector<semilla>();

	public static void main(String[] args) {
	

		int s;

		while (true) {

			System.out.println("Incerte una semilla de 3 digitos");

			try {

				s = imprime();

			
				if ((s > 1) && (s < 999))
					break;

			} catch (Exception e) {
				System.out.println("solo numero enteros");
			}

		}
		System.out.println(s + " : generando...");

		generar(s);

		for (int i = 0; i < V.size(); i++) {
			System.out.println(V.elementAt(i).toString());
		}
	}

	private static void generar(int s) {
		generar(s, 0);
	}

	private static void generar(int s, int n) {
		if (s < 100)
			return;

		int sc;
		String sn;
		String ni, sub;

		sc = (int) Math.pow(s, 2);
		ni = String.valueOf(sc);

		sub = ni.substring(1, ni.length() - 1);
		sn = sub.substring(0, 3);
		n++;

		V.addElement(new semilla(n, s, sc, ni, sn));
		generar(Integer.valueOf(sn), n);
	}

	public static int imprime() {
		Scanner S = new Scanner(System.in);
		return S.nextInt();
	}

}
