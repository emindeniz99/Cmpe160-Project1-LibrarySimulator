package books;

import java.util.ArrayList;

import interfaces.ReadInLibrary;
import librarymembers.LibraryMember;

public class Handwritten extends Book implements ReadInLibrary {

	/*
	 * 
	 * int bookID; String bookType;
	 * 
	 * public boolean isTaken;
	 * 
	 * LibraryMember whoHas;
	 * 
	 * 
	 */
	
	/** Creates an Handwritten Book with the ID.
	 * @param ID of Handwritten Book
	*/
	public Handwritten(int bookID) {
		super(bookID, "H");

	}

	
	/** Creates an employee with the specified name.
	 * @param lastName The employee’s last name.
	 * @param firstName The employee’s first name.
	*/
	@Override
	public void readBook(LibraryMember member) {
		// TODO Auto-generated method stub

		ArrayList<Book> history = member.getTheHistory();
		if (!history.contains(this)) {
			history.add(this);
		}

		this.inReadingLibrary = true; // inLib mi?
		this.isTaken = true;
		this.whoHas = member;
		// member.reduceCapacity(); // Bu olacak mý? max sýnýrýndaysa okuyabilir mi?
		ArrayList<Book> curr = member.getCurrentBooks();
		curr.add(this);

	}

	/** Returns book
	 * Sets Taken or not, Who has
	 * Increases capacity of member, if book borrowed
	 * @param member who wants to return book
	 */
	@Override
	public void returnBook(LibraryMember member) {
		// TODO Auto-generated method stub
		ArrayList<Book> curr = member.getCurrentBooks();

		curr.remove(this);

		this.isTaken = false;
		this.whoHas = null;

		if (!this.inReadingLibrary)
			member.increaseCapacity();

		this.inReadingLibrary = false;

	}

}