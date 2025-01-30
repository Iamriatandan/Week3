package linkedlist.singlylinkedlist.studentrecordmanagement;
//class representing singly linked list of students
public class StudentList {
    private Student head; //head node of list private

    //adding new student at beginning of the list
    public void addStudentAtBegin(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);//new node for insertion
        newStudent.next = head;//assigning first value to head
        head = newStudent;
    }

    //adding a new student at end of list
    public void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);//new node
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head; //temp variable created and assigned with head
        while (temp.next != null) {//traversing to end of list
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    //adding a new student at a specific position
    public void addStudentAtPosition(int rollNumber, String name, int age, char grade, int position) {
        if (position == 1) {
            addStudentAtBegin(rollNumber, name, age, grade);
            return;
        }
        //creating new node for inserting at any other position
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    //deleting a student record by roll numner
    public void deleteStudent(int roll) {
        if (head == null) return; // if list is empty no nothing
        if (head.rollNumber == roll) {//if head node is to be deleted
            head = head.next;//update head tp next node
            return;
        }
        Student temp = head;//temprorary pointer to traverse the list
        while (temp.next != null && temp.next.rollNumber != roll) {//finding roll one before to delete
            temp = temp.next;
        }
        if (temp.next == null) {//if roll number is not found
            System.out.println("Student not found");
            return;
        }
        temp.next = temp.next.next;//by passing the node to be deleted
    }

    //method to search student by roll no
    public void searchStudent(int roll) {
        Student temp = head;//temprorary pointer to traverse the list
        while (temp != null) { // loop traversing list until pointer goes to null
            if(temp.rollNumber == roll){//if rolll no matches
                System.out.println("Roll number : " + temp.rollNumber);
                System.out.println("Name : " + temp.name);
                System.out.println("Age : " + temp.age);
                System.out.println("Grade : " + temp.grade);
                return;
            }
            temp= temp.next;
        }
        System.out.println("Student not found");
    }
    //method to update a student's grade by roll number
    public void updateGrade(int roll, char newGrade){
        Student temp = head;//temporary pointer to traverse the list
        while(temp!=null){
            if(temp.rollNumber == roll){
                temp.grade = newGrade;
                System.out.println("Grade updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    //method to display all student records
    public void displayStudent(){
        Student temp = head;//temprorary pointer
        while (temp!=null){
            System.out.println("Roll Number : " + temp.rollNumber + " | Name : " + temp.name + " | Age : " + temp.age + " | Grade : " + temp.grade);
            temp = temp.next;// moving pointer to next student node
        }
    }
}