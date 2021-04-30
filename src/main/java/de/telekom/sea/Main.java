package de.telekom.sea;

import de.telekom.sea.seminar.SeminarApp;

public class Main {

	public static void main(String[] args) {
		//SeminarApp app = new SeminarApp(); // app - Referenz, new SeminarApp - Instanz
		var app = SeminarApp.getRootApp();
		app.setParent(null); // null to exclude parameter
		app.run(args);

	}

}
