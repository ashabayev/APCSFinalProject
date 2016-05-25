import java.util.LinkedList;

/**
 * @author Anna and Aadit
 *
 */
public class Patron {
	private String lastName;
	private String firstName;
	private Address address;
	private LinkedList<LibraryBook> checkedOut; // TODO: checked out
	private double fee = 0.00;

	/**
	 * Constructor creates a patron from a last name, first name, and address
	 * 
	 * @param last
	 *            the patron's last name
	 * @param first
	 *            the patron's first name
	 * @param residence
	 *            the patron's address
	 * 
	 * @param overdueFee
	 *            the fee the patrons owes to the library
	 * @param newChecked
	 *            out the books checked out by the patron at first
	 */
	public Patron(String firstN, String lastN, Address residence, double overdueFee,
			LinkedList<LibraryBook> newCheckedOut) {
		setFirstName(firstN);
		setLastName(lastN);
		setAddress(residence);
		setFines(overdueFee);
		setCheckedOut(newCheckedOut);
	}

	/**
	 * Constructor creates a patron from a last name, first name, and address
	 * 
	 * @param last
	 *            the patron's last name
	 * @param first
	 *            the patron's first name
	 * @param residence
	 *            the patron's address
	 */
	public Patron(String firstN, String lastN, Address residence, double overdueFee) {
		setFirstName(firstN);
		setLastName(lastN);
		setAddress(residence);
		setFines(overdueFee);
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstN
	 */
	public void setFirstName(String firstN) {
		firstName = firstN;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastN
	 */
	public void setLastName(String lastN) {
		lastName = lastN;
	}

	/**
	 * @return fullName
	 */
	public String getFullName() {
		return getFirstName() + " " + getLastName();
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address.toString();
	}

	/**
	 * @param residence
	 *            the Address object that corresponds to the patron's address
	 */
	public void setAddress(Address residence) {
		address = residence;
	}

	/**
	 * The overloaded setAddress() method that takes strings for street address,
	 * city, state, and zipcode
	 * 
	 * @param road
	 *            the road where the patron lives
	 * @param city
	 *            the city in which the patron lives
	 * @param state
	 *            the state in which the patron lives
	 * @param zipcode
	 *            the zip code corresponding to the patron's home address
	 */
	public void setAddress(String road, String city, String state, String zipcode) {
		setAddress(new Address(road, city, state, zipcode));
	}

	/**
	 * @return checkedOut the list of books the patron currently checked out
	 */
	public LinkedList<LibraryBook> getCheckedOut() {
		return checkedOut;
	}

	/**
	 * @param checkedOut
	 *            the list of the checkout books for the patron
	 */
	public void setCheckedOut(LinkedList<LibraryBook> checkedOut) {
		this.checkedOut = checkedOut;
	}

	/**
	 * @param l
	 *            the library book that the patron wants to checkout
	 */
	public void addCheckedOut(LibraryBook l) {
		checkedOut.add(l);
	}

	/**
	 * @return the current fee owed by the patron
	 */
	public double getFines() {
		return fee;
	}

	/**
	 * @param fee
	 */
	public void setFines(double fee) {
		this.fee = fee;
	}

	/**
	 * toString method returns information about the patron
	 * 
	 * @return String info on patron
	 */
	public String toString() {
		return (firstName + " " + lastName + ", Address: " + address.toString() + ", Fee: " + getFines());
	}

}
