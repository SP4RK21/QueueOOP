package queue;

public class ArrayQueue extends AbstractQueue {
    private Object[] elements = new Object[10];
    private int head = 0;

    private void ensureCapacity(int neededCapacity) {
        if (neededCapacity <= elements.length) {
            return;
        }
        Object[] tmp = new Object[2 * size];
        System.arraycopy(elements, head, tmp, 0, elements.length - head);
        System.arraycopy(elements, 0, tmp, elements.length - head, size - elements.length + head);
        elements = tmp;
        head = 0;
    }

    @Override
    protected void enqueueElement(Object element) {
        ensureCapacity(size + 1);
        elements[(head + size) % elements.length] = element;
    }

    @Override
    protected void removeFirst() {
        head = (head + 1) % elements.length;
    }

    @Override
    protected Object getFirst() {
        return elements[head];
    }

    public void clearQueue() {
        elements = new Object[10];
        head = 0;
    }

}
