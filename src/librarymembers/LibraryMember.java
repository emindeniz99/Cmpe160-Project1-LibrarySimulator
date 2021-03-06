package librarymembers;

import java.util.*;

import books.Book;

public abstract class LibraryMember {

	protected int id;

	protected int maxNumberOfBooks;

	protected int timeLimit;

	public int getTimeLimit() {
		return timeLimit;
	}

	protected ArrayList<Book> history = new ArrayList<Book>();

	private ArrayList<Book> currentBooks = new ArrayList<Book>();

	// Why is it abstract?
	abstract public ArrayList<Book> getTheHistory();

	// ArrayList will be added ?
	// getTheHistory
/**
 * Reducer for regulating max Number of book to control no excess borrowed books
 */
	public void reduceCapacity() {
		maxNumberOfBooks--;
	}
	/**
	 * Increaser for regulating max Number of book to control no excess borrowed books
	 */
	public void increaseCapacity() {
		maxNumberOfBooks++;
	}

	
	/** Gets All Books which the member has read
	 * @return History of readed books
	 */
	public ArrayList<Book> getCurrentBooks() {

		return currentBooks;

	}
	/** Getter method for maximum Number Of Books
	 * @return Maximum number of books
	 */
	public int getMaxNumberOfBooks() {
		return maxNumberOfBooks;
	}

	// test

	public void yazdir() {
		System.out.print(" id " + this.id);
		System.out.print("  limit " + this.timeLimit);
		System.out.print("  max: " + this.maxNumberOfBooks);
		System.out.print(" history: " + this.history.toString());
		System.out.print(" elindekiler: " + this.currentBooks);
	}
}