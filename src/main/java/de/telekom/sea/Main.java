package de.telekom.sea;

import de.telekom.sea.seminar.SeminarApp;

public class Main {

	public static void main(String[] args) {
		SeminarApp app = new SeminarApp(); //app - Referenz, new SeminarApp - Instanz
		var app2 = app.getRootApp();
		System.out.println(app2);
		System.out.println(app);
		//app.getRootApp(); //return new SeminarApp
		app.setParent(null);	//null to exclude parameter
		app.run(args);

	}

}
