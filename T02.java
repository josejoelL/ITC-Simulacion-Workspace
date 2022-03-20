package Simulacion;
import java.util.Scanner;
import java.util.Random;
public class T02 {

	public static void main(String[] args) {
		int N = 0;
		System.out.println("Escribe que metodo quieres");
		Acciones();
		do {
			try {
				N = ObtenerInt();
			}catch(Exception E) {
				System.out.println("ERROR: Debe de ingresar un numero entero");
				N = 0;			
			}
			if(N<1 || N>2) {
				System.out.println("Accion no reconocida, elige otra opcion");
				Acciones();
			}
		}while(N<1 || N>2);
		switch(N) {
		case 1:
			Manual();
			break;
		case 2:
			Aleatorio();
			break;
		}
	}
	private static void Aleatorio() {
		System.out.println("");
		int NN = (int)(ObtenerNAleatorio()*100);
		for(int x = 0 ; x<NN; x++) {
			//System.out.println((x+1) + ". " + ObtenerNAleatorio());
		System.out.println(ObtenerNAleatorio());	
		}
	}
	private static void Manual() {
		System.out.println("Escribe cuantos numeros generados quiere");
		boolean C = false;
		int NN = 0;
		do {
			try {
				NN = ObtenerInt();
				C = true;
			}catch(Exception e) {
				System.out.println("ERROR: Debe ingresar solo numeros enteros");
			}
		}while(!C);
		for(int x = 0; x<NN; x++)
			System.out.println((x+1) + ". " + ObtenerNAleatorio());
		
	}
	private static double ObtenerNAleatorio() {
		Random R = new Random();
		return R.nextDouble();
	}
	//-----------------------------------------------------------------------------
	private static void Acciones() {
		System.out.println("1. Manual");
		System.out.println("2. Random");
	}
	public static int ObtenerInt() {
		Scanner S = new Scanner(System.in);
		return S.nextInt();
	}
	public static double ObtenerDouble() {
		Scanner S = new Scanner(System.in);
		return S.nextDouble();
	}

}
