package de.telekom.sea.seminar;

public class SeminarApp {
	
	private Object parent;
	private static SeminarApp thisisInstance;
	
	public Object getParent() {
		return parent;
	}
	
	public void setParent(Object parent) {
		this.parent = parent;
	}
	
	public void run(String[] args) {
		Person child = new Person();
		child.setParent(this);
		System.out.println("Hello Maven");
	}
	
	public static Object getRootApp() {
		//return this; impossible if static
		return thisisInstance;
		
	}

}
