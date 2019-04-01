package library;

import java.util.*;

import librarymembers.Academic;
import librarymembers.LibraryMember;
import librarymembers.Student;
import books.Book;
import books.Printed;
import books.Handwritten;
class Library{
	
	LibraryMember[] members;
	Book[] books;
	
	int firstBook=1;
	int lastBook=0; // index of last book
	int firstMember=1;
	int lastMember=0;
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
		if(BookType.equals("P"))
			books[lastBook]=new Printed(lastBook);
		
		if(BookType.equals("H"))
			books[lastBook]=new Handwritten(lastBook);
				
		FileScanner.nextLine();
	}
	
	void addMember() {
		lastMember++;
		String BookType=  FileScanner.next();
		if(BookType.equals("S"))
			members[lastMember]=new Student(lastMember);
		
		if(BookType.equals("A"))
			members[lastMember]=new Academic(lastMember);
				
		FileScanner.nextLine(); // Satýrlarý bitirmeyi unutma
	}
	
	void borrowBook(int Tick) { // sadece printedlar borrowlanabilir
		
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmayý unutma !!!!
		Printed choosenBook= (Printed)  books[borrowedBookID] ;
		if( choosenBook.getIsTaken()==false ) {
			choosenBook.borrowBook(members[borrowerID],Tick);
		}
		FileScanner.nextLine();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}