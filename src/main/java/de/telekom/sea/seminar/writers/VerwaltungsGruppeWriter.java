package de.telekom.sea.seminar.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import de.telekom.sea.seminar.Person;
import de.telekom.sea.seminar.interfaces.MyList;

public class VerwaltungsGruppeWriter {

	public void writeAll(MyList verwaltungsGruppe) throws IOException {
		try {
			BufferedWriter writerFile = new BufferedWriter(new FileWriter(PersonWriter.address));
			PersonWriter personWriter = new PersonWriter(writerFile);
			

			String header = String.format("%s;%s;%s;\n", "ID", "First name", "Last name");
			writerFile.write(header);
			for (int i = 0; i < (verwaltungsGruppe.size()); i++) {
				Person person = (Person) verwaltungsGruppe.get(i);
				personWriter.write(person);
			}
			writerFile.close();
		} finally {
			System.out.println("Written");
		}

	}
}