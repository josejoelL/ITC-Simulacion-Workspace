package Simulacion;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

public class AgujaDelBufon extends JFrame {
	private int NAgujas; 
	private double PI;
	private JLabel Resultado;
	private JpLienzo Lienzo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AgujaDelBufon() {
		setLayout(new BorderLayout());
		setSize(800, 700);
		setLocationRelativeTo(null);
		Lienzo = new JpLienzo();
		add(Lienzo, BorderLayout.CENTER);
		Resultado = new JLabel("PI = 0");
		add(Resultado, BorderLayout.SOUTH);
		
	}
	public void setNAgujas(int A) {
		NAgujas = A;
	}
	public void Tablero() {
		for(int i = 0; i<NAgujas; i++) {
			Lienzo.PintarAguja();
		}
		Aciertos();
		JFreeChart lineChart = ChartFactory.createLineChart(
                "Calculo de PI",
                "Agujas",
                "PI",
                Lienzo.getdataset(),
                PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(lineChart);
		JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panel);
	}
	public void Aciertos() {
		PI = ((2.0*(double)(NAgujas))/((double)(Lienzo.getAciertos())));
		Resultado.setText("PI = " + PI);
	}
	public void Inicio() {
		int N  = 0;
		boolean C = true;
		do {
			try {
				N = Integer.parseInt(JOptionPane.showInputDialog("Escribe cuantas agujas arrojaras"));
				C = false;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Escribe solo numeros");
			}
		}while(C);
		setNAgujas(N);
		Tablero();
	}
}
