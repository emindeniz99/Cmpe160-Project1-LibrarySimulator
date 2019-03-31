package books;


import interfaces.*;
import librarymembers.LibraryMember;


public class Printed implements ReadInLibrary,Borrow{
	
	int a=44;
	
	
	
	 // implementing Read in Lib
	public void borrowBook(LibraryMember member, int tick) {
		
		
		
	}
	
	//implement for RÝN
	public void extend(LibraryMember member, int tick) {
		
	}
	
	
	
	
	// for Borrow
	public void readBook(LibraryMember member) {
		
		
	}
	
}