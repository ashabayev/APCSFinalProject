import java.util.ArrayList;

public class TestLibrary {
	
	public static void main(String[] args) {
		ArrayList<Book> wholeList = new ArrayList<Book>();
		LibraryBook one = new LibraryBook("place", 15811, 2000, "booktitle", new Author("name", "publisher"));
		wholeList.add(one);
		Patron henry = new Patron("Morris", "Henry", new Address("237J Harvey Hall", "Menomonie",  "WI", "54751"));
	}
}
