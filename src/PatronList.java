import java.util.LinkedList;

public class PatronList {
	private LinkedList<Patron> patronList;

	public PatronList() {
		patronList = new LinkedList<Patron>();
	}

	public void addPatron(Patron p) {
		patronList.add(p);
	}

	public Patron removePatron(int i) {
		return patronList.remove(i);
	}

}
