package de.telekom.sea.seminar;

public class SeminarApp extends Child {

	private static SeminarApp thisInstance;

	public SeminarApp() { // Constructor
		thisInstance = this;
	}

	public void run(String[] args) {
		Person child = new Person();
		child.setParent(this);
		System.out.println("Hello Maven");
	}

	public static Object getRootApp() {
		// return this; impossible if static
		return thisInstance;

	}

}
