package library;

import java.util.*;

import librarymembers.Academic;
import librarymembers.LibraryMember;
import librarymembers.Student;
import books.Book;
import books.Printed;
import books.Handwritten;

/**
 * Reads inputs and checks for validty of events and calls other methods
 * 	organizes all processes
 * Includes some methods for working as library
 * 
 * <ul>
 *  <li> {@link #addBook} 
 *  <li> {@link #addMember}
 *  <li>{@link #borrowBook}
 *  <li>{@link #returnBook}
 *  <li>{@link #extendBook}
 *  <li>{@link #readInLibrary}
 * </ul>
 * 
 * @author Emin Deniz
 * @version 4.0
 */


public class Library {

	private	LibraryMember[] members;

	private Book[] books;

	private int lastBook = 0; // index of last book , 0 means no book

	private int lastMember = 0;
	private	Scanner fileScanner;

	private int totalFee;

	private LibraryMember getMemberByID(int id) {
		return members[id - 1];
	}

	private Book getBookByID(int id) {
		return books[id - 1];
	}

	/** Initializes Members and Books Arrays and uses Scanner for reading input
	 * 
	 * @param input		to read remaining of the input
	 */
	public Library(Scanner input) {

		fileScanner = input;
		members = new LibraryMember[1000000]; // 10**6-1 mý olacak hocaya sor, anlatýmda eksik var
		books = new Book[1000000];

	}

	
	/** Adds new Book with next ID
	 *  with respect to readed BookType via Scanner
	 *  H -> Handwritten
	 *  P -> Printed
	 *  ps. First Book's ID is 1
	 */
	public void addBook() {
		String BookType = fileScanner.next();

		if (BookType.equals("P")) {
			lastBook++;
			books[lastBook - 1] = new Printed(lastBook);
		}

		if (BookType.equals("H")) {
			lastBook++;
			books[lastBook - 1] = new Handwritten(lastBook);
		}
		System.out.println(lastBook + ". idli    Book basýldý   " + BookType);
		// for(int i =0;i<10;i++) System.out.print(books[i]);
		// System.out.println();
		fileScanner.nextLine();
	}

	
	
	/** Adds new LibraryMember with next ID
	 *  with respect to readed MemberType via Scanner
	 *  A -> Academic
	 *  S -> Student
	 *  ps. First LibraryMember's ID is 1
	 */
	public void addMember() {
		String MemberType = fileScanner.next();

		if (MemberType.equals("A")) {
			lastMember++;
			members[lastMember - 1] = new Academic(lastMember);
		}

		if (MemberType.equals("S")) {
			lastMember++;
			members[lastMember - 1] = new Student(lastMember);
		}
		System.out.println(lastMember + ".    Kiþi basýldý     " + MemberType);
		// for(int i =0;i<10;i++) System.out.print(members[i]);
		// System.out.println();
		fileScanner.nextLine();
	}

