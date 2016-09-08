package seedu.addressbook.common;

import static org.junit.Assert.*;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Phone;

import java.util.*;

public class UtilsTest {
	
	@Test
	public void isAnyNull_true() {
		assertTrue(Utils.isAnyNull((Object)null));
		assertTrue(Utils.isAnyNull(null, Phone.EXAMPLE, Email.EXAMPLE, Address.EXAMPLE, null));
	}
	
	@Test
	public void isAnyNull_false() {
		assertFalse(Utils.isAnyNull());
		assertFalse(Utils.isAnyNull(Name.EXAMPLE, Phone.EXAMPLE, Email.EXAMPLE, Address.EXAMPLE));
	}
	
	@Test
	public void elementsAreUnique_true() {
		try {
			Collection<Name> testTrue = new ArrayList<Name>();
			testTrue.add(new Name("same"));
			testTrue.add(new Name("different"));
			
			assertTrue(Utils.elementsAreUnique(testTrue));
		} catch (IllegalValueException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void elementsAreUnique_false() {
		try {
			Collection<Name> testFalse = new ArrayList<Name>();
			testFalse.add(new Name("same"));
			testFalse.add(new Name("same"));
			
			assertFalse(Utils.elementsAreUnique(testFalse));
		} catch (IllegalValueException e) {
			e.printStackTrace();
		}
	}
}
