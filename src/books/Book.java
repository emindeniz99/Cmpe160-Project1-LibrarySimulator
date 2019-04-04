package books;

import librarymembers.LibraryMember;

public abstract class Book {

   private int bookID;
   private	String bookType;
/**
 * Keeps if the book is taken or not
 */
   protected  boolean isTaken;
   /**
    * Keeps who has the book
    */
	protected LibraryMember whoHas;
/**
 * Keeps whether the book is being reading in library or not
 */
	protected boolean inReadingLibrary = false;

	/** Constructor of book according to ID and Type
	 * @param bookID ID of Book
	 * @param bookType Type of Book Handwritten or Printed
	 */
	Book(int bookID, String bookType) {
		this.bookID = bookID;
		this.bookType = bookType;
	}

	/** Returns the book by the member
	 * @param member who brings back
	 */
	abstract public void returnBook(LibraryMember member);

	
	/** Returns if book is taken or not
	 * @return if the Book is Taken or Not
	*/
	public boolean getIsTaken() {
		return isTaken;
	}
	
	/** Returns if book has been readed or not
	 * @return The Book readed in library or Not
	*/
	public boolean getInReadingLibrary() {
		return inReadingLibrary;
		
	}
	
}