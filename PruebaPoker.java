package Simulacion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PruebaPoker {
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
			
			}
		
		for(int x=0;x<=n-1;x++) {
			int con1=0, con2=0, con3=0, con4=0, con5=0, con6=0, con7=0, con8=0, con9=0, con0=0;
			int xx=2,yy=3;
			String p=(Ran.get(x));
			
			for(int y=0;y<=4;y++) {
			
				String ps=p.substring(xx,yy);
				
				if(ps.equals("1")) {con1=con1+1;}
				else if(ps.equals("2")){con2=con2+1;}
				else if(ps.equals("3")){con3=con3+1;}
				else if(ps.equals("4")){con4=con4+1;}
				else if(ps.equals("5")){con5=con5+1;}
				else if(ps.equals("6")){con6=con6+1;}
				else if(ps.equals("7")){con7=con7+1;}
				else if(ps.equals("8")){con8=con8+1;}
				else if(ps.equals("9")){con9=con9+1;}
				else if(ps.equals("0")){con0=con0+1;}
				
				
				xx=xx+1;
				yy=yy+1;		
			}
			Poker.add(EventoPokar(con1,con2,con3,con4,con5,con6,con7,con8,con9,con0));
		    if(Poker.get(x).equals("Quintilla")){qui=qui+1;}
		    else if(Poker.get(x).equals("Poker")){pok=pok+1;}
		    else if(Poker.get(x).equals("Full")){ful=ful+1;}
		    else if(Poker.get(x).equals("Dos Pares")){dpar=dpar+1;}
		    else if(Poker.get(x).equals("Tercia")){ter=ter+1;}
		    else if(Poker.get(x).equals("Par")){par=par+1;}
		    else if(Poker.get(x).equals("Pachuca")){pac=pac+1;}
	
			
		}
		System.out.println("");
		System.out.println("Sacar los tipos de eventos: ");
		System.out.println("__________________________");
		System.out.println(" " +"n  " + " | " + "  ri   " + " | " +"evento "+ "" );
		for(int i=0;i<=n-1;i++) {
			System.out.println(" " +(i+1)+" " + " | " + Ran.get(i) + " | " + Poker.get(i) + "" );
		}
		System.out.println("__________________________");

		System.out.println("");
		System.out.println("");
		System.out.println("Sacar chi cuadrada: ");
		System.out.println("______________________________________________________");
		System.out.println(" " +"evento    " + " | " + "FO   " + " | " +"PE    "+ "  | "+"FE     "+" | "+"(FO-FE)^2/FE" );
		
	    System.out.println(" " +"Pachuca   "+ " | " +pac+"    "+ " | " +f1.format(0.3024)+ " | "+f1.format(0.3024*n)+" | "+f1.format((Math.pow((pac-(0.3024*n)),2))/(0.3024*n)) );
	    System.out.println(" " +"Par       "+ " | " +par+"    "+ " | " +f1.format(0.5040)+ " | "+f1.format(0.5040*n)+" | "+f1.format((Math.pow((par-(0.5040*n)),2))/(0.5040*n)) );
	    System.out.println(" " +"Tercia    "+ " | " +ter+"    "+ " | " +f1.format(0.0720)+ " | "+f1.format(0.0720*n)+" | "+f1.format((Math.pow((ter-(0.0720*n)),2))/(0.0720*n)) );
	    System.out.println(" " +"Dos Pares "+ " | " +dpar+"    "+ " | " +f1.format(0.1080)+ " | "+f1.format(0.1080*n)+" | "+f1.format((Math.pow((dpar-(0.1080*n)),2))/(0.1080*n)) );
	    System.out.println(" " +"Full      "+ " | " +ful+"    "+ " | " +f1.format(0.0090)+ " | "+f1.format(0.0090*n)+" | "+f1.format((Math.pow((ful-(0.0090*n)),2))/(0.0090*n)) );
	    System.out.println(" " +"Poker     "+ " | " +pok+"    "+ " | " +f1.format(0.0045)+ " | "+f1.format(0.0045*n)+" | "+f1.format((Math.pow((pok-(0.0045*n)),2))/(0.0045*n)) );
	    System.out.println(" " +"Quintilla "+ " | " +qui+"    "+ " | " +f1.format(0.0001)+ " | "+f1.format(0.0001*n)+" | "+f1.format((Math.pow((qui-(0.0001*n)),2))/(0.0001*n)) );
	    double fina=((Math.pow((pac-(0.3024*n)),2))/(0.3024*n))+
	    		((Math.pow((par-(0.5040*n)),2))/(0.5040*n))+
	    		((Math.pow((ter-(0.0720*n)),2))/(0.0720*n))+
	    		((Math.pow((dpar-(0.1080*n)),2))/(0.1080*n))+
	    		((Math.pow((ful-(0.0090*n)),2))/(0.0090*n))+
	    		((Math.pow((pok-(0.0045*n)),2))/(0.0045*n))+
	    		((Math.pow((qui-(0.0001*n)),2))/(0.0001*n));
	    System.out.println(" " +"Totales   " + " | " + n+"    " + " | " +"      "+ "  | "+"E=     "+" | "+f1.format(fina) );
		
		System.out.println("______________________________________________________");
		System.out.println("");
		
		if(fina<=chi) {System.out.println("Entonces los numeros son independientes");}
		else {System.out.println("Entonces los numeros no son independientes");}
		
		
		
		
	}
	
	public static String EventoPokar(int conn1, int conn2, int conn3, int conn4, int conn5, int conn6, int conn7, int conn8, int conn9, int conn0) {
		int con1=conn1;
		int con2=conn2;
		int con3=conn3;
	    int con4=conn4;
	    int con5=conn5;
	    int con6=conn6;
	    int con7=conn7;
	    int con8=conn8;
	    int con9=conn9;
	    int con0=conn0;
	    
	    if(con1==5 || con2==5 || con3==5 || con4==5 || con5==5 || con6==5 || con7==5 || con8==5 || con9==5 || con0==5 ) {
			return "Quintilla";
		}
		else if(con1==4 || con2==4 || con3==4 || con4==4 || con5==4 || con6==4 || con7==4 || con8==4 || con9==4 || con0==4) {
			return "Poker";
		}
		else if(con1==3 && con2==2 || con1==3 && con3==2 || con1==3 && con4==2 || con1==3 && con5==2 || con1==3 && con6==2 || con1==3 && con7==2
				|| con1==3 && con8==2 || con1==3 && con9==2 || con1==3 && con0==2) {
			return "Full";
		}
		else if(con2==3 && con1==2 || con2==3 && con3==2 || con2==3 && con4==2 || con2==3 && con5==2 || con2==3 && con6==2 || con2==3 && con7==2
				|| con2==3 && con8==2 || con2==3 && con9==2 || con2==3 && con0==2) {
			return "Full";
		}
		else if(con3==3 && con2==2 || con3==3 && con1==2 || con3==3 && con4==2 || con3==3 && con5==2 || con3==3 && con6==2 || con3==3 && con7==2
				|| con3==3 && con8==2 || con3==3 && con9==2 || con3==3 && con0==2) {
			return "Full";
		}
		else if(con4==3 && con2==2 || con4==3 && con3==2 || con4==3 && con1==2 || con4==3 && con5==2 || con4==3 && con6==2 || con4==3 && con7==2
				|| con4==3 && con8==2 || con4==3 && con9==2 || con4==3 && con0==2) {
			return "Full";
		}
		else if(con5==3 && con2==2 || con5==3 && con3==2 || con5==3 && con4==2 || con5==3 && con1==2 || con5==3 && con6==2 || con5==3 && con7==2
				|| con5==3 && con8==2 || con5==3 && con9==2 || con5==3 && con0==2) {
			return "Full";
		}
		else if(con6==3 && con2==2 || con6==3 && con3==2 || con6==3 && con4==2 || con6==3 && con5==2 || con6==3 && con1==2 || con6==3 && con7==2
				|| con6==3 && con8==2 || con6==3 && con9==2 || con6==3 && con0==2) {
			return "Full";
		}
		else if(con7==3 && con2==2 || con7==3 && con3==2 || con7==3 && con4==2 || con7==3 && con5==2 || con7==3 && con6==2 || con7==3 && con1==2
				|| con7==3 && con8==2 || con7==3 && con9==2 || con7==3 && con0==2) {
			return "Full";
		}
		else if(con8==3 && con2==2 || con8==3 && con3==2 || con8==3 && con4==2 || con8==3 && con5==2 || con8==3 && con6==2 || con8==3 && con7==2
				|| con8==3 && con1==2 || con8==3 && con9==2 || con8==3 && con0==2) {
			return "Full";
		}
		else if(con8==3 && con2==2 || con8==3 && con3==2 || con8==3 && con4==2 || con8==3 && con5==2 || con8==3 && con6==2 || con8==3 && con7==2
				|| con8==3 && con1==2 || con8==3 && con9==2 || con8==3 && con0==2) {
			return "Full";
		}
		else if(con9==3 && con2==2 || con9==3 && con3==2 || con9==3 && con4==2 || con9==3 && con5==2 || con9==3 && con6==2 || con9==3 && con7==2
				|| con9==3 && con8==2 || con9==3 && con1==2 || con9==3 && con0==2) {
			return "Full";
		}
		else if(con0==3 && con2==2 || con0==3 && con3==2 || con0==3 && con4==2 || con0==3 && con5==2 || con0==3 && con6==2 || con0==3 && con7==2
				|| con0==3 && con8==2 || con0==3 && con9==2 || con0==3 && con1==2) {
			return "Full";
		}
		else if(con1==2 && con2==2 || con1==2 && con3==2 || con1==2 && con4==2 || con1==2 && con5==2 || con1==2 && con6==2 || con1==2 && con7==2
				|| con1==2 && con8==2 || con1==2 && con9==2 || con1==2 && con0==2) {
			return "Dos Pares";
		}
		else if(con2==2 && con3==2 || con2==2 && con4==2 || con2==2 && con5==2 || con2==2 && con6==2 || con2==2 && con7==2
				|| con2==2 && con8==2 || con2==2 && con9==2 || con2==2 && con0==2) {
			return "Dos Pares";
		}
		else if(con3==2 && con4==2 || con3==2 && con5==2 || con3==2 && con6==2 || con3==2 && con7==2 || con3==2 && con8==2 
				|| con3==2 && con9==2 || con3==2 && con0==2) {
			return "Dos Pares";
		}
		else if( con4==2 && con5==2 || con4==2 && con6==2 || con4==2 && con7==2 || con4==2 && con8==2 || con4==2 && con9==2 
				|| con4==2 && con0==2) {
			return "Dos Pares";
		}
		else if(con5==2 && con6==2 || con5==2 && con7==2 || con5==2 && con8==2 || con5==2 && con9==2 || con5==2 && con0==2) {
			return "Dos Pares";
		}
		else if(con6==2 && con7==2 || con6==2 && con8==2 || con6==2 && con9==2 || con6==2 && con0==2) {
			return "Dos Pares";
		}
		else if(con7==2 && con8==2 || con7==2 && con9==2 || con7==2 && con0==2) {
			return "Dos Pares";
		}
		else if(con8==2 && con9==2 || con8==2 && con0==2 || con9==2 && con0==2) {
			return "Dos Pares";
		}
		else if(con1==3 || con2==3 || con3==3 || con4==3 || con5==3 || con6==3 || con7==3 || con8==3 || con9==3 || con0==3) {
			return "Tercia";
		}
		else if(con1==2 || con2==2 || con3==2 || con4==2 || con5==2 || con6==2 || con7==2 || con8==2 || con9==2 || con0==2) {
			return "Par";
		}
		else {return "Pachuca";}
	}

}
