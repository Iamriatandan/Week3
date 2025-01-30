package linkedlist.doublylinkedlist.moviemanagementsystem;

public class Main {
    public static void main(String[] args) {
        MovieManagement movies = new MovieManagement();
        // adding movies
        movies.addMovieAtStart("Welcome" ,"Anees Bazmee",2006,4.5);
        movies.addMovieAtEnd("Hera Pheri " ,"Priyadarshan",2002,4.9);
        movies.addMovieAtStart("Bhagam Bhag", "Priyadarshan",2005,4.6 );
        movies.addMovieAtEnd("Singham Returns","Rohit Shetty",2018,4.0);
        movies.addMovieAtEnd("Hero No 1","Srijan Soni",1999,4.2);

        // displaying movies
        movies.displayForwardOrder();

        //remove movie
        movies.removeMovie("Hero No 1");

        //displaying movie in forward order
        movies.displayForwardOrder();

        //displaying movies in reverse order
        movies.displayReverseOrder();

        //updating movie rating
        movies.updateRating("Singham Returns",3.8 );

        //search movie by title
        movies.searchByDirector("Priyadarshan");

        //search movie by rating
        movies.searchByRating(4.9);

    }
}
