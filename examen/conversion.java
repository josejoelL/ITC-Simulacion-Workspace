package conversiones;

import java.util.Scanner;

import programashechosduranteelcursodeasesoriasdepoo.Clientes;
import programashechosduranteelcursodeasesoriasdepoo.Mesas;

public class conversion {
	
	static Scanner S=new Scanner(System.in);
	
	public static void main(String[] args) {
		do {
			switch( MostrarMenu() ) {
			case 1:
				break;
			case 2:
				break;
			case 3: 
				break;
			case 4: 
				break;
			}
		
		}while(true);

	}

	public static int MostrarMenu() {
		System.out.println("1-. Binario");
		System.out.println("2-. Decimal");
		System.out.println("3-.Octal");
		System.out.println("4-.Hexadecimal");
		System.out.print("Opción: ");
		return S.nextInt();
	}

}
