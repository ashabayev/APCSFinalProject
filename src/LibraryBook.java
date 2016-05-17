import java.util.Date;

/**
 * @author Anna and Aadit
 *
 */
public class LibraryBook implements Book {
	private String location;
	private String isbn;
	private String publishedYear;
	private String title;
	private Author author;
	private Date dueDate;

	/**
	 * constructor
	 * 
	 * @param place
	 * @param isbnNum
	 * @param pubYear
	 * @param bookTitle
	 * @param newAuthor
	 */
	public LibraryBook(String place, String isbnNum, String pubYear, String bookTitle, Author newAuthor) {
		setShelfLocation(place);
		setISBN(isbnNum);
		setYearPublished(pubYear);
		setTitle(bookTitle);
		setAuthor(newAuthor);
	}

	/**
	 * constructor
	 * 
	 * @param place
	 * @param isbnNum
	 * @param pubYear
	 * @param bookTitle
	 * @param newAuthor
	 * @param dueDate
	 */
	public LibraryBook(String place, String isbnNum, String pubYear, String bookTitle, Author newAuthor, Date dueDate) {
		setShelfLocation(place);
		setISBN(isbnNum);
		setYearPublished(pubYear);
		setTitle(bookTitle);
		setAuthor(newAuthor);
		setDueDate(dueDate);
	}

	/**
	 * constructor
	 * 
	 * @param place
	 * @param isbnNum
	 * @param pubYear
	 * @param bookTitle
	 * @param newAuthor
	 * @param dueDateMonth
	 * @param dueDateDay
	 * @param dueDateYear
	 */
	public LibraryBook(String place, String isbnNum, String pubYear, String bookTitle, Author newAuthor,
			int dueDateMonth, int dueDateDay, int dueDateYear) {
		setShelfLocation(place);
		setISBN(isbnNum);
		setYearPublished(pubYear);
		setTitle(bookTitle);
		setAuthor(newAuthor);
		setDueDate(dueDateMonth, dueDateDay, dueDateYear);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Book#getShelfLocaton()
	 */
	public String getShelfLocation() {
		return location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Book#setShelfLocation(java.lang.String)
	 */
	public void setShelfLocation(String desiredLocation) {
		location = desiredLocation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Book#getISBN()
	 */
	public String getISBN() {
		return isbn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Book#setISBN(java.lang.String)
	 */
	public void setISBN(String desiredISBN) {
		isbn = desiredISBN;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Book#getYearPublished()
	 */
	public String getYearPublished() {
		return publishedYear;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Book#setYearPublished(java.lang.String)
	 */
	public void setYearPublished(String year) {
		publishedYear = year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Book#getTitle()
	 */
	public String getTitle() {
		return title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Book#setTitle(java.lang.String)
	 */
	public void setTitle(String desiredTitle) {
		title = desiredTitle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Book#getAuthor()
	 */
	public Author getAuthor() {
		return author;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Book#setAuthor(Author)
	 */
	public void setAuthor(Author desiredAuthor) {
		author = desiredAuthor;
	}

	/**
	 * @return dueDate
	 */
	public Date getDate() {
		return dueDate;
	}

	/**
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String getDueDate() {
		return dueDate.getMonth() + "/" + dueDate.getDay() + "/" + dueDate.getYear();
	}

	/**
	 * @param d
	 */
	public void setDueDate(Date d) {
		dueDate = d;
	}

	/**
	 * @param month
	 * @param year
	 * @param day
	 */
	@SuppressWarnings("deprecation")
	public void setDueDate(int month, int year, int day) {
		dueDate = new Date(year, month, day);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "{" + getTitle() + ", " + getAuthor().toString() + ", " + getYearPublished() + "," + getISBN() + ", "
				+ getShelfLocation() + ", " + getDueDate() + "}";
	}

	public String toStringNoDate() {
		return "{" + getTitle() + ", " + getAuthor().toString() + ", " + getYearPublished() + "," + getISBN() + ", "
				+ getShelfLocation() + "}";
	}

}
