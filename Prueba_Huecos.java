package Simulacion;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Prueba_Huecos {
	private ArrayList tabla;
	private double pf;// <--porcentaje de fallo podriamos manejar un booleano tambien

	// RandomAccessFile tchi=new RandomAccessFile("chicuadrado.dat","rw");
	ArrayList <Integer> tam=new ArrayList<Integer>();
	private double B, T, A,sumOI;
	
	private	boolean E;
	private	int i[];
	private	boolean ch;	//<--si es independiente o no
	private	int suma=0;
	private	int aux=0;
	public Prueba_Huecos(ArrayList tabla, double pf) {
		super();
		this.tabla = tabla;
		this.pf = pf;
		A=0.3;
		B=0.6;
		T=B-A;
	}


	public Prueba_Huecos(ArrayList tabla, double pf, double b, double t, double a) {
		this.tabla = tabla;
		this.pf = pf;
		B = b;
		T = t;
		A = a;
		
	}
	public void Tabla1() {
		
		System.out.println("____________________________");
		System.out.println("|n       | ui      | E | I |");
		System.out.println("|________|_________|___|___|");
		for (int x = 0; x < tabla.size(); x++) {
			
	//		System.out.println((x+1)+"\t"+tabla.get(x)+"\t"+hueco((Double) tabla.get(x))+"\t"+i(	hueco((Double) tabla.get(x))		,(x+1)==tabla.size()?2 :	hueco((Double) tabla.get(x+1)) )	);
		System.out.printf("|n.%d\t | %.5f | %s | %s |\n",
			x+1,
			tabla.get(x),
			hueco((Double) tabla.get(x)),
			i(	hueco((Double) tabla.get(x)),
			(x+1)==tabla.size()?2 :	hueco((Double) tabla.get(x+1)) ));
		}
		System.out.println("|________|_________|___|___|");
	
	}
private int hueco(Double n) {	return n>=A && n<=B?1:0 ;		}


private String i(int n,int n2) {
	 aux=0;
	 
		if (n==0) {
			 suma++;
			 if (n2==1) {
				 aux=suma;
				 suma=0;
				 tam.add(aux);	
				return aux+"";
			}
			 if (n2==2) {
				 aux=suma;
				 suma=0;
				 tam.add(aux);
				return aux+"";
			 }
			 return " " ;
		}
		if (n==1) {
			 if (n2==1) {
					return " ";
				}
			 if (n2==2) {
				 tam.add(0);
					return "0";
				}
			 tam.add(0);
			 return "0";
		}
		return "";
		
	
	}

	
	public void Tabla2() {
		System.out.println(" \n");
		i=new int[tam.size()];
		int	aux2=0;
		int aux= 0;
	
		//este para guardar las frecuencias en un solo arreglo 
		for (int y = 0; y < tam.size(); y++) {
			aux = 0;
			//System.out.print(tam.get(y)+", ");
			
			for (int x = 0; x < tam.size(); x++) {
				if (y==tam.get(x)) {
					aux++;

				}
			
		}
		i[y]=aux;
	}
		System.out.println("  ");
		boolean band=false;
	
	//este para allar el valor max que podra tener i
			for (int z = 0;z < i.length; z++) {
				if (i[z]==0) {
					aux2=z;
					break;
					
				}
			
			//	System.out.println(z+ " "+i[z]);
			}

//este es la tabla


double	sumPI=0;
double	sumOI=tam.size();
double	sumEI=0;
double	sumCHI=0;


System.out.println("__________________________________________________________________");
System.out.println("|   |    |      |                |               |       2       |");
System.out.println("|   |    |      |                |               | (Oi-Ei)       |");
System.out.println("| i | Pi | Oi   | Ei             | Oi-Ei         |_________      |");
System.out.println("|   |    |      |                |               |    Ei         |");
System.out.println("|___|____|______|________________|_______________|_______________|");


	for (int j = 0; j <= aux2; j++) {
		/*
		System.out.println(j+
				"\t\t"+PI(j,j==aux2?true:false)+
				"\t\t"+OI(j,j==aux2?true:false)+
				"\t\t"+EI(PI(j,j==aux2?true:false))+
				"\t\t"+DIFERENCIA(OI(j,j==aux2?true:false),EI(PI(j,j==aux2?true:false)))+		
				"\t\t"+CHI(DIFERENCIA(OI(j,j==aux2?true:false),EI(PI(j,j==aux2?true:false)))	,EI(PI(j,j==aux2?true:false)))
				);	
		*/
	
System.out.printf("|%d  |%.2f|%.0f\t|%.5f\t |%.5f\t |%.5f\t |		\n",
		j,
		PI(j,j==aux2?true:false),
		OI(j,j==aux2?true:false),
		EI(PI(j,j==aux2?true:false)),
		DIFERENCIA(OI(j,j==aux2?true:false),EI(PI(j,j==aux2?true:false))),
		CHI(DIFERENCIA(OI(j,j==aux2?true:false),EI(PI(j,j==aux2?true:false)))	,EI(PI(j,j==aux2?true:false)))
		);
			
	sumPI+=PI(j,j==aux2?true:false);
		
		sumEI+=EI(PI(j,j==aux2?true:false));
		sumCHI+=CHI(DIFERENCIA(OI(j,j==aux2?true:false),EI(PI(j,j==aux2?true:false)))	,EI(PI(j,j==aux2?true:false)));
	
		
	
	
	
	
	}
	System.out.println("|___|____|______|________________|_______________|_______________|");
	System.out.printf( "|suma de Pi:%.0f   |suma de Oi:%.0f   |suma de Ei:%.0f  |suma de CHI:   |\n",
			sumPI,
			sumOI,
			sumEI,
			sumCHI
			);
	 System.out.printf("|               |                |               |%.5f\t |\n",sumCHI);
	System.out.print("|_______________|________________|_______________|_______________|");

	
	if( sumCHI<= calcCHI(aux2) ){
	
	
	System.out.print("<-- es <= que "+calcCHI(aux2));
	System.out.print ("  por lo tanto son numeros independientes \n");
	
	}else {
		System.out.println(sumCHI+"No es <= que "+calcCHI(aux2));
		System.out.println("por lo tanto No son numeros independiente");
	}
	
	}
	private double calcCHI(int aux2) {
		
	double [][] Tchi= {
	{},{},{},{},{},		
	{3.8415,5.9915,7.8147,9.4877,11.0705,12.5916,14.0671,15.5073,16.9190,18.3070},
	{},{},{},{},		
	{2.7055,4.6052,6.2514,7.7794,9.2363,10.6446,12.0170,13.3616,14.6837,15.9872	}				
	};
	// System.out.println(Tchi.length+ " "+Tchi[5].length );
	//mis i no caben en los en espacio 0
	if (pf==5) {
		return Tchi[5][aux2-1];
	}
	if (pf==10) {
		return Tchi[10][aux2-1];
	}	
	return 0;
	}


	private double CHI(double DIFERENCIA, double EI) {
		
		return Math.pow(DIFERENCIA,2)/EI;
	}
	private double DIFERENCIA(double OI, double EI) {
		
		return OI-EI;
	}
	private double EI(double PI) {
		return PI*tam.size() ;
		
	}
	private double OI(int j,boolean fin) {
		
		if (fin) {
		int sum=0;
			for (int k = j; k < i.length; k++) {
				sum+=i[k];
			}
			return sum;
		}
		
		return i[j] ;
		
	}	
	private double PI(int i,boolean fin) {
		if (i==0) {
		return T;
		}
		
		if (fin) {
		return Math.pow((1-T), i);
		}
		
		return Math.pow((1-T), i)*T;
		
	}

}
