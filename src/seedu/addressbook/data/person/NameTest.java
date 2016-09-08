package seedu.addressbook.data.person;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	private Name name;
	
	@Before
	public void setup() throws IllegalValueException {
		name = new Name("John K Smith");
	}
	
	@Test
	public void isSimilar_true() throws IllegalValueException {
		assertFalse(name.isSimilar_notNull(null)) ;
		assertTrue(name.isSimilar_caseSensitive(new Name("John K SMITH")));
		assertTrue(name.isSimilar_subset(new Name("John Smith")));
		assertTrue(name.isSimilar_differentOrderWithComma(new Name("Smith, John K")));
	}
}
