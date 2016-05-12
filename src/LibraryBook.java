
public class LibraryBook implements Book {
	private String location;
	private String isbn;
	private String publishedYear;
	private String title;
	private Author author;

	public LibraryBook(String place, String isbnNum, String pubYear, String bookTitle, Author newAuthor) {
		location = place;
		isbn = isbnNum;
		publishedYear = pubYear;
		title = bookTitle;
		author = newAuthor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Book#getShelfLocaton()
	 */
	public String getShelfLocaton() {
		return location;
	}

	public void setShelfLocation(String desiredLocation) {
		location = desiredLocation;
	}

	public String getIBSN() {
		return isbn;
	}

	public void setISBN(String desiredISBN) {
		isbn = desiredISBN;
	}

	public String getYearPublished() {
		return publishedYear;
	}

	public void setYearPublished(String year) {
		publishedYear = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String desiredTitle) {
		title = desiredTitle;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author desiredAuthor) {
		author = desiredAuthor;
	}

}
