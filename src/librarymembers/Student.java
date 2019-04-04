package librarymembers;

import java.util.ArrayList;

import books.Book;

public class Student extends LibraryMember {

	/** Constructs a Student Member with input ID
	 * set Maximum simultaneous Borrowed Books and 
	 * set Time Limit for Borrowing
	 * @param id ID of Student
	 */
	public Student(int id) {
		this.id = id;

		this.maxNumberOfBooks = 10;

		this.timeLimit = 20;
	}

	// No permission for Handwritten books
/** gets All Books which the member has read
 * @return history of readed books
 */
	@Override
	public ArrayList<Book> getTheHistory() {
		// TODO Auto-generated method stub
		return history;
	}

}