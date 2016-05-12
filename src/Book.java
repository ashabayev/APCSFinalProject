
public interface Book {
	String getShelfLocaton();

	/**six shelfing locations: shelf, express shelf, drive up pickup, checked out, lost
	 * @param location
	 */
	void setShelfLocation(String location);

	int getIBSN();

	void setISBN(int isbn);

	int getYearPublished();

	void setYearPublished(int year);

	String getTitle();

	void setTitle(String title);

	Author getAuthor();

	void setAuthor(Author author);
}
