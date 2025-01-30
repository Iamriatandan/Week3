package linkedlist.circlarlinkedlist.roundrobinschedulingalgorithm;

import linkedlist.circlarlinkedlist.taskmanagementsystem.Main;

public class RoundRobin {
    private Process head;
    private Process tail;

    //adding process at end
    public void addAtEnd(int processId, int burstTime,int priority){
        Process newProcess = new Process(processId,burstTime,priority);
        if(head == null){
            head = tail = newProcess;
            newProcess.next=head; //CQ
        }
        else{
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; //CQ
        }
    }

    //remove process by process id after execution
    public void removeProcess(int processId){
        if(head == null)return;
        Process temp = head,prev = null;
        do{
            if(temp.processId == processId){
                if(temp == head){
                    head = head.next;
                    tail.next = head;
                }
                else{
                    prev.next = temp.next;
                    if(temp == tail ){
                        tail = prev;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }while(temp!=head);
    }

    //stimulate round robin
    public void roundRobinScheduling(int timeQuantum){
        if(head == null){
            System.out.println("No Process o schedule");
            return;
        }
        int totalTime=0;
        int completedProcess =0;
        int totalProcesses= countProcesses();//get total process count

        int[] waitingTime = new int[totalProcesses+1]; //store waiting time
        int[] turnAroundTime = new int [totalProcesses+1];//store turnaround time

        Process current = head;
        System.out.println("Execution Order");

        // execute processes in round robin manner until all are completed
        while(completedProcess<totalProcesses){
            if(current.remainingTime >0){
                int executionTime = Math.min(timeQuantum, current.remainingTime);
                System.out.println("Process " + current.processId + " executes for " + executionTime + "ms");

                current.remainingTime -= executionTime;
                totalTime+= executionTime;

                if(current.remainingTime==0){
                    completedProcess++;
                    turnAroundTime[current.processId] = totalTime;
                    waitingTime[current.processId]=turnAroundTime[current.processId]- current.burstTime;
                    removeProcess(current.processId);
                }
            }
            current=current.next;
        }
        }
    //calculate and display average waiting and turnround time
    public void displayProcess(){
        if(head == null){
            System.out.println("No process in queue");
            return;
        }
        Process temp = head;
        System.out.println("/n Processes in the circular queue");
        do{
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        }while(temp!=head);
    }
    //count total process
    private int countProcesses(){
        if(head == null) return 0;
        int count =0;
        Process temp = head;
        do{
            count++;
            temp = temp.next;
        }while(temp!= head);
        return count;
    }

    // Display the average waiting time and turnaround time
    public void displayResults(int[] waitingTime, int[] turnaroundTime, int totalProcesses) {
        double avgWT = 0, avgTAT = 0;
        System.out.println("\nProcess Execution Summary:");
        for (int i = 1; i <= totalProcesses; i++) {
            System.out.println("Process " + i + ": Waiting Time = " + waitingTime[i] + "ms, Turnaround Time = " + turnaroundTime[i] + "ms");
            avgWT += waitingTime[i];
            avgTAT += turnaroundTime[i];
        }
        avgWT /= totalProcesses;
        avgTAT /= totalProcesses;
        System.out.println("\nAverage Waiting Time: " + avgWT + "ms");
        System.out.println("Average Turnaround Time: " + avgTAT + "ms");
    }
}
