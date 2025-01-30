package linkedlist.singlylinkedlist.studentrecordmanagement;
//class representing student and its attributes
public class Student {
    int rollNumber;
    String name;
    int age ;
    char grade;
    Student next; // pointer to the next student in linked list

    //constructor to initialize student details
    public Student(int rollNumber,String name,int age,char grade){
        this.rollNumber=rollNumber;
        this.name=name;
        this.age=age;
        this.grade = grade;
        this.next=null;
    }
}
