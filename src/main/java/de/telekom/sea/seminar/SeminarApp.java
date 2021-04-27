package de.telekom.sea.seminar;

public class SeminarApp extends Child{

	private static SeminarApp thisInstance;

	public SeminarApp() { // Constructor
		thisInstance = this;
	}

	public void run(String[] args) {
		Person child = new Person();
		child.setParent(null);
		System.out.println("Hello World");
		
		Person teilnehmer1 = new Person(); // !! for the class initialization
		teilnehmer1.setVorname("Hans");
		teilnehmer1.setNachname("Mueller");

		Person teilnehmer2 = new Person();
		teilnehmer2.setVorname("Iuliia");
		teilnehmer2.setNachname("Shmitko");

		System.out.println(teilnehmer1.getVorname() + " " + teilnehmer1.getNachname());
		System.out.println(teilnehmer2.getVorname() + " " + teilnehmer2.getNachname());

		VerwaltungsGruppe gruppe1 = new VerwaltungsGruppe();
		gruppe1.add(teilnehmer1);
		gruppe1.add(teilnehmer2);

		System.out.println("Size is: "+ gruppe1.size());
		
		gruppe1.get(0);
		gruppe1.get(1);
		gruppe1.size();
		gruppe1.remove(teilnehmer1);
		System.out.println("Size is: "+ gruppe1.size());
	
	}

	public static Object getRootApp() {
		// return this; impossible if static
		return thisInstance;

	}

}
