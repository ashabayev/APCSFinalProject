
public class Author {
	private String firstName;
	private String lastName;
	private String publisher;

	public Author(String firstN, String lastN, String newPublisher) {
		firstName = firstN;
		lastName = lastN;
		publisher = newPublisher;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String desiredPublisher) {
		publisher = desiredPublisher;
	}
}
