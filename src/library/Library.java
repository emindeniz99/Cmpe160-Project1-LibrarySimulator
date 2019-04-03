package library;

import java.util.*;

import librarymembers.Academic;
import librarymembers.LibraryMember;
import librarymembers.Student;
import books.Book;
import books.Printed;
import books.Handwritten;
public class Library{
	
	LibraryMember[] members;
	Book[] books;
	
	int firstBook=0;
	int lastBook=-1; // index of last book , -1 means no book
	int firstMember=0;
	int lastMember=-1;
	Scanner FileScanner;
	
	private int totalFee;
	
	private LibraryMember getMemberByID(int id) {
		return members[id-1];
	}
	
	private Book getBookByID(int id) {
		return books[id-1];
	}
	
	public Library(Scanner input) {
		
		 FileScanner=input;
		members=new LibraryMember[1000000];
		books=new Book[1000000];
	
	}
	
	
	public void addBook() {
		String BookType=  FileScanner.next();
		
		
		if(BookType.equals("P")) {
			lastBook++;
			books[lastBook]=new Printed(lastBook+1);
		}
			
		
		if(BookType.equals("H")) {
			lastBook++;
			books[lastBook]=new Handwritten(lastBook+1);
		}
			
		for(int i =0;i<10;i++) System.out.print(books[i]);		
		System.out.println();
		FileScanner.nextLine();
	}
	
	public void addMember() {
		lastMember++;
		String BookType=  FileScanner.next();
		if(BookType.equals("S"))
			members[lastMember]=new Student(lastMember);
		
		if(BookType.equals("A"))
			members[lastMember]=new Academic(lastMember);
				
		FileScanner.nextLine(); // Satýrlarý bitirmeyi unutma
	}
	
	 public void borrowBook(int Tick) { // sadece printedlar borrowlanabilir 
		// !!! checkleri ekle, þuan hiç check yokk WP grubundakileri dikkate al
		
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmayý unutma !!!!
		Printed choosenBook= (Printed)  books[borrowedBookID] ;
		if( choosenBook.getIsTaken()==false ) {
			choosenBook.borrowBook(members[borrowerID],Tick);
		}
		FileScanner.nextLine();
	}
	
	
	
	
	public void returnBook(int Tick) {
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmayý unutma !!!!
		Printed choosenBook= (Printed)  books[borrowedBookID] ;
		
		if(choosenBook.deadLine<Tick) {
			this.totalFee+=Tick-choosenBook.deadLine;
		}
		choosenBook.returnBook(members[borrowerID]);
		
		
		FileScanner.nextLine();
	}
	
	
	public void extendBook(int Tick) {
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmayý unutma !!!!
		Printed choosenBook= (Printed)  books[borrowedBookID] ;
		
		if(choosenBook.deadLine<Tick) {
			choosenBook.extend(members[borrowerID], Tick);
		}
		
		
		
	}
	
	public void readInLibrary() {
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmayý unutma !!!!    BUNU IKISI DE OKUYABILIR
		Printed choosenBook= (Printed)  books[borrowedBookID] ;
		LibraryMember theMember=members[borrowerID];
		
		choosenBook.readBook(theMember);
	}
	
	
	
	
	
	
}