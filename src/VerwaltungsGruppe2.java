
public class VerwaltungsGruppe2 implements MyList {
	
	private int anzahl = 10;
	private Object[] liste = new Object[anzahl];

	public boolean add(Object obj) {
		for (int i = 0; i < anzahl; i++) {
			if (liste[i] == null) {
				liste[i] = (Object) obj;
				return true;
			}
		}
		return false;
	}

	public int size() {
		for (int i = 0; i < anzahl; i++) {
			if (liste[i] == null) {
				System.out.println(i);
				return i;
			}
		}
		return anzahl;
	}

	public Object get(int teiln) {
		if (liste[teiln] == null) {
			return null;
		}
		return liste[teiln];
	}

	public boolean remove(Object obj) {
		int derLetzte = 0;

		for (int j = 0; j < anzahl; j++) {
			if (liste[j] == null) {
				derLetzte = j - 1;
				break;
			} else {
				derLetzte = j;
			}
		}

		if (derLetzte < 0) {
			return false;
		}
		for (int i = 0; i < anzahl; i++) {
			if (obj == liste[i]) {
				liste[i] = liste[derLetzte];
				liste[derLetzte] = null;
				return true;
			}
		}
		return false;
	}
}
