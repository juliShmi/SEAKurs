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
		// haelt die Schleife bis zum Abbruch am Leben
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
			break;
		case "2":
			System.out.println("2: Liste anzeigen");
			listAllPersons();
			break;
		case "3":
			System.out.println("3: Liste löschen");
			break;
		case "4":
			System.out.println("4: Beenden");
			break;
		default:
			System.out.println("Falsche Eingabe");
		}
	}

	private void inputPerson() {

	}

	private void listAllPersons() {

		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i) != null) {
				Person p = (Person) myList.get(i);
				System.out.println(p.getVorname() + " " + p.getNachname());
			}

		}

	}

	private void removeAll() {

	}

}
