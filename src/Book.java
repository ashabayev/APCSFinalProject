
public interface Book {
	String getShelfLocaton();

	/**
	 * six shelfing locations: shelf, express shelf, drive up pickup, checked
	 * out, lost
	 * 
	 * @param location
	 */
	void setShelfLocation(String location);

	String getIBSN();

	void setISBN(String isbn);

	String getYearPublished();

	void setYearPublished(String year);

	String getTitle();

	void setTitle(String title);

	Author getAuthor();

	void setAuthor(Author author);
}
