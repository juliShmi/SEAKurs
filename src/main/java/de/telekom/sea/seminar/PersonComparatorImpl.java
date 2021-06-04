package de.telekom.sea.seminar;

public class PersonComparatorImpl implements PersonComparator {

	public PersonComparatorImpl() {
	}

	@Override
	public int compare(Person person1, Person person2) {
		int compareResult = 0;

		for (int i = 0; i < Math.min(person1.getNachname().length(), person2.getNachname().length()); i++) {
			if (person1.getVorname() == person2.getVorname() && person1.getNachname() == person2.getNachname()) {
				return compareResult;
			}
			if (person1.getNachname().charAt(i) > person2.getNachname().charAt(i)) {
				compareResult = 1;
				break;
			}
			if (person1.getNachname().charAt(i) < person2.getNachname().charAt(i)) {
				compareResult = -1;
				break;
			}
			if (person1.getNachname() == person2.getNachname()) {
				for (int j = 0; j < Math.min(person1.getVorname().length(), person2.getVorname().length()); j++) {
					if (person1.getVorname().charAt(j) > person2.getVorname().charAt(j)) {
						compareResult = 1;
						break;
					}
					if (person1.getVorname().charAt(j) < person2.getVorname().charAt(j)) {
						compareResult = -1;
						break;
					}
				}

			}
		}
		return compareResult;

	}
}

//person1 ist kleiner als person2: -1

//person1 ist gleich wie person2: 0

//person1 ist größer als person2: 1