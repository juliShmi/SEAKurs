package de.telekom.sea.seminar;

public class Menu implements MyMenu {

	private MyList myList;

	private java.util.Scanner scanner = new java.util.Scanner(System.in);
	private String result;

	public void setMyList(MyList myList) {
		this.myList = myList;
	}

	public void keepAsking() {
		do {
			showMenu();
			result = inputMenu();
			checkMenu(result);
		} while (!result.equals("4"));

	}

	private void showMenu() {
		System.out.println("Menu: ");
		System.out.println("1: Person anlegen");
		System.out.println("2: Liste anzeigen");
		System.out.println("3: Liste löschen");
		System.out.println("4: Beenden");
	}

	private String inputMenu() {
		return scanner.nextLine();

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
			System.out.println("4: Beenden");
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
		myList.add(p);
	}

	private void listAllPersons() {
		if (myList.size() == 0) {
			System.out.println("Die Liste ist leer");
		} else {
			for (int i = 0; i < myList.size(); i++) {
				if (myList.get(i) != null) {
					Person p = (Person) myList.get(i);
					System.out.println(p.getVorname() + " " + p.getNachname());
				}

			}
		}

	}

	private void removeAll() {
		myList.clear();

	}

}
