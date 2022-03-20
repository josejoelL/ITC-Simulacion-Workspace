package Simulacion;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
public class T01U01 {
	public static void main(String args[]) {
		double M, C, G = 9.81, V=0, V2=0;
		boolean Constante = false;
		System.out.println("Escribe cual es la masa (KG)");
		M = PedirDouble();
		System.out.println("Escribe cual es la constante");
		C = PedirDouble();
		System.out.println("T | V (m/Seg)");
		System.out.println("----------------------------------");
		for(int T = 0; !Constante;T++) {
			V = Resultado(M,G,C,T);
			if(V2 == V && T != 0) {
				Constante = true;
			}else {
				System.out.println(T + " | " + V);
				V2 = V;
			}			
		}
	}
	public static double PedirDouble() {
		Scanner S = new Scanner(System.in);
		return S.nextDouble();
	}
	public static double Resultado(double M, double G, double C, double T) {
		return ((G*M)/C)*(1-Math.pow(Math.E,-(C/M)*T));
	}
}
