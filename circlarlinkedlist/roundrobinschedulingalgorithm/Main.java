package linkedlist.circlarlinkedlist.roundrobinschedulingalgorithm;

public class Main {
    public static void main(String[] args) {
        //instance
        RoundRobin procssses =  new RoundRobin();

        //adding process
        procssses.addAtEnd(1,5,6);
        procssses.addAtEnd(2,6,7);
        procssses.addAtEnd(3,7,8);
        procssses.addAtEnd(4,8,9);

        //removing process
        procssses.removeProcess(1);

        //performing round-robin algorithm
        procssses.roundRobinScheduling(2);
        System.out.println();

        //displayong processes
        procssses.displayProcess();
    }
}
