package Queue;

class QueueEmptyException extends Exception
{
    public QueueEmptyException() {
        super("This queue is empty.");
    }
}

public class Queue<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {return this.data;}
    }

    private Node<T> head;
    private Node<T> tail;

    public Queue() {};

    public boolean isEmpty() {return head == null && tail == null;}

    public boolean enQueue(T data) {
        if (this.isEmpty()) {
            head = tail = new Node(data);
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        return true;
    }

    public T deQueue() throws QueueEmptyException {
        if (this.isEmpty()) {
            throw new QueueEmptyException();
        } else {
            Node<T> toDelete = head;
            T res = toDelete.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            toDelete = null;
            return res;
        }
    }


}
