package de.telekom.sea;

import java.io.IOException;

import de.telekom.sea.seminar.run.SeminarApp;

public class Main {

	public static void main(String[] args) throws IOException {
		//SeminarApp app = new SeminarApp(); // app - Referenz, new SeminarApp - Instanz
		var app = SeminarApp.getRootApp();
		app.setParent(null); // null to exclude parameter
		app.run(args);

	}

}
