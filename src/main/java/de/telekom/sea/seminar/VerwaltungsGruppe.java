package de.telekom.sea.seminar;

public class VerwaltungsGruppe extends Child{

	private Object[] objectListe = new Object[15];
	private int index = 0;

	public boolean add(Object obj) {
		if (obj != null) {
			while (objectListe[index] != null) {
				index++;
			}
			objectListe[index] = obj;
			System.out.println("index = " + index);
			++index;
			return true;
		}

		else {
			return false;
		}
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
		System.out.println("teilnehmerGruppe[" + i + "] " + ((Person) objectListe[i]).getVorname() + " "
				+ ((Person) objectListe[i]).getNachname());
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

	public void clear() {
		for (int i = 0; i < objectListe.length; i++) {
			objectListe[i] = null;
		}
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
