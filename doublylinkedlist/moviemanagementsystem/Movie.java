package linkedlist.doublylinkedlist.moviemanagementsystem;
//defining atributes
public class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;//pointer for next node address
    Movie prev;//pointer for prev node address

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
