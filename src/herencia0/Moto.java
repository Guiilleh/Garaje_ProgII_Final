package herencia0;

public class Moto extends Vehiculo {
    
    double potencia2;
    
    public Moto(double potencia1, double potencia2) {
	super(potencia1);
	this.potencia2 = potencia2;
    }
    
    public double getPotencia1() {
	return potencia1;
    }
    
    public double getPotencia2() {
	return potencia2;
    }
    
    public double getTotal() {
	return potencia1+potencia2;
    }
    
    @Override
    public String Mostrar() {
	return "Moto\n" + super.Mostrar() + "\n";
    }
}
