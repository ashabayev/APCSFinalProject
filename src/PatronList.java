import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * list of object patron
 * 
 * @author Anna and Aadit
 *
 */
public class PatronList {
	private LinkedList<Patron> patronList;

	/**
	 * constructor
	 * 
	 */
	public PatronList() {
		patronList = new LinkedList<Patron>();
	}

	/**
	 * @return patronList
	 */
	public LinkedList<Patron> getPatrons() {
		return patronList;
	}

	/**
	 * @param index
	 * @return
	 */
	public Patron getPatron(int index) {
		return patronList.get(index);
	}

	/**
	 * @param p
	 */
	public void addPatron(Patron p) {
		patronList.add(p);
		Collections.sort(patronList, new Comparator<Patron>() {
			public int compare(Patron b1, Patron b2) {
				return b1.getLastName().compareTo(b2.getLastName());
			}
		});
	}

	/**
	 * @param search
	 * @return found
	 */
	public LinkedList<Patron> searchPatrons(String search) {
		LinkedList<Patron> found = new LinkedList<Patron>();
		int j = 0;
		for (int i = 0; i < patronList.size(); i++) {
			if (search.equalsIgnoreCase(patronList.get(i).getFirstName())
					|| search.equalsIgnoreCase(patronList.get(i).getLastName())
					|| search.equalsIgnoreCase(patronList.get(i).getFullName())) {
				found.add(patronList.get(i));
				j++;
			}
		}
		if (j == 0) {
			return null;
		} else {
			return found;
		}
	}

	public int searchPatron(Patron p) {
		for (int i = 0; i < getPatrons().size(); i++) {
			if (getPatrons().get(i).equals(p)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * print
	 * 
	 * @param l
	 */
	public void printPatrons(LinkedList<Patron> l) {
		if (l.size() == 0) {
			System.out.println("No current patrons");
		} else {
			System.out.println("Patrons in list: ");
			for (int i = 0; i < l.size(); i++) {
				int j = i + 1;
				System.out.println(j + ". " + l.get(i).toString());
			}
		}
	}

}
