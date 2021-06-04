package de.telekom.sea.seminar;

import de.telekom.sea.seminar.events.Event;
import de.telekom.sea.seminar.events.EventListener;
import de.telekom.sea.seminar.events.EventRegistration;
import de.telekom.sea.seminar.interfaces.MyList;

public class BaharakVGruppe extends BaseObject implements MyList, EventRegistration {
	/** Liste aller Teinelhmern ist ein array und hat die Länge 15 d.h. maximal 15
	 * Object in diesm Fall Personen duerfen an Seminar teilnehmen
	 */
	private final static int MAX_SIZE = 3;
	private Object[] objectList;	
	private int index;                 // integer Variable die die Navigationin die Array-Elemente steuert
	private EventListener listener;    // listener oder subscriber
	private String description;        // event message zur Benachrichtigung eines Subscribers
	
	/** construtor für den Fall dass diese Klasse ohne Input Parameter (Anzahl der Personen)
	 * konstruiert werden soll. Der Konstruktor setzt defaultmäßig die Anzahl
	 * der Teilnehmern auf 5!
	 * @throws MyException
	 */
	public BaharakVGruppe() throws MyException {
		this(3);
	}
	
	/** consctructor of VerwaltungsGruppe with size
	 * @param size
	 * @throws MyException
	 */
	public BaharakVGruppe (int size) throws MyException {
		if (size <= 0 || size > MAX_SIZE) {
			throw new MyException("\nLänge der Liste passt nicht!! muss zwischen 1 und " + MAX_SIZE + " sein!!!");
		}
		else
			objectList = new Object[size];
	}
	/** ein Object wird angemeldet: d.h. die Anmeldung wird nur dann erfolgen wenn
	 *  folgende Voraussetzungen erfüllt sind: 1- für den Object muss ein Instanz
	 *  initialisiert sein 2- der Object darf nicht zum zweiten Mal sich anmelden
	 *  (hierzu wird ein dubletten check durchgeführt 3- in den Seminar muss
	 *  mindestens ein freier Platz geben
	 */
	public boolean add(final Object obj) throws IndexOutOfBoundsException {
		if (size() >= objectList.length) {
			throw new IndexOutOfBoundsException("Maximale Größe ist bereits erreicht!!!");
		}
		if ((obj == null))
			return false;	
		if (!(doubleCheck(obj))) {	
			while (objectList[index] != null) {
				index++;
			}
			objectList[index++] = obj;
			if (size() == objectList.length)
				description = "a new person has been added.\n List is now full!!!";
			else
				description = "a new person has been added.";
			sendEvent(description);
			return true;
		}
		description = "the person is already registered!";
		sendEvent(description);
		return false;
	}
	/** gibt die aktuelle Größe der Liste zurück
	 */
	public int size() {
		return index;
	}
	/** gibt die maximale erlaubte Größe der Liste bzw. Anzahl der Teilnehmer zurück
	 */
	public int getMaxsize() {
		return objectList.length;
	}
	/** die Referenz eines Objects in Array wird geliefert
	 */
	public Object get(int i) {
		if (objectList[i] == null) {
			throw new RuntimeException("ObjectList[" + i + "] verweist auf null - Verletzung der Regel!!!");
		}
		return objectList[i];
	}
	/** Ein Object wird gelöscht:
	 */
	public boolean remove(final Object obj) {
		if ((obj == null) || !(obj instanceof Person))
			return false;
		for (int i = 0; i < size(); i++) {
			if (get(i).equals(obj)) {
				--index;
				shiftList(i);
				description = "a person has been deleted.";
				sendEvent(description);
				return true;
			}
		}
		return false;
	}
	/** Ein Object wird gelöscht anhand Angabe von TeilnehmerId
	 */
	public boolean removeById(final long l) {
		for (int i = 0; i < size(); i++) {
			if (((Person) objectList[i]).getId() == l) {
				--index;
				shiftList(i);
			
				description = "a person has been deleted.";
				sendEvent(description);
				return true;
			}
		}
		return false;
	}
	/** Ein Object wird gelöscht:
	 */
	public boolean removeByIndex(int i) {
		if ((get(i) == null) || !(get(i) instanceof Person))
			return false;
		--index;
		shiftList(i);
		description = "a person has been deleted.";
		sendEvent(description);
		return true;
	}
	/**
	 * nach Löschen jedes element in der Liste werden immer andere Element nach
	 * hinten verschoben somit man keine freie Stelle in Array zwischen Elemente
	 * läßt
	 */
	private void shiftList(int i) {
		for (int j = i; j < size(); j++) {
			objectList[j] = get(j + 1);
		}
		objectList[index] = null;
	}
	/** finde das Object zum Löschen anhand eindeutige Id
	 */
	public Object findObjectById(final long l) {
		for (int i = 0; i < size(); i++) {
			if (((Person) objectList[i]).getId() == l) {
				return (Person) get(i);
			}
		}
		return null;
	}
	/** finde Index von der Liste wo ein Object mit Id=l zum Löschen gibt
	 */
	public int findIndexById(final long l) {
		for (int i = 0; i < size(); i++) {
			if (((Person) objectList[i]).getId() == l) {
				return i;
			}
		}
		return size();
	}
	/** es wird in der Lister der angemeldeten Object geprüft ob der Object nicht
	 *  bereits angemeldet ist
	 */
	private boolean doubleCheck(Object obj) {
		for (int i = 0; i < size(); i++) {
			if (objectList[i] == obj) {
				return true;
			}
		}
		return false;
	}
	/** Die Liste der Objecte wird gelöscht und index auch auf 0 gesetzt.
	 */
	public void clear() {
		if (size() > 0) {
			index = 0;
			objectList = new Object[10];
			description = "list of persons has been deleted";
			sendEvent(description);
		}
	}
	/** suche nach alle Personen die Vorname = vorname haben
	 */
	public BaharakVGruppe searchName(final String vorname) throws MyException {
		
		BaharakVGruppe subList = new BaharakVGruppe(size());	
		
			for (int i = 0; i < size(); i++) {
				String treffer = ((Person) get(i)).getVorname();		
				if (treffer.toLowerCase().startsWith(vorname.toLowerCase())) {
					subList.add((Person) get(i));
				}
			}
			return subList;
	}
	
