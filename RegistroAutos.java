package Simulacion;
import java.io.*;
import java.util.*;
import usb.Rutinas;


public class RegistroAutos {
    private static boolean Salir=false;
    private static int option=0;
    private static Scanner In= new Scanner(System.in);
    private static String Marca, Modelo, Fecha, Fechaj;
    private static int Ano, PrimerServicio, Kilometraje;
    private static String Placai, Placaj;
    private static int Registroi, Registroj, suma, sumaj;
    
    /* Autos:
        Marca String 30+2
        Modelo String 30+2    Lon=72
        Ano int 4
        PrimerServicio int 4
    */
    /* Placas:
        Placa String 10+2  Lon=16
        Registro int 4
    */
    /* Servicios:
        Kilometraje int 4
        Fecha String 8+2   Lon=18
        SigServicio int 4
    */
    /* NoServicios:
        Fecha String 6+2   Lon= 12
        Suma int 4
    */
    public static void main (String [] args) throws Exception {
        RandomAccessFile Autos;
        RandomAccessFile Placas;
        RandomAccessFile Servicios;
        RandomAccessFile NoServicios;
        try{
            Autos = new RandomAccessFile("Autos.Dat", "rw");
            Placas = new RandomAccessFile("Placas.Dat", "rw");
            Servicios = new RandomAccessFile("Servicios.Dat", "rw");
            NoServicios = new RandomAccessFile("NoServicios.Dat", "rw");
        } catch (Exception e){
            System.out.println("El archivo no pudo abrirse");
            return;
        }

        String a;
        while (!Salir){
                MostrarMenu();
            switch(option){
                case 1:
                    a=In.nextLine();
                    if (!Registrar(Autos, Placas))
                        System.out.println("No se pudo registrar el auto");
                    else
                        System.out.println("Auto registrado exitosamente");
                    break;
                case 2: 
                    MostrarMenu2();
                    switch (option){
                        case 1: 
                            a=In.nextLine(); 
                            MostrarAuto(Autos, Placas); break;
                        case 2: 
                            MostrarPlacas(Placas);
                            break;
                        case 3:
                            a=In.nextLine();
                            MostrarServicios(Placas, Autos, Servicios);
                            break;
                    }
                    break;
                case 3:
                    a=In.nextLine();
                    if (RegistrarServicio(Placas,Autos,Servicios))
                        System.out.println("Servicio registrado exitosamente");
                    else
                        System.out.println("La placa no pertenece a ningun auto");
                    break;
                case 4: CalcularServicios(Servicios, NoServicios); break;
                case 0: Salir=true;
                    Autos.close();
                    Placas.close();
                    Servicios.close();
                    NoServicios.close();
                    break;
            }
        }
    }
    
    public static void MostrarMenu(){
        System.out.println("\n1. Registrar");
        System.out.println("2. Mostrar");
        System.out.println("3. Registrar Servicio");
        System.out.println("4. Numero de Servicios Fecha");
        System.out.println("0. Salir");
        try{
            option=In.nextInt();
        } catch (InputMismatchException e){
            System.out.println("El dato proporiconado no es adecuado. Intentelo nuevamente");  
            String a=In.nextLine();
            MostrarMenu();
        }  
    }
    
    public static void MostrarMenu2(){
        System.out.println("\n1. Mostrar Auto");
        System.out.println("2. Mostrar Placas");
        System.out.println("3. Mostrar los Servicios");
        try{
            option=In.nextInt();
        } catch (InputMismatchException e){
            System.out.println("El dato proporiconado no es adecuado. Intentelo nuevamente");  
            String a=In.nextLine();
            MostrarMenu2();
        }
    }
    
    public static void MostrarPlacas(RandomAccessFile Placas)throws Exception{
        Placas.seek(0);
        for (int i=0; i<Placas.length()/16; i++){
            Placai=Placas.readUTF();
            Registroi=Placas.readInt();
            
            System.out.println("\nPlaca: "+Placai+" Registro: "+Registroi);
        }
    }
    
    public static void OrdenarPlacas(RandomAccessFile Placas)throws Exception{
        int NumRegistros= (int) Placas.length()/16;
        
        for (int i=0; i<NumRegistros-1; i++)         
            for (int j=i+1; j<NumRegistros; j++){
                Placas.seek(i*16);
                Placai=Placas.readUTF();
                Registroi=Placas.readInt();
                Placas.seek(j*16);
                Placaj=Placas.readUTF();
                Registroj=Placas.readInt();
                if (Placai.compareTo(Placaj)>0){
                    Placas.seek(i*16);
                    Placas.writeUTF(Placaj);
                    Placas.writeInt(Registroj);
                    Placas.seek(j*16);
                    Placas.writeUTF(Placai);
                    Placas.writeInt(Registroi);
                }
            }
        
    }
    
