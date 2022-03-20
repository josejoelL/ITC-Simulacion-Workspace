package examen;

public class semilla {
private	int n;	

private	int sc,ns;
private	String sn;
private	String ni;

public semilla(int n, int s, int sc, String ni, String sn) {
	super();
	this.n = n;
	this.sc = s;
	this.ns = sc;
	this.sn = sn;
	this.ni = ni;
}

@Override
public String toString() {
	return "|n=" + n + "| sc=" + sc + "| ns=" + ns +"| ni=" + ni + "| sn=" + sn +  "|";
}

}
