import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.telekom.sea.seminar.Anrede;
import de.telekom.sea.seminar.Person;
import de.telekom.sea.seminar.PersonComparatorImpl;

public class TestComparator {

	private PersonComparatorImpl comparator;
	private Person cut1;
	private Person cut2;

	@BeforeEach
	void setup() {

		comparator = new PersonComparatorImpl();

	}

	@Test
	void testPerson1Groesser() {
		cut1 = new Person("Tony", "Stark", Anrede.MANN);
		cut2 = new Person("Peter", "Parker", Anrede.MANN);
		var result = comparator.compare(cut1, cut2);
		assertEquals(1, result);
		assertNotEquals(-1, result);
	}

	@Test
	void testPerson2Groesser() {
		cut1 = new Person("Thor", "Odynsson", Anrede.MANN);
		cut2 = new Person("Peter", "Parker", Anrede.MANN);
		var result = comparator.compare(cut1, cut2);
		assertEquals(-1, result);
		assertNotEquals(1, result);
	}

	@Test
	void testEqualsPerson() {
		cut1 = new Person("Peter", "Parker", Anrede.MANN);
		cut2 = new Person("Peter", "Parker", Anrede.MANN);
		var result = comparator.compare(cut1, cut2);
		assertEquals(0, result);
		assertNotEquals(1, result);
	}

	@Test
	void testEqualsNachName() {
		cut1 = new Person("May", "Parker", Anrede.FRAU);
		cut2 = new Person("Peter", "Parker", Anrede.MANN);
		var result = comparator.compare(cut1, cut2);
		assertEquals(-1, result);
		assertNotEquals(1, result);
	}

	@Test
	void testShortNachname() {
		cut1 = new Person("May", "Abc", Anrede.FRAU);
		cut2 = new Person("Mark", "Zuckerberg", Anrede.MANN);
		var result = comparator.compare(cut1, cut2);
		assertEquals(-1, result);
		assertNotEquals(1, result);
	}

	@AfterEach
	void teardown() {
		cut1 = null;
		cut2 = null;

	}

}
