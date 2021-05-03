package de.telekom.sea.seminar;

public class VerwaltungsGruppe extends BaseObject implements MyList, EventRegistration {

	private Object[] objectListe = new Object[15];
	private int index = 0;
	
	private EventListener eventListener;

	public boolean add(Object obj) {
		if (obj != null) {
			while (objectListe[index] != null) {
				index++;
			}
			objectListe[index] = obj;
			System.out.println("index = " + index);
			++index;
			Event event = new Event();
			event.setDescription("Teilnehmer added");
			eventListener.receive(event);
			return true;
		}

		else {
			return false;
		}
	}
	
	public void subscribe(EventListener eventListener) {
		this.eventListener = eventListener;
	}
	
	public int size() {
		int sum = 0;
		for (int i = 0; i < objectListe.length; i++) {
			if (objectListe[i] != null) {
				sum++;
			}
		}
		return sum;
	}

	public Object get(int i) {
//		System.out.println("teilnehmerGruppe[" + i + "] " + ((Person) objectListe[i]).getVorname() + " "
//				+ ((Person) objectListe[i]).getNachname());
		return objectListe[i];

	}

	public boolean remove(Object obj) {
		int i = 0;
		if (obj != null) {
			while (objectListe[i] != obj) {
				i++;
			}
			objectListe[i] = null;
			index = i;
			return true;
		}
		return false;
	}

	public boolean remove(int index) {
		int i;
		if (index >= 0 && index < this.size()) {
			objectListe[index] = null;
			i = index;
			while ((i < objectListe.length) && (objectListe[i + 1] != null)) {
				objectListe[i] = objectListe[i + 1];
				objectListe[i + 1] = null;
				i++;
			}
			return true;
		} else
			return false;
	}

	public void clear() {
		for (int i = 0; i < objectListe.length; i++) {
			objectListe[i] = null;}
		Event event = new Event();
		event.setDescription("Alle Teilnehmer deleted");
		eventListener.receive(event);
	}

	public boolean doubleCheck(Object obj) {
		for (int i = 0; i < objectListe.length; i++) {
			if (objectListe[i] == obj) {
				return true;
			}
		}
		return false;
	}

}
