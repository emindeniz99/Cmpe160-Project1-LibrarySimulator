package books;

import java.util.ArrayList;

import interfaces.ReadInLibrary;
import librarymembers.LibraryMember;

public class Handwritten extends Book implements ReadInLibrary{
	
	/*
	 * 
	int bookID;
	String bookType;
	
	public boolean isTaken;
	
	LibraryMember whoHas;

	 * 
	 */
	
	
	public Handwritten(int bookID){
		super(bookID,"H");
		
	}

	@Override
	public void readBook(LibraryMember member) {
		// TODO Auto-generated method stub
		ArrayList<Book> history=member.getTheHistory();
		history.add(this); // böyle olur mu?
		this.isTaken=true;
		this.whoHas=member;
		member.reduceCapacity(); // Bu olacak mý? max sýnýrýndaysa okuyabilir mi?
		
		

	}

	@Override
	public void returnBook(LibraryMember member) {
		// TODO Auto-generated method stub
		
		this.isTaken=false;
		this.whoHas=null;
		member.increaseCapacity();
		

		
	}
	
	
	
}