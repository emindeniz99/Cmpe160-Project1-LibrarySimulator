package books;

import librarymembers.LibraryMember;

public abstract class Book {

   private int bookID;
   private	String bookType;
/**
 * keeps that book is taken or not
 */
   protected  boolean isTaken;
   /**
    * keeps who has the book
    */
	protected LibraryMember whoHas;
/**
 * keeps the book is being reading in library or not
 */
	protected boolean inReadingLibrary = false;

	/** constructor of book wrt ID and Type
	 * @param bookID id of Book
	 * @param bookType Type of Book Handwritten or Printed
	 */
	Book(int bookID, String bookType) {
		this.bookID = bookID;
		this.bookType = bookType;
	}

	/** returns the book by the member
	 * @param member who bringing back
	 */
	abstract public void returnBook(LibraryMember member);

	
	/** returns if book is taken or not
	 * @return is the Book Taken or Not
	*/
	public boolean getIsTaken() {
		return isTaken;
	}
	
	/** returns if book has been readed or not
	 * @return the Book readed in library or Not
	*/
	public boolean getInReadingLibrary() {
		return inReadingLibrary;
		
	}
	
}