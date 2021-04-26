
public class Teilnehmer {

	private String vorname;
	private String nachname;

	// set name
	public void setVorname(String p_vorname) {
		vorname = p_vorname;
	}

	// set surname
	public void setNachname(String p_nachname) {
		nachname = p_nachname;
	}

	// get name
	public String getVorname() {
		return (vorname);
	}

	// get surname
	public String getNachname() {
		return (nachname);
	}

	// compare content and address of 2 classes
	public boolean equals(Teilnehmer person) {
	   
	        if (person == null) {
	        	System.out.println("person zum Vergleich verweist auf nichts! noch nicht instanziiert!");
	        	return false;
	        }
	        // check Referenz bzw. Adresse
	        if (this == person) {
	        	System.out.println(person.getVorname() + " " + person.getNachname() +
	        			" ist dieselbe Person " + getVorname() + " " + this.getNachname());
	        	return true;
	        }
	       
	        // check Klassen-Typen
	        if ((getClass()) != (person.getClass())) {
	        	System.out.println(person.getVorname() + " " + person.getNachname() +
	        			" hat andere Typ als Person: " + this.getVorname() + " " + this.getNachname());
	        	return false;
	        }
	       
	        // check der Inhalte beiden Klassen
	        if ( (this.getVorname() == person.getVorname()) && (this.getNachname() == person.getNachname())) {
	        	System.out.println(person.getVorname() + " " + person.getNachname() +
	        			" ist dieselbe Person " + this.getVorname() + " " + this.getNachname());
	        	return true;
	        }
	       
	        else {
	        	System.out.println(person.getVorname() + " " + person.getNachname() +
	        			" ist Unterschiedlich als Person : " + this.getVorname() + " " + this.getNachname());
	        	return false;
	        } 	
	}
}
