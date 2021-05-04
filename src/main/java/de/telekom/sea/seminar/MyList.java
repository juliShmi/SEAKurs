package de.telekom.sea.seminar;

public interface MyList extends EventRegistration {

	public boolean add(Object obj);

	public int size();

	public Object get(int i);

	public boolean remove(String firstName, String lastName);

	public boolean remove(int i);

	public void clear();

}
