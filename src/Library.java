import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * library class
 * 
 * @author Anna and Aadit
 *
 */
public class Library {
	private BookList books;
	private PatronList patrons;
	private Scanner scanner;

	/**
	 * constructor
	 */
	public Library() {
		books = new BookList();
		patrons = new PatronList();
		scanner = new Scanner(System.in);
	}

	/**
	 * User Interface
	 */
	public void UI() {
		System.out.println("Enter one of the following options: " + "\n" + "1. Include a book in the catalog" + "\n"
				+ "2. Check out a book" + "\n" + "3. Return a book" + "\n" + "4. Status" + "\n" + "5. Add Patron" + "\n"
				+ "6. Exit");
		scanner = new Scanner(System.in); // creates scanner
		char task = scanner.nextLine().charAt(0);
		switch (task) {
		case '1':
			addBook();// Include a book in the catalog
			break;
		case '2':
			System.out.println("What would book would you like to search for?");
			checkOutBook(scanner.nextLine());
			break;
		case '3':
			returnBook();
			// match the book with library book data, and then set that to
			// checked in
			break;
		case '4':
			System.out.println("What would book would you like to search for?");
			status(scanner.nextLine());
			// print list of books that patron has
			break;
		case '5':
			addPatron();
		case '6':
			System.out.println("Have a nice day! Come again soon!");
			break;
		default: // exit
			System.out.println("Have a nice day! Come again soon!");
			break;
		}
	}

	/**
	 * @return BookList
	 */
	public BookList getBooks() {
		return books;
	}

	/**
	 * prints BookList
	 */
	public void printBookList() {
		books.printBooks(books.getBooks());
	}

	/**
	 * @return patrons
	 */
	public PatronList getPatrons() {
		return patrons;
	}

	/**
	 * prints PatronList
	 */
	public void printPatrons() {
		patrons.printPatrons(patrons.getPatrons());
	}

	/**
	 * addBook
	 */
	public void addBook() {
		LinkedList<String> info = new LinkedList<String>();
		System.out.println(
				"What is the location of the book? Please choose from 'on shelf', 'checked out', or 'being processed'.");
		info.add(scanner.nextLine());
		System.out.println("What is the ISBN number of book (without dashes)?");
		info.add(scanner.nextLine());
		System.out.println("What is the year in which the book was published?");
		info.add(scanner.nextLine());
		System.out.println("What is the title of the book?");
		info.add(scanner.nextLine());
		System.out.println("What is the first name of the author?");
		info.add(scanner.nextLine());
		System.out.println("What is the last name of the author?");
		info.add(scanner.nextLine());
		System.out.println("What is the author's publisher?");
		info.add(scanner.nextLine());
		Author newAuthor = new Author(info.get(4), info.get(5), info.get(6));
		books.addBook(new LibraryBook(info.get(0), info.get(1), info.get(2), info.get(3), newAuthor));
		System.out.println("You have successfully added the book: ");
		System.out.println(books.getBooks().get(books.getBooks().size() - 1).toStringNoDate());
		UI();
	}

	/**
	 * @return book
	 */
	public int searchBooks(String search) {
		LinkedList<LibraryBook> foundBooks = new LinkedList<LibraryBook>();
		System.out.println("Please enter the number corresponding to the field you are searching for the book by:");
		System.out.println("1. Title");
		System.out.println("2. Author");
		System.out.println("3. ISBN");
		System.out.println("4. Year Published");
		int bookChoice = scanner.nextLine().charAt(0);
		// search by different methods
		switch (bookChoice) {
		case 1:
			foundBooks = books.searchTitles(search);
		case 2:
			foundBooks = books.searchAuthors(search);
		case 3:
			foundBooks = books.searchISBN(search);
		case 4:
			foundBooks = books.searchYear(search);
		default:
			foundBooks = books.searchTitles(search);
		}
		if (foundBooks == null) {
			return -1;
		} else {
			System.out.println("Based on your search, the following books have been found:");
			books.printBooks(foundBooks);
			System.out.println(
					"Of these books, which would you like to select? Please select the number corresponding to that book.");
			return books.searchBook(foundBooks.get(scanner.nextInt() - 1));
		}
	}

