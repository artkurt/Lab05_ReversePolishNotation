public class Stack<T> {
    // Inner class
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;  // oberstes Element im Stack

    public Stack() {
        top = null;
    }

    // Methode zum Hinzufügen eines Elements auf den Stack
    public void push(T item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
    }

    // Methode zum Entfernen und Zurückgeben des obersten Elements
    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack Underflow: Der Stack ist leer!");
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    // Methode zum Zurückgeben des obersten Elements ohne Entfernen
    public T peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack Underflow: Der Stack ist leer!");
        }
        return top.data;
    }

    // Prüfen, ob der Stack leer ist
    public boolean isEmpty() {
        return top == null;
    }
}
