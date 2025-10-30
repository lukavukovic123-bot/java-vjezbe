public class Kombi extends Vozilo {

    private int kapacitetPutnika;

    public Kombi(String proizvodjac, String boja, int godinaProizvodnje, int kubikaza, int kapacitetPutnika) {
        super(proizvodjac, boja, godinaProizvodnje, kubikaza);
        this.kapacitetPutnika = kapacitetPutnika;
    }

    public int getKapacitetPutnika() {
        return kapacitetPutnika;
    }

    public void setKapacitetPutnika(int kapacitetPutnika) {
        this.kapacitetPutnika = kapacitetPutnika;
    }

	public void Informacije() {
	   System.out.println ("==Kapacitet putnika==\n" + kapacitetPutnika);
	   
   }
	
	
	public double izracunajCijenuRegistracije() {
        double cijena = super.izracunajCijenuRegistracije();

        if (kapacitetPutnika > 8) {
            cijena += 30;
        }

        return cijena;
    }
	
}

