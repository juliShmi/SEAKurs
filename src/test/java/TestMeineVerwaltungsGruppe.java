import de.telekom.sea.seminar.Anrede;
import de.telekom.sea.seminar.Person;
import de.telekom.sea.seminar.VerwaltungsGruppe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;

public class TestMeineVerwaltungsGruppe {

	private VerwaltungsGruppe vwg;
	Person cut1;
	Person cut2;
	Person cut3;
	Person cut4;
	Person nullPerson;

	@BeforeEach
	void setup() {
		cut1 = new Person("Paul", "Paulsen", Anrede.MANN);
		cut2 = new Person("Hans", "Mueller", Anrede.MANN);
		cut3 = new Person("Sara", "Paulsen", Anrede.FRAU);
		cut4 = new Person("Maria", "Mueller", Anrede.FRAU);

		vwg = new VerwaltungsGruppe();
	}

	@Test
	void testAssertLength() {
		assertTrue(vwg.add(cut1));
		assertTrue(vwg.add(cut2));
		assertTrue(vwg.add(cut3));
		assertEquals(3, vwg.size());
		assertThrows(RuntimeException.class, () -> {
			vwg.add(cut4);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			vwg.add(cut4);
		});

	}

	@Test
	void testAddNullPerson() {
		assertThrows(RuntimeException.class, () -> {
			vwg.add(nullPerson);
		});

	}

	@Test
	void testGetPerson() {
		vwg.add(cut1);
		vwg.add(cut2);
		vwg.add(cut3);
		assertSame(vwg.get(0), cut1);
		assertSame(vwg.get(1), cut2);
		assertSame(vwg.get(2), cut3);
		assertNotSame(cut3, vwg.get(0));
		assertThrows(RuntimeException.class, () -> {
			vwg.get(4);
		});
		assertThrows(RuntimeException.class, () -> {
			vwg.get(-1);
		});
	}
	
	@Test
	void testRemoveByIndex() {
		vwg.add(cut1);
		vwg.add(cut2);
		assertTrue(vwg.remove(0));
		assertEquals(1,vwg.size());
	}

	
	@Test
	void checkEventListener() {
		assertThrows(RuntimeException.class, () -> {vwg.subscribe(null);
			});	
	}
	
	@Test
	void testDoublcheck() {
		vwg.add(cut1);
		vwg.add(cut2);
		assertTrue(vwg.doubleCheck(cut1));
		assertFalse(vwg.doubleCheck(cut3));
	}

	@Test
	void testClearList() {
		
		vwg.add(cut1);
		vwg.add(cut2);
		vwg.add(cut3);
		vwg.clear();
		assertEquals(0, vwg.size());
		
	}

	@AfterEach
	void teardown() {
		cut1 = null;
		cut2 = null;
		cut3 = null;
		cut4 = null;
		vwg.clear();
	}

}