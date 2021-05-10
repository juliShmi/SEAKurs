package de.telekom.sea.seminar;

public interface MyList extends EventRegistration {
	
	public boolean add(Object obj); //anmelden
	
	public int size(); // anzahlTeilnehmer
	
	public Object get(int i); //getTeilnehmer
	
	public boolean remove(String vornameToRemove, String nachnameToRemove);
	
	public boolean remove(int i);
	
	public void clear();
	
	public MyList search(String searchString);
		
	
	//public boolean equalsLists(Object obj);//public void printList();
}

