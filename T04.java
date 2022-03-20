package Simulacion;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class T04 {
	private static double n;
	private static int m,a,c,x;
	private static final long L = (long) (Math.pow(2,15));
	private static ArrayList<Integer> VO; 
	public static void main(String[] args) {
		boolean C = false;
		VO = new ArrayList<Integer>();
		LeerSemilla();
		LeerMultiplicador();
		LeerIncremento();
		LeerModulo();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Modulo = " + m);
		System.out.println("Multiplicador = " + a);
		System.out.println("Incremento = " + c);
		System.out.println("Semilla = " + x);
		System.out.println("----------------------------------------------------------------------------");
		for(int i = 0; !C; i++){
			if(ValoresRepetidos()) {
				C = true;
			}
			else {
				System.out.println((i+1) + " | " + x + " | " + ((a*x)+c) +" | " + (a*x+c)+"/"+m  +" | " +  ((a*x+c)%m));
				VO.add(x);
				x = ((a*x+c)%m);
			}
		}
	}
	public static boolean ValoresRepetidos() {
		for(int i = 0; i<VO.size() && VO.size() != 0; i++) {
			if(VO.get(i) == x) {
				return true;
			}
		}
		return false;
	}
	public static void LeerModulo() {
		Scanner s = new Scanner(System.in);
		boolean p = false;
		System.out.println("Dame un numero para el modulo (primo y menor a " + L + ")");
		do{
			m = s.nextInt();
			if(ComprobarRango()) {
				p = ComprobarPrimo();
				if(!p) {
					System.out.println("No has escrito un numero primo");
				}
			}
			else {
				System.out.println("No esta en un rango valido");
			}
		}while(!p);
	}
	public static boolean ComprobarRango() {
		if(m < L) {
			return true;
		}
		return false;
	}
	public static void LeerMultiplicador(){
		Scanner s = new Scanner(System.in);
		System.out.println("Escribe para el multiplicador (mayor a 2)");
		do {
			a = s.nextInt();
			if(a>2) {
				a = (2*a)+1;
			}
			if(a % 3 == 0 || a % 5 == 0 || !(a>2)) {
				System.out.println("No se admite ese numero, escribe otro");
			}
		}
		while(a % 3 == 0 || a % 5 == 0 || !(a>2));
	}
	public static void LeerIncremento() {
		Scanner s = new Scanner(System.in);
		System.out.println("Dame un numero para incremento (impar y que de un residuo de 5)");
		do{
			c = s.nextInt();
			if(c%2==0) {
				System.out.println("No se admite numeros pares, ingresa otro");
			}
			if(c%8!=5) {
				System.out.println("El numero tiene que dar un residuo de 5 al dividirse por 8, ingresa otro");
			}
		}while(c%2 == 0 || (c%8!=5));
	}
	public static void LeerSemilla() {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		System.out.println("¿Como se generara la semilla? (1. Manual | 2. Aleatorio)");
		switch(s.nextInt()) {
		case 1:
			System.out.println("Escribe la semilla");
			x = s.nextInt();
			break;
		case 2:
			System.out.println("Se generara una semilla");
			x = r.nextInt();
			if(r.nextDouble()*2 == 1)
				x = x *(-1);
			break;
		}
	}
	public static boolean ComprobarPrimo() {
		int D = 0;
		if(m == 1 || m == 2) {
			return true;
		}
		for(int i = 1; i<=m ; i++) {
			if(m%i==0) {
				//System.out.println("Es divisible entre " + i);
				D++;
			}
			if(D>2) {
				return false;
			}
		}
		return true;
	}
}
