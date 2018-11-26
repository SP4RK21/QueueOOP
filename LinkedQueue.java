package queue;

public class LinkedQueue extends AbstractQueue {
    private Node head = null;
    private Node tail = null;

    @Override
    protected void enqueueElement(Object element) {
        Node el = new Node(element, null);
        if (size == 0) {
            head = el;
        } else {
            tail.next = el;
        }
        tail = el;
    }

    @Override
    protected void removeFirst() {
        head = head.next;
    }

    @Override
    protected Object getFirst() {
        return head.value;
    }

    @Override
    protected void clearQueue() {
        head = null;
        tail = null;
    }

    private class Node {
        private Object value;
        private Node next;

        private Node(Object val, Node nxt) {
            assert val != null;

            value = val;
            next = nxt;
        }
    }
}
