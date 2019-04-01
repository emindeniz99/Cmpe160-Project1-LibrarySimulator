package librarymembers;

import java.util.ArrayList;

import books.Book;

public class Student extends LibraryMember{
	
	
	
	
int 	maxNumberOfBooks=10;
int 	timeLimit=50;
	// No permission for Handwritten books

public Student(int id){
	this.id=id;
	
}
	@Override
	ArrayList<Book> getTheHistory() {
		// TODO Auto-generated method stub
		return history;
	}



}