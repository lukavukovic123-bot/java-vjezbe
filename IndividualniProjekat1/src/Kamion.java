public class Kamion extends Vozilo {

	    private double kapacitetTereta;
	    private boolean imaPrikolicu;

	    public Kamion(String proizvodjac, String boja, int godinaProizvodnje, int kubikaza, double kapacitetTereta, boolean imaPrikolicu) {
	        super(proizvodjac, boja, godinaProizvodnje, kubikaza);
	        this.kapacitetTereta = kapacitetTereta;
	        this.imaPrikolicu = imaPrikolicu;
	    }

	    public double getKapacitetTereta() {
	        return kapacitetTereta;
	    }

	    public void setKapacitetTereta(double kapacitetTereta) {
	        this.kapacitetTereta = kapacitetTereta;
	    }

	    public boolean isImaPrikolicu() {
	        return imaPrikolicu;
	    }

	    public void setImaPrikolicu(boolean imaPrikolicu) {
	        this.imaPrikolicu = imaPrikolicu;
	    }

	   public void Informacije() {
		   System.out.println ("==Kapacitet tereta==\n" + kapacitetTereta + "tona");
		   System.out.println ("==Ima prikolicu==\n" + (imaPrikolicu ? "Da" : "Ne"));
		   
	   }
	   
	   public double izracunajCijenuRegistracije() {
	        double cijena = super.izracunajCijenuRegistracije();

	        if (imaPrikolicu) {
	            cijena += 50;
	        }

	        return cijena;
	    }
	   	   
}

	

