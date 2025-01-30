package linkedlist.circlarlinkedlist.roundrobinschedulingalgorithm;

public class Process {
    int processId;
    int burstTime;//until process goes on
    int priority;
    int remainingTime;
    Process next;
    //constructor

    public Process(int processId, int burstTime, int priority){
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;//initially remaining time = burst time
        this.next = null;
    }
}
