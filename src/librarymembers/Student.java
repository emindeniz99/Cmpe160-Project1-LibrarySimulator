package librarymembers;

import java.util.ArrayList;

import books.Book;

public class Student extends LibraryMember{
	


	
	
	public Student(int id){
		this.id=id;
		
	maxNumberOfBooks=10;
		
	timeLimit=3;
		 	}
	
	
	

	// No permission for Handwritten books


	@Override
	public ArrayList<Book> getTheHistory() {
		// TODO Auto-generated method stub
		return history;
	}



}