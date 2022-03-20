package Simulacion;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

public class Mazo extends ImageIcon {
	Carta Cartas[][] = new Carta[4][10];
	public Mazo() {
		super("Imagenes" + File.separator + "Reverso.png");
		for(int x = 0; x<4; x++) {
			for(int y = 0; y<10; y++) {
				Cartas[x][y] = new Carta((x+1),(y+1<8?y+1:y+3));
			}
		}
		//MostrarCartas();
	}
	public void MostrarCartas() {
		for(int x = 0; x<4; x++) {
			for(int y = 0; y<10; y++) {
				System.out.println(Cartas[x][y].getNumero() + " de " + Cartas[x][y].getSimbolo());
			}
		}
	}
	public Carta Robar() {
		int S, N;
		double SD, ND;
		Random R = new Random();
		boolean C = false;
		do {
			SD = R.nextDouble();
			ND = R.nextDouble();
			S = Simbolo(SD);
			N = Numero(ND);
			//System.out.println(SD + " | " + ND + " | " + S + " | " + N);
			if(Cartas[S][N].getEstado()){
				Cartas[S][N].Robada();
				C = true;
			}
		}while(!C);
		return Cartas[S][N];
	}
	public int Simbolo(double N) {
		if(N<=0.25)
			return 0;
		if(N<=0.5)
			return 1;
		if(N<=0.75)
			return 2;
		return 3;
	}
	public int Numero(double N) {
		if(N<=0.1)
			return 0;
		if(N<=0.2)
			return 1;
		if(N<=0.3)
			return 2;
		if(N<=0.4)
			return 3;
		if(N<=0.5)
			return 4;
		if(N<=0.6)
			return 5;
		if(N<=0.7)
			return 6;
		if(N<=0.8)
			return 7;
		if(N<=0.9)
			return 8;
		return 9;
	}
}
