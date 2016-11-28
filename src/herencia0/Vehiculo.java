package herencia0;

public class Vehiculo {
    
    public double potencia1;
    
    public Vehiculo(double potencia1) {
	this.potencia1 = potencia1;
    }
    
    public String Mostrar() {
	return "La potencia es: " + potencia1;
    }
}
