package Simulacion;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

public class Diana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JpLienzo Lienzo;
	private int NDardos;
	private double Resultado;
	private JLabel Respuesta;
	public Diana() {
		setLayout(new BorderLayout());
		setSize(800, 700);
		setLocationRelativeTo(null);
		Lienzo = new JpLienzo(true);
		add(Lienzo, BorderLayout.CENTER);
		Respuesta = new JLabel("PI = 0");
		add(Respuesta, BorderLayout.SOUTH);
	}
	public void CalcularResultado() {
		Resultado = (((double)(Lienzo.getAciertos())/(double)(NDardos))*4.0);
	}
	public void Resultado() {
		CalcularResultado();
		Respuesta.setText("PI = " + Resultado);
	}
	public void Inicio() {
		int N  = 0;
		boolean C = true;
		do {
			try {
				N = Integer.parseInt(JOptionPane.showInputDialog("Escribe cuantos dardos arrojaras"));
				C = false;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Escribe solo numeros");
			}
		}while(C);
		setNDardos(N);
		TDiana();
		JFreeChart lineChart = ChartFactory.createLineChart(
                "Calculo de PI",
                "Dardos",
                "PI",
                Lienzo.getdataset2(),
                PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(lineChart);
		JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panel);
	}
	public void setNDardos(int D) {
		NDardos = D;
	}
	public void TDiana() {
		for(int x = 0; x<NDardos; x++) {
			Lienzo.PintarDardo();
		}
		Resultado();
	}

}
