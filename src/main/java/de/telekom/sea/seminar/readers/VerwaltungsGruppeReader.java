package de.telekom.sea.seminar.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import de.telekom.sea.seminar.writers.PersonWriter;

public class VerwaltungsGruppeReader {

	public void readGruppe() throws IOException {
		try {
			BufferedReader readerFile = new BufferedReader(new FileReader(PersonWriter.address));
			PersonReader gruppeReader = new PersonReader(readerFile);
			gruppeReader.readPerson();
		} finally {
		}

	}
}