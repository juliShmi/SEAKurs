package de.telekom.sea.seminar;

public class BaseObject extends Object { // interites all methods from Object e.g. hashCode, toString, equals etc.

	// explizite parent - child Beziehung

	private Object parent;

	private int i;

	public int getI() {
		return i;
	}

	protected void setI(int i) {
		this.i = i;
	}

	// eindeutige ID fuer jede neue Instanz
	private long id;

	private static long idCounter = 1; // globale variable; static means that generierten objects get counter 1

	public BaseObject() {
		this.id = idCounter++; // counter +1 through the generation ob a new object
	}

	public Long getId() {
		return id;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;

	}

	@Override

	public String toString() {
		return ((Long) id).toString(); // can be Object as well but it's better to have features of the defined
										// primitive date type
	}

	@Override
	public boolean equals(Object obj) {
		/*
		 * if (obj == this) { // dieselbe Identitaet festzustellen (bin ich ich?) return
		 * true; } if (obj == null) { // is Object null? return false; }
		 */ if (!(obj instanceof BaseObject)) { // wenn das ist nicht ein Instanz von BaseObject (derselbe Typ)
			return false;
		}
		BaseObject baseobject = (BaseObject) obj; // cast auf den Typ BaseObject

		return (baseobject.id == this.id); // <---- short version of if-else (compares inhalt (id))
	}
}
