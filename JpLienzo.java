package Simulacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import Simulacion.Figura;

public class JpLienzo extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	private DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
	private int Fig, x1, y1, x2, y2, Ancho, Alto, CX, A, NC;
	private Color color;
	private ArrayList<Figura> Contenido;
	public JpLienzo(){
		super();
		NC = 2;
		Contenido = new ArrayList<Figura>();
		setBackground(Color.white);
		
		ValoresIniciales();
		Pintar();
		//repaint();
		DividirTablero(NC);
	}
	public JpLienzo(boolean C) {
		super();
		Contenido = new ArrayList<Figura>();
		setBackground(Color.white);
		ValoresIniciales(C);
		Pintar(C);
		PintarCentro();
		Pintar(C);
	}
	private void PintarCentro() {
		Fig = 4;
		x1=300;
		x2=300;
		y1=300;
		y2=300;
		Ancho=2;
		Alto=2;
		color = Color.BLUE;
		
	}
	public void ValoresIniciales() {
		dataset.addValue(0, "Valor de PI",0+"");
		A = 0;
		Fig = 2;
		x1=50;
		x2=550;
		y1=50;
		y2=550;
		Ancho=0;
		Alto=0;
		color = Color.BLACK;
	}
	public void ValoresIniciales(boolean C) {
		dataset2.addValue(0, "Valor de PI",0+"");
		A = 0;
		Fig = 4;
		x1=50;
		x2=550;
		y1=50;
		y2=550;
		Ancho = Math.abs(x2-x1);
		Alto = Math.abs(y2-y1);
		color = Color.BLACK;
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
				g.drawRect(f.getX1(), f.getY1(), f.getAncho(), f.getAlto());
				break;
			case 3: //Circulo
			case 4: //Ovalo
				g.drawOval(f.getX1(), f.getY1(), f.getAncho(), f.getAlto());
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
			g.drawRect(x1, y1, Ancho, Alto);
			break;
		case 3: //Circulo
		case 4: //Ovalo
			g.drawOval(x1, y1, Ancho, Alto);
			break;
		case 5: //Linea
			g.drawLine(x1, y1, x2, y2);
		}
	}
	public int getFig() {
		return Fig;
	}
	public void setFig(int fig) {
		Fig = fig;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public ArrayList<Figura> getContenido() {
		return Contenido;
	}
	public void setContenido(ArrayList<Figura> contenido) {
		Contenido = contenido;
	}
	public void Pintar() {
		Ancho = Math.abs(x2-x1);
		Alto = Math.abs(y2-y1);
		Contenido.add(new Figura(Fig,x1,y1,x2,y2,Ancho,Alto,color));
		repaint();
	}
	public void Pintar(boolean C) {
		Contenido.add(new Figura(Fig,x1,y1,x2,y2,Ancho,Alto,color));
		repaint();
	}
	public void PintarAguja() {
		GenerarAguja();
		repaint();
		if(DentroDeRango()) {
			A++;
			color = Color.GREEN;
			dataset.addValue(CalcularResultado(), "Valor de PI",A+"" );
		}
		else {
			color = Color.RED;
		}
		Contenido.add(new Figura(Fig,x1,y1,x2,y2,Ancho,Alto,color));
	}
	public void PintarDardo() {
		GenerarDardo();
		repaint();
		if(DentroDeRango(true)) {
			A++;
			color = Color.GREEN;
			dataset2.addValue(CalcularResultado(true), "Valor de PI",A+"" );
		}
		else {
			color = Color.RED;
		}
		Contenido.add(new Figura(Fig,x1,y1,x2,y2,Ancho,Alto,color));
	}
	public DefaultCategoryDataset getdataset() {
		return dataset;
	}
	public DefaultCategoryDataset getdataset2() {
		return dataset2;
	}
	public double CalcularResultado(boolean C) {
		return (((double)(A)/(double)(Contenido.size()-2))*4.0);
	}
	public double CalcularResultado() {
		return ((2.0*(double)(Contenido.size()-1-(NC)))/((double)(A)));
	}
	public void setX1(int x) {
		x1 = x;
	}
	public void setY1(int y) {
		y1 = y;
	}
	public void setX2(int x) {
		x2 = x;
	}
	public void setY2(int y) {
		y2 = y;
	}
	public void DividirTablero(int D) {
		CX = (((x2-x1)/D));
		for(int i = 1; i<=D;i++) {
			x1 = x1 + CX;
			x2 = x1;
			Fig = 5;
			Pintar();
		}
	}
	public void GenerarAguja() {
		Random R = new Random();
		x1 = (int) (R.nextDouble()*600);
		y1 = (int) (R.nextDouble()*600);
		x2 = (int) (Math.floor(Math.random()*((x1-CX)-(x1+CX+1))+(x1+CX)));
		y2 = (int) Math.sqrt((Math.pow(CX,2)- Math.pow((x2-x1),2)))+y1;
	}
	public void GenerarDardo() {
		Random R = new Random();
		x1 = (int) (R.nextDouble()*600);
		y1 = (int) (R.nextDouble()*600);
		x2 = x1;
		y2 = y1;
		Ancho = 5;
		Alto = 5;
	}
	public boolean DentroDeRango() {
		if((y1<=50 && y2 >= 50) || (y2 <= 50 && y1 >= 50)) {
			if((x1 < 50 && x2 < 50)) {
				return false;
			}
			if((x1 > 550 && x2 > 550)) {
				return false;
			}
			return true;
		}
		if((y1<=550 && y2 >= 550) || (y2 <= 550 && y1 >= 550)) {
			if((x1 < 50 && x2 < 50)) {
				return false;
			}
			if((x1 > 550 && x2 > 550)) {
				return false;
			}
			return true;
		}
		if((x1<=550 && x2 >= 550) || (x2 <= 550 && x1 >= 550)) {
			if((y1 < 50 && y2 < 50)) {
				return false;
			}
			if((y1 > 550 && y2 > 550)) {
				return false;
			}
			return true;
		}
		if((x1<=50 && x2 >= 50) || (x2 <= 50 && x1 >= 50)) {
			if((y1 < 50 && y2 < 50)) {
				return false;
			}
			if((y1 > 550 && y2 > 550)) {
				return false;
			}
			return true;
		}
		if((x1>=50||x2>=50) && (x1<=550||x2<=550) && (y1>=50||y2>=50) && (y1<=550||y2<=550)) {
			return BuscarDentro();
		}
		return false;
	}
	public boolean DentroDeRango(boolean C) {
		if(Math.sqrt((Math.pow(x1-300,2) + Math.pow(y1-300,2))) <= 250) {
			return true;
		}
		return false;
	}
	public boolean BuscarDentro() {
		for(int i = 0; i < NC; i++) {
			if((x1 <= (50+i*CX) && x2 >= (50+(i*CX))) || (x1 >= (50+i*CX) && x2 <= (50+(i*CX)))) {
				return true;
			}
		}
		return false;
	}
	public int getAciertos() {
		return A;
	}
	/*
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getButton()==0){
			x2 = e.getX();
			y2 = e.getY();
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1){
			x1 = e.getX();
			y1 = e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == 1){
			
		}
	}
	*/
}
