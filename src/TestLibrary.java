import java.util.ArrayList;
import java.util.Scanner;

public class TestLibrary {

	public static void main(String[] args) {
		
		
		ArrayList<LibraryBook> wholeList = new ArrayList<LibraryBook>();
		//populate the library with different books
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
				new Author("Leslie", "Elman", "Fall River"));
		LibraryBook seven = new LibraryBook("On Shelf", "9781435140370", "2012", "H.P. Lovecraft: Great Tales of Horror",
				new Author("Howard Phillips", "Lovecraft", "Fall River"));
		LibraryBook eight = new LibraryBook("On Shelf", "9781566196043", "1992", "The Complete Sherlock Holmes",
				new Author("Arthur Conan", "Doyle", "Barnes and Noble"));
		LibraryBook nine = new LibraryBook("On Shelf", "9780439420891", "2003", "The Thief Lord",
				new Author("Cornelia", "Funke", "Scholastic"));
		LibraryBook ten = new LibraryBook("On Shelf", "9780552779733", "2005", "The Book Thief",
				new Author("Markus", "Zusak", "Transworld"));
		wholeList.add(one);
		wholeList.add(two);
		wholeList.add(three);
		wholeList.add(four);
		wholeList.add(five);
		wholeList.add(six);
		wholeList.add(seven);
		wholeList.add(eight);
		wholeList.add(nine);
		wholeList.add(ten);

		System.out.println("Enter one of the following options: " +
				"\n" + "1. Include a book in the catalog" +
				"\n" + "2. Check out a book" +
				"\n" + "3. Return a book" +
				"\n" + "4. Status" +
				"\n" + "5. Exit");
		ArrayList<LibraryBook> henryList = new ArrayList<LibraryBook>();
		Scanner sc = new Scanner(System.in); //creates scanner
		char task = sc.next().charAt(0);
		switch(task){
		case '1': //Include a book in the catalog
			break;
		case '2'://Check out a book
			//if(wholeList.getShelfLocation().compareString("On Shelf") == false)
				//henryList.add(e)
			break;
		case '3': //return a book
			//match the book with library book data, and then set that to checked in
			break;
		case '4': //status
			//print list of books that patron has
			break;
		default: //exit
			System.out.println("Have a nice day! Come again soon!");
			break;
		}
		
		Patron henry = new Patron("Morris", "Henry", new Address("237J Harvey Hall", "Menomonie", "WI", "54751"), 0, wholeList);
		System.out.println(henry.toString());
		System.out.println("Books checked out: " + henry.getCheckedOut()); //TODO: it prints the address of the list not the actual list yet
		System.out.println("Books checked out: ") ; //printBooks()

	}
}
