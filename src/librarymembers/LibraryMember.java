package librarymembers;

import java.util.*;

import books.Book;
public abstract class LibraryMember{
	
	int id;
	
	int maxNumberOfBooks;
	
	int  timeLimit;
	
	public int getTimeLimit() {
		return timeLimit;
	}

	ArrayList<Book> history;
	
	// Why is it abstract?
	 abstract public ArrayList<Book> getTheHistory();
	
	//ArrayList will be added ?
	 // getTheHistory 
	
	 
	 public void reduceCapacity() {
		 maxNumberOfBooks--;
	 }
	 
	 public void increaseCapacity() {
		 maxNumberOfBooks++;
	 }
}