public class KompleksniBroj {
	//Atributi klase
	
	private float realniDio;
	private float imaginarniDio;
	
	//konstruktori
	public KompleksniBroj() { 
		realniDio = 0;
		imaginarniDio = 0;
	}	
	
	public KompleksniBroj(float a, float b) {
		realniDio = a;
		imaginarniDio = b;
	}
	
	public KompleksniBroj(float a) {
		realniDio = a;
		imaginarniDio = 0;	
	}
	
	//geteri i seteri
	public float dajRealniDio() {
		return realniDio;
	}
	
	public float dajImaginarniDio() {
		return imaginarniDio;
	}
	
	public float postaviRealniDio(float a) {
		realniDio = a;
	    		return realniDio;
	}
	 
	public float postaviImaginarniDio(float b) {
		imaginarniDio = b;
		return imaginarniDio;
	}

	
	
	
	
	public void odstampaj() {
		if (imaginarniDio >= 0) 
			System.out.printf("%.2f + %.2fi\n", realniDio, imaginarniDio);
		 else 
			System.out.printf("%.2f - %.2fi\n", realniDio, -imaginarniDio);
		
	}

		
	//moduo
		
	public float moduo() {
		return (float) Math.sqrt(realniDio * realniDio + imaginarniDio * imaginarniDio);	
		
	}
	
	//sabiranje
	
	public KompleksniBroj saberi(KompleksniBroj a) {
		KompleksniBroj rez =  new KompleksniBroj();
		rez.realniDio = realniDio + a.realniDio ; 
		rez.imaginarniDio = imaginarniDio + a.imaginarniDio;
		return rez;
	}
	
	
	public static KompleksniBroj saberi(KompleksniBroj a, KompleksniBroj b) {
		KompleksniBroj rez = new KompleksniBroj();
		rez.postaviRealniDio(a.dajRealniDio() + b.dajRealniDio());
		rez.postaviImaginarniDio(a.dajImaginarniDio() + b.dajImaginarniDio());
		return rez;
		
	}
	
	
	
	//oduzimanje
	public KompleksniBroj oduzmi(KompleksniBroj a) {
		KompleksniBroj rez =  new KompleksniBroj();
		rez.postaviRealniDio(dajRealniDio() - a.dajRealniDio());
		rez.postaviImaginarniDio(dajImaginarniDio() - a.dajImaginarniDio());
		return rez;
	
	}
	
	
	
	public static KompleksniBroj oduzmi(KompleksniBroj a, KompleksniBroj b) {
		return new KompleksniBroj(a.dajRealniDio() - b.dajRealniDio(), a.dajImaginarniDio() - b.dajImaginarniDio());
	}
	
	
	//mnozenje
	public KompleksniBroj mnozenje(KompleksniBroj a) {
		KompleksniBroj rezultat = new KompleksniBroj();
		rezultat.postaviImaginarniDio(realniDio * a.realniDio - imaginarniDio * a.imaginarniDio);
		rezultat.postaviImaginarniDio(imaginarniDio * a.realniDio + realniDio * a.imaginarniDio);
		return rezultat;
		
	}
	
	public static KompleksniBroj mnozenje(KompleksniBroj a, KompleksniBroj b) {
		return new KompleksniBroj(a.dajRealniDio() * b.dajRealniDio() - a.dajImaginarniDio() * b.dajImaginarniDio(),
				a.dajImaginarniDio() * b.dajRealniDio() + a.dajRealniDio() * b.dajImaginarniDio());
	}
	
	
	//djeljenje 
	public KompleksniBroj podijeli(KompleksniBroj a) {
		KompleksniBroj rezultat = new KompleksniBroj();
		rezultat.postaviRealniDio(dajRealniDio() * a.dajImaginarniDio() + dajImaginarniDio() * a.dajImaginarniDio() / a.moduo() * a.moduo());
		rezultat.postaviImaginarniDio(dajImaginarniDio() * a.dajRealniDio() - dajImaginarniDio() * a.dajImaginarniDio() / a.moduo() * a.moduo());
		return  rezultat;
	
	}

	public void odstampaj1() {
		if (dajImaginarniDio() < 0 );
			System.out.printf("%.2f - %.2fi\n", dajRealniDio(), -dajImaginarniDio());
		 
			System.out.printf("%.2f + %.2fi\n", dajRealniDio(), dajImaginarniDio());
	}
	
	
	//staticke metode nemaju direktan pristup atributima klase
	public static KompleksniBroj odrediMaxMin(KompleksniBroj x[], boolean minIliMax) {
		KompleksniBroj minMax = x[0];
		for(int i =1; i < x.length; i++) {
			if(minIliMax) {
				if(minMax.moduo() < x[i].moduo()) {
					minMax = x[i];
				}
			} else {
				if(minMax.moduo() > x[i].moduo()) {
					minMax = x[i];
				}
			}
		}
		return minMax;
		
	}
	
	
}
