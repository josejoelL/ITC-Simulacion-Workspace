package Simulacion;

import java.util.ArrayList;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class P02_Chi
{
	public static void main(String [] args)
	{
		Scanner R = new Scanner(System.in);
		
		ArrayList <Double> MNR = new ArrayList<Double>();
		ArrayList <Double> IM = new ArrayList<Double>();
		ArrayList <Integer> OM = new ArrayList<Integer>();
		
		int N = 0, Inter, X;
		Double NR, X0 = 0.0;
		boolean C = false;
		
		while(!C)
		{
			try {
				System.out.print("INGRESE DE CUANTOS NUMEROS SERA LA MUESTRA: ");
				N = R.nextInt();
				
				C = N > 34? true: false;
				
				if(!C)
					System.out.println("** LA MUESTRA DEBE SER MAYOR A 34 **");
			} catch (Exception e) {
				R = new Scanner(System.in);
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			NR = Generar_Random();
			
			MNR.add(NR);
		}
		
		Inter = (int) (Math.round(Math.sqrt(N)*1)/1d);
		
		for(int i=0; i <= Inter; i++)
		{IM.add((double)i/Inter);}
		
		for(int i=1; i <= IM.size(); i++)
		{
			X=0;
			
			for(int j=0; j<MNR.size(); j++)
			{
				if(MNR.get(j) > IM.get(i-1) && MNR.get(j) < IM.get(i))
					X++;
			}
			
			OM.add(X);
		}
		
		System.out.println("n |  NR");
		
		for(int i=0; i<MNR.size(); i++)
			System.out.println((i+1) + " | " + MNR.get(i));
		
		System.out.println();
		
		System.out.println("Intervalo |   O   |   E   |   (O-E)   |   ((O-E)^2)/E");
		
		for(int i=1; i<IM.size(); i++)
		{
			System.out.println(IM.get(i) + " | " + OM.get(i-1) + " | " + (N/Inter) + " | " + ((OM.get(i-1))-(N/Inter)) + " | "
					+ (Math.pow(2, ((OM.get(i-1))-(N/Inter)))/(N/Inter)));
			X0 = X0 +  (Math.pow(2, ((OM.get(i-1))-(N/Inter)))/(N/Inter));
		}
		
		System.out.println("X0 = " + X0);
	
		DefaultCategoryDataset Intervalo = new DefaultCategoryDataset();
		
		for(int i=0; i < OM.size()-1; i++)
		{
			Intervalo.setValue(OM.get(i), (IM.get(i+1)+""), (IM.get(i+1)+""));
		}
		
		JFreeChart JFC = ChartFactory.createBarChart("** PRUEBA CHI CUADRADO **", "Intervalos", "Observado", Intervalo, PlotOrientation.VERTICAL, true, false, false);
		
		ChartFrame Frame = new ChartFrame(null, JFC);
		
		Frame.pack();
		Frame.setVisible(true);
	}
	
	public static Double Generar_Random()
	{
		Double R = Math.random()*1;
		
		R = Math.round(R*100000)/100000d;
		
		return R;
	}
}
