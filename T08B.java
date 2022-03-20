package Simulacion;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class T08B extends JFrame {
	private int PR, G;
	private double P;
	private ArrayList <Double> PA, NG;
	private ArrayList<Integer> ZR, C;
	private DefaultPieDataset dataset;
	public T08B(){
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		ConstruirRuleta();
		MostrarRuleta();
		DeterminarProbabilidad();
		DeterminarLanzamientos();
		Lanzamientos();
		MostrarResultados();
		GirarRuleta();
	}
	public void ConstruirRuleta() {
		boolean C = false;
		do {
			try {
				PR = Integer.parseInt(JOptionPane.showInputDialog(this, "¿Cuantas partes tendra la ruleta?"));
				C = true;
			}catch(Exception E) {
				JOptionPane.showMessageDialog(this, "Solo puedes ingresar numeros enteros");
			}
		}while(!C);
	}
	public void MostrarRuleta() {
		DefaultPieDataset Dataset = new DefaultPieDataset();
		for(int x = 1; x<=PR; x++)
			Dataset.setValue(x+"",1);
		JFrame JF = new JFrame();
		JFreeChart lineChart = ChartFactory.createPieChart(
                "Ruleta",
                Dataset,
                true, true, false);
		ChartPanel panel = new ChartPanel(lineChart);
		JF.setSize(800,600);
		JF.add(panel);
		JF.setVisible(true);
	}
	public void DeterminarProbabilidad() {
		P = 1 / ((double)(PR));
		PA = new ArrayList <Double>();
		for(int x = 1; x<=PR; x++) {
			PA.add((P*x));
		}
	}
	public void DeterminarLanzamientos() {
		boolean C = false;
		do {
			try {
				G = Integer.parseInt(JOptionPane.showInputDialog(this, "¿Cuantas veces girara la ruleta?"));
				C = true;
			}catch(Exception E) {
				JOptionPane.showMessageDialog(this, "Solo puedes ingresar numeros enteros");
			}
		}while(!C);
	}public void Lanzamientos() {
		Random R = new Random();
		dataset = new DefaultPieDataset();
		ZR = new ArrayList<Integer>();
		C = new ArrayList<Integer>();
		NG = new ArrayList<Double>();
		for(int x = 0; x<PR; x++) {
			C.add(0);
		}
		for(int x = 0; x<G; x++) {
			NG.add(R.nextDouble());
			for(int y = 0; y<PA.size(); y++) {
				if(NG.get(x)<PA.get(y)) {
					ZR.add(y+1);
					C.set((y),C.get(y)+1);
					break;
				}
			}
		}
		for(int x = 0; x<C.size(); x++) {
			if(C.get(x) != 0) {
				dataset.setValue("Seccion " + (x+1) , C.get(x));
			}
		}
	}
	public void MostrarResultados() {
		JFreeChart lineChart = ChartFactory.createPieChart(
                "Resultados",
                dataset,
                true, true, false);
		ChartPanel panel = new ChartPanel(lineChart);
		add(panel);
		setVisible(true);
	}
	public void GirarRuleta() {
		
	}
	
	public ArrayList<Double> getNG(){
		return NG;
	}
	public ArrayList<Integer> getZR(){
		return ZR;
	}
}
