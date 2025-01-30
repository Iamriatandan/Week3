package linkedlist.doublylinkedlist.librarybookmanagement;

public class LibraryBook {
    private Book head;
    private Book tail;
    int count=0;
    public LibraryBook(){
        this.head = null;
        this.tail=null;

    }

    //adding book in library
    //Method to add book at start
    public void addAtBegin(String title,String author,int bookId,String genre,boolean availiblityStatus){
        Book newbook = new Book(title, author, bookId, genre, availiblityStatus);
        if(head == null){
            head = tail = newbook;
        }
        count++;
    }

    //adding book at last
    public void addAtEnd(String title,String author,int bookId,String genre,boolean availiblityStatus){
        Book newBook = new Book(title, author, bookId, genre, availiblityStatus);
        if(head == null){
            head = tail = newBook;
        }
        else{
            tail.next = newBook;// pointing to new node
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    //adding book at specific position
    public void addAtPosition(String title,String author,int bookId,String genre,boolean availiblityStatus,int position){
        if(position == 1){
            addAtBegin(title, author, bookId, genre, availiblityStatus);
            return;
        }
        Book current = head;
        Book newBook = new Book(title, author, bookId, genre, availiblityStatus);
        for(int i =1;current!= null && i<position-1;i++){
            current= current.next;
        }
        if(current==null){
            System.out.println("Position out of range");
            return;
        }
        newBook.next = current.next;
        if (current.next != null) {
            current.next.prev = newBook;
        } else {
            tail = newBook;  // If adding at the end, update the tail
        }
        current.next = newBook;
        newBook.prev = current;

        count++;
    }

    //remove a book by book id
    public void removeBook(int bookid) {
        Book current = head;
        while(current!=null){
            if(current.bookId == bookid){
                if(current == head){
                   head = head.next;
                   if(head!= null)
                       head.prev = null;
                }
                else if(current == tail){//if removing tail
                    tail =  current.prev; //update tail
                    tail.next = null;
                }
                else{//removing from middle
                    current.prev.next = current.next;// Link previous node to next node
                    current.next.prev = current.prev; // Link next node to previous node
                }
                return;
            }
            current = current.next;
            count--;
        }
        System.out.println("Book not in Library");
    }

    //search book by title
    public void searchByTitle(String searchTitle){
        Book current = head;
        while(current != null){
            if(current.title.equalsIgnoreCase(searchTitle)){
                System.out.println("Book is : " + current.title + " | Author : " + current.author + " | BookId : " + current.bookId + " Genre : " +
                        current.genre + " | Book is Availaible : " + current.availiblityStatus);
            }
            current= current.next;
        }
    }

    //method to search book by author name
    public void searchByAuthor(String searchAuthor){
        Book current = head;
        while(current != null){
            if(current.author.equalsIgnoreCase(searchAuthor)){
                System.out.println("Book is : " + current.title + " | BookId : " + current.bookId + " Genre : " +
                        current.genre + " | Book is Availaible : " + current.availiblityStatus);
            }
            current= current.next;
        }
    }

    public void updateAvailiblity(boolean availiblityStatus){
        Book current = head;
        while(current!=null){
            if(availiblityStatus == false){
                System.out.println("Book not availaible in library");
            }
            else{
                System.out.println("Book availaible in library");
            }
            current = current.next;
        }
    }

    //display books in forward order
    public void forwardOrder(){
        Book current = head;
        while(current!= null){
            System.out.println("Book is : " + current.title + " | BookId : " + current.bookId + " Genre : " +
                    current.genre + " | Book is Availaible : " + current.availiblityStatus);
            current = current.next;
        }

    }

    //display books in reverse order
    public void reverseOrder(){
        Book current = tail;
        while(current!= null){
            System.out.println("Book is : " + current.title + " | BookId : " + current.bookId + " Genre : " +
                    current.genre + " | Book is Availaible : " + current.availiblityStatus);
            current = current.next;
        }

    }

    //Count total books in library
    public void totalBooks() {
        System.out.println("Total Number of Books are : " + count);
    }
    
}
