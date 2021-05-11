package de.telekom.sea.seminar;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PersonWriter {

	String address = "C:\\Users\\ishmitko\\Quests\\SEAKurs\\src\\main\\java\\de\\telekom\\sea\\seminar\\SEA.Test.txt";

	public PersonWriter() throws IOException {

	}

	public void write(Person person) throws IOException {
		try (BufferedWriter writerFile = new BufferedWriter(new FileWriter(address))) {
			writerFile.write(person.getVorname() + " " + person.getNachname() + "\n");
		} finally {
			System.out.println("Written");
		}

	}
}