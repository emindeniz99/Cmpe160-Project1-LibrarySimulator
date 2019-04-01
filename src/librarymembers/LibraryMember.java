package librarymembers;

import java.util.*;

import books.Book;
public abstract class LibraryMember{
	
	int id;
	
	int maxNumberOfBooks;
	
	int  timeLimit;
	
	ArrayList<Book> history;
	
	// Why is it abstract?
	 abstract ArrayList<Book> getTheHistory();
	
	//ArrayList will be added ?
	 // getTheHistory 
	
}