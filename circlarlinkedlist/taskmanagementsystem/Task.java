package linkedlist.circlarlinkedlist.taskmanagementsystem;

public class Task {

        //attributes
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Task next;

        public Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

