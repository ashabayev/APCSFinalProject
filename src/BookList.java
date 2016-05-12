import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class BookList {
	private LinkedList<LibraryBook> bookList;

	public BookList() {
		bookList = new LinkedList<LibraryBook>();
	}

	public void addBook(LibraryBook b) {
		bookList.add(b);
		Collections.sort(bookList, new Comparator<LibraryBook>() {
			public int compare(LibraryBook b1, LibraryBook b2) {
				return b1.getTitle().compareTo(b2.getTitle());
			}
		});
	}

	public LibraryBook removeBook(int i) {
		return bookList.remove(i);
	}

	public LinkedList<LibraryBook> searchTitles(String search) {
		LinkedList<LibraryBook> found = new LinkedList<LibraryBook>();
		for (int i = 0; i < bookList.size(); i++) {
			if (search.equalsIgnoreCase(bookList.get(i).getTitle())) {
				found.add(bookList.get(i));
			}
		}
		return found;
	}

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

	public LinkedList<LibraryBook> searchISBN(String search) {
		LinkedList<LibraryBook> found = new LinkedList<LibraryBook>();
		for (int i = 0; i < bookList.size(); i++) {
			if (search.equalsIgnoreCase(bookList.get(i).getIBSN())) {
				found.add(bookList.get(i));
			}
		}
		return found;
	}

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
