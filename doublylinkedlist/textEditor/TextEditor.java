package linkedlist.doublylinkedlist.textEditor;

public class TextEditor {
    private Text head, tail, current;
    private final int MAX_HISTORY = 10; // Limit to last 10 states
    private int size = 0;

    // Add a new text state (similar to typing or performing an action)
    public void addTextState(String newText) {
        Text newNode = new Text(newText);

        // If history is empty, initialize head & tail
        if (head == null) {
            head = tail = current = newNode;
        } else {
            // Remove forward history (if any) when adding a new state
            current.next = null;
            tail = current;

            // Append new state at the end
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = tail;
        }

        size++;

        // Maintain history size limit
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Added: " + newText);
    }

    // Undo operation (move to previous state)
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Undo not possible.");
            return;
        }
        current = current.prev;
        System.out.println("Undo: " + current.textState);
    }

    // Redo operation (move to next state)
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Redo not possible.");
            return;
        }
        current = current.next;
        System.out.println("Redo: " + current.textState);
    }

    // Display current state of text
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No text history available.");
        } else {
            System.out.println("Current Text: " + current.textState);
        }
    }
}
