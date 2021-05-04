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
			event.setDescription("Person added");
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
		return objectListe[i];

	}

	public boolean remove(String vornameToRemove, String nachnameToRemove) {
		boolean success = false;
		if (this.objectListe.length > 0)
			for (int i = 0; i < this.objectListe.length; i++) {
				Person sPerson = (Person) this.objectListe[i];
				if ((sPerson.getVorname().equals(vornameToRemove))
						&& (sPerson.getNachname().equals(nachnameToRemove))) {
					this.objectListe[i] = null;
					for (int j = i; j < this.size(); j++) {
						this.objectListe[j] = objectListe[j + 1];
						objectListe[j + 1] = null;
					}
					Event event = new Event();
					event.setDescription("Person(s) by name " + vornameToRemove + " " + nachnameToRemove + " deleted");
					eventListener.receive(event);
					success = true;
					return success;
				}

			}
		return success;
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
			Event event = new Event();
			event.setDescription("Person in position" + i + " is deleted");
			eventListener.receive(event);
			return true;
		} else
			return false;
	}

	public void clear() {
		for (int i = 0; i < objectListe.length; i++) {
			objectListe[i] = null;
		}
		Event event = new Event();
		event.setDescription("All persons deleted");
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
