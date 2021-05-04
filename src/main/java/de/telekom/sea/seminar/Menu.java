package de.telekom.sea.seminar;

public class Menu implements MyMenu, EventListener {

	private MyList verwaltungsGruppe;

	private java.util.Scanner scanner = new java.util.Scanner(System.in);
	private String result;

	public Menu(MyList myList) {
		verwaltungsGruppe = myList;
	}

	public Menu() {
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
		System.out.println("1: add  person");
		System.out.println("2: show list");
		System.out.println("3: delete list");
		System.out.println("4: delete person by index");
		System.out.println("5: delete person by name");
		System.out.println("6: quit");
	}

	private String inputMenu() {
		return scanner.nextLine();

	}

	private void checkMenu(String eingabe) {
		switch (eingabe) {
		case "1":
			System.out.println("1: add  person");
			inputPerson();
			break;
		case "2":
			System.out.println("2: show list");
			listAllPersons();
			break;
		case "3":
			System.out.println("3: delete list");
			removeAll();
			break;
		case "4":
			System.out.println("4: delete person by index");
			removePerson();
			break;
		case "5":
			System.out.println("5: delete person(s) by name");
			removeByName();
			break;
		case "6":
			System.out.println("6: quit");
			break;
		default:
			System.out.println("wrong task");
		}
	}

	private void inputPerson() {
		Person p = new Person();
		String firstName;
		String lastName;
		System.out.println("Please input a  first name: ");
		firstName = scanner.nextLine();
		System.out.println("Please input a last name: ");
		lastName = scanner.nextLine();
		p.setVorname(firstName);
		p.setNachname(lastName);
		verwaltungsGruppe.add(p);
	}

	private void listAllPersons() {
		if (verwaltungsGruppe.size() == 0) {
			System.out.println("List is empty");
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
		System.out.println("Please input index to delete");
		int index = scanner.nextInt();
		boolean success = verwaltungsGruppe.remove(index);
		if (success) {
			System.out.println("Person deleted successfully");
		} else {
			System.out.println("Delete failed");
		}
		scanner.nextLine();
	}

	private void removeByName() {
		System.out.println("Please input first name:");
		String vornameToRemove = scanner.nextLine();
		System.out.println("Please input last name:");
		String nachnameToRemove = scanner.nextLine();
		boolean success = verwaltungsGruppe.remove(vornameToRemove, nachnameToRemove);
		if (success)
			System.out.println("Person deleted successfully");
		else
			System.out.println("Delete failed");

	}

	private void removeAll() {
		verwaltungsGruppe.clear();

	}

}
