
/**
 * @author Anna and Aadit
 *
 */
public class Author {
	private String firstName;
	private String lastName;
	private String publisher;

	/**constructor
	 * @param firstN
	 * @param lastN
	 * @param newPublisher
	 */
	public Author(String firstN, String lastN, String newPublisher) {
		firstName = firstN;
		lastName = lastN;
		publisher = newPublisher;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return fullName
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param desiredPublisher
	 */
	public void setPublisher(String desiredPublisher) {
		publisher = desiredPublisher;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getFullName() + ", " + getPublisher();
	}
}
