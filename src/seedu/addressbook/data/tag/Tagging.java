package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.*;

public class Tagging {
	
	private final Person person;
	private final Tag tag;
	private String sign;
	
	public Tagging(Person person, Tag tag, String sign) {
		this.person = person;
		this.tag = tag;
		this.sign = sign;
	}
	
	public String toString() {
		return sign + " " + person.getName() + " " + tag;
	}

}
