
public class VerwaltungsGruppeBaharak implements MyList {
		/*
		 * Liste aller Teinelhmern ist ein array und hat die Länge 15 d.h. maximal 10
		 * Object dürfen an Seminar teilnehmen
		 */

		private Object[] objectListe = new Object[15];

		/* index ist eine integer Variable die den Zugang in Array-Elemente steuert */
		private int index;

		/*
		 * ein Object wird angemeldet: d.h. die Anmeldung wird nur dann erfolgen wenn
		 * folgende Voraussetzungen erfüllt sind: 1- für den Object muss ein Instanz
		 * initialisiert sein 2- der Object darf nicht zum zweiten Mal sich anmelden
		 * (hierzu wird ein dubletten check durchgeführt 3- in den Seminar muss
		 * mindestens ein freier Platz geben
		 */
		public boolean add(Object obj) {
			if ((obj != null) && (dublettenCheck(obj) != true)) {
				while (objectListe[index] != null) {
					index++;
				}
				objectListe[index++] = obj;
				return true;
			}
			return false;
		}

		// Berechnung von Anzahl der angemeldeten Object
		public int size() {
			int sum = 0;
			for (int i = 0; i < objectListe.length; i++) {
				if (objectListe[i] != null) {
					sum++;
				}
			}
			return sum;
		}

		// die Adresse eines Objects in Array wird geliefert
		public Object get(int i) {
			return objectListe[i];
		}

		/*
		 * Object wird abgemeldet:
		 */
		public boolean remove(Object obj) {
			if (obj != null) {
				for (int i = 0; i < objectListe.length; i++) {
					if (get(i) == obj) {
						objectListe[i] = null;
						index = 0;
						return true;
					}
				}
			}
			return false;
		}

		/*
		 * es wird in der Lister der angemeldeten Object geprüft ob der Object nicht
		 * bereits angemeldet ist
		 */
		public boolean dublettenCheck(Object obj) {
			for (int i = 0; i < objectListe.length; i++) {
				if (objectListe[i] == obj) {
					return true;
				}
			}
			return false;
		}

		/*
		 * Die Liste der angemeldeten Object wird ausgegeben
		 */
		public void printList() {
			for (int i = 0; i < objectListe.length; i++) {
				if (objectListe[i] != null)
					System.out.println(
							"Object[" + i + "]: " + objectListe[i] + " " + ((Teilnehmer) objectListe[i]).getVorname());
			}

		}
	} // Ende VerwaltungsGruppe

