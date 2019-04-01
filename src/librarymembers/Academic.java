package librarymembers;

import java.util.ArrayList;

import books.Book;

public class Academic extends LibraryMember{
	
	
	
	// history field from parent class
int 	maxNumberOfBooks=20;
int 	timeLimit=50;
	

public Academic(int id){ // Constructor lar public mi olmalý?
	this.id=id;
	
}


@Override
ArrayList<Book> getTheHistory() {
	// TODO Auto-generated method stub
	
	return history;
}



}