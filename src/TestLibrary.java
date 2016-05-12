import java.util.ArrayList;

public class TestLibrary {

	public static void main(String[] args) {
		
		ArrayList<LibraryBook> wholeList = new ArrayList<LibraryBook>();
		LibraryBook one = new LibraryBook("On Shelf", "9780930289232", "1986", "Watchman",
				new Author("Alan", "Moore", "DC Comics"));
		LibraryBook two = new LibraryBook("On Shelf", "9780802150325", "1981", "NINE PLAYS of the Modern Theatre",
				new Author("Harold", "Clurman", "Grove Press"));
		LibraryBook three = new LibraryBook("On Shelf", "9780393062243", "2007", "Death by Black Hole",
				new Author("Neil", "Tyson", "Norton"));
		LibraryBook four = new LibraryBook("On Shelf", "9780307277138", "2007", "Laugh Lines: Short Comic Plays",
				new Author("Eric", "Lane", "Vintage"));
		LibraryBook five = new LibraryBook("On Shelf", "9780743482783", "1992", "Hamlet",
				new Author("William", "Shakespeare", "The Folger Shakespeare Company"));
		LibraryBook six = new LibraryBook("On Shelf", "9781435126787", "2010", "Weird but True",
				new Author("Leslie", "Elman", "Fall River Press"));
		wholeList.add(one);

		System.out.println("Enter one of the following options: " +
				"\n" + "1. Include a book in the catalog" +
				"\n" + "2. Check out a book" +
				"\n" + "3. Return a book" +
				"\n" + "4. Status" +
				"\n" + "5. Exit");
		switch(task){
		//Include a book in the catalog
		case '1':
			break;
			//Check out a book
		case '2':
			break;
			//return a book
		case '3':
			break;
			//status
		case '4':
			break;
			//exit
		default:
			System.out.println("Have a nice day! Come again soon!");
			break;
		}
		
		Patron henry = new Patron("Morris", "Henry", new Address("237J Harvey Hall", "Menomonie", "WI", "54751"), 0, wholeList);
		System.out.println(henry.toString());
		System.out.println("Books checked out: " + henry.getCheckedOut()); //TODO: it prints the address of the list not the actual list yet
	}
}
