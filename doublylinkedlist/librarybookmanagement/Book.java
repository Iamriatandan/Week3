package linkedlist.doublylinkedlist.librarybookmanagement;
//attribute class
//: Book Title, Author, Genre, Book ID, and Availability Status. Implement the following functionalities:
//Add a new book at the beginning, end, or at a specific position.
//Remove a book by Book ID.
//Search for a book by Book Title or Author.
//Update a book’s Availability Status.
//Display all books in forward and reverse order.
//Count the total number of books in the library.
//Hint:
//Use a doubly linked list with two pointers (next and prev) in each node to facilitate traversal in both directions.
//Ensure that when removing a book, both the next and prev pointers are correctly updated.
//Displaying in reverse order will require traversal from the last node using prev pointers.
public class Book {
    String title;
    String author;
    int bookId;
    String genre;
    boolean availiblityStatus;
    Book prev;
    Book next;

    //constructor

    public Book(String title, String author, int bookId, String genre, boolean availiblityStatus) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.genre = genre;
        this.availiblityStatus = true;
        this.prev= null;
        this.next=null;
    }
}