	private int fine(LibraryMember member, int tick) {
		int debt = 0; // borç
		// borç check ediyoruz
		for (int i = 0; i < member.getCurrentBooks().size(); i++) {
			int deadline = ((Printed) member.getCurrentBooks().get(i)).getDeadline();
			if (deadline < tick) {
				debt += tick - deadline;
				break;

			}
		}
		return debt;
	}

	
	/** reads Borrower and Borrowed Book and 
	 * checks validity of the process and
	 * calls <code>borrowBook</code> method 
	 * to complete borrowing
	 * 
	 * @param Tick process Number, so Time
	 */
	public void borrowBook(int Tick) { // sadece printedlar borrowlanabilir
		// !!! checkleri ekle, þuan hiç check yokk WP grubundakileri dikkate al

		int borrowedBookID = fileScanner.nextInt();
		int borrowerID = fileScanner.nextInt();
		// casting yapmayý unutma !!!!
		if (borrowedBookID <= lastBook && borrowerID <= lastMember) {
			if (getBookByID(borrowedBookID) instanceof Printed) {

				Printed choosenBook = (Printed) getBookByID(borrowedBookID);

				LibraryMember who = getMemberByID(borrowerID);
				
				// System.out.println(who.getMaxNumberOfBooks());
				// System.out.println(choosenBook.getIsTaken()+"alýndý mý ");
				// System.out.println("dctKKKKKKKKKKKKKtcd"+who.id);
				if (choosenBook.getIsTaken() == false) {
					//// System.out.println("dd");
					// boolean debt=false; //borç
					// //borç check ediyoruz
					// for(int i =0;i<who.getCurrentBooks().size();i++) {
					// if(((Printed) who.getCurrentBooks().get(i)).getDeadline()<Tick) {
					// debt=true;
					// System.out.println("NBORÇÇÇ");
					// break;
					// }
					// }

					if (fine(who, Tick) == 0) { // borc yoksa
						// System.out.println("dcttcd"+who.id);

						// kota var mý bakalým
						// System.out.println("kim" +who.id +"---- book"+ choosenBook.bookID);
						//
						if (who.getMaxNumberOfBooks() > 0) {
							System.out.println("--------" + borrowerID + ". kiþi aldý---- kitap" + borrowedBookID);
							choosenBook.borrowBook(this.getMemberByID(borrowerID), Tick);
							// System.out.println("drrd");
							// for(int i =0;i<10;i++) System.out.println(who.getCurrentBooks().get(i));
							// System.out.println();

						}

					}
					

				}
			}

			else
				System.out.println("Geçersiz el yazgýsý");
			System.out.println();
		}
		
		fileScanner.nextLine();
	}

/*	public boolean doesMemberHoldBook(LibraryMember member, Book book) {
		for (int i = 0; i < member.getCurrentBooks().size(); i++) {
			if (member.getCurrentBooks().get(i).bookID == book.bookID) {
				return true;
			}
			// member.getCurrentBooks().contains(obje)

			// contains kullan!!

		}
		return false;

	}
*/
	
	
	
	/** checks and return the book
	 * Reads Returner and Returned Book and 
	 * checks validity of the process and
	 * calls <code>returnBook</code> method 
	 *  to complete Returning Process
	 * @param Tick process Number, so Time
	 */
	public void returnBook(int Tick) {
		int borrowedBookID = fileScanner.nextInt();
		int borrowerID = fileScanner.nextInt();
		// casting yapmayý unutma !!!!
		// Printed choosenBook= (Printed) this.getBookByID(borrowedBookID) ;
//		System.out.println("TÝCKS "+Tick);
		LibraryMember who = getMemberByID(borrowerID);

		if (borrowedBookID <= lastBook + 1 && borrowerID <= lastMember + 1) {
			if (who.getCurrentBooks().contains(getBookByID(borrowedBookID))) {
				// if(doesMemberHoldBook(who,getBookByID(borrowedBookID))){
//				System.out.println("efe");

//				System.out.println("deaEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEd  "+ choosenBook.getDeadline() +"   tick "+ Tick);

				if (this.getBookByID(borrowedBookID) instanceof Printed) {
					Printed choosenBook = (Printed) this.getBookByID(borrowedBookID);

					int penalty = 0;
					if (choosenBook.getDeadline() < Tick) {
						penalty = Tick - choosenBook.getDeadline();
						this.totalFee += penalty;
//					System.out.println(who.id+"kim      book "+choosenBook.bookID+   "  ceza:"+ penalty);
					}

				}

				System.out.println();
//				System.out.println("iadeden önce"+who.getCurrentBooks().toString() +"");
				who.yazdir();
				System.out.println();

				this.getBookByID(borrowedBookID).returnBook(this.getMemberByID(borrowerID));
				if (this.getBookByID(borrowedBookID).getInReadingLibrary())
					System.out.print("kütüpte");

				System.out.println(borrowerID + "kim      book " + borrowedBookID + "   Tot: "
						+ this.getTotalFee());
				who.yazdir();
				System.out.println();
//				System.out.println("iadeden sonrs"+who.getCurrentBooks().toString() +"\n");
			}
			// fileScanner.nextLine();
		}

		fileScanner.nextLine();

//		System.out.println("TOT     "+this.getTotalFee());

//		System.out.println(members[0].getCurrentBooks().toString());
//		System.out.println(members[0].getTheHistory().toString());

	}

	
	
