package linkedlist.singlylinkedlist.studentrecordmanagement;
//main class to check student management system
public class StudentManagement {
    public static void main(String[] args) {
        //creating object of student list class
        StudentList list = new StudentList();

        //adding records
        list.addStudentAtBegin(138,"Ria",23, 'A');
        list.addStudentAtEnd(209,"Yash",22,'A');
        list.addStudentAtPosition(139,"Rimjhim",22,'A',2);
        list.addStudentAtPosition(140,"Risabh",22,'B',3);

        //Display all students
        list.displayStudent();

        //searching for a student
        System.out.println("\n Searching for roll number 209");
        list.searchStudent(209);

        //updating student's grade
        System.out.println("\n Update grade for roll number 139");
        list.updateGrade(139,'B');

        //Deleting student record
        System.out.println("\n Deleting record for 140");
        list.deleteStudent(140);

        //displaying updated student records
        System.out.println("\n Displaying updated student records" );
        list.displayStudent();
    }
}
