package Simulacion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Camiones_colas {
private static int hora=11, hora2=11;
private static int min=0, min2=0;
private static DecimalFormat s=new DecimalFormat("00");
private static ArrayList <Double> RR=new ArrayList<Double>();
private static ArrayList <Integer> tLL=new ArrayList<Integer>();
private static ArrayList <Integer> hr2=new ArrayList<Integer>();
private static ArrayList <Integer> mn2=new ArrayList<Integer>();
private static ArrayList <Integer> hr1=new ArrayList<Integer>();
private static ArrayList <Integer> mn1=new ArrayList<Integer>();
private static ArrayList <Integer> hr11=new ArrayList<Integer>();
private static ArrayList <Integer> mn11=new ArrayList<Integer>();
private static ArrayList <Double> RR2=new ArrayList<Double>();
private static ArrayList <Integer> tS=new ArrayList<Integer>();
private static ArrayList <Integer> opp=new ArrayList<Integer>();
private static ArrayList <Integer> tecc=new ArrayList<Integer>();
private static ArrayList <Integer> camx=new ArrayList<Integer>();
private static Random NR=new Random();
private static Random NR2=new Random();
private static Random NRc=new Random();
private static double R, R2, Rc;
private static int con=0, vez=3, Ts=0, Tes=0, cami=0, tl=0, op=0, tec=0, hm=0,hm2=0, mm=0, mm2=0, cam=0 ,c=0,c2=0,c3=0, p=0, xd=0, ps=0;;
	public static void main(String[] args) {

	
	
	
	tablerio(3);
	tablerio(4);
	tablerio(5);
	tablerio(6);
	 
	
	
	
	
	
	}
	
	
	public static  void tablerio(int o) {
		
			Rc=NRc.nextDouble();
			cami=CamionesIni(Rc);
			vez=cami;
			while(!(hora>=8 && hora<=10 || hora>=8 && hora<=10 || hora2==7 && min2>=30 || hora==7 && min>=30)) {
				if(con==0) {
					if(cami>0) { 
				
				hr1.add(hora); mn1.add(min);
				R2=NR2.nextDouble();Ts=tiempoS(R2, o); tiempo(Ts); 
						cam=cami-1;
						tS.add(Ts);
						RR.add(0.0);
						RR2.add(R2);
						tLL.add(0);
						hr2.add(hora2); mn2.add(min2);
					    hr11.add(hora); mn11.add(min);
					    opp.add(0); tecc.add(0);
					}
					else {
					hr1.add(hora); mn1.add(min);
					 
					hr11.add(hora); mn11.add(min);
							cam=cami;		
							RR2.add(0.0);
							RR.add(0.0);
							tS.add(0);
							tLL.add(0);
							hr2.add(hora2); mn2.add(min2);
							opp.add(0); tecc.add(0);
					}
				con+=1;
				
				}
				else {
					
					R=NR.nextDouble();RR.add(R);
					tl=LlegadaCam(R); tLL.add(tl);    tiempo2(tl); 
					hr2.add(hora2); mn2.add(min2);
					
				if(cami==0 || cami==1) {
					if((hora>=11 && hora2>=11 && hora<=hora2 && min<=min2)) {hm=hora*60; hm2=hora2*60; mm=hm+min; mm2=hm2+min2;  op=mm2-mm; hora=hora2; min=min2;}
					else if (hora>=0 && hora<=10  && hora2>=0 && hora2<=10  &&  hora<=hora2 )
							{if(hora==hora2 && min<=min2) {hm=hora*60; hm2=hora2*60; mm=hm+min; mm2=hm2+min2; op=mm2-mm; hora=hora2; min=min2;}
							else if(hora==hora2 && min>=min2){hm=hora*60; hm2=hora2*60; mm=hm+min; mm2=hm2+min2; tec=mm-mm2;cam=cam+1;}
							else{hm=hora*60; hm2=hora2*60; mm=hm+min; mm2=hm2+min2; op=mm2-mm; hora=hora2; min=min2;}}
					else if(hora>=11  && hora2>=0 && hora2<=10) {hm=(hora)*60; hm2=(hora2+hora+1)*60; mm=hm+min; mm2=hm2+min2; op=mm2-mm;  hora=hora2; min=min2;}
					else if(hora2>=11  && hora>=0 && hora<=10) {hm=(hora+hora2+1)*60; hm2=(hora2)*60; mm=hm+min; mm2=hm2+min2; tec=mm-mm2;cam=cam+1; }
					else {hm=hora*60; hm2=hora2*60; mm=hm+min; mm2=hm2+min2; tec=mm-mm2;  cam=cam+1;}
					if(cami>0)cami=cami-1;
					}
					if(cami==2 || cami==3) {
						if((hora>=11 && hora2>=11 && hora<=hora2 && min<=min2)) {hm=(hora)*60; hm2=(hora2)*60; mm=hm+min; mm2=hm2+min2; tec=Math.abs(mm-mm2);cam=cam+1; }
						else if (hora>=0 && hora<=10  && hora2>=0 && hora2<=10  &&  hora<=hora2 )
								{if(hora==hora2 && min<=min2) {hm=(hora)*60; hm2=(hora2)*60; mm=hm+min; mm2=hm2+min2; tec=Math.abs(mm-mm2); cam=cam+1; }
								else if(hora==hora2 && min>=min2){hm=hora*60; hm2=hora2*60; mm=hm+min; mm2=hm2+min2; tec=Math.abs(mm-mm2); cam=cam+1;}
								else{hm=(hora+hora2+1)*60; hm2=(hora2)*60; mm=hm+min; mm2=hm2+min2; tec=Math.abs(mm-mm2); cam=cam+1; }}
						else if(hora>=11  && hora2>=0 && hora2<=10) {hm=(hora)*60; hm2=(hora2)*60; mm=hm+min; mm2=hm2+min2; tec=Math.abs(mm-mm2); cam=cam+1; }
						else if(hora2>=11  && hora>=0 && hora<=10) {hm=(hora+hora2+1)*60; hm2=(hora2)*60; mm=hm+min; mm2=hm2+min2; tec=Math.abs(mm-mm2); cam=cam+1; }
						else {hm=hora*60; hm2=hora2*60; mm=hm+min; mm2=hm2+min2; tec=Math.abs(mm-mm2);  cam=cam+1;}
						if(cami>0)cami=cami-1;
					}
					
					
				
				
							
					hr1.add(hora); mn1.add(min);
					
			
					
					
					
					R2=NR2.nextDouble();
							Ts=tiempoS(R2, o); tS.add(Ts); tiempo(Ts); hr11.add(hora); mn11.add(min);
							if(hora>=3 && c==0) {tiempo(30); c=1;}
							
							
							
							RR2.add(R2);
							opp.add(op); tecc.add(tec);
							if(cam>0)
					cam=cam-1;
							op=0; tec=0;
							
				
					
				}
				
				
				
		}
			
			
			
			
			xd=1;
			camx.add(vez);
			Tes=camx.get(0);
			for(int i=1;i<tLL.size();i++) {
				 p=hr11.get(i-1); c3=mn11.get(i-1);
				
				c2=0;
				if(Tes!=(tLL.size()-1)+vez) {
					if(xd==i-1) {xd+=1;}
					
					
					
					if(!(ps==1)) {
						
				for(int x=xd;x<tLL.size();x++) {
					
					
					if((x)<tLL.size()) {
						
					if(p>=11 && hr2.get(x)>=11 && c3>mn2.get(x)) {c2=c2+1; xd=x;if(xd==tLL.size()-1 ) {ps=1;} }
					else if(p>=0 && p<=10 && hr2.get(x)>=0 && hr2.get(x)<=10 && p>=hr2.get(x)){
						 if(p>hr2.get(x)) {c2=c2+1; xd=x;if(xd==tLL.size()-1 ) {ps=1;} }
						else if(p==hr2.get(x) && c3>mn2.get(x)) {c2=c2+1; xd=x;if(xd==tLL.size()-1 ) {ps=1;} }
						else if(p==hr2.get(x) && c3==mn2.get(x)) {xd=x; break; }
						else {xd=x; break;}
					}
					else if(p>=0 && p<=10 && hr2.get(x)>=11){c2=c2+1; xd=x; if(xd==tLL.size()-1 ) {ps=1;}}
					else {xd=x; break;}
					
						}
					else { break;}
					
				}
					
					}
				}
				int X=camx.get(i-1), Y=c2;;
				
				Tes=Tes+c2;
				System.out.println(Tes);
				//if(vez>=2) {
					//if(!(i>=tLL.size()-1)) {
					if(X>0) {
				c2=Y+(X-1);
					}
					//}
					//}
				
				
			
				
				
				camx.add(c2);
				//if(camx.get(i)<=1) {vez=0;}
				
				
				X=0; Y=0;
			}
			
		for(int m=0; m<tLL.size();m++)	{
			if(m==0 ) {
			System.out.println(RR.get(m)+"               | "+tLL.get(m)+" | "+s.format(hr2.get(m))+":"+s.format(mn2.get(m))+" | "
					+ s.format(hr1.get(m))+":"+s.format(mn1.get(m))+" | "+RR2.get(m)+" | "+tS.get(m)+" | "
					+s.format(hr11.get(m))+":"+s.format(mn11.get(m))+" | "+opp.get(m)+" | "+tecc.get(m)+" | "+camx.get(m));}
			else {
			System.out.println(RR.get(m)+" | "+tLL.get(m)+" | "+s.format(hr2.get(m))+":"+s.format(mn2.get(m))+" | "
					+ s.format(hr1.get(m))+":"+s.format(mn1.get(m))+" | "+RR2.get(m)+" | "+tS.get(m)+" | "
					+s.format(hr11.get(m))+":"+s.format(mn11.get(m))+" | "+opp.get(m)+" | "+tecc.get(m)+" | "+camx.get(m));
			}
		}
			
		
			
			 con=0; vez=3; Ts=0; Tes=0; cami=0; tl=0; op=0; tec=0; hm=0;hm2=0; mm=0; mm2=0; cam=0 ;c=0;c2=0;c3=0; p=0; xd=0;
			 RR.clear();tLL.clear();hr2.clear();mn2.clear();hr1.clear();mn1.clear();RR2.clear();tS.clear();hr11.clear();mn11.clear();opp.clear();
			 tecc.clear();camx.clear();hora=11; hora2=11;min=0; min2=0;ps=0;
			 System.out.println("");
			
			
		
	}
	
	
	
	public static void tiempo(int t) {
	
	for(int i=0;i<t;i++) {
		if( min<59 ) {
			min=min+1;
		}
		else if(min==59){
			min=0;
			if(hora<11)
			hora=hora+1;
			else if(hora==11) {
				hora=0;
			}
		}
	}

	}
	
	public static void tiempo2(int t) {
		
		for(int i=0;i<t;i++) {
			
			
			
			if( min2<59 ) {
				min2=min2+1;
			}
			else if(min2==59){
				min2=0;
				if(hora2<11)
				hora2=hora2+1;
				else if(hora2==11) {
					hora2=0;
				}
			}
			
			
		}
	}
	
	public static int CamionesIni(double p) {
		if(p>=0 && p<0.50) {
			return 0;
		}
		else if(p>=0.50 && p<0.75 ) {
			return 1;
		}
		else if(p>=0.75 && p<0.90 ) {
			return 2;
		}
			return 3;
	}
	
	public static int LlegadaCam(double p) {
		if(p>=0 && p<0.02) {
			return 20;
		}
		else if(p>=0.02 && p<0.10 ) {
			return 25;
		}
		else if(p>=0.10 && p<0.22 ) {
			return 30;
		}
		else if(p>=0.22 && p<0.47 ) {
			return 35;
		}
		else if(p>=0.47 && p<0.67 ) {
			return 40;
		}
		else if(p>=0.67 && p<0.82 ) {
			return 45;
		}
		else if(p>=0.82 && p<0.92 ) {
			return 50;
		}
		else if(p>=0.92 && p<0.97 ) {
			return 55;
		}
		return 60;
	}
	
	public static int tiempoS(double p, int z) {
		switch(z) {
		case 3: 
			if(p>=0 && p<0.05) {
				return 20;
			}
			else if(p>=0.05 && p<0.15 ) {
				return 25;
			}
			else if(p>=0.15 && p<0.35 ) {
				return 30;
			}
			else if(p>=0.35 && p<0.60 ) {
				return 35;
			}
			else if(p>=0.60 && p<0.72 ) {
				return 40;
			}
			else if(p>=0.72 && p<0.82 ) {
				return 45;
			}
			else if(p>=0.82 && p<0.90 ) {
				return 50;
			}
			else if(p>=0.90 && p<0.96 ) {
				return 55;
			}
			return 60;
			
		case 4:
			if(p>=0 && p<0.05) {
				return 15;
			}
			else if(p>=0.05 && p<0.20 ) {
				return 20;
			}
			else if(p>=0.20 && p<0.40 ) {
				return 25;
			}
			else if(p>=0.40 && p<0.60 ) {
				return 30;
			}
			else if(p>=0.60 && p<0.75 ) {
				return 35;
			}
			else if(p>=0.75 && p<0.87 ) {
				return 40;
			}
			else if(p>=0.87 && p<0.95 ) {
				return 45;
			}
			else if(p>=0.95 && p<0.99 ) {
				return 50;
			}
			return 55;
			
		case 5:
			if(p>=0 && p<0.10) {
				return 10;
			}
			else if(p>=0.10 && p<0.28 ) {
				return 15;
			}
			else if(p>=0.28 && p<0.50 ) {
				return 20;
			}
			else if(p>=0.50 && p<0.68 ) {
				return 25;
			}
			else if(p>=0.68 && p<0.78 ) {
				return 30;
			}
			else if(p>=0.78 && p<0.86 ) {
				return 35;
			}
			else if(p>=0.86 && p<0.92 ) {
				return 40;
			}
			else if(p>=0.92 && p<0.97 ) {
				return 45;
			}
			return 50;
			
		default:
			if(p>=0 && p<0.12) {
				return 5;
			}
			else if(p>=0.12 && p<0.27 ) {
				return 10;
			}
			else if(p>=0.27 && p<0.53 ) {
				return 15;
			}
			else if(p>=0.53 && p<0.68 ) {
				return 20;
			}
			else if(p>=0.68 && p<0.80 ) {
				return 25;
			}
			else if(p>=0.80 && p<0.88 ) {
				return 30;
			}
			else if(p>=0.88 && p<0.94 ) {
				return 35;
			}
			else if(p>=0.94 && p<0.98 ) {
				return 40;
			}
			return 45;
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
