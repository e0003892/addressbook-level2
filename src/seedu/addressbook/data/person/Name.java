package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";

    public final String fullName;

    public Name(String name) {
    	this.fullName = name.trim();
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split(",|\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }
    
    public boolean isSimilar(Name other) {
    	if (other == null) {
    		return false;
    	} else {
    		if (fullName.equalsIgnoreCase(other.toString())) {
    			return true;
    		} else {
    			List<String> splitOther = other.getWordsInName();
    			for (String string : splitOther) {
    				if (fullName.contains(string)) {
    					return true;
    				}
    			}
    			return false;
    		}
    	}
    }
}
