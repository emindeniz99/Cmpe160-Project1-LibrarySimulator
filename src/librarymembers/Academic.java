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

	public Academic(int id) { // Constructor lar public mi olmalý?
		this.id = id;
		this.maxNumberOfBooks = 20;
		this.timeLimit = 50;
	}

	@Override
	public ArrayList<Book> getTheHistory() {
		// TODO Auto-generated method stub

		return history;
	}

}