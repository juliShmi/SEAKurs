package de.telekom.sea.seminar.readers;

import java.io.BufferedReader;

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

	public void readPerson() throws IOException {
		try {
			String currentLine;
			while ((currentLine = readerFile.readLine()) != null) {
				String[] result = currentLine.split(";");
				String formatForReading = String.format("%s %s %s", result[0].trim(), result[1].trim(),
						result[2].trim());
				System.out.println(formatForReading);
			}

		} finally {

		}

	}
}
