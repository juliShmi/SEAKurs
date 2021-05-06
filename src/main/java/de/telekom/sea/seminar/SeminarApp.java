package de.telekom.sea.seminar;

public class SeminarApp extends BaseObject {

	private static SeminarApp theInstance; // = null by default

	private SeminarApp() {
	}

	public void run(String[] args) {

		MyList verwaltungsGruppe = new VerwaltungsGruppe();
		try (MyMenu menu = new Menu(verwaltungsGruppe)) {

			verwaltungsGruppe.subscribe(menu);
			menu.keepAsking();

		}
	}

	public static SeminarApp getRootApp() {
		if (theInstance == null) {
			theInstance = new SeminarApp();
		}

		return theInstance;

	}

}
