package de.telekom.sea.seminar;

public class SeminarApp {
	
	public Object parent;
	
	public void run(String[] args) {
		Person child = new Person();
		child.parent = this;
		System.out.println("Hello Maven");
	}

}
