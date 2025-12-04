"""Zamislite da ste dobili tajanstveno pismo sa mapom i uputstvima za pronalaženje
"""skrivenog blaga. Uputstva su sljedeća: """"Trebate da krenete od starog hrasta koji ima"""
"""sledeću poziciju G (x1,y1). Onda trebate ići pravo do stare kuće koja se nalazi na poziciji
"""K(x2,y2). Blago je zakopano u susjedstvu, gdje se nalazi kuća, i to desno od pozicije kuće za"""
"""dvije pozicije, i ispod za tri pozicije. Izračunajte koordinate blaga. Izračunajte (vazdušno)"""
"""rastojanje od hrasta do blaga. Izračunajte rastojanje od hrasta do blaga tako da morate"""
"""obići i kuću."""

import java.util.Scanner;

public class tajanstevno_blago {

	public static double calculateDistance(double x1, double y1, double x2, double y2) {
	        
		double dx = x2 - x1;
	    double dy = y2 - y1;
	        
	    return Math.sqrt(dx * dx + dy * dy);
	    }

	    static void main() {
	    	
	        Scanner sc = new Scanner(System.in);
	        
	        double x1 = sc.nextDouble(), y1 = sc.nextDouble(), x2 = sc.nextDouble(), y2 = sc.nextDouble();
	        double x3 = x2 + 2, y3 = y2 - 3;

	        double hrast_blago = calculateDistance(x1, y1, x3, y3);
	        double distanca = calculateDistance(x1, y1, x2, y2) + calculateDistance(x2, y2, x3, y3);

	        System.out.printf("Rastojanje od hrasta do blaga je %.2f%nRastojanje hrast-kuca-blago je: %.2f", hrast_blago, distanca);
	    
	        sc.close();
	    
	    }
	    
}
