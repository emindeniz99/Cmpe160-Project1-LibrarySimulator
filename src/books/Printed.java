package books;


import interfaces.*;
import librarymembers.LibraryMember;


public class Printed extends Book implements ReadInLibrary,Borrow{
	
	int deadLine;
	boolean isExtended;
	
	
	public Printed(int bookID){
		super(bookID,"P"); // Bu gerekli mi?? Yoksa otomatik çaðrýlýyor muydu?
		
	}
	
	 // implementing Read in Lib
	public void borrowBook(LibraryMember member, int tick) {
		
		
		
	}
	
	//implement for RÝN
	public void extend(LibraryMember member, int tick) {
		
	}
	
	
	
	
	
	
	
	
	// for Borrow
	public void readBook(LibraryMember member) {
		
		
	}

	
	
	
	
	
	
	@Override
	void returnBook(LibraryMember member) {
		// TODO Auto-generated method stub
		
	}
	
}