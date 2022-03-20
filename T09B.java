package Simulacion;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import java.util.ArrayList;
import java.util.Random;
public class T09B extends JFrame{
	private int NV, CE;
	private ArrayList<Double> NG;
	private ArrayList<Integer> x, y;
	private ArrayList<ArrayList> A;
	public T09B() {
		setSize(640,680);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		PreguntarVeces();
		CE = 0;
		A = new ArrayList<ArrayList>();
		JpLienzoB Lienzo = new JpLienzoB();
		for(int x = 0; x<NV; x++) {
			this.x = new ArrayList<Integer>();
			y = new ArrayList<Integer>();
			NG = new ArrayList<Double>();
			GenerarNumeros();
			Caminar();
			for(int y = 0; y<10; y++) {
				if(y != 0) {
					Lienzo.setX(this.x.get(y-1));
					Lienzo.setY((this.y.get(y-1)*-1));
				}
				else {
					Lienzo.setX(0);
					Lienzo.setY(0);
				}
				Lienzo.Pintar(this.x.get(y), (this.y.get(y)*-1));
				if(y == 9) {
					Lienzo.addContenido(this.x.get(y), (this.y.get(y)*-1));
				}
			}
			A.add(NG);
			A.add(this.x);
			A.add(y);
			JOptionPane.showMessageDialog(this, "El borracho #" + (x+1) + " ha terminado de caminar");
			JOptionPane.showMessageDialog(this, (this.x.get(9)>=1)?"El borracho " +(x+1) + " termino en la parte este" : "El borracho " + (x+1) + " termino en otra parte");
			CE = this.x.get(9)>=1?(CE+1):(CE);
		}
		add(Lienzo, BorderLayout.CENTER);
		setVisible(true);
		ProbabilidadDeEste();
		JPanel PN = new JPanel(), PS = new JPanel();
		PN.add(new JLabel("N"));
		PS.add(new JLabel("S"));
		add(PN, BorderLayout.NORTH);
		add(PS, BorderLayout.SOUTH);
		add(new JLabel("E"), BorderLayout.EAST);
		add(new JLabel("O"), BorderLayout.WEST);
		setVisible(true);
	}
	public void PreguntarVeces() {
		boolean C = false;
		do {
			try {
				NV = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuantos borracho saldran a caminar"));
				C = true;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Solo ingrese numeros enteros");
			}
		}while(!C);
	}
	public void GenerarNumeros() {
		Random R = new Random();
		for(int x = 0; x<10; x++) {
			NG.add(R.nextDouble());
		}
	}
	public void Caminar() {
		for(int x =0 ; x<10; x++) {
			if(x == 0) {
				this.x.add(0);
				y.add(0);
			}
			else {
				this.x.add(this.x.get(x-1));
				y.add(y.get(x-1));
			}
			if(NG.get(x) <= 0.25) {
				this.y.set(x, this.y.get(x)+CaminarNorte());
			}
			if(NG.get(x) > 0.25 && NG.get(x) <= 0.50) {
				this.y.set(x, this.y.get(x)+CaminarSur());
			}
			if(NG.get(x) > 0.50 && NG.get(x) <= 0.75) {
				this.x.set(x, this.x.get(x)+CaminarEste());
			}
			if(NG.get(x) > 0.75 && NG.get(x) <= 1) {
				this.x.set(x, this.x.get(x)+CaminarOeste());
			}
		}
	}
	public void ProbabilidadDeEste() {
		JOptionPane.showMessageDialog(this, "La probabilidad de llegar al este es de " + (CE/(double)(NV)));
	}
	public int CaminarNorte() {
		return 1;
	}
	public int CaminarSur() {
		return -1;
	}
	public int CaminarEste() {
		return 1;
	}
	public int CaminarOeste() {
		return -1;
	}
	public ArrayList<ArrayList> getBorrachos(){
		return A;
	}
}