    public static void OrdenarNoServicios(RandomAccessFile NoServicios) throws Exception{
        int NumeroRegistros= (int) NoServicios.length()/12;
        
        for (int i=0; i< NumeroRegistros-1; i++)
            for (int j=i+1; j<NumeroRegistros; j++){
                NoServicios.seek(i*12);
                Fecha=NoServicios.readUTF();
                suma=NoServicios.readInt();
                NoServicios.seek(j*12);
                Fechaj=NoServicios.readUTF();
                sumaj=NoServicios.readInt();
                if (Fecha.compareTo(Fechaj)>0){
                    NoServicios.seek(i*12);
                    NoServicios.writeUTF(Fechaj);
                    NoServicios.writeInt(sumaj);
                    NoServicios.seek(j*12);
                    NoServicios.writeUTF(Fecha);
                    NoServicios.writeInt(suma);
                }
            }
        
    }
    public static boolean Registrar(RandomAccessFile Autos, RandomAccessFile Placas) throws Exception {
        try{
            System.out.print("\nPlaca: ");
            Placai=In.nextLine();
            if (Binaria(Placas, Placai)!=-1)
                return false;
            if (Placai.length()>10)
                throw new MiEx("No se puede superar los 10 caracteres de placa");
            System.out.print("Marca: ");
            Marca=In.nextLine();
            System.out.print("Modelo: ");
            Modelo=In.nextLine();
            System.out.print("AÃ±o: ");
            Ano=In.nextInt();
        } catch(InputMismatchException e){
            System.out.println("El dato proporiconado no es adecuado. Intentelo nuevamente");
            String a=In.nextLine();
            return Registrar(Autos, Placas);
        } catch (MiEx ex){
            System.out.println(ex.getMessage());
            return false;
        }
            
        Autos.seek(Autos.length());
        Autos.writeUTF(Rutinas.PonBlancos(Marca, 30));
        Autos.writeUTF(Rutinas.PonBlancos(Modelo, 30));
        Autos.writeInt(Ano);
        Autos.writeInt(-1);
        Placas.seek(Placas.length());
        Placas.writeUTF(Rutinas.PonBlancos(Placai, 10));
        
        Registroi=(int)Placas.length()/16+1;
            
        Placas.seek(Placas.length());
        Placas.writeInt(Registroi);
        if (Registroi>=2)
            OrdenarPlacas(Placas);
        return true;
    }

    public static void MostrarAuto(RandomAccessFile Autos, RandomAccessFile Placas) throws Exception{
        System.out.print("\nPlaca: ");
        Placai=In.nextLine();
        Registroi=Binaria(Placas, Placai);
        if (Registroi==-1){
            System.out.println("La placa introducida no pertenece a ningun vehiculo");
            return;
        }
            
        Autos.seek((Registroi-1)*72);
        Marca=Autos.readUTF();
        Modelo=Autos.readUTF();
        Ano=Autos.readInt();
        PrimerServicio=Autos.readInt();
                    
        System.out.println("Marca: "+Marca+" Modelo: "+Modelo+" AÃ±o: "+Ano+"  Primer Servicio: "+PrimerServicio);
    }

    private static int Binaria(RandomAccessFile Arch ,String Placa)throws Exception{
	if(Arch.length()==0)
            return -1;
	int inferior=0,mitad=0,superior=(int) Arch.length()/16-1;
	String PLACAREG;
	int REGISTRO;
	while (inferior <= superior){
	    mitad=(inferior+superior)/2;
	    Arch.seek(mitad*16);
	    PLACAREG=Arch.readUTF();
	    REGISTRO=Arch.readInt();
	    int Res=Placa.compareToIgnoreCase(PLACAREG.trim());
	    if(Res==0)
	    	return REGISTRO;
	    if(Res>0)
	    	inferior=mitad+1;
	    else
	    	superior=mitad-1;
	}
	return -1;
    }
    
