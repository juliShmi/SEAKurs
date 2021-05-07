package de.telekom.sea.seminar;

public class Menu implements MyMenu, EventListener, java.io.Closeable {

	private MyList verwaltungsGruppe;

	private java.util.Scanner scanner = new java.util.Scanner(System.in);
	private String result;

	public Menu(MyList myList) {
		verwaltungsGruppe = myList;
	}

	public Menu() {
	}

	@Override
	public void close() {
		scanner.close();
		System.out.println("Program is closed");
	}

	public void keepAsking() {
		do {
			showMenu();
			result = inputMenu();
			checkMenu(result);
		} while (!result.equals("6"));

	}

	public void receive(Event event) {
		listAllPersons();
		System.out.println(event.getDescription());
	}

	private void showMenu() {
		System.out.println("Menu: ");
		System.out.println("1: Person anlegen");
		System.out.println("2: Liste anzeigen");
		System.out.println("3: Liste löschen");
		System.out.println("4: Person löschen");
		System.out.println("5: Person suchen");
		System.out.println("6: Beenden");
	}

	private String inputMenu() {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		var input = scanner.nextLine();
		return input;

	}

	private void checkMenu(String eingabe) {
		switch (eingabe) {
		case "1":
			System.out.println("1: Person anlegen");
			inputPerson();
			break;
		case "2":
			System.out.println("2: Liste anzeigen");
			listAllPersons();
			break;
		case "3":
			System.out.println("3: Liste löschen");
			removeAll();
			break;
		case "4":
			System.out.println("4: Person löschen");
			removePerson();
			break;
		case "5":
			System.out.println("5: Person suchen");
			searchPerson();
			break;
		case "6":
			System.out.println("6: Beenden");
			break;
		default:
			System.out.println("Falsche Eingabe");
		}
	}

	private void inputPerson() {
		Person p = new Person();
		String firstName;
		String lastName;
		System.out.println("Bitte einen Vornamen eingeben: ");
		firstName = scanner.nextLine();
		System.out.println("Bitte einen Nachnamen eingeben: ");
		lastName = scanner.nextLine();
		p.setVorname(firstName);
		p.setNachname(lastName);
		verwaltungsGruppe.add(p);
	}

	private void listAllPersons() {
		if (verwaltungsGruppe.size() == 0) {
			System.out.println("Die Liste ist leer");
		} else {
			for (int i = 0; i < verwaltungsGruppe.size(); i++) {
				if (verwaltungsGruppe.get(i) != null) {
					Person p = (Person) verwaltungsGruppe.get(i);
					System.out.println(p.getVorname() + " " + p.getNachname());
				}
			}
		}

	}

	private void removePerson() {
		System.out.println("Bitte zu löschenden Index");
		int index = scanner.nextInt();
		boolean success = verwaltungsGruppe.remove(index);
		if (success) {
			System.out.println("Löschen erfolgreich");
		} else {
			System.out.println("Löschen nicht erfolgreich");
		}
		scanner.nextLine();
	}

	private void removeAll() {
		verwaltungsGruppe.clear();

	}

	private void searchPerson() {
		System.out.println("Please input letter(s) for searching");
		MyList subVerwaltungsGruppe = verwaltungsGruppe;
		String searchString = scanner.nextLine();
		for (int i = 0; i < subVerwaltungsGruppe.size(); i++) {
			Person p = (Person) subVerwaltungsGruppe.get(i);
			if (p.getVorname().toLowerCase().startsWith(searchString) && searchString != null) {
				System.out.println(p.getVorname() + " " + p.getNachname());
			} else
				continue;

		}
	}

}
