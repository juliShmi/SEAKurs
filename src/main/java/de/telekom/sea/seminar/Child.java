package de.telekom.sea.seminar;

public class Child extends Object{ //interites all methods from Object e.g. hashCode, toString, equals etc.

	private Object parent;

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
		
	}
}