    public static boolean RegistrarServicio(RandomAccessFile Placas, RandomAccessFile Autos, RandomAccessFile Servicios) throws Exception{
        try{
            System.out.print("\nPlaca: ");
            Placai=In.nextLine();
            Registroi=Binaria(Placas, Placai);
            if (Registroi==-1)
                return false;
            System.out.print("Kilometraje: ");
            Kilometraje=In.nextInt();
            System.out.print("Fecha: ");
            Fecha=In.nextLine();Fecha=In.nextLine();
            if (Fecha.length()!=8)
                throw new MiEx("Formato de fecha inadecuado");
        } catch(InputMismatchException e){
            System.out.println("El dato proporiconado no es adecuado. Intentelo nuevamente");
            Placai=In.nextLine();
            return RegistrarServicio(Placas, Autos, Servicios);
        } catch (MiEx ex){
            System.out.println(ex.getMessage());
            return RegistrarServicio(Placas, Autos, Servicios);
        }
        
        Servicios.seek(Servicios.length());
        Servicios.writeInt(Kilometraje);
        Servicios.writeUTF(Fecha);
        Servicios.writeInt(-1);
        ModificarServicios(Autos, Servicios);
        return true;
    }
    
    public static void ModificarServicios(RandomAccessFile Autos, RandomAccessFile Servicios) throws Exception{
        Autos.seek(((Registroi-1)*72)+68);
        PrimerServicio=Autos.readInt();
        
        if (PrimerServicio==-1){
            Autos.seek(((Registroi-1)*72)+68);
            Autos.writeInt((int)Servicios.length()/18);
            return;
        }
        
        while (true){
            Servicios.seek((PrimerServicio-1)*18+14);
            PrimerServicio=Servicios.readInt();
            
            if (PrimerServicio==-1){
                Servicios.seek(Servicios.getFilePointer()-4);
                Servicios.writeInt((int)Servicios.length()/18);
                return;
            }
        }
    }
    
    public static void MostrarServicios(RandomAccessFile Placas, RandomAccessFile Autos, RandomAccessFile Servicios) throws Exception{
        
        try{
           System.out.println("\nPlaca: "); 
           Placai=In.nextLine();
        } catch (InputMismatchException e){
            System.out.println("El dato proporiconado no es adecuado. Intentelo nuevamente");
            MostrarServicios(Placas, Autos, Servicios);
        }
        
        Registroi=Binaria(Placas, Placai);
        if (Registroi==-1){
            System.out.println("La placa no pertenece a ningun vehiculo");
            return;
        }
                        
        Autos.seek(((Registroi-1)*72)+68);
        PrimerServicio=Autos.readInt();
        if (PrimerServicio==-1){
            System.out.println("Este auto no tiene ningun servicio");
            return;
        }
        
        while (true){
            Servicios.seek((PrimerServicio-1)*18);
            Kilometraje=Servicios.readInt();
            Fecha=Servicios.readUTF();
            PrimerServicio=Servicios.readInt();
            System.out.println("Kilometraje: "+Kilometraje+" Fecha: "+Fecha);
            
            if (PrimerServicio==-1){
                break;
            }  
        }
    }
    
    public static void CalcularServicios(RandomAccessFile Servicios, RandomAccessFile NoServicios) throws Exception{
        
        boolean flag=false;
        for (int i=0; i<Servicios.length()/18; i++){
            Servicios.seek(i*18+4);
            Fecha=Servicios.readUTF();
            Fecha=ConvAñoMes(Fecha);
            for (int j=0; j<NoServicios.length()/12; j++){
                NoServicios.seek(j*12);
                Fechaj=NoServicios.readUTF();
                if (Fecha.equals(Fechaj)){
                    suma=NoServicios.readInt(); 
                    NoServicios.seek(j*12+8);
                    NoServicios.writeInt(suma+1);
                    flag=true;
                    break;
                }
            }
            if (flag)
                flag=false;
            else{
                NoServicios.seek(NoServicios.length());
                NoServicios.writeUTF(Fecha);
                NoServicios.writeInt(1);
            }
        }
        OrdenarNoServicios(NoServicios);
        NoServicios.seek(0);
        for (int i=0; i<NoServicios.length()/12; i++){
            Fecha=NoServicios.readUTF();
            suma=NoServicios.readInt();
            
            System.out.println("Ano:\tMes:\tCantidad de Servicios:\n"+SepararAnoMes(Fecha)+"\t"+suma);
        }
        NoServicios.setLength(0);
    }
    
    public static String ConvAñoMes(String Fecha){
        String NvFecha= Fecha.substring(0, 6);
        return NvFecha;
    }
    
    public static String SepararAnoMes(String Fecha){
        String NvFecha=Fecha.substring(0, 4);
        NvFecha+="\t"+Fecha.substring(4, 6);
        return NvFecha;
    }
   
}
