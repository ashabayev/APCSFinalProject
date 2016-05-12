import java.util.ArrayList;

public class Patron {
	private String lastName;
	private String firstName;
	private Address address;
	private ArrayList<LibraryBook> checkedOut; // TODO: checked out
	private long fee;

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
	public Patron(String last, String first, Address residence, int overdueFee, ArrayList<LibraryBook> newCheckedOut) {
		lastName = last;
		firstName = first;
		address = residence;
		setFee(overdueFee);
		setCheckedOut(newCheckedOut);
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

	public ArrayList<LibraryBook> getCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(ArrayList<LibraryBook> checkedOut) {
		this.checkedOut = checkedOut;
	}

	public long getFee() {
		return fee;
	}

	public void setFee(long fee) {
		this.fee = fee;
	}
}
