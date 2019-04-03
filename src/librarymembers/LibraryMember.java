package librarymembers;

import java.util.*;

import books.Book;
public abstract class LibraryMember{
	
	public int id;
	
	int maxNumberOfBooks;
	
	int  timeLimit;
	
	public int getTimeLimit() {
		return timeLimit;
	}

	ArrayList<Book> history=new ArrayList<Book>();
	
	ArrayList<Book> currentBooks=new ArrayList<Book>();
	
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
	 
	 
	 public ArrayList<Book> getCurrentBooks() {
		 
		 return currentBooks;
		 
	 }
	 
	 public int getMaxNumberOfBooks() {
		 return maxNumberOfBooks;
	 }
}