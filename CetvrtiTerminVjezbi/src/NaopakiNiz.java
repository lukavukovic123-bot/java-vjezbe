/*
 Napisati program koji kreira niz od 10 cijelih brojeva, popunjava ga brojevima od 1 do 10 
a zatim ispisuje elemente niza u obrnutom redosledu.
*/

public class naopaki_niz {

	 public static void main() {
	        int[] niz = new int[10];
	        for (int i = 0; i < niz.length; i++) {
	            niz[i] = i + 1;
	        }

	        for (int i = 9; i >= 0; i--) {
	            System.out.println(niz[i]);
	        }
	    }
	}