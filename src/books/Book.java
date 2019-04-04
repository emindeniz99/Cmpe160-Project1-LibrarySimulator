package books;

import librarymembers.LibraryMember;

public abstract class Book{
	
	public int bookID;
	String bookType;
	
	public boolean isTaken;
	
	LibraryMember whoHas;
	
	public boolean inReadingLibrary=false;
	
	
	 Book(int bookID,String bookType){
	this.bookID=bookID;
	this.bookType=bookType;
	}
	
	
	abstract public void returnBook(LibraryMember member) ;
	
	//getter
	public boolean getIsTaken() {
		return isTaken;
	}
}