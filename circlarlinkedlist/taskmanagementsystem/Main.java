package linkedlist.circlarlinkedlist.taskmanagementsystem;

public class Main {
    public static void main(String[] args) {
        TaskManagement tasks = new TaskManagement();

        //adding tasks
        tasks.addAtBegin(123,"Addition",3,"3/01/25");
        tasks.addAtEnd(124,"Subtraction",4,"5/01/25");
        tasks.addAtBegin(121,"Multiplication",5,"6/01/25");

        //remove task
        tasks.removeTaskById(123);

        //viewing current task
        tasks.viewCurrentTask();

        // displaying all tasks
        System.out.println();
        tasks.displayTasks();

        //searching task by priority
        tasks.searchByPriority(4);

    }
}
