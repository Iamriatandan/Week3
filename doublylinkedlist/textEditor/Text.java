package linkedlist.doublylinkedlist.textEditor;

public class Text {
    String textState;
    Text prev, next;

    public Text(String textState) {
        this.textState = textState;
        this.prev = this.next = null;
    }
}
