package de.telekom.sea.seminar;

public class SeminarApp extends BaseObject {

	private static SeminarApp theInstance; // = null by default

	private SeminarApp() {}

	public void run(String[] args) {
//		//
		MyList verwaltungsgruppe = new VerwaltungsGruppe();
		MyMenu menu2 = new Menu(); // empty constructor

		MyMenu menu = new Menu(verwaltungsgruppe); // constructor with parameter
		menu.keepAsking();

	}

	public static SeminarApp getRootApp() {
		if (theInstance == null) {
			theInstance = new SeminarApp();
		}
		// return this; impossible if static
		return theInstance;

	}

}
