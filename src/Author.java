
public class Author {
	private String name;
	private String publisher;
	
	public Author(String newName, String newPublisher)
	{
		name = newName;
		publisher = newPublisher;
	}

	public String getName() {
		return name;
	}

	public void setName(String desiredName) {
		name = desiredName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String desiredPublisher) {
		publisher = desiredPublisher;
	}
}
