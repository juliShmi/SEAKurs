package de.telekom.sea.seminar.run;

import java.io.IOException;

import de.telekom.sea.seminar.BaseObject;
import de.telekom.sea.seminar.Menu;
import de.telekom.sea.seminar.VerwaltungsGruppe;
import de.telekom.sea.seminar.interfaces.MyList;
import de.telekom.sea.seminar.interfaces.MyMenu;

public class SeminarApp extends BaseObject {

	private static SeminarApp theInstance; // = null by default

	private SeminarApp() {
	}

	public void run(String[] args) throws IOException {

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
