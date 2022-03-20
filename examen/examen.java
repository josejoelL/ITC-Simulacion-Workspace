package simulacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


		public class examen extends JFrame implements ActionListener {
			LeeEntero semilla;
		
			int x,y,w,h;
		int n;
		int semilla_cuadrado=0;
		int numero_interno=0;
		int nueva_semilla=0;
			
			public examen(){
				super("semilla aleatoria");
				HazInterfaz();
				HazEscuchas();
			}
			private void HazInterfaz(){
				setSize(600,500);
				setLocationRelativeTo(null);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setLayout(new GridLayout(0,2,5,0));
				semilla=new LeeEntero(3);
			
				add(new JLabel("semilla",SwingConstants.RIGHT));
				add(semilla);
				
				
				//this.setResizable(false);
				setVisible(true);

				
			}
			private void HazEscuchas(){
				semilla.addActionListener(this);
			
			}
			public static void main(String [] a){
				new examen();
			}
			@Override
			public void actionPerformed(ActionEvent Evt) {
				if(Evt.getSource()==semilla){
					if(semilla.getCantidad()>999){
						JOptionPane.showMessageDialog(null, "valor no válido");
						return;
					}
					
				}
				
			}

		




		
		
	

}
