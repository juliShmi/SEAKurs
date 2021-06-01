import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import de.telekom.sea.seminar.Anrede;
import de.telekom.sea.seminar.Person;
import de.telekom.sea.seminar.VerwaltungsGruppe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SuppressWarnings("unused")
	
	
public class TestVerwaltungsGruppe {
		private VerwaltungsGruppe cut;
		@BeforeEach
		void setup() {
			cut = new VerwaltungsGruppe();
			Person p = new Person("Erika", "Musterfrau", Anrede.FRAU);
		}
		
		
		@Test
		void add_fistElement_test(Object obj) {
			// Arrange
			Person p = new Person("Erika", "Musterfrau", Anrede.FRAU);
			// Act
			var result1 = cut.add(p);
			// Assert
			assertTrue(result1);
			
			var result2 = cut.get(0);
			assertEquals(p, result2);
		}
		@Test
		void add_nextElement_test(Object obj) {
			// Arrange
			Person p1 = new Person("Erika", "Musterfrau", Anrede.FRAU);
			Person p2 = new Person("Max", "Mustermann", Anrede.MANN);
			cut.add(p1);
			
			// Act
			var result1 = cut.add(p2);
			// Assert
			var result2 = cut.get(1);
			assertTrue(result1);
			assertEquals(p2, result2);
		}
		@Test
		void add_oneElementOverSize_test(Object obj) {
			// Arrange
			Person p1 = new Person("Erika", "Musterfrau", Anrede.FRAU);
			Person p2 = new Person("Max", "Mustermann", Anrede.MANN);
			Person p3 = new Person("Lutz", "Musterdivers", Anrede.DIVERS);
			Person p4 = new Person("Erika", "Musterfrau", Anrede.FRAU);
			Person p5 = new Person("Max", "Mustermann", Anrede.MANN);
			Person p6 = new Person("Lutz", "Musterdivers", Anrede.DIVERS);
			cut.add(p1);
			cut.add(p2);
			cut.add(p3);
			cut.add(p4);
			cut.add(p5);
			// Act
			var result = cut.add(p6);
			// One over index
			assertFalse(result);
			
		}
	}

