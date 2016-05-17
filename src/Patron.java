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
	private double fee;

	/**
	 * Constructor creates a patron from a last name, first name, and address
	 * 
	 * @param last
	 *            the patron's last name
	 * @param first
	 *            the patron's first name
	 * @param residence
	 *            the patron's address
	 * @param newChecked
	 *            out the books checked out by the patron at first
	 */
	public Patron(String firstN, String lastN, Address residence, double overdueFee,
			LinkedList<LibraryBook> newCheckedOut) {
		setFirstName(firstN);
		setLastName(lastN);
		setAddress(residence);
		setFee(overdueFee);
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
		setFee(overdueFee);
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
	 */
	public void setAddress(Address residence) {
		address = residence;
	}

	/**
	 * toString method returns information about the patron @return information
	 * about the patron
	 * 
	 * @param none
	 * @return String info on patron
	 */
	public String toString() {
		return (firstName + " " + lastName + ", " + address.toString());
	}

	/**
	 * @return checkedOut
	 */
	public LinkedList<LibraryBook> getCheckedOut() {
		return checkedOut;
	}

	/**
	 * @param checkedOut
	 */
	public void setCheckedOut(LinkedList<LibraryBook> checkedOut) {
		this.checkedOut = checkedOut;
	}

	/**
	 * @param l
	 */
	public void addCheckedOut(LibraryBook l) {
		checkedOut.add(l);
	}

	/**
	 * @return
	 */
	public double getFee() {
		return fee;
	}

	/**
	 * @param fee
	 */
	public void setFee(double fee) {
		this.fee = fee;
	}
}
