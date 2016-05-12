import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
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

	/**adds book to bookList
	 * @param b
	 */
	public void addBook(LibraryBook b) {
		bookList.add(b);
		//sort books
		Collections.sort(bookList, new Comparator<LibraryBook>() {
			public int compare(LibraryBook b1, LibraryBook b2) {
				return b1.getTitle().compareTo(b2.getTitle());
			}
		});
	}

	/**search for book by title
	 * @param search
	 * @return
	 */
	public LinkedList<LibraryBook> searchTitles(String search) {
		LinkedList<LibraryBook> found = new LinkedList<LibraryBook>();
		for (int i = 0; i < bookList.size(); i++) {
			if (search.equalsIgnoreCase(bookList.get(i).getTitle())) {
				found.add(bookList.get(i));
			}
		}
		return found;
	}

	/**search for book by author
	 * @param search
	 * @return
	 */
	public LinkedList<LibraryBook> searchAuthors(String search) {
		LinkedList<LibraryBook> found = new LinkedList<LibraryBook>();
		for (int i = 0; i < bookList.size(); i++) {
			if (search.equalsIgnoreCase(bookList.get(i).getAuthor().getFirstName())
					|| search.equalsIgnoreCase(bookList.get(i).getAuthor().getLastName())
					|| search.equalsIgnoreCase(bookList.get(i).getAuthor().getFullName())) {
				found.add(bookList.get(i));
			}
		}
		return found;
	}

	/**search for book by ISBN
	 * @param search
	 * @return
	 */
	public LinkedList<LibraryBook> searchISBN(String search) {
		LinkedList<LibraryBook> found = new LinkedList<LibraryBook>();
		for (int i = 0; i < bookList.size(); i++) {
			if (search.equalsIgnoreCase(bookList.get(i).getIBSN())) {
				found.add(bookList.get(i));
			}
		}
		return found;
	}

	/**search for book by year
	 * @param search
	 * @return
	 */
	public LinkedList<LibraryBook> searchYear(String search) {
		LinkedList<LibraryBook> found = new LinkedList<LibraryBook>();
		for (int i = 0; i < bookList.size(); i++) {
			if (search.equalsIgnoreCase(bookList.get(i).getYearPublished())) {
				found.add(bookList.get(i));
			}
		}
		return found;
	}
}
