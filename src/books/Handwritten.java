package books;

import interfaces.ReadInLibrary;
import librarymembers.LibraryMember;

public class Handwritten extends Book implements ReadInLibrary{
	
	public Handwritten(int bookID){
		super(bookID,"H");
		
	}

	@Override
	public void readBook(LibraryMember member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void returnBook(LibraryMember member) {
		// TODO Auto-generated method stub
		
		this.isTaken=false;
		this.whoHas=null;
		
		
	}
	
	
	
}