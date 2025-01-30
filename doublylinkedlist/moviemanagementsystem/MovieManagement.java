package linkedlist.doublylinkedlist.moviemanagementsystem;
//assigning head and tail and then appling different functions
public class MovieManagement {
    private Movie head;//pointer for first node
    private Movie tail;//pointer for last node

    //constructor to access them
    public MovieManagement(){
        this.head = null;
        this.tail = null;
    }

    //method to add movie at beginning
    public void addMovieAtStart(String title , String director , int year,double rating){
        //creating new movie node to add
        Movie newMovie = new Movie(title, director, year, rating);
        if(head == null){// if list is empty
            head = tail = newMovie; // this node becomes both head and tail
        }
    }
    //method to add movie at end
    public void addMovieAtEnd(String title , String director , int year,double rating ){
        //creating new movie node to add
        Movie newMovie = new Movie(title, director, year, rating);
        if(head == null){// if list is empty
            head = tail = newMovie; // this node becomes both head and tail
        }
        else{
            tail.next=newMovie;//current tails next points to new node
            newMovie.prev = tail; // pointing new node previous to current tail
            tail = newMovie;//update tail value of new node
        }
    }

    //remove movie from list by title
    public void removeMovie(String title){
        Movie current = head;//temporary pointer for traversal
       while(current != null){//using loop to go this till end
           if(current.title.equalsIgnoreCase(title)){//if title matches
               if(current == head){ //trying to remove head node and then updating head to next node
                   head = head.next;
                   if (head != null) head.prev = null; // Remove previous link
               }
               else if(current == tail){//if removing tail
                   tail =  current.prev; //update tail
                   tail.next = null;
               }
               else{//removing from middle
                   current.prev.next = current.next;// Link previous node to next node
                   current.next.prev = current.prev; // Link next node to previous node
               }
               return;//exit after removal
           }
           current = current.next;//moving to next node
       }
        System.out.println("Movie not found");
    }

    //searching movie by director name
    public void searchByDirector(String directorname){
        Movie current = head;
        while(current != null){
            if(current.director.equalsIgnoreCase( directorname)){
                System.out.println("Movie : " + current.title + " | Publishing Year : " + current.year + " | Rating : " + current.rating );
            }
            current = current.next;//move pointer to next node
        }
    }

    //search movies by rating
    public void searchByRating(double rate){
        Movie current = head;
        while(current!= null){
            if(current.rating == rate){
                System.out.println("Name of movie : " + current.title + " | Directed by : " + current.director + " | Published in year : " + current.year);
            }
            current = current.next;//move to next node
        }
    }
    //display movies in forward order
    public void displayForwardOrder(){
        Movie current= head;
        while(current!= null){
            System.out.println("Movie Name : " + current.title + " | Directed by : " + current.director + " | Publishing year : " + current.year + " | Rating : " + current.rating);
            current = current.next;
        }
    }
    //display movies in reverse order
    public void displayReverseOrder(){
        Movie current= tail;
        while(current!= null){
            System.out.println("Movie Name : " + current.title + " | Directed by : " + current.director + " | Publishing year : " + current.year + " | Rating : " + current.rating);
            current = current.prev;
        }
    }

    //update movie rating based on title
    public void updateRating(String checkTitle , double newRating ){
        Movie current = head;
        while(current != null){
            if(current.title.equalsIgnoreCase(checkTitle)){
                current.rating=newRating;
            }
            current = current.next;
        }
        System.out.println("Movie not found");
    }


}
