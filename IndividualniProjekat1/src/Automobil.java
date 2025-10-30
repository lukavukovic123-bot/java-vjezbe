public class Automobil extends Vozilo {

	    private int brojVrata;
	    private String tipMotora;

	    public Automobil(String proizvodjac, String boja, int godinaProizvodnje, int kubikaza, int brojVrata, String tipMotora) {
	        super(proizvodjac, boja, godinaProizvodnje, kubikaza);
	        this.brojVrata = brojVrata;
	        this.tipMotora = tipMotora;
	    }

	    public int getBrojVrata() {
	        return brojVrata;
	    }

	    public void setBrojVrata(int brojVrata) {
	        this.brojVrata = brojVrata;
	    }

	    public String getTipMotora() {
	        return tipMotora;
	    }

	    public void setTipMotora(String tipMotora) {
	        this.tipMotora = tipMotora;
	    }

	   public void Informacije() {
		   System.out.println ("==Broj vrata==\n" + brojVrata);
		   System.out.println ("==Tip motora je==\n" + tipMotora);
	   }
	   
		   
		  public double izracunajCijenuRegistracije() {
	        double cijena = super.izracunajCijenuRegistracije();

	      
	        if (tipMotora.equalsIgnoreCase("dizel")) {
	            cijena += 20;
	        }

	        return cijena;
	      
  }
	}

	

