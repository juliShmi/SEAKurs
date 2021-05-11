package de.telekom.sea.seminar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class VerwaltungsGruppeWriter {

	public void writeAll(MyList verwaltungsGruppe) throws IOException {
		try {
		PersonWriter personWriter = new PersonWriter();
		BufferedWriter writerFile = new BufferedWriter(new FileWriter(personWriter.address));
		for (int i = 0; i < (verwaltungsGruppe.size()); i++) {
			Person person = (Person) verwaltungsGruppe.get(i);
			writerFile.write(person.getVorname() + " " + person.getNachname() + "\n");
		}writerFile.close();
		}finally {
			System.out.println("Written");
		}
		
	}
}