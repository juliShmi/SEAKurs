package de.telekom.sea.seminar;

public class Person extends BaseObject {

	private String vorname;
	private String nachname;

	public void abs() {
		System.out.println(getI());
		super.setI(3);
	}

	public void setVorname(String p_vorname) {
		vorname = p_vorname;
	}

	public void setNachname(String p_nachname) {
		nachname = p_nachname;
	}

	public String getVorname() {
		return (vorname);
	}

	public String getNachname() {
		return (nachname);
	}

	public boolean equals(final Object obj) {
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
