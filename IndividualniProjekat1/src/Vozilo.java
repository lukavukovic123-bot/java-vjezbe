public class Vozilo {

    private String proizvodjac;
    private String boja;
    private int godinaProizvodnje;
    private int kubikaza;


    public Vozilo(String proizvodjac, String boja, int godinaProizvodnje, int kubikaza) {
        this.proizvodjac = proizvodjac;
        this.boja = boja;
        this.godinaProizvodnje = godinaProizvodnje;
        this.kubikaza = kubikaza;
    }

    
    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(int godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public int getKubikaza() {
        return kubikaza;
    }

    public void setKubikaza(int kubikaza) {
        this.kubikaza = kubikaza;
    }

    
    public void Informacije() {
    	System.out.println ("==Proizvodjac==\n" + proizvodjac);
    	System.out.println ("==Boja==\n" + boja);
    	System.out.println ("==Godina proizvodnje==\n" + godinaProizvodnje);
    	System.out.println ("==Kubikaza==\n" + kubikaza + "cm3");
    	
    }


	public double izracunajCijenuRegistracije() {
		 double cijena = 100.0; 
	        
	        
	        if (godinaProizvodnje < 2000) {
	            cijena += 50;
	        } else if (godinaProizvodnje < 2010) {
	            cijena += 30;
	        }

	        return cijena;
	}
    	
   

}
    
    
   
