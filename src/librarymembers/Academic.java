package librarymembers;

import java.util.ArrayList;

import books.Book;

public class Academic extends LibraryMember {

//	
//	
//	// history field from parent class
//int 	maxNumberOfBooks=20;
//int 	timeLimit=50;
//	//BUNLARI CONSTRUCTORA MI YAZMAM GEREKLÝ
	/**
	 * Constructs a Academic Member with input ID set Maximum simultaneous Borrowed
	 * Books and set Time Limit for Borrowing
	 * 
	 * @param id ID of Academics
	 */
	public Academic(int id) { // Constructor lar public mi olmalý?
		this.id = id;
		this.maxNumberOfBooks = 20;
		this.timeLimit = 50;
	}

	/**
	 * Gets All Books which the member has read
	 * 
	 * @return History of readed books
	 */
	@Override
	public ArrayList<Book> getTheHistory() {
		// TODO Auto-generated method stub

		return history;
	}

}