package Simulacion;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.util.Random;

public class T07B extends JFrame {
	private ArrayList <Double> NG;
	private int C, N;
	private ArrayList <Integer> V;
	public T07B() {
		NG = new ArrayList<Double>();
		V = new ArrayList<Integer>();
		setLayout(new BorderLayout());
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		N();
		Comprados();
		GenerarValores();
	}
	private void N() {
		boolean C = false;
		do {
			try {
				N = Integer.parseInt(JOptionPane.showInputDialog(this, "Escribe cuantas veces se simulara"));
				C = true;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Solo introduce un numero entero");
			}
		}while(!C);
	}
	private void Comprados() {
		boolean C = false;
		do {
			try {
				this.C = Integer.parseInt(JOptionPane.showInputDialog(this, "¿Cual fue la cantidad de telefonos comprados? (100, 150, 200, 250, 300)"));
				if (this.C == 100 || this.C == 150 || this.C == 200 || this.C == 250 || this.C == 300) {
					C = true;
				}
				else {
					JOptionPane.showMessageDialog(this, "Solo solo puedes introducir 100, 150, 200, 250 o 300");
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Solo introduce un numero entero");
			}
		}while(!C);
	}
	private void GenerarValores() {
		Random R = new Random();
		int VV[] = new int[5];
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(int x = 0; x < N; x++) {
			NG.add(R.nextDouble());
			if((NG.get(x) >= 0 && NG.get(x) < 0.3) || (NG.get(x) >= 0.3 && C == 100)) {
				V.add(100);
				VV[0]++;
			}
			if((NG.get(x) >= 0.3 && NG.get(x) < 0.5) || (NG.get(x) >= 0.5 && C == 150)) {
				V.add(150);
				VV[1]++;
			}
			if((NG.get(x) >= 0.5 && NG.get(x) < 0.8) || (NG.get(x) >= 0.8 && C == 200)) {
				V.add(200);
				VV[2]++;
			}
			if((NG.get(x) >= 0.8 && NG.get(x) < 0.95) || (NG.get(x) >= 0.95 && C == 250)) {
				V.add(250);
				VV[3]++;
			}
			if(NG.get(x) >= 0.95 && NG.get(x) <= 1 && C == 300) {
				V.add(300);
				VV[4]++;
			}
		}
		if(VV[0] != 0) {
			dataset.setValue("100 Vendidos", VV[0]);
		}
		if(VV[1] != 0) {
			dataset.setValue("150 Vendidos", VV[1]);
		}
		if(VV[2] != 0) {
			dataset.setValue("200 Vendidos", VV[2]);
		}
		if(VV[3] != 0) {
			dataset.setValue("250 Vendidos", VV[3]);
		}
		if(VV[4] != 0) {
			dataset.setValue("300 Vendidos", VV[4]);
		}
		JFreeChart lineChart = ChartFactory.createPieChart(
                "Celulares vendidos",
                dataset,
                true, true, false);
		ChartPanel panel = new ChartPanel(lineChart);
		add(panel);
		setVisible(true);
	}
	public int getN() {
		return N;
	}
	public ArrayList<Integer> getV(){
		return V;
	}
	public ArrayList<Double> getNG(){
		return NG;
	}
	public int getC() {
		return C;
	}
	
}
