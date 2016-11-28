/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia0;

/**
 *
 * @author Admin
 */
public class My_Calculation extends Calculation {		    // MAIN CLASS

    public void multiplication(int x, int y) {			    // METHOD OF MAIN CLASS
	z = x * y;
	System.out.println("The product of the given numbers: " + z);
    }

    public static void main(String args[]) {
	String formatH = "%5s%15s%15s%15s%n";
	String format = "%5s%15s%15s%15s%n";
	
	System.out.printf(formatH, "#  |", "Costos |", "Potencias |", "Vehículo |");
	System.out.printf(format, "1  |", "2000.0 |", "90.0 |", "Motos |");
	System.out.printf(format, "2  |", "20000.0 |", "300.0 |", "Coches |");
	System.out.printf(format, "3  |", "3600.0 |", "130.0 |", "Coches |");
	System.out.printf(format, "4  |", "7200000.0 |", "8900.0 |", "Coches |");
	System.out.printf(format, "15  |", "72300000.0 |", "81900.0 |", "Coches |");
	
	
	/*int a = 20, b = 10;
	My_Calculation demo = new My_Calculation();		    // OBJECT OF MAIN CLASS, HAS ACCESS TO ALL FUNCTIONS
	demo.multiplication(a, b);				    // FUNCTION OF MAIN CLASS
	demo.addition(a, b);					    // FUNCTION OF EXTENDED CLASS
	demo.Subtraction1(a, b);				    // FUNCTION OF EXTENDED CLASS
	System.out.println("The difference between the given numbers: " + demo.Subtraction2(a, b));
	    */
    }
}

class Calculation {






    int z;

    public void addition(int x, int y) {
	z = x + y;
	System.out.println("The sum of the given numbers: " + z);
    }
    
    public void Subtraction1(int x, int y) {
	z = x - y;
	System.out.println("The difference between the given numbers: " + z);
    }

    public int Subtraction2(int x, int y) {
	z = x - y;
	//System.out.println("The difference between the given numbers: " + z);
	return z;
    }
}
