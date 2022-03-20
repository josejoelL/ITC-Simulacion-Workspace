package Simulacion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.data.category.DefaultCategoryDataset;

public class JpLienzoB extends JPanel{
	private static final long serialVersionUID = 1L;
	private int Fig, x1, y1, x2, y2, Ancho, Alto, NC;
	private Color color;
	private ArrayList<Figura> Contenido;
	public JpLienzoB(){
		super();
		NC = 2;
		Contenido = new ArrayList<Figura>();
		setBackground(Color.white);
		PintarCentro();
		Pintar();
		PintarLineas();
	}
	private void PintarCentro() {
		Fig = 4;
		x1=600;
		x2=600;
		y1=600;
		y2=600;
		Ancho=2;
		Alto=2;
		color = Color.BLUE;
		
	}
	public void PintarLineas() {
		Contenido.add(new Figura(5, 300, 0, 300, 600,1,1,color.BLACK));
		Contenido.add(new Figura(5, 0, 300, 600, 300,1,1,color.BLACK));
		repaint();
	}
	public void PintaTodo(Graphics g){
		Figura f;
		for(int  i= 0; i<Contenido.size(); i++){
			f = Contenido.get(i);
			g.setColor(f.getColor());
			//Cuando la figura va rellena
			switch(f.getFig()){
			case 1: //Cuadrado
			case 2: //Recatangulo
				g.fillRect(f.getX1(), f.getY1(), f.getAncho(), f.getAlto());
				break;
			case 3: //Circulo
			case 4: //Ovalo
				g.fillOval(f.getX1(), f.getY1(), f.getAncho(), f.getAlto());
				break;
			case 5: //Linea
				g.drawLine(f.getX1(), f.getY1(), f.getX2(), f.getY2());	
			}
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		PintaTodo(g);
		/*Ancho = Math.abs(x2-x1);
		Alto = Math.abs(y2-y1);*/
		if(Fig == 1 || Fig == 3){
			Ancho = Ancho>Alto?Ancho:Alto;
			Alto = Ancho>Alto?Ancho:Alto;
		}
		g.setColor(color);
		switch(Fig){
		case 1: //Cuadrado
		case 2: //Rectangulo
			g.fillRect(x1, y1, Ancho, Alto);
			break;
		case 3: //Circulo
		case 4: //Ovalo
			g.fillOval(x1, y1, Ancho, Alto);
			break;
		case 5: //Linea
			g.drawLine(x1, y1, x2, y2);
		}
	}
	public void Pintar() {
		Ancho = Math.abs(x2-x1);
		Alto = Math.abs(y2-y1);
		Contenido.add(new Figura(5,x1,y1,x2,y2,Ancho,Alto,color));
		repaint();
	}
	public void Pintar(int x, int y) {
		x1 = (x * 50) + 300;
		y1 = (y * 50) + 300;
		Contenido.add(new Figura(5,x1,y1,x2,y2,5,5,color));
		repaint();
	}
	public void setX(int x) {
		x2 = (x * 50) + 300;
	}
	public void setY(int y) {
		y2 = (y * 50) + 300;
	}
	public void addContenido(int x, int y) {
		x1 = (x * 50) + 300;
		y1 = (y * 50) + 300;
		Contenido.add(new Figura(1, (x1-1), (y1-1), (x1+1), (y1+1), 3, 3, Color.RED));
		repaint();
	}
}
