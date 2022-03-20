package Simulacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import javax.swing.Timer;
/*
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
*/
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Mesa extends JFrame implements ActionListener{
	private String Mensaje;
	private int NC, SC;
	private Carta Manos[][];
	private Mazo Mazo;
	private JPanel PN, PS, PC, PCON, CN,CS;
	private JToolBar PO, PE;
	private JButton Cartas[][], BN,BS,BE,BO;
	private int CON, RG[], JG[], CR, G, NJ;
	private Timer T;
	private JLabel C[];
	public Mesa() throws HeadlessException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		setSize(700,580);
		JG = new int[4];
		PreguntarNJuegos();
		for(int x = 1; x<=NJ; x++) {
			NuevoJuego();
			//MostrarCartas();
			T = new Timer(3000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JugarCarta();
					setVisible(true);
				}});
			T.start();
			while(T.isRunning()) {
				
			}
			setVisible(true);
			BuscarGanador();
			JOptionPane.showMessageDialog(this, Mensaje);
			JOptionPane.showMessageDialog(this, "El juego #" + x +" ha concluido");
			if(x != NJ) {
				PC.remove(3);
				PC.remove(2);
				PC.remove(1);
				PC.remove(0);
			}
		}/*
		JOptionPane.showMessageDialog(this, "Resultado: JN = " + JG[1] + ", JS = " +JG[0] +", JO = " + JG[2] + ", JE = " + JG[3]);
		DefaultPieDataset Dataset = new DefaultPieDataset();
		if(JG[0] != 0)
			Dataset.setValue("Jugador del sur", JG[0]);
		if(JG[1] != 0)
			Dataset.setValue("Jugador del norte", JG[1]);
		if(JG[2] != 0)
			Dataset.setValue("Jugador del oeste", JG[2]);
		if(JG[3] != 0)
			Dataset.setValue("Jugador del este", JG[3]);
		JFrame JF = new JFrame();
		JFreeChart lineChart = ChartFactory.createPieChart(
                "Juegos ganados/Empatados",
                Dataset,
                true, true, false);
		ChartPanel panel = new ChartPanel(lineChart);
		JF.setSize(800,600);
		JF.add(panel);
		JF.setVisible(true);*/
		setVisible(true);
	}
	/*public Mesa(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Mesa(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Mesa(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	*/
	public void NuevoJuego() {
		CON = 0;
		CR = 0;
		RG = new int [4];
		Manos = new Carta[4][10];
		Mazo = new Mazo();
		Cartas = new JButton[4][10];
		for(int x = 0; x<10; x++) {
			for(int y = 0; y<4; y++) {
				Manos[y][x] = Mazo.Robar();
				Cartas[y][x] = new JButton(Manos[y][x]);
			}
		}
		PS = new JPanel();
		for(int x=0; x<10; x++) {
			PS.add(Cartas[0][x]);
		}
		add(PS, BorderLayout.SOUTH);
		PN = new JPanel();
		for(int x=0; x<10; x++) {
			PN.add(Cartas[1][x]);
		}
		add(PN, BorderLayout.NORTH);
		PO = new JToolBar();
		for(int x=0; x<10; x++) {
			PO.add(Cartas[2][x]);
		}
		PO.setOrientation(JToolBar.VERTICAL);
		PO.setFloatable(false);
		add(PO, BorderLayout.WEST);
		PE = new JToolBar();
		for(int x=0; x<10; x++) {
			PE.add(Cartas[3][x]);
		}
		PE.setOrientation(JToolBar.VERTICAL);
		PE.setFloatable(false);
		add(PE, BorderLayout.EAST);
		PC = new JPanel();
		PC.setLayout(new BorderLayout());
		add(PC, BorderLayout.CENTER);
	}
	public void MostrarCartas() {
		for(int x = 0; x<4; x++) {
			System.out.println("----- Jugador #" + (x+1) + " -----");
			for(int y = 0; y<10; y++) {
				System.out.println(Manos[x][y].toString());
			}
		}
	}
	public void JugarCarta() {
		CON++;
		int N[] = new int[4];
		double ND;
		Random R = new Random();
		boolean C = false;
		for(int x = 0; x < 4; x++) {
			C = false;
			do {
				ND = R.nextDouble();
				N[x] = Mazo.Numero(ND);
				if(Cartas[x][N[x]].isEnabled()) {
					C = true;
					Cartas[x][N[x]].setEnabled(false);
				}
			}while(!C);
		}
		if(CON == 1) {
			BS = new JButton();
			BN = new JButton();
			BO = new JButton();
			BE = new JButton();
			BS.setBackground(Color.DARK_GRAY);
			BN.setBackground(Color.DARK_GRAY);
			BE.setBackground(Color.DARK_GRAY);
			BO.setBackground(Color.DARK_GRAY);
		}
		BS.setIcon(new ImageIcon("Imagenes" + File.separator + Manos[0][N[0]].getNSimbolo() + "-" + Manos[0][N[0]].getNumero() + ".png"));
		BN.setIcon(new ImageIcon("Imagenes" + File.separator + Manos[1][N[1]].getNSimbolo() + "-" + Manos[1][N[1]].getNumero() + ".png"));
		BO.setIcon(new ImageIcon("Imagenes" + File.separator + Manos[2][N[2]].getNSimbolo() + "-" + Manos[2][N[2]].getNumero() + ".png"));
		BE.setIcon(new ImageIcon("Imagenes" + File.separator + Manos[3][N[3]].getNSimbolo() + "-" + Manos[3][N[3]].getNumero() + ".png"));
		/*BS.setEnabled(false);
		BN.setEnabled(false);
		BO.setEnabled(false);
		BE.setEnabled(false);*/
		if(CON == 1) {
			PC.add(BN, BorderLayout.NORTH);
			PC.add(BS, BorderLayout.SOUTH);
			PC.add(BO, BorderLayout.WEST);
			PC.add(BE, BorderLayout.EAST);
		}
		Cartas[0][N[0]].setIcon(new ImageIcon("Imagenes" + File.separator + "x" + "-" + "x" + ".png"));
		Cartas[1][N[1]].setIcon(new ImageIcon("Imagenes" + File.separator + "x" + "-" + "x" + ".png"));
		Cartas[2][N[2]].setIcon(new ImageIcon("Imagenes" + File.separator + "x" + "-" + "x" + ".png"));
		Cartas[3][N[3]].setIcon(new ImageIcon("Imagenes" + File.separator + "x" + "-" + "x" + ".png"));
		BuscarNumero(N);
		ActualizarContadores();
		if(CON == 10) {
			T.stop();
		}
	}
	public void BuscarNumero(int N[]) {
		NC = Manos[0][N[0]].getNumero();
		if((NC < Manos[1][N[1]].getNumero() && NC != 1) || Manos[1][N[1]].getNumero() == 1) {
			NC = Manos[1][N[1]].getNumero();
		}
		if((NC < Manos[2][N[2]].getNumero() && NC != 1) || Manos[2][N[2]].getNumero() == 1) {
			NC =  Manos[2][N[2]].getNumero();
		}
		if((NC < Manos[3][N[3]].getNumero() && NC != 1) || Manos[3][N[3]].getNumero() == 1) {
			NC = Manos[3][N[3]].getNumero();
		}
		BuscarSimbolo(N);
	}
	public void BuscarSimbolo(int N[]) {
		SC = 0;
		if(Manos[0][N[0]].getNumero() == NC) {
			if(Manos[0][N[0]].getNSimbolo() > SC) {
				SC = Manos[0][N[0]].getNSimbolo();
			}
		}
		if(Manos[1][N[1]].getNumero() == NC) {
			if(Manos[1][N[1]].getNSimbolo() > SC) {
				SC = Manos[1][N[1]].getNSimbolo();
			}
		}
		if(Manos[2][N[2]].getNumero() == NC) {
			if(Manos[2][N[2]].getNSimbolo() > SC) {
				SC = Manos[2][N[2]].getNSimbolo();
			}
		}
		if(Manos[3][N[3]].getNumero() == NC) {
			if(Manos[3][N[3]].getNSimbolo() > SC) {
				SC = Manos[3][N[3]].getNSimbolo();
			}
		}
		BuscarGanador(N);
	}
	public void BuscarGanador(int N[]) {
		if(Manos[0][N[0]].getNumero() == NC && Manos[0][N[0]].getNSimbolo() == SC) {
			RG[0]++;
			if(CR < RG[0]) {
				CR = RG[0];
			}
			return;
		}
		if(Manos[1][N[1]].getNumero() == NC && Manos[1][N[1]].getNSimbolo() == SC) {
			RG[1]++;
			if(CR < RG[1]) {
				CR = RG[1];
			}
			return;
		}
		if(Manos[2][N[2]].getNumero() == NC && Manos[2][N[2]].getNSimbolo() == SC) {
			RG[2]++;
			if(CR < RG[2]) {
				CR = RG[2];
			}
			return;
		}
		if(Manos[3][N[3]].getNumero() == NC && Manos[3][N[3]].getNSimbolo() == SC) {
			RG[3]++;
			if(CR < RG[3]) {
				CR = RG[3];
			}
			return;
		}
	}
	public void ActualizarContadores() {
		if(CON == 1) {
			PCON = new JPanel();
			PCON.setLayout(new BorderLayout());
			PC.add(PCON, BorderLayout.CENTER);
			C = new JLabel[4];
			C[0] = new JLabel("");
			C[1] = new JLabel("");
			C[2] = new JLabel("");
			C[3] = new JLabel("");
			CN = new JPanel();
			CS = new JPanel();
			CS.add(C[0]);
			CN.add(C[1]);
			PCON.add(CS, BorderLayout.SOUTH);
			PCON.add(CN, BorderLayout.NORTH);
			PCON.add(C[2], BorderLayout.WEST);
			PCON.add(C[3], BorderLayout.EAST);
		}
		C[0].setText(RG[0]+"");
		C[1].setText(RG[1]+"");
		C[2].setText(RG[2]+"");
		C[3].setText(RG[3]+"");
	}
	public void BuscarGanador() {
		G = 0;
		Mensaje = "";
		if(CR == RG[0]) {
			G++;
			JG[0]++;
			Mensaje = "El ganador es el jugador del sur";
		}
		if(CR == RG[1]) {
			G++;
			JG[1]++;
			Mensaje = G>1? Mensaje + ", del norte":"El ganador es el jugador del norte";
		}
		if(CR == RG[2]) {
			G++;
			JG[2]++;
			Mensaje = G>1? Mensaje + ", del oeste":"El ganador es el jugador del oeste";
		}
		if(CR == RG[3]) {
			G++;
			JG[3]++;
			Mensaje = G>1? Mensaje + ", del este":"El ganador es el jugador del este";
		}
	}
	public void PreguntarNJuegos() {
		boolean C = false;
		do {
			try {
				NJ = Integer.parseInt(JOptionPane.showInputDialog("Ingresa cuantos juegos se simulara"));
				C = true;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Solo ingresa numeros enteros");
			}
		}while(!C);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
