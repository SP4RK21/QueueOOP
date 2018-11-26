package queue;

//inv: 0 <= size && ∀i=1..size: queue[i] != null && elements are removed in the order they are received
public interface Queue {
    // Pre: element ≠ null
    // Post: head' = head && size' = size + 1 && ∀i=1...size: queue[i]' = queue[i] && queue[size + 1] = element
    void enqueue(Object element);

    // Pre: size > 0
    // Post: R = first element in queue && queue – immutable
    Object element();

    // Pre: size > 0
    // Post: R = first element in queue && size' = size - 1 && head' = head->next &&  queue - immutable
    Object dequeue();

    // Pre: true
    // Post: R = size && immutable
    int size();

    // Pre: true
    // Post: R = (size == 0) && immutable
    boolean isEmpty();

    // Pre: true
    // Post: immutable && R = array with queue elements in right order
    Object[] toArray();

    // Pre: true
    // Post: new empty queue
    void clear();


}
