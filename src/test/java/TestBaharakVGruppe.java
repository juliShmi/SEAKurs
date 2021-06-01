import org.junit.jupiter.api.Test;

import de.telekom.sea.seminar.BaharakVGruppe;
import de.telekom.sea.seminar.MyException;
import de.telekom.sea.seminar.Person;
import de.telekom.sea.seminar.VerwaltungsGruppe;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;

public class TestBaharakVGruppe {

	private BaharakVGruppe vw;
	Person cut1;
	Person cut2;
	Person cut3;
	Person cut4;
	Person cutNull;

	@BeforeEach
	void setup() throws MyException {
		cut1 = new Person();
		cut2 = new Person();
		cut3 = new Person();
		cut4 = new Person();
		vw = new BaharakVGruppe();

		cut1.setVorname("Paul");
		cut1.setNachname("Paulsen");
		cut1.setAnrede("Mann");

		vw.add(cut1);

	}
	@Test
	void addNull_test() {
		
		var result = (vw.add(cutNull));
		assertFalse(result);
	
	}
	@Test
	
	void addMore_test() throws MyException {
		vw = new BaharakVGruppe();
		vw.add(cut1);
		
		cut2.setVorname("Hans");
		cut2.setNachname("Mueller");
		cut2.setAnrede("Mann");

		cut3.setVorname("Sara");
		cut3.setNachname("Paulsen");
		cut3.setAnrede("Frau");

		cut4.setVorname("Maria");
		cut4.setNachname("Mueller");
		cut4.setAnrede("Frau");
		
		vw.add(cut2);
		vw.add(cut3);

	var result = (vw.add(cut4));
	assertFalse(result);
	}

	@AfterEach
	void teardown() {
		cut1 = null;
		cut2 = null;
		cut3 = null;
		cut4 = null;
	}

}
