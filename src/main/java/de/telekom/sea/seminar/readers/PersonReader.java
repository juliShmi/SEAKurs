package de.telekom.sea.seminar.readers;

import java.io.BufferedReader;

import de.telekom.sea.seminar.BaseObject;
import de.telekom.sea.seminar.Person;
import de.telekom.sea.seminar.writers.PersonWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PersonReader {

	BufferedReader readerFile;

	public PersonReader(BufferedReader readerFile) {
		this.readerFile = readerFile; // csv
	}

	public void readHeader() throws IOException {
		try {
			String headerLine = readerFile.readLine();
			String[] result = headerLine.split(";");
			String formatForReading = String.format("%s %s %s", result[0].trim(), result[1].trim(), result[2].trim());
			System.out.println(formatForReading);
		} finally {

		}

	}

	public Person readPerson() throws IOException {
		try {
			String currentLine;
			Person person = new Person();
			while ((currentLine = readerFile.readLine()) != null) {
				String[] result = currentLine.split(";");
				Long id = Long.parseLong(result[0].trim());
				String firstName = result[1].trim();
				String lastName = result[2].trim();

				person.setID(id);
				person.setVorname(firstName);
				person.setNachname(lastName);

				String returnedFormat = String.format("%s %s %s \n", person.getID(), person.getVorname(),
						person.getNachname());
				System.out.println(returnedFormat);

			}
			return person;

		} finally {

		}

	}
}
