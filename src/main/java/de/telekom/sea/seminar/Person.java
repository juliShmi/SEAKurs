package de.telekom.sea.seminar;

public class Person extends BaseObject {

	private String vorname;
	private String nachname;

	private Anrede anrede;
	private long id;

	public Person() {

	}

	public Person(String vorname, String nachname, Anrede anrede) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.anrede = anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = Anrede.fromString(anrede);
	}

	public Anrede getAnrede() {
		return this.anrede;
	}

	public void abs() {
		System.out.println(getI());
		super.setI(3);
	}

	public void setID(long id) {
		this.id = id;
	}

	public long getID() {
		return this.id;
	}

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

	public boolean equals(final Object obj) {
//		if (obj == this) {			
//			return true;
//		}
//		if (obj == null) {			
//			return false;
//		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person person = (Person) obj;
		// this.equals(obj);
		if (!super.equals(obj)) {
			return false;// Aufruf der extended Klasse
		}
		// pruefen Vorname, Nachname
		System.out.println("");
		return true;
	}

}
