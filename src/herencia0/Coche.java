package herencia0;

public class Coche extends Vehiculo {
    
    public int numPlazas;
    
    public Coche(double potencia1, int numPlazas) {
	super(potencia1);
	this.numPlazas = numPlazas;
    }
    
    public double getPotencia1() {
	return potencia1;
    }
    
    public int getNumPlazas() {
	return numPlazas;
    }
    
    @Override
    public String Mostrar() {
	return "Coche\n" + super.Mostrar() + "\nEl número de plazas es: " + numPlazas + "\n";
    }
}
