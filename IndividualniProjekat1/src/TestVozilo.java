public class TestVozilo {


	    public static void main(String[] args) {
	        
	    	
	    	Automobil auto = new Automobil("Skodila", "Zelena", 2020, 2000, 4, "Dizel");
	        
	    	Kamion kamion = new Kamion("Vozaci MANa", "Zlatna", 1999, 120000, 20, true);
	        
	    	Kombi kombi = new Kombi("Sprinter", "Bijela", 2015, 2500, 15);

	        
	    	//
	    	
	    	
	        System.out.println("== Automobil ==");
	        auto.Informacije();
	        
	        System.out.println("Cijena registracije je " + auto.izracunajCijenuRegistracije() + " eura");

	        
	        //
	        
	        System.out.println("\n== Kamion ==");
	        kamion.Informacije();
	       
	        System.out.println("Cijena registracije je " + kamion.izracunajCijenuRegistracije() + " eura");

	        
	        //
	        
	        
	        System.out.println("\n== Kombi ==");
	        kombi.Informacije();
	       
	        System.out.println("Cijena registracije je " + kombi.izracunajCijenuRegistracije() + " eura");
	  
	    
	        //
	        
	    
	    }
	

	
	
}

