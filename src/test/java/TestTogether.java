import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.telekom.sea.seminar.generics.Light;
import de.telekom.sea.seminar.generics.Sun;
import de.telekom.sea.seminar.generics.Together;

public class TestTogether {

	private Sun cut1;
	private Light cut2;
	private Together<Sun, Light> together;
	private Together<Sun, Light> together2;

	@BeforeEach
	void setup() {

		together = new Together<Sun, Light>(cut1, cut2);

	}

	@Test
	void testJoin() {
		cut1 = new Sun();
		cut2 = new Light();
		assertEquals(true, together.join(cut1, cut2));
		assertNotEquals(false, together.join(cut1, cut2));

	}

	@Test
	void testJoinNull() {
		assertEquals(false, together.join(cut1, cut2));
		assertNotEquals(true, together.join(cut1, cut2));
	}

	@Test
	void testSplit() {
		cut1 = new Sun();
		cut2 = new Light();
		together.join(cut1, cut2);
		together.split();
		assertNotEquals(null, together.getFirst());
		assertNotEquals(null, together.getSecond());
		assertEquals(cut1, together.getFirst());
		assertEquals(cut2, together.getSecond());
	}

	@Test
	void testToString() {
		cut1 = new Sun();
		cut2 = new Light();
		together.join(cut1, cut2);
		assertEquals(cut1.toString() + " " + cut2.toString(), together.togetherToString());
		assertNotEquals(null, together.togetherToString());


	}

	@Test
	void testEquals() {
		cut1 = new Sun();
		cut2 = new Light();
		together.join(cut1, cut2);
		together2 = new Together<Sun, Light>(cut1, cut2);
		together2.join(cut1, cut2);
		
		assertEquals(true, together.equalsTogether(together2));
		assertEquals(true, together.equalsTogether(together));
		assertNotEquals(false, together.equalsTogether(together2));

	}

	@Test
	void testHashcodes() {
		cut1 = new Sun();
		cut2 = new Light();
		together.join(cut1, cut2);
		together2 = new Together<Sun, Light>(cut1, cut2);
		together2.join(cut1, cut2);
		assertEquals(false, together.hashCode(together2));
		assertEquals(true, together.hashCode(together));
		assertNotEquals(true, together.hashCode(together2));

	}

	@AfterEach
	void teardown() {
		cut1 = null;
		cut2 = null;
		together = null;

	}

}
