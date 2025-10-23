package com.udg.edu.me;

import java.util.ArrayList;

public class Student {

		public String ime;
		public String prezime;
		public String brojIndeksa;
		public String adresa;
		public float brojBodova;
		public boolean polozioIliNe;
		public static int prolazNaIspitu;
		
//konstruktor
		public Student(String ime, String prezime, String brojIndeksa, String adresa, float brojBodova) {
			this.ime = ime;
			this.prezime = prezime;
			this.brojIndeksa = brojIndeksa;
			this.adresa = adresa;
			this.brojBodova = brojBodova;
			this.azurirajProlaz();
		}
		
//geteri i seteri
		public String getIme() {
			return ime;
		}

		public void setIme(String ime) {
			this.ime = ime;
		}

		public String getPrezime() {
			return prezime;
		}

		public void setPrezime(String prezime) {
			this.prezime = prezime;
		}

		public String getBrojIndeksa() {
			return brojIndeksa;
		}

		public void setBrojIndeksa(String brojIndeksa) {
			this.brojIndeksa = brojIndeksa;
		}

		public String getAdresa() {
			return adresa;
		}

		public void setAdresa(String adresa) {
			this.adresa = adresa;
		}

		public float getBrojBodova() {
			return brojBodova;
		}

		public void setBrojBodova(float brojBodova) {
			this.brojBodova = brojBodova;
			this.azurirajProlaz();
		}

		public boolean isPolozioIliNe() {
			return polozioIliNe;
		}

		public void setPolozioIliNe(boolean polozioIliNe) {
			this.polozioIliNe = polozioIliNe;
		}

		public static int getProlazNaIspitu() {
			return prolazNaIspitu;
		}

		public static void setProlazNaIspitu(int prolazNaIspitu) {
			Student.prolazNaIspitu = prolazNaIspitu;
		}

		@Override
		public String toString() {
			if (this.polozioIliNe)
			return "Student [name=" + ime + ", prezime=" + prezime + ", brojIndeksa=" + brojIndeksa + ", adresa=" + adresa
					+ ", brojBodova=" + brojBodova + ", polozioIliNe=" + "polozio" + "]";
		else {
			return "Student [name=" + ime + ", prezime=" + prezime + ", brojIndeksa=" + brojIndeksa + ", adresa=" + adresa
					+ ", brojBodova=" + brojBodova + ", polozioIliNe=" + "nije polozio" + "]";
	}
}


		
		public void azurirajProlaz() {
		    this.polozioIliNe = this.brojBodova >= Student.prolazNaIspitu;
		}
		
		
		public static ArrayList<Student> izdvojUlica(ArrayList<Student> niz, String ulica) {
			ArrayList<Student> izdvojeno = new ArrayList<Student>();
			
			for(Student s: niz)
				if (s.getAdresa().contains(ulica)) {
					izdvojeno.add(s);
				}
			return izdvojeno;
		}
		
		
		public
		static ArrayList<Student> izdvojProlazNaIspitu(ArrayList<Student>
		niz, 
		boolean poloziliNisuPolozili){


		ArrayList<Student> 
		izdvojeno = new ArrayList<Student>();



		for(Student
		s: niz) {


		if(poloziliNisuPolozili ==
		s.isPolozioIliNe())


		izdvojeno.add(s);


		/*


		if(poloziliNisuPolozili && s.isPolozioIliNe())


		izdvojeno.add(s);


		if(!poloziliNisuPolozili && !s.isPolozioIliNe())


		izdvojeno.add(s);


		*/


		}
		return izdvojeno;


}
}
