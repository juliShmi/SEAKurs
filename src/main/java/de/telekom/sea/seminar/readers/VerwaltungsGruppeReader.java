package de.telekom.sea.seminar.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import de.telekom.sea.seminar.writers.PersonWriter;

public class VerwaltungsGruppeReader {

	public void readGruppe() throws IOException {
		try {
			BufferedReader readerFile = new BufferedReader(new FileReader(PersonWriter.address));
			PersonReader gruppeReader = new PersonReader(readerFile);
			Stream<String> linesInFile = Files.lines(Paths.get(PersonWriter.address));
			long linesCount = linesInFile.count();
			System.out.println("File size is (Strings): " + linesCount);
			gruppeReader.readHeader();
			for (int i = 1; i < linesCount; i++) {

				gruppeReader.readPerson();
			}

		} finally

		{
		}

	}
}