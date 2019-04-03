package books;

import librarymembers.LibraryMember;

public abstract class Book{
	
	public int bookID;
	String bookType;
	
	public boolean isTaken;
	
	LibraryMember whoHas;
	
	
	
	
	 Book(int bookID,String bookType){
	this.bookID=bookID;
	this.bookType=bookType;
	}
	
	
	abstract void returnBook(LibraryMember member) ;
	
	//getter
	public boolean getIsTaken() {
		return isTaken;
	}
}