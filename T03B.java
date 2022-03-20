package Simulacion;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class T03B {
	static int R;
	static String NS;
	static long N =0;
	static ArrayList<Long> VO;
	public static void main(String[] args) {
		int P = 0; 
		R = 0;
		boolean C = true;
		Scanner S = new Scanner(System.in);
		VO = new ArrayList<Long>();
		do {
			System.out.println("Elige una opcion (1. Manual | 2. Aleatorio)");
			R = S.nextInt();
		}while(R < 1 || R > 2);
		if(R == 1) {
			System.out.println("Escribe un numero de 10 digitos");
			N = S.nextInt();
		}
		if(R == 2) {
			Random RA = new Random();
			N = (long) (RA.nextInt());
			if(N < 0) {
				N = N * (-1);
			}
		}
		ComprobarNDigitos();
		for (int x = 0; C && N != 0; x++) {
			N = N*N;
			NS = N+"";
			if(NS.length()>=5) {
				if((NS.length()%2) == 0) {
					NS = "0" + NS;
				}
				//System.out.println(NS);
				P = (int) ((NS.length()/2)/*+0.5*/);
				NS = NS.substring(P-2,P+3);
				N = Integer.parseInt(NS);
			}
			if(!ValorRepetido(N)) {
				System.out.println((x+1) + ". " + N);
				VO.add(N);
			}
			else {
				C = false;
			}
		}
	}
	
	public static void ComprobarNDigitos() {
		Scanner S = new Scanner(System.in);
		NS = N+"";
		if(!(NS.length() == 10)) {
			while(NS.substring(0).equals("0") || NS.length() != 10) {
				if(NS.length()<10 || NS.substring(0).equals("0")) {
					do {
						if(R == 1) {
							System.out.println("Vuelve a ingresar un numero (10 digitos)");
							N = S.nextInt();
						}
						else {
							Random RA = new Random();
							N = (long) (RA.nextInt());
							if(N < 0) {
								N = N * (-1);
							}
						}
						NS = N+"";
					}while(NS.length()<10);
				}
				if(NS.length()>10) {
					while(NS.length() != 10) {
						NS = NS.substring(1);
						N = Integer.parseInt(NS);
					}
				}
			}
		}
	}
	private static boolean ValorRepetido(long n) {
		for(int x = 0; x<VO.size(); x++) {
			if(VO.get(x) == n) {
				return true;
			}
		}
		return false;
	}
}
