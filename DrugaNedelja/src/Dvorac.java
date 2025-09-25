"""Dvorac se nalazi u centru na koordinatama (0, 0). Na polju je N neprijateljskih """
"""katapulta. Katapult može da pogodi dvorac ako mu je Manhattan rastojanje do 
"""centra manje ili jednako određenoj vrijednosti D. """
"""Potrebno je odrediti koliko katapulta predstavlja prijetnju. Osim toga, "'"'
"""provjeriti da li će katapulti koji predstavljaju prijetnju srušiti dvorac """
"""ispaljivanjem po jednog hica, ako je poznato za dvorac da ima health HD, a da """
"""je za svaki katapult ima istu vrijednost napada KA (zbir svih KA iz dometa >= """
"""HD)"""

import java.util.Scanner;

public class dvorac_manhattan_rastojanje {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int N = sc.nextInt(); // broj katapulta
	long D = sc.nextLong(); // domet (Manhattan)
	long HD = sc.nextLong(); // health dvorca
	long KA = sc.nextLong(); // svaki katapult u dometu
	
	int threatCount = 0;
	
	for (int i = 0; i < N; i++) {
		long x = sc.nextLong();
		long y = sc.nextLong();
		long manhattan = Math.abs(x) + Math.abs(y);
		if (manhattan <= D) {
				threatCount++;
		}
	}
	
	long totalDamage = (long) threatCount * KA;
	
	System.out.println(threatCount);
		if (totalDamage >= HD) {
			System.out.println("Dvorac unisten");
		} 
		else {
			System.out.println("Dvorac nije unisten");
	}
		
	sc.close();
}
	
}
