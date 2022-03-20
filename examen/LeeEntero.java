package examen;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
public class LeeEntero extends JTextField implements KeyListener,FocusListener{
	
	protected int Longitud;
	
	public LeeEntero(){
		this(3);
	}
	public LeeEntero(int Longitud){
		this.Longitud=Longitud;
		HazEscuchas();
	}
	private void HazEscuchas(){
		this.addKeyListener(this);
		this.addFocusListener(this);
	}
	public double getCantidad(){
		return Long.parseLong(getText());
	}
	@Override
	public void focusGained(FocusEvent Evt) {
		setBackground(Color.YELLOW);
		setBorder(new LineBorder(Color.RED));
		selectAll();
		setFocusTraversalKeysEnabled(false);
		Font Fuente=new Font("Tahoma",Font.BOLD,20);
		setFont(Fuente);				
		
	}
	@Override
	public void focusLost(FocusEvent Evt) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		Font Fuente=new Font("TimesRoman",Font.PLAIN,12);
		setFont(Fuente);
	}
	@Override
	public void keyPressed(KeyEvent Evt) {
		if(Evt.isControlDown()){
			Evt.consume();
			return;
		}
		//consume la tecla Inicio,flecha izq o flecha der
		if(Evt.getKeyCode()==36 ||Evt.getKeyCode()==37 || Evt.getKeyCode()==39){
			Evt.consume();
			return;
		}		
		
		
	}
	@Override
	public void keyReleased(KeyEvent Evt) {
		
		
	}
	@Override
	public void keyTyped(KeyEvent Evt) {
		if(getText().length()==Longitud){
			Toolkit.getDefaultToolkit().beep();
			Evt.consume();
			return;
		}
		if("-0123456789".indexOf(Evt.getKeyChar()) ==-1  ){
			Evt.consume();
			return;
		} 
		if(Evt.getKeyChar()=='-' && getText().length()!=0   ){
			Evt.consume();
			return;
		}
		setText(getText()+Evt.getKeyChar());
		Evt.consume();
	}
	
	
}
