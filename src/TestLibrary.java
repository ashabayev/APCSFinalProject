import java.util.Date;

/**
 * test class
 * 
 * @author Anna and Aadit
 *
 */
public class TestLibrary {

	/**
	 * The driver class that demonstrates the classes created for this entire
	 * project and their functionality, including Library, Book, Patron,
	 * LibraryBook, BookList, PatronList, and Author
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Library library = new Library();
		BookList wholeList = new BookList();
		Date date = new Date();
		date.setDate(date.getDate() + 14);
		// populate the library with different books
		wholeList.addBook(new LibraryBook("Checked Out", "9780930289232", "1986", "Watchman",
				new Author("Alan", "Moore", "DC Comics"), date));
		wholeList.addBook(new LibraryBook("Checked Out", "9780802150325", "1981", "NINE PLAYS of the Modern Theatre",
				new Author("Harold", "Clurman", "Grove Press"), date));
		wholeList.addBook(new LibraryBook("Checked Out", "9780393062243", "2007", "Death by Black Hole",
				new Author("Neil", "Tyson", "Norton"), date));
		wholeList.addBook(new LibraryBook("Checked Out", "9780307277138", "2007", "Laugh Lines: Short Comic Plays",
				new Author("Eric", "Lane", "Vintage"), date));
		wholeList.addBook(new LibraryBook("Checked Out", "9780743482783", "1992", "Hamlet",
				new Author("William", "Shakespeare", "The Folger Shakespeare Company"), date));
		wholeList.addBook(new LibraryBook("Checked Out", "9781435126787", "2010", "Weird but True",
				new Author("Leslie", "Elman", "Fall River"), date));
		wholeList.addBook(
				new LibraryBook("Checked Out", "9781435140370", "2012", "H.P. Lovecraft: Great Tales of Horror",
						new Author("Howard Phillips", "Lovecraft", "Fall River"), date));
		wholeList.addBook(new LibraryBook("Checked Out", "9781566196043", "1992", "The Complete Sherlock Holmes",
				new Author("Arthur Conan", "Doyle", "Barnes and Noble"), date));
		wholeList.addBook(new LibraryBook("Checked Out", "9780439420891", "2003", "The Thief Lord",
				new Author("Cornelia", "Funke", "Scholastic"), date));
		wholeList.addBook(new LibraryBook("Checked Out", "9780552779733", "2005", "The Book Thief",
				new Author("Markus", "Zusak", "Transworld"), date));
		library.getPatrons().addPatron(new Patron("Henry", "Morris",
				new Address("237J Harvey Hall", "Menomonie", "WI", "54751"), 0.00, wholeList.getBooks()));
		System.out.println("An example of how Patron Information is printed:");
		System.out.println(library.getPatrons().getPatron(0).toString());
		System.out.println("Books checked out: ");
		wholeList.printBooks(library.getPatrons().getPatron(0).getCheckedOut());
		wholeList.removeBook(5);
		library.getPatrons().addPatron(new Patron("Omar", "Aldawud",
				new Address("4587 Alpha Lane", "Chicago", "IL", "60584"), 98.25, wholeList.getBooks()));
		wholeList.removeBook(2);
		library.getPatrons().addPatron(new Patron("Aadit", "Shah",
				new Address("337 November Lane", "Chicago", "IL", "54871"), 58.54, wholeList.getBooks()));
		wholeList.removeBook(0);
		library.getPatrons().addPatron(new Patron("Anna", "Shabayev",
				new Address("3145 Lorridge Lane", "Chicago", "IL", "32568"), 5.68, wholeList.getBooks()));
		wholeList.removeBook(1);
		library.getPatrons().addPatron(new Patron("Kevin", "James",
				new Address("9265 Beta Lane", "Chicago", "IL", "58478"), 8.24, wholeList.getBooks()));
		System.out.println("Additionally, the following patrons have already been preloaded to this library to test:");
		System.out.println(library.getPatrons().getPatron(1).toString());
		System.out.println(library.getPatrons().getPatron(2).toString());
		System.out.println(library.getPatrons().getPatron(3).toString());
		System.out.println(library.getPatrons().getPatron(4).toString());
		library.UI();
	}
}
