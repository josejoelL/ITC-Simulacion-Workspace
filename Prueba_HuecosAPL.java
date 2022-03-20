package Simulacion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Prueba_HuecosAPL {

	public static void main(String[] args) {
		Random R=new Random();
		DecimalFormat f1=new DecimalFormat("####0.00000");
		Scanner Leer=new Scanner(System.in);
		ArrayList <Double> NR=new ArrayList<Double>();
		ArrayList <String> Ran=new ArrayList<String>();
		ArrayList <String> Poker=new ArrayList<String>();
		int qui=0, pok=0, ful=0, dpar=0, ter=0, par=0, pac=0, n=0, error=0;
		boolean f=false, d=false;
		double chi=0;
		do {
		System.out.println("cuantos numeros random se usaran (30 o mas): ");
		n=Leer.nextInt();
		if(n>=30) {f=true;}
		System.out.println("de cuanto sera el error (5 o 10 porciento): ");
		error=Leer.nextInt();
		System.out.println("");
		if(error==5 || error==10) {d=true;}
		}while(f==false || d==false);
		
		if(error==5) {chi=12.5916;}
		else {chi=10.6446;}
		
		for(int i=0;i<=n-1;i++) {
			NR.add(R.nextDouble());
		}
		
		for(int x=0;x<=n-1;x++) {
			String p=String.valueOf(NR.get(x));
			String ps=p.substring(0,7);
			Ran.add(ps);
			
			
			System.out.print(x+1+"- ");
			System.out.println(Ran.get(x));
			
			}Prueba_Huecos ph=new Prueba_Huecos(NR, error);ph.Tabla1();ph.Tabla2();
	}
			
}	
