package de.telekom.sea.seminar;

public class Person extends BaseObject {
		
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

}
