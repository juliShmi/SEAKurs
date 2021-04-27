package de.telekom.sea.seminar;

public class SeminarApp {
	
	private Object parent;
	
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
	
	public Object getRootApp() {
		return this;
		
	}

}
