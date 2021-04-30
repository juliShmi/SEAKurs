package de.telekom.sea.seminar;

public class SeminarApp extends BaseObject {

	private static SeminarApp thisInstance; // = null by default

	public SeminarApp() {
		if (thisInstance == null) // Constructor {

			thisInstance = this;
	}

	public void run(String[] args) {
//		//
		MyList verwaltungsgruppe = new VerwaltungsGruppe();
		MyMenu menu2 = new Menu(); // empty constructor

		MyMenu menu = new Menu(verwaltungsgruppe); // constructor with parameter
		menu.keepAsking();

	}

	public static Object getRootApp() {
		// return this; impossible if static
		return thisInstance;

	}

}
