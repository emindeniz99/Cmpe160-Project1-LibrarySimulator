package books;

import librarymembers.LibraryMember;

public abstract class Book {

   private int bookID;
private	String bookType;

	protected  boolean isTaken;

	protected LibraryMember whoHas;

	protected boolean inReadingLibrary = false;

	Book(int bookID, String bookType) {
		this.bookID = bookID;
		this.bookType = bookType;
	}

	abstract public void returnBook(LibraryMember member);

	// getter
	
	/** Gets the employee’s last name.
	 * @return is the Book Taken or Not
	*/
	public boolean getIsTaken() {
		return isTaken;
	}
	
	public boolean getInReadingLibrary() {
		return inReadingLibrary;
		
	}
	
}