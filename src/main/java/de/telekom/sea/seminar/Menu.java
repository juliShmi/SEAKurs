package de.telekom.sea.seminar;

import java.io.IOException;

import de.telekom.sea.seminar.events.Event;
import de.telekom.sea.seminar.events.EventListener;
import de.telekom.sea.seminar.interfaces.MyList;
import de.telekom.sea.seminar.interfaces.MyMenu;
import de.telekom.sea.seminar.readers.PersonReader;
import de.telekom.sea.seminar.readers.VerwaltungsGruppeReader;
import de.telekom.sea.seminar.writers.PersonWriter;
import de.telekom.sea.seminar.writers.VerwaltungsGruppeWriter;

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

	public void keepAsking() throws IOException {
		do {
			showMenu();
			result = inputMenu();
			checkMenu(result);
		} while (!result.equals("9"));

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
		System.out.println("6: search person");
		System.out.println("7: write all list");
		System.out.println("8: read file");
		System.out.println("9: quit");
	}

	private String inputMenu() {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		var input = scanner.nextLine();
		return input;
	}

	private void checkMenu(String eingabe) throws IOException {
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
			System.out.println("5: delete person by name");
			removeByName();
			break;
		case "6":
			System.out.println("6: search person");
			searchPerson();
			break;
		case "7":
			System.out.println("7: write all list");
			writeAllList();
			break;
		case "8":
			System.out.println("8: read file");
			readFile();
			break;
		case "9":
			System.out.println("9: quit");
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

	private void searchPerson() {
		System.out.println("Please input letter(s) for searching");
		String searchString = scanner.nextLine();
		MyList subObjectListe = verwaltungsGruppe.search(searchString);
		if (subObjectListe.size() == 0) {
			System.out.println("subObjectListe ist leer");
		}

	}

	private void writeAllList() throws IOException {
		System.out.println("File created");
		VerwaltungsGruppeWriter writer = new VerwaltungsGruppeWriter();
		writer.writeAll(verwaltungsGruppe);

	}

	private void readFile() throws IOException {
		VerwaltungsGruppe neueGruppe = new VerwaltungsGruppe();
		VerwaltungsGruppeReader fileReader = new VerwaltungsGruppeReader();
		System.out.println("Start reading file");
		neueGruppe = fileReader.readGruppe();

	}
}
