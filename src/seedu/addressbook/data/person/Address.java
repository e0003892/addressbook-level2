package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, clementi ave 2, #12-89, 600123";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in block, street, unit, postalcode";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String[] splitAddress = address.split(", ");
        if (!isValidAddress(splitAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        block = new Block(splitAddress[0]);
        street = new Street(splitAddress[1]);
        unit = new Unit(splitAddress[2]);
        postalCode = new PostalCode(splitAddress[3]);
        
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String[] test) {
        return test.length == 4;
    }

    @Override
    public String toString() {
        return block.getBlock() + ", " + street.getStreet() + ", " + unit.getUnit() + ", " + postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

class Block{
	private String block;
	
	public Block(String block){
		this.block = block;
	}
	
	public String getBlock(){
		return block;
	}	
}

class Street{
	private String street;
	
	public Street(String street){
		this.street = street;
	}
	
	public String getStreet(){
		return street;
	}	
}

class Unit{
	private String unit;
	
	public Unit(String unit){
		this.unit = unit;
	}
	
	public String getUnit(){
		return unit;
	}	
}

class PostalCode{
	private String postalCode;
	
	public PostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	
	public String getPostalCode(){
		return postalCode;
	}	
}