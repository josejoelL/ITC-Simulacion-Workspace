package Simulacion;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class T06B extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int N;
	private ArrayList<Double> Resultado;
	private ArrayList<Integer> Consultas;
	private DefaultPieDataset dataset;
	public T06B() {
		Resultado = new ArrayList<Double>();
		Consultas = new ArrayList<Integer>();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(800,600);
		boolean C = false;
		do{
			try {
				N = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el numero de dias"));
				C = true;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Solo ingresa numeros enteros");
			}
		}while(!C);
		Calcular();
	}
	public void Calcular() {
		dataset = new DefaultPieDataset();
		int C0 = 0, C1 = 0, C2 = 0, C3 = 0, C4 = 0, C5 = 0;
		Random R = new Random();
		for(int x = 0; x<N; x++) {
			Resultado.add(R.nextDouble());
			if(Resultado.get(x) >= 0 && Resultado.get(x) < 0.05) {
				Consultas.add(0);
				C0++;
			}
			if(Resultado.get(x) >= 0.05 && Resultado.get(x) < 0.15) {
				Consultas.add(1);
				C1++;
			}
			if(Resultado.get(x) >= 0.15 && Resultado.get(x) < 0.35) {
				Consultas.add(2);
				C2++;	
			}
			if(Resultado.get(x) >= 0.35 && Resultado.get(x) < 0.65) {
				Consultas.add(3);
				C3++;
			}
			if(Resultado.get(x) >= 0.65 && Resultado.get(x) < 0.85) {
				Consultas.add(4);
				C4++;
			}
			if(Resultado.get(x) >= 0.85 && Resultado.get(x) <= 1) {
				Consultas.add(5);
				C5++;
			}
		}
		if(C0 != 0) {
			dataset.setValue("0 Consultas", C0);
		}
		if(C1 != 0) {
			dataset.setValue("1 Consulta", C1);
		}
		if(C2 != 0) {
			dataset.setValue("2 Consultas", C2);
		}
		if(C3 != 0) {
			dataset.setValue("3 Consultas", C3);
		}
		if(C4 != 0) {
			dataset.setValue("4 Consultas", C4);
		}
		if(C5 != 0) {
			dataset.setValue("5 Consultas", C5);
		}
		JFreeChart lineChart = ChartFactory.createPieChart(
                "Consultas",
                dataset,
                true, true, false);
		ChartPanel panel = new ChartPanel(lineChart);
		add(panel);
		setVisible(true);
	}
	public ArrayList<Integer> getConsultas() {
		return Consultas;
	}
	public ArrayList<Double> getResultado(){
		return Resultado;
	}
	public DefaultPieDataset getDataset() {
		return dataset;
	}
}
