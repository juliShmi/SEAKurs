package de.telekom.sea.seminar.writers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import de.telekom.sea.seminar.Person;

public class PersonWriter {

	public static String address = "C:\\Users\\ishmitko\\Quests\\SEAKurs\\src\\main\\java\\de\\telekom\\sea\\seminar\\files\\SEA.Test.csv";

	BufferedWriter bufferedWriter;


	public PersonWriter(BufferedWriter bufferedWriter) {
		this.bufferedWriter = bufferedWriter;
	}

	public void write(Person person) throws IOException {
		try {

			String personFormat = String.format("%s;%s;%s;%s;\n", person.getId().toString(), person.getVorname(),
					person.getNachname(), person.getAnrede());
			bufferedWriter.write(personFormat);
		} finally

		{
			System.out.println("Written");
		}

	}

}
