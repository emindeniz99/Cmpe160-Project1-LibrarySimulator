package library;

import java.util.*;
import librarymembers.LibraryMember;
import books.Book;

class Library{
	
	LibraryMember[] members;
	Book[] books;
	
	int firstBook=1;
	int lastBook=0; // index of last book
	Scanner FileScanner;
	
	private int totalFee;
	
	public Library(Scanner input) {
		
		 FileScanner=input;
		members=new LibraryMember[1000000];
		books=new Book[1000000];
	
	}
	
	
	void addBook() {
		
		lastBook++;
		String BookType=  FileScanner.next();
		books[lastBook]=Book(lastBook,BookType);
		
		
		
		
		
		
		FileScanner.nextLine();
	}
	
	
	
	
	
	
	
}