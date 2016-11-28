package herencia0;

import java.util.Scanner;

/*
    super: función para acceder a valores públicos de la clase padre
    extends: palabra reservada para darle acceso a los valores públicos de una clase a otra
    this:
    Clase padre: clase que proporciona objetos
    clase hija: clase que recibe los objetos de la clase padre
    redefinición de método: acción que consiste en reescribir un método, ya sea con diferentes parámetro o con diferente tipo
*/

public class Garaje {

    public static void main(String[] args) {
	// declarations
	Garaje g = new Garaje();
	int numPlazas = g.numPlazas, usedPlazas=0, optn, allowZero=1, usedPlazasCar=0, usedPlazasMot=0;
	double potencia, potencia1, potencia2, totalPotencia=0, costMotos=0, costCars=0, totalCostos=0, potMotos=0, potCars=0;
	double[][] potPlaza = new double[30][2];
	double[][] Costos = new double[numPlazas][2];
	Coche[] Coches = new Coche[numPlazas];
	Moto[] Motos = new Moto[numPlazas];
	
	System.out.println("En el garaje hay un máximo de " + numPlazas + " plazas");
	System.out.println("En cada plaza puede haber un coche o dos motos");
	System.out.println("Acontinuación empezará el proceso de ingreso de vehículos a las plazas");
	System.out.println("Para culminar con el proceso y pasar a la muestra de costos, ingrese \"0\" cuando sea ofertado");
	
	for(int i = 0; i < numPlazas; i++) {
	    potencia=0;
	    potencia1=0;
	    potencia2=0;
	    System.out.println("Ingrese uno de los siguientes vehículos");
	    System.out.println("Moto (1)");
	    System.out.println("Coche (2)");
	    if(i!=0) {
		System.out.println("Salir (0)");
		allowZero=0;
	    }
	    optn = g.validInt(allowZero/*1 first run, 0 afterwards*/, 2);
	    
	    switch(optn) {
		case 1:
		    System.out.println("Ingrese la potencia de la primera moto:");
		    potencia1 = g.validInt(0);
		    System.out.println("Ingrese la potencia de la segunda moto, \"0\" si no hay");
		    potencia2 = g.validInt(0);
		    potencia = potencia1 + potencia2;
		    Motos[i] = new Moto(potencia1, potencia2);
		    Costos[i][0] = g.Cuota(Motos[i].getPotencia1(), Motos[i].getPotencia2());
		    potPlaza[i][0] = potencia;
		    usedPlazasMot++;
		    
		    // embasurar not
		    Coches[i] = null;
		    Costos[i][1] = 0;
		    potPlaza[i][1] = 0;
		    break;
		case 2:
		    System.out.println("Ingrese la potencia del coche");
		    potencia1 = g.validInt(0);
		    potencia = potencia1;
		    Coches[i] = new Coche(potencia1, numPlazas);
		    Costos[i][1] = g.Cuota(Coches[i].getPotencia1());
		    potPlaza[i][1] = potencia;
		    usedPlazasCar++;
		    
		    // embasurar-not
		    Motos[i] = null;
		    Costos[i][0] = 0;
		    potPlaza[i][0] = 0;
		    break;
		case 0:
		    System.out.println("Mostrando resultados...");
		    break;
		default:
		    throw new AssertionError();
	    }
	    if(optn==0) {
		break;
	    }
	    usedPlazas++;
	    totalPotencia += potencia;
	}
	costMotos=0;
	costCars=0;
	for(int i = 0; i < usedPlazas; i++) {
	    costMotos += Costos[i][0];
	    costCars += Costos[i][1];
	    totalCostos += Costos[i][0];
	    totalCostos += Costos[i][1];
	    potMotos += potPlaza[i][0];
	    potCars += potPlaza[i][1];
	}
	
	System.out.println("Total de plazas usadas: " + usedPlazas);
	System.out.println("-- Plazas usadas por motos: " + usedPlazasMot);
	System.out.println("-- Plazas usadas por coches: " + usedPlazasCar);
	
	System.out.println("Total de costos: " + totalCostos);
	System.out.println("-- Total costos de Motos: " + costMotos);
	System.out.println("-- Total costos de Coches: " + costCars);
	
	System.out.println("Total de potencias en todas las plazas: " + totalPotencia);
	System.out.println("-- Total potencias de Motos: " + potMotos);
	System.out.println("-- Total potencias de Coches: " + potCars);
	
	System.out.println("Totales de Costos y Potencias por Plaza:");
	
	String formatH = "%5s%15s%15s%15s%n";
	String format = "%5s%15s%15s%15s%n";
	
	System.out.printf(formatH, "#  |", "Costos |", "Potencias |", "Vehículo |");
	for(int i = 0; i < usedPlazas; i++) {
	    if(potPlaza[i][0] != 0) {
		System.out.printf(format, (i+1) + " |", "Bs. " + Costos[i][0] + " |", potPlaza[i][0] + " |", "Motos |");
	    }
	    if(potPlaza[i][1] != 0) {
		System.out.printf(format, (i+1) + " |", "Bs. " + Costos[i][1] + " |", potPlaza[i][1] + " |", "Coches |");
	    }
	}
    }
    
    int numPlazas;
    
    public static Scanner reader = new Scanner(System.in);
    
    public Garaje() {
	this.numPlazas = 30;
    }
    
    public double Cuota(double potencia1, double potencia2) {	// motos
	double cuota;
	if(potencia2!=0) {
	    cuota = potencia1 * potencia2;
	} else {
	    cuota = potencia1 * 2;
	}
	return cuota;
    }
    
    public double Cuota(double potencia1) { // coches
	double cuota = potencia1 * numPlazas;
	return cuota;
    }
    
    public int validInt() {
	int x;
	while(!reader.hasNextInt()) {
	    reader.next();
	}
	x = reader.nextInt();
	return x;
    }
    
    public int validInt(int init) {
	int x;
	do {
	    while(!reader.hasNextInt()) {
		reader.next();
	    }
	    x = reader.nextInt();
	} while(x<init);
	return x;
    }
    
    public int validInt(int init, int end) {
	int x;
	do {
	    while(!reader.hasNextInt()) {
		reader.next();
	    }
	    x = reader.nextInt();
	} while(x<init || x>end);
	return x;
    }
    
    public String SandN() {
	String x;
	do {
	    x = reader.next();
	} while(!(x.equalsIgnoreCase("s")) && !(x.equalsIgnoreCase("n")));
	return x.toLowerCase();
    }
}
