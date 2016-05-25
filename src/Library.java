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
				+ "6. Pay Patron Fines" + "\n" + "7. Access Full Book Directory" + "\n" + "8. Exit");
		scanner = new Scanner(System.in); // creates scanner
		char task = scanner.nextLine().charAt(0);
		switch (task) {
		case '1':
			addBook();// Include a book in the catalog
			break;
		case '2':
			checkOutBook();
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
			payFines();
		case '7':
			printBookList();
		case '8':
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
	 * prints entire BookList
	 */
	public void printBookList() {
		getBooks().printBooks(getBooks().getBooks());
		UI();
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
		getPatrons().printPatrons(getPatrons().getPatrons());
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
		getBooks().addBook(new LibraryBook(info.get(0), info.get(1), info.get(2), info.get(3), newAuthor));
		System.out.println("You have successfully added the book: ");
		System.out.println(getBooks().getBooks().get(getBooks().getBooks().size() - 1).toStringNoDate());
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
			foundBooks = getBooks().searchTitles(search);
		case 2:
			foundBooks = getBooks().searchAuthors(search);
		case 3:
			foundBooks = getBooks().searchISBN(search);
		case 4:
			foundBooks = getBooks().searchYear(search);
		default:
			foundBooks = getBooks().searchTitles(search);
		}
		if (foundBooks == null) {
			return -1;
		} else {
			System.out.println("Based on your search, the following books have been found:");
			getBooks().printBooks(foundBooks);
			System.out.println(
					"Of these books, which would you like to select? Please select the number corresponding to that book.");
			return getBooks().searchBooks(foundBooks.get(scanner.nextInt() - 1));
		}
	}

	/**
	 * check out book to patron
	 * 
	 * @param search
	 */
	@SuppressWarnings("deprecation")
	public void checkOutBook() {
		System.out.println("What would book would you like to checkout?");
		String search = scanner.nextLine();
		int bookChoice = searchBooks(search);
		if (bookChoice == -1) {
			System.out.println("Unfortunately, no books were found based on the search.");
			UI();
		} else if (getBooks().getBook(bookChoice).getShelfLocation().equalsIgnoreCase("checked out")) {
			System.out.println(
					"We are sorry, but the book you requested has already been checked to another patron. It will be returned on or before: "
							+ getBooks().getBook(bookChoice).getDueDate());
			UI();
		} else {
			scanner = new Scanner(System.in);
			System.out.println("What patron would you like to check the book out to?");
			String patronSearch = scanner.nextLine();
			LinkedList<Patron> foundPatrons = getPatrons().searchPatrons(patronSearch);
			if (foundPatrons == null) {
				System.out.println("Unfortunately, no such patrons were found.");
				UI();
			} else {
				getPatrons().printPatrons(foundPatrons);
				System.out.println(
						"Of these patrons, which would you like to check out? Please select the number corresponding to that patron.");
				int patronChoice = scanner.nextInt() - 1;
				System.out.println("The chosen book has been checked out to the following patron: ");
				System.out.println(
						getPatrons().getPatron(getPatrons().searchPatrons(foundPatrons.get(patronChoice))).toString());
				getBooks().getBook(bookChoice).setShelfLocation("checked out");
				Date dueDate = new Date();
				dueDate = new Date(dueDate.getYear(), dueDate.getMonth(), dueDate.getDay() + 14);
				getBooks().getBook(bookChoice).setDueDate(dueDate);
				getPatrons().getPatron(getPatrons().searchPatrons(foundPatrons.get(patronChoice)))
						.addCheckedOut(getBooks().getBook(bookChoice));
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
		LinkedList<Patron> foundPatrons = getPatrons().searchPatrons(search);
		getPatrons().printPatrons(foundPatrons);
		System.out.println(
				"Of these patrons, which would you like to choose? Please select the number corresponding to that patron.");
		int patronChoice = scanner.nextInt() - 1;
		System.out.println("You have chosen this patron: ");
		System.out
				.println(getPatrons().getPatron(getPatrons().searchPatrons(foundPatrons.get(patronChoice))).toString());
		System.out.println("This patron has the following books checked out currently:");
		getBooks().printBooks(
				getPatrons().getPatron(getPatrons().searchPatrons(foundPatrons.get(patronChoice))).getCheckedOut());
		System.out.println(
				"Of these books, which would you like to return? Please select the number corresponding to that book.");
		int bookChoice = scanner.nextInt() - 1;
		System.out.println("You have returned the following book:");
		System.out.println(getPatrons().getPatron(getPatrons().searchPatrons(foundPatrons.get(patronChoice)))
				.getCheckedOut().get(bookChoice).toString());
		getPatrons().getPatron(getPatrons().searchPatrons(foundPatrons.get(patronChoice))).getCheckedOut()
				.get(bookChoice).setShelfLocation("being processed");
		getBooks().addBook(getPatrons().getPatron(getPatrons().searchPatrons(foundPatrons.get(patronChoice)))
				.getCheckedOut().remove(bookChoice));
		int index = getBooks().getBooks().size() - 1;
		Date currentDate = new Date();
		if (currentDate.after(getBooks().getBook(index).getDate())) {
			getPatrons().getPatron(patronChoice).setFines(getPatrons().getPatron(patronChoice).getFines() + 5.00);
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
			System.out.println(getBooks().getBook(bookChoice).getShelfLocation());
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
		if (getPatrons().searchPatrons(new Patron(info.get(0), info.get(1), newAddress, patronFees)) != -1) {
			System.out.println("The patron you have requested to add already exists within the system.");
		} else {
			getPatrons().addPatron(new Patron(info.get(0), info.get(1), newAddress, patronFees));
			System.out.println("You have successfully added the patron: ");
			System.out.println(getPatrons().getPatrons().get(getPatrons().getPatrons().size() - 1).toString());
		}
		UI();
	}

	public int searchPatrons(String search) {
		LinkedList<Patron> foundPatrons = getPatrons().searchPatrons(search);
		if (foundPatrons == null) {
			return -1;
		} else {
			System.out.println("Based on your search, the following patrons have been found:");
			getPatrons().printPatrons(foundPatrons);
			System.out.println(
					"Of these patron, which would you like to select? Please select the number corresponding to that patron.");
			return getPatrons().searchPatrons(foundPatrons.get(scanner.nextInt() - 1));
		}
	}

	public void payFines() {
		System.out.println("What patron desires to pay their fines? Please search for them in the directory.");
		int result = searchPatrons(scanner.nextLine());
		if (result == -1) {
			System.out.println("Unfortunately, the patron you have searched for can not be found.");
		} else {
			System.out.println("This patron has the following fine: " + getPatrons().getPatron(result).getFines());
			System.out.println("How much of this fine would the patron like to pay?");
			double payment = scanner.nextDouble();
			while (payment < 0) {
				System.out.println("The payment amount you have entered is negative, please enter a valid payment.");
				payment = scanner.nextDouble();
			}
			if (payment >= getPatrons().getPatron(result).getFines()) {
				System.out.println("The patron has attempted to pay more than their current fines");
				payment = payment - getPatrons().getPatron(result).getFines();
				getPatrons().getPatron(result).setFines(0);
				System.out.println("Please return the following amount to the patron: " + payment);
			} else {
				getPatrons().getPatron(result).setFines(getPatrons().getPatron(result).getFines() - payment);
				System.out.println("Now, the remaining fines left on this patron account is: "
						+ getPatrons().getPatron(result).getFines());
			}
		}
		UI();
	}

}
