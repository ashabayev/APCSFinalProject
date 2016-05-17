import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * list of object LibraryBook
 * 
 * @author Anna and Aadit
 *
 */
public class BookList {
	private LinkedList<LibraryBook> bookList;

	/**
	 * constructor
	 */
	public BookList() {
		bookList = new LinkedList<LibraryBook>();
	}

	/**
	 * @return bookList
	 */
	public LinkedList<LibraryBook> getBooks() {
		return bookList;
	}

	/**
	 * @param index
	 * @return book at index
	 */
	public LibraryBook getBook(int index) {
		return bookList.get(index);
	}

	/**
	 * adds book to bookList
	 * 
	 * @param b
	 */
	public void addBook(LibraryBook b) {
		bookList.add(b);
		// sort books
		Collections.sort(bookList, new Comparator<LibraryBook>() {
			public int compare(LibraryBook b1, LibraryBook b2) {
				return b1.getAuthor().getLastName().compareTo(b2.getAuthor().getLastName());
			}
		});
	}

	public void removeBook(int index) {
		bookList.remove(index);
		Collections.sort(bookList, new Comparator<LibraryBook>() {
			public int compare(LibraryBook b1, LibraryBook b2) {
				return b1.getAuthor().getLastName().compareTo(b2.getAuthor().getLastName());
			}
		});
	}

	/**
	 * search for book by title
	 * 
	 * @param search
	 * @return
	 */
	public LinkedList<LibraryBook> searchTitles(String search) {
		LinkedList<LibraryBook> found = new LinkedList<LibraryBook>();
		int j = 0;
		for (int i = 0; i < bookList.size(); i++) {
			if (search.equalsIgnoreCase(bookList.get(i).getTitle())) {
				found.add(bookList.get(i));
				j++;
			}
		}
		if (j == 0) {
			return null;
		} else {
			return found;
		}
	}

	/**
	 * search for book by author
	 * 
	 * @param search
	 * @return
	 */
	public LinkedList<LibraryBook> searchAuthors(String search) {
		LinkedList<LibraryBook> found = new LinkedList<LibraryBook>();
		int j = 0;
		for (int i = 0; i < bookList.size(); i++) {
			if (search.equalsIgnoreCase(bookList.get(i).getAuthor().getFirstName())
					|| search.equalsIgnoreCase(bookList.get(i).getAuthor().getLastName())
					|| search.equalsIgnoreCase(bookList.get(i).getAuthor().getFullName())) {
				found.add(bookList.get(i));
				j++;
			}
		}
		if (j == 0) {
			return null;
		} else {
			return found;
		}
	}

	/**
	 * search for book by ISBN
	 * 
	 * @param search
	 * @return
	 */
	public LinkedList<LibraryBook> searchISBN(String search) {
		LinkedList<LibraryBook> found = new LinkedList<LibraryBook>();
		int j = 0;
		for (int i = 0; i < bookList.size(); i++) {
			if (search.equalsIgnoreCase(bookList.get(i).getISBN())) {
				found.add(bookList.get(i));
				j++;
			}
		}
		if (j == 0) {
			return null;
		} else {
			return found;
		}
	}

	/**
	 * search for book by year
	 * 
	 * @param search
	 * @return
	 */
	public LinkedList<LibraryBook> searchYear(String search) {
		LinkedList<LibraryBook> found = new LinkedList<LibraryBook>();
		int j = 0;
		for (int i = 0; i < bookList.size(); i++) {
			if (search.equalsIgnoreCase(bookList.get(i).getYearPublished())) {
				found.add(bookList.get(i));
				j++;
			}
		}
		if (j == 0) {
			return null;
		} else {
			return found;
		}
	}

	/**
	 * search for book in the list
	 * 
	 * @param b
	 * @return found
	 */
	public int searchBook(LibraryBook b) {
		int found = -1;
		for (int i = 0; 0 < getBooks().size(); i++) {
			if (b.equals(getBooks().get(i))) {
				found = i;
				break;
			}
		}
		return found;
	}

	/**
	 * @param l
	 */
	public void printBooks(LinkedList<LibraryBook> l) {
		if (l.size() == 0) {
			System.out.println("List is empty.");
		} else {
			System.out.println("Contents of list: ");
			for (int i = 0; i < l.size(); i++) {
				int j = i + 1;
				System.out.println(j + ". " + l.get(i).toStringNoDate());
			}
		}
	}

}
