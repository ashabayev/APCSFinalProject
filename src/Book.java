
/**
 * @author Anna and Aadit
 *
 */
public interface Book {
	String getShelfLocation();

	/**
	 * six shelfing locations: shelf, express shelf, drive up pickup, checked
	 * out, lost
	 * 
	 * @param location
	 */
	void setShelfLocation(String location);

	/**
	 * @return ISBN
	 */
	String getISBN();

	/**
	 * @param isbn
	 */
	void setISBN(String isbn);

	/**
	 * @return yearPublished
	 */
	String getYearPublished();

	/**
	 * @param year
	 */
	void setYearPublished(String year);

	/**
	 * @return title
	 */
	String getTitle();

	/**
	 * @param title
	 */
	void setTitle(String title);

	/**
	 * @return author
	 */
	Author getAuthor();

	/**
	 * @param author
	 */
	void setAuthor(Author author);
}
