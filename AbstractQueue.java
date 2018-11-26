package queue;

public abstract class AbstractQueue implements Queue {
    protected int size = 0;

    protected abstract void enqueueElement(Object element);

    protected abstract void removeFirst();

    protected abstract Object getFirst();

    protected abstract void clearQueue();

    public void enqueue(Object element) {
        assert element != null;

        enqueueElement(element);
        size++;
    }

    public Object dequeue() {
        Object value = element();
        removeFirst();
        size--;
        return value;
    }

    public Object[] toArray() {
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = dequeue();
            enqueue(temp[i]);
        }
        return temp;
    }

    public Object element() {
        assert size > 0;

        return getFirst();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        clearQueue();
    }
}
