package Simulacion;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Carta extends ImageIcon{
	private String S;
	private int N;
	private boolean E;
	public Carta() {
		super();
	}
	public Carta(int S, int N) {
		super("Imagenes" + File.separator + "0" + "-" + "0(1)" + ".png");
		switch (S) {
		case 1:
			this.S = "Bastos";
			break;
		case 2:
			this.S = "Espadas";
			break;
		case 3:
			this.S = "Copas";
			break;
		case 4:
			this.S = "Oros";
			break;
		}
		this.N = N;
		E = true;
	}
	public String getSimbolo() {
		return S;
	}
	public int getNSimbolo() {
		if(S.equals("Bastos")) {
			return 1;
		}
		if(S.equals("Espadas")) {
			return 2;
		}
		if(S.equals("Copas")) {
			return 3;
		}
		return 4;
	}
	public int getNumero() {
		return N;
	}
	public boolean getEstado(){
		return E;
	}
	public void Robada() {
		E = false;
	}
	public String toString() {
		return N + " de " + S;
	}
}