	/** suche nach alle Personen die Nachname = nachname haben
	 */
	public BaharakVGruppe searchSurname(final String nachname) throws MyException {
		
		BaharakVGruppe subList = new BaharakVGruppe(size());	
		
			for (int i = 0; i < size(); i++) {
				String treffer = ((Person) get(i)).getNachname();		
				if (treffer.toLowerCase().startsWith(nachname.toLowerCase())) {
					subList.add((Person) get(i));
				}
			}
			return subList;
	}
	
	/** suche nach alle Personen die ID = id haben
	 */
	public BaharakVGruppe searchId(final long id) throws MyException {
		
		BaharakVGruppe subList = new BaharakVGruppe(size());	
		
			for (int i = 0; i < size(); i++) {
				long treffer = (((Person) get(i)).getId());		
				if (treffer == id ) {
					subList.add((Person) get(i));
				}
			}
			return subList;
	}
	
	/** bietet Abonnement an das Menu an
	 */
	public void subscribe(EventListener eventListener) {
		if (eventListener != null)
			listener = eventListener;
	}
	
	/** Abmeldung von Listener Menu
	 */
	public void unsubscribe(EventListener eventListener) {
		if ((eventListener != null) && listener == eventListener)
			listener = null;
	}
	/** Event-Versand
	 * @param message
	 */
	private void sendEvent(String message) {
		if (listener != null) {
			Event event = new Event();
			event.description = message;
			listener.receive(event);
		}
	}
	
	@Override
	public boolean equals(final Object obj) {
		for (int i = 0; i < size(); i++) {
			if (((Person) objectList[i]).equals(obj)) {
				return true;
			}
		}
		return false;
	}
//	@Override
//	public String toString() {
//
//		for (int i = 0; i < size(); i++) {
//			if (((Person) objectList[i]).equals(obj)) {
//				return get(i).toString();
//			}	
//	}

	@Override
	public boolean remove(String vornameToRemove, String nachnameToRemove) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MyList search(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}
} // Ende VerwaltungsGruppe