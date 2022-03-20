package Simulacion;
import java.util.Scanner;
public class T03 {

	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		int C = 0;
		do {
			System.out.println("Escribe una opcion (1. Cuadrados | 2. Newman)");
			C = S.nextInt();
		}while(C < 1 || C > 2);
		if(C == 1) {
			T03A.main(args);
		}
		if(C == 2) {
			T03B.main(args);
		}
		
	}

}
