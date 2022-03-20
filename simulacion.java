package Simulacion;

import java.util.Scanner;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class simulacion {
	public static void main(String args[]) {
		double M, C, G = 9.81, V=0, V2=0;
		boolean Constante = false;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		System.out.println("Escribe cual es la masa (KG): ");
		M = PedirDouble();
		System.out.println("Escribe cual es la constante: ");
		C = PedirDouble();
		System.out.println("T | V (m/Seg)");
		System.out.println("----------------------------------");
		for(int T = 0; !Constante;T++) {
			V = Resultado(M,G,C,T);
			if(V2 == V && T != 0) {
				Constante = true;
				JFreeChart lineChart = ChartFactory.createLineChart(
                        "Velocidad de caida",
                        "tiempo",
                        "velocidad",
                        dataset,
                        PlotOrientation.VERTICAL, true, true, false);
				ChartPanel panel = new ChartPanel(lineChart);
				JFrame ventana = new JFrame("Grafica");
                ventana.setVisible(true);
                ventana.setSize(800, 600);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventana.add(panel);
			}else {
				System.out.println(T + " | " + V);
				dataset.addValue(V, "velocidad-tiempo",T+"" );
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
