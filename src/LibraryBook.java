
public class LibraryBook implements Book {
	private String location;
	private int isbn;
	private int publishedYear;
	private String title;
	private Author author;

	public LibraryBook(String place, int isbnNum, int pubYear, String bookTitle, Author newAuthor)
	{
		location = place;
		isbn = isbnNum;
		publishedYear = pubYear;
		title = bookTitle;
		author = newAuthor;
	}
	
	/* (non-Javadoc)
	 * @see Book#getShelfLocaton()
	 */
	public String getShelfLocaton() {
		return location;
	}

	public void setShelfLocation(String desiredLocation) {
		location = desiredLocation;
	}

	public int getIBSN() {
		return isbn;
	}

	public void setISBN(int desiredISBN) {
		isbn = desiredISBN;
	}

	public int getYearPublished() {
		return publishedYear;
	}

	public void setYearPublished(int year) {
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
