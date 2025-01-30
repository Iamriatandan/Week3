package linkedlist.doublylinkedlist.textEditor;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addTextState("Hello");
        editor.addTextState("Hello, World!");
        editor.addTextState("Hello, World! How are you?");
        editor.displayCurrentState();

        editor.undo();
        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addTextState("Hello, Universe!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();
    }
}
