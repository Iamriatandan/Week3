package linkedlist.doublylinkedlist.librarybookmanagement;

public class Main {
    public static void main(String[] args) {
        //creating instance
        LibraryBook books = new LibraryBook();

        //adding books
        books.addAtBegin("The Alchemist","Paulo Coelho", 101, "Fiction", true);
        books.addAtEnd("To Kill a Mockingbird", "Harper Lee", 102, "Classic", false);
        books.addAtPosition("1984", "George Orwell", 103, "Dystopian",true,1);

        //remove book
        books.removeBook(103);

        //searching book by author and title
        books.searchByAuthor("Paulo Coehlo");
        books.searchByTitle("1984");

        //update books availaiblity status
        books.updateAvailiblity(true);

        //displaying books in forward and reverse ordr
        books.forwardOrder();
        System.out.println();
        books.reverseOrder();

        // total books in library
        books.totalBooks();
    }
}
