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
	
	int firstBook=1;
	int lastBook=0; // index of last book , 0 means no book
	int firstMember=1;
	int lastMember=0;
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
		members=new LibraryMember[999999]; // 10**6 mý olacak hocaya sor, anlatýmda eksik var
		books=new Book[999999];
	
	}
	
	
	public void addBook() {
		String BookType=  FileScanner.next();
		
		
		if(BookType.equals("P")) {
			lastBook++;
			books[lastBook-1]=new Printed(lastBook);
		}
			
		
		if(BookType.equals("H")) {
			lastBook++;
			books[lastBook-1]=new Handwritten(lastBook);
		}
		System.out.println(lastBook+". idli    Book basýldý   "+BookType);	
//		for(int i =0;i<10;i++) System.out.print(books[i]);		
//		System.out.println();
		FileScanner.nextLine();
	}
	
	public void addMember() {
		String MemberType=  FileScanner.next();
		
		
		if(MemberType.equals("A")) {
			lastMember++;
			members[lastMember-1]=new Academic(lastMember);
		}
			
		
		if(MemberType.equals("S")) {
			lastMember++;
			members[lastMember-1]=new Student(lastMember);
		}
		System.out.println(lastMember+".    Kiþi basýldý     "+MemberType);
//		for(int i =0;i<10;i++) System.out.print(members[i]);		
//		System.out.println();
		FileScanner.nextLine();
	}
	
	
	private int fine(LibraryMember member,int tick) {
		int debt=0; //borç
		//borç check ediyoruz
		for(int i =0;i<member.getCurrentBooks().size();i++) {
			int deadline = ((Printed) member.getCurrentBooks().get(i)).getDeadline();
			if(deadline<tick) {
				debt+=tick-deadline;
				break;
				
				
			}
		}
		return debt;
	}
	
	
	
	
	
	
	
	public void borrowBook(int Tick) { // sadece printedlar borrowlanabilir
		// !!! checkleri ekle, þuan hiç check yokk WP grubundakileri dikkate al

		int borrowedBookID = FileScanner.nextInt();
		int borrowerID = FileScanner.nextInt();
		// casting yapmayý unutma !!!!
		if (borrowedBookID <= lastBook && borrowerID <= lastMember) {
			if (getBookByID(borrowedBookID) instanceof Printed) {
				
				Printed choosenBook = (Printed) getBookByID(borrowedBookID);

				LibraryMember who = getMemberByID(borrowerID);
//			System.out.println(who.getMaxNumberOfBooks());
//			System.out.println(choosenBook.getIsTaken()+"alýndý mý ");
//			System.out.println("dctKKKKKKKKKKKKKtcd"+who.id);
				if (choosenBook.getIsTaken() == false) {
////				System.out.println("dd");
//				boolean debt=false; //borç
//				//borç check ediyoruz
//				for(int i =0;i<who.getCurrentBooks().size();i++) {
//					if(((Printed) who.getCurrentBooks().get(i)).getDeadline()<Tick) {
//						debt=true;
//						System.out.println("NBORÇÇÇ");
//						break;
//					}
//				}

					if (fine(who, Tick) == 0) { // borc yoksa
//					System.out.println("dcttcd"+who.id);

						// kota var mý bakalým
//					System.out.println("kim" +who.id +"---- book"+ choosenBook.bookID);
//					
						if (who.getMaxNumberOfBooks() > 0) {
							System.out.println("--------" + who.id + ". kiþi aldý---- kitap" + choosenBook.bookID);
							choosenBook.borrowBook(this.getMemberByID(borrowerID), Tick);
//						System.out.println("drrd");
//						for(int i =0;i<10;i++) System.out.println(who.getCurrentBooks().get(i));		
//						System.out.println();

						}

					}

				}
			}

			else
				System.out.println("Geçersiz el yazgýsý");
		  System.out.println();
		}

		FileScanner.nextLine();
	}
	
	 
	
	 public boolean doesMemberHoldBook(LibraryMember member,Book book) {
		 for(int i =0;i<member.getCurrentBooks().size();i++) {
				if(member.getCurrentBooks().get(i).bookID==book.bookID) {
					return true;
				}
//				member.getCurrentBooks().contains(obje)
				
				// contains kullan!!
				
				
		 }
		 return false;
		 
	 }
	 
	
	public void returnBook(int Tick) {
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmayý unutma !!!!
//		Printed choosenBook= (Printed) this.getBookByID(borrowedBookID) ;  
		System.out.println("TÝCKS "+Tick);
		LibraryMember who=getMemberByID(borrowerID);
		
		if(borrowedBookID<=lastBook+1&&borrowerID<=lastMember+1){
			if(who.getCurrentBooks().contains(getBookByID(borrowedBookID))){
//			if(doesMemberHoldBook(who,getBookByID(borrowedBookID))){
				System.out.println("efe");
				Printed choosenBook= (Printed) this.getBookByID(borrowedBookID) ;
				System.out.println("deaEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEd  "+ choosenBook.getDeadline() +"   tick "+ Tick);
		if(choosenBook.getDeadline()<Tick) {
			int penalty = Tick-choosenBook.getDeadline();
			this.totalFee+= penalty;
			System.out.println(who.id+"  "+choosenBook.bookID+   "AAAAAAAAAAAAAAAaaaaaaaaaaaaaaaaaaaaaAAAAAAAAAAAA"+ penalty);
		}
		choosenBook.returnBook(this.getMemberByID(borrowerID));
		
		}
//		FileScanner.nextLine();
	}
		
		FileScanner.nextLine();
		
		System.out.println("TOT     "+this.getTotalFee());

		System.out.println(members[0].getCurrentBooks().toString());
		System.out.println(members[0].getTheHistory().toString());
		
	}
	
	
	public void extendBook(int Tick) {
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmayý unutma !!!!
		Printed choosenBook= (Printed) this.getBookByID(borrowedBookID) ;
		
		LibraryMember who=getMemberByID(borrowerID);
		
		if (borrowedBookID <= lastBook && borrowerID <= lastMember) {
			if (who.getCurrentBooks().contains(choosenBook)) {
				if ((choosenBook.getDeadline() > Tick) && !choosenBook.getIsExtended()) {
					choosenBook.extend(this.getMemberByID(borrowerID),Tick);
				}
				
   // BURADA CURRENT ARRAYI KULLANDIÐIM ÝÇÝN bu printed kitap mý diye test etmedim.
			}

		}

//		if (choosenBook.getDeadline() < Tick) {
//			choosenBook.(members[borrowerID], Tick);
//		}
		FileScanner.nextLine();
			}
	
	public void readInLibrary() {
		int borrowedBookID=FileScanner.nextInt();
		int borrowerID=FileScanner.nextInt();
		// casting yapmayý unutma !!!!    BUNU IKISI DE OKUYABILIR
if(borrowedBookID<=lastBook && borrowerID<=lastMember) {
	LibraryMember who=getMemberByID(borrowerID);
	

	if(getBookByID(borrowedBookID).getIsTaken()==false){
	
			
			if( getBookByID(borrowedBookID) instanceof Printed  ) {
		
		
				Printed choosenBook= (Printed)  getBookByID(borrowedBookID);
		
		
				choosenBook.readBook(who);
		
			}
			
			if( getBookByID(borrowedBookID) instanceof Handwritten  ) {
				
				if(who instanceof Academic){
				Handwritten choosenBook= (Handwritten)  getBookByID(borrowedBookID);
		
		
				choosenBook.readBook(who);
				}
			}
	
	}}
		
		
FileScanner.nextLine();
	}
	
	
	
	
	
	
	
	public Book[] getBooks() {
		return books;
		
	}
	
	public LibraryMember[] getMembers() {
		return members;
	}
	
	public int getTotalFee() {
		return totalFee;
		
	}
	
}