"""Napisati program kojim se izračunava potrebna dužina trake za ivicu stoljnjaka kružnog
"""oblika čija je površina P"""

import java.util.Scanner;

public class obim_kruga {

	
	 static void main(String[] args)  {
	        Scanner sc = new Scanner(System.in);
	        
	        int P = sc.nextInt();
	        double r = Math.sqrt(P) / Math.PI;
	        double O = 2 * r * Math.PI;
	        
	        System.out.printf("Obim je %.2f", O);
     
	        sc.close();
	 }
}
		
