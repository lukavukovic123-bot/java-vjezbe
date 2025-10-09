/*
 Kreirati program koji ce kreirati novi niz, korisnik unosi dužinu niza a nakon toga: 
► Popuniti niz sa random vrijednostima i prikazati ga.
 ► Izmijeniti svaki parni element niza da bude njegova suprotna vrijednost (-1*n), a svaki 
neparni pretvoriti u njegovu inverznu vrijednost (1/n)
*/

import java.util.Scanner;
import java.util.Random;

public class randomNiz {
	
	

	    public static void main(String[] args) {
	    	
	        Scanner sc = new Scanner(System.in);
	        Random rand = new Random();

	        System.out.print("Unesite velicinu niza: ");
	        
	        int velicinaNiz = sc.nextInt();
	        int[] niz = new int[velicinaNiz];

	        // Popunjavanje niza 
	        for (int i = 0; i < velicinaNiz; i++) {
	            niz[i] = rand.nextInt(10) + 1;
	        }

	        // Ispis 
	        System.out.println("Nasumični niz:");
	        for (int i = 0; i < velicinaNiz; i++) {
	            System.out.print(niz[i] + " ");
	        }

	        sc.close();
	    }


}