	/**
	 * check out book to patron
	 * 
	 * @param search
	 */
	@SuppressWarnings("deprecation")
	public void checkOutBook(String search) {
		int bookChoice = searchBooks(search);
		if (bookChoice == -1) {
			System.out.println("Unfortunately, no books were found based on the search.");
			UI();
		} else if (books.getBook(bookChoice).getShelfLocation().equalsIgnoreCase("checked out")) {
			System.out.println(
					"We are sorry, but the book you requested has already been checked to another patron. It will be returned on or before: "
							+ books.getBook(bookChoice).getDueDate());
			UI();
		} else {
			scanner = new Scanner(System.in);
			System.out.println("What patron would you like to check the book out to?");
			String patronSearch = scanner.nextLine();
			LinkedList<Patron> foundPatrons = patrons.searchPatrons(patronSearch);
			if (foundPatrons == null) {
				System.out.println("Unfortunately, no such patrons were found.");
				UI();
			} else {
				patrons.printPatrons(foundPatrons);
				System.out.println(
						"Of these patrons, which would you like to check out? Please select the number corresponding to that patron.");
				int patronChoice = scanner.nextInt() - 1;
				System.out.println("The chosen book has been checked out to the following patron: ");
				System.out.println(patrons.getPatron(patrons.searchPatron(foundPatrons.get(patronChoice))).toString());
				books.getBook(bookChoice).setShelfLocation("checked out");
				Date dueDate = new Date();
				dueDate = new Date(dueDate.getYear(), dueDate.getMonth(), dueDate.getDay() + 14);
				books.getBook(bookChoice).setDueDate(dueDate);
				patrons.getPatron(patrons.searchPatron(foundPatrons.get(patronChoice)))
						.addCheckedOut(books.getBook(bookChoice));
				UI();
			}
		}
	}

	/**
	 * return library book
	 * 
	 * @param search
	 */
	public void returnBook() {
		System.out.println("Which patron has the book that you would like to return?");
		String search;
		search = scanner.nextLine();
		LinkedList<Patron> foundPatrons = patrons.searchPatrons(search);
		patrons.printPatrons(foundPatrons);
		System.out.println(
				"Of these patrons, which would you like to choose? Please select the number corresponding to that patron.");
		int patronChoice = scanner.nextInt() - 1;
		System.out.println("You have chosen this patron: ");
		System.out.println(patrons.getPatron(patrons.searchPatron(foundPatrons.get(patronChoice))).toString());
		System.out.println("This patron has the following books checked out currently:");
		books.printBooks(patrons.getPatron(patrons.searchPatron(foundPatrons.get(patronChoice))).getCheckedOut());
		System.out.println(
				"Of these books, which would you like to return? Please select the number corresponding to that book.");
		int bookChoice = scanner.nextInt() - 1;
		System.out.println("You have returned the following book:");
		System.out.println(patrons.getPatron(patrons.searchPatron(foundPatrons.get(patronChoice))).getCheckedOut()
				.get(bookChoice).toString());
		patrons.getPatron(patrons.searchPatron(foundPatrons.get(patronChoice))).getCheckedOut().get(bookChoice)
				.setShelfLocation("being processed");
		books.addBook(patrons.getPatron(patrons.searchPatron(foundPatrons.get(patronChoice))).getCheckedOut()
				.remove(bookChoice));
		int index = books.getBooks().size() - 1;
		Date currentDate = new Date();
		if (currentDate.after(books.getBook(index).getDate())) {
			patrons.getPatron(patronChoice).setFee(patrons.getPatron(patronChoice).getFee() + 5.00);
		}
		UI();
	}

	/**
	 * status of a book
	 * 
	 * @param search
	 */
	public void status(String search) {
		int bookChoice = searchBooks(search);
		if (bookChoice == -1) {
			System.out.println("The searched book was no found in the library.");
		} else {
			System.out.println("The status of the book you have selected is: ");
			System.out.println(books.getBook(bookChoice).getShelfLocation());
		}
		UI();
	}

	public void addPatron() {
		LinkedList<String> info = new LinkedList<String>();
		System.out.println("What is the first name of the patron");
		info.add(scanner.nextLine());
		System.out.println("What is the last name of the patron?");
		info.add(scanner.nextLine());
		System.out.println("What is the street address of the patron?");
		info.add(scanner.nextLine());
		System.out.println("What is the city in which they live?");
		info.add(scanner.nextLine());
		System.out.println("What is state (abbreviation) in which they live?");
		info.add(scanner.nextLine());
		System.out.println("What is their zip code?");
		info.add(scanner.nextLine());
		Address newAddress = new Address(info.get(2), info.get(3), info.get(4), info.get(5));
		System.out.println("Please enter the current charges the patron has (if none enter 0.0)?");
		double patronFees = scanner.nextDouble();
		patrons.addPatron(new Patron(info.get(0), info.get(1), newAddress, patronFees));
		System.out.println("You have successfully added the patron: ");
		System.out.println(patrons.getPatrons().get(patrons.getPatrons().size() - 1).toString());
		UI();
	}

}
