package linkedlist.circlarlinkedlist.taskmanagementsystem;

public class TaskManagement {
    private Task head =null;
    private Task tail=null;
    private Task current=null;// pointer to track current task

   //adding tasks
   //adding task at begining
   public void addAtBegin(int taskId,String taskName,int priority,String dueDate){
       Task newTask = new Task(taskId, taskName, priority, dueDate);
       if(head == null){
           head = tail = newTask;
           newTask.next = head;//circular linked list
       }
       else{
           newTask.next = head;//pointing new task to current head
           head = newTask;
           tail.next = head;
       }
   }

   //adding task at end
    public void addAtEnd(int taskId,String taskName,int priority,String dueDate){
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if(head == null){
            head = tail = newTask;
            newTask.next = head;//circular linked list
        }
        else{
            tail.next = newTask;
            tail = newTask;//move tail to new task
            tail.next = head;//Maintain circular structure
        }
    }

    //remove a task by id
    public void removeTaskById(int taskId){
        if(head == null)return;
        Task temp = head , prev = null;
        do{
            if(temp.taskId == taskId){
                if(temp == head){
                    head = head.next;
                    tail.next = head;
                }
                else{
                    prev.next = temp.next;//bypass removed task
                    if(temp == tail ){
                        tail = prev;//updating tail
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }while(temp!=head);
    }

    //to view current task
    public void viewCurrentTask(){
       if(current == null){
           current = head;
       }
        System.out.println("Current Task : " + current.taskName + "(Priority : " + current.priority + ")");
    }

    //move to next Task
    public void moveToNextTask(){
        if(current == null){
            current = head;
        }
        else{
            current=current.next;
        }
        viewCurrentTask();
    }

    //display all tasks
    public void displayTasks(){
       if(head == null)return;
       Task temp = head;
       do{
           System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
           temp = temp.next;
       }while(temp!=head);//loop until returns to head
    }

    //search for a task by priority
    public void searchByPriority(int priority){
       if(head == null)return;
       Task temp = head;
       do{
           if(temp.priority == priority){
               System.out.println("Task Found: " + temp.taskName + " (ID: " + temp.taskId + ")");
           }
           temp = temp.next;
       }while(temp!= head);
    }

}
