package Simulacion;

import java.io.Serializable;
import java.awt.Color;

public class Figura implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int Fig, x1, y1, x2, y2, Ancho, Alto;
	private Color color;
	public Figura(int fig, int x1, int y1, int x2, int y2, int ancho, int alto, Color color ){
		Fig = fig;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		Ancho = ancho;
		Alto = alto;
		this.color = color; 
		
	}
	public Figura(){
		this(0,0,0,0,0,0,0,Color.black);
	}
	public int getFig() {
		return Fig;
	}
	public void setFig(int fig) {
		Fig = fig;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public int getAncho() {
		return Ancho;
	}
	public void setAncho(int ancho) {
		Ancho = ancho;
	}
	public int getAlto() {
		return Alto;
	}
	public void setAlto(int alto) {
		Alto = alto;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