	/** checks and calls <code>extendBook</code> method
	 * Reads Extender and Extended Book and 
	 * checks validity of the process and
	 * calls <code>returnBook</code> method 
	 * 
	 * @param Tick process Number, so Time
	 */
	public void extendBook(int Tick) {
		int borrowedBookID = fileScanner.nextInt();
		int borrowerID = fileScanner.nextInt();
		// casting yapmayý unutma !!!!
		Printed choosenBook = (Printed) this.getBookByID(borrowedBookID);

		LibraryMember who = getMemberByID(borrowerID);

		if (borrowedBookID <= lastBook && borrowerID <= lastMember) {
			if (who.getCurrentBooks().contains(choosenBook)) {
				if ((choosenBook.getDeadline() > Tick) && !choosenBook.getIsExtended()) {
					choosenBook.extend(this.getMemberByID(borrowerID), Tick);
					System.out.println(borrowerID + "uzattý book:" + borrowedBookID);
				}

				// BURADA CURRENT ARRAYI KULLANDIÐIM ÝÇÝN bu printed kitap mý diye test etmedim.
			}

		}

		// if (choosenBook.getDeadline() < Tick) {
		// choosenBook.(members[borrowerID], Tick);
		// }
		fileScanner.nextLine();

	}
	/** checks and calls <code>readBook</code> method
	 * Reads Borrower and Borrowed Book and 
	 * checks validity of the process and
	 * calls <code>readBook</code> method 
	 * to complete getting book to read in library
	 * @param Tick process Number, so Time
	 */
	public void readInLibrary() {
		int borrowedBookID = fileScanner.nextInt();
		int borrowerID = fileScanner.nextInt();
		// casting yapmayý unutma !!!! BUNU IKISI DE OKUYABILIR
		if (borrowedBookID <= lastBook && borrowerID <= lastMember) {
			LibraryMember who = getMemberByID(borrowerID);

			if (getBookByID(borrowedBookID).getIsTaken() == false) {

				if (getBookByID(borrowedBookID) instanceof Printed) {

					Printed choosenBook = (Printed) getBookByID(borrowedBookID);

					choosenBook.readBook(who);
					System.out.println(borrowerID + ". kiþi ,,Kütüpte okudu kitap: " + borrowedBookID);
//					System.out.println(who.getCurrentBooks().toString());
					who.yazdir();
					System.out.println();
				}

				else if (getBookByID(borrowedBookID) instanceof Handwritten) {

					if (who instanceof Academic) {
						Handwritten choosenBook = (Handwritten) getBookByID(borrowedBookID);

						choosenBook.readBook(who);

						System.out.println(borrowerID + ". kiþi ,,Kütüpte okudu kitap: " + borrowedBookID);
						who.yazdir();
						System.out.println();
//						System.out.println(who.getCurrentBooks().toString());

					}
				}

			}
		}

		fileScanner.nextLine();
	}

	
	/** gets Books array which includes all books that are in library
	 * 
	 * @return all books in Library
	 */
	public Book[] getBooks() {
		return books;

	}

	/** gets Books array which includes all books that are in library
	 * 
	 * @return all books in Library
	 */
	public LibraryMember[] getMembers() {
		return members;
	}

	/** gets total fee in Library
	 * 
	 * @return Total Gains from Those who miss the Deadline for Borrowed Book
	 */
	public int getTotalFee() {
		return totalFee;

	}

}