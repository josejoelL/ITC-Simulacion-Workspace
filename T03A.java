package Simulacion;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class T03A {

	static ArrayList <Integer> VO;
	static Scanner S;
	static String NS;
	public static void main(String[] args) {
		int N = 0, R = 0;
		boolean C = false;
		VO = new ArrayList<Integer>();
		S = new Scanner(System.in);
		do {
			System.out.println("Elige una opcion (1. Manual | 2. Aleatorio)");
			R = S.nextInt();
		}while(R < 1 || R > 2);
		if(R == 1) {
			do {
				System.out.println("Escribe un numero");
				N = S.nextInt();
			}while((N+"").length() != 4);
		}
		if(R == 2) {
			do {
				Random RA = new Random();
				N = (int) (RA.nextDouble()*9999);
			}while((N+"").length() != 4);
		}
		N = (int) Math.pow((double)(N), 2);
		for(int  x = 0; N != 0 && !C; x++) {
			N = (ObtenerNumero(N));
			if(!ValorRepetido(N)){
				VO.add(N);
				//System.out.println(N);
				System.out.println((x+1) + ". " + NS.substring(2,6));
				N = Integer.parseInt(NS.substring(2,6));
				N = (int) Math.pow((double)(N), 2);
			}else {
				C = true;
			}
		}
	}
	private static boolean ValorRepetido(int n) {
		for(int x = 0; x<VO.size(); x++) {
			if(VO.get(x) == n) {
				return true;
			}
		}
		return false;
	}
	public static int ObtenerNumero(int N) {
		NS=N+"";
		if(NS.length() == 8) {
			return N;
		}
		else {
			if(NS.length() < 8) {
				while(NS.length() < 8)
					NS = "0"  + NS;
			}
			if(NS.length() > 8) {
				while(NS.length() > 8)
					NS = NS.substring(1);
			}
		}
		return N;
	}

}
