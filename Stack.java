class StackEmptyException extends Exception {
    public StackEmptyException() {
        super("The stack is empty.");
    }
}

public class Stack<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {return this.data;}
    }

    private Node<T> head;

    public Stack(){};

    public boolean isEmpty() {
        return head == null;
    }

    public boolean push(T data) {
        head = new Node(data, head);
        return true;
    }

    public T top() throws StackEmptyException {
        if (this.isEmpty()) throw new StackEmptyException();
        return head.getData();
    }

    public T pop() throws StackEmptyException {
        if (this.isEmpty()) throw new StackEmptyException();
        Node<T> toDelete = head;
        head = head.next;
        T res = toDelete.data;
        toDelete = null;
        return res;
    }
}

