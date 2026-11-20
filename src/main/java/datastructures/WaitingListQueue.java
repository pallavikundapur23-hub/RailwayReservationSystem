package datastructures;

/** A small array-backed FIFO queue implemented without Java's Queue classes. */
public class WaitingListQueue<T> {
    private Object[] elements;
    private int front;
    private int size;

    public WaitingListQueue() { elements = new Object[8]; }
    public void enqueue(T value) {
        if (value == null) throw new IllegalArgumentException("Queue does not accept null values.");
        if (size == elements.length) grow();
        elements[(front + size) % elements.length] = value; size++;
    }
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) return null;
        T value = (T) elements[front]; elements[front] = null;
        front = (front + 1) % elements.length; size--; return value;
    }
    @SuppressWarnings("unchecked")
    public T peek() { return isEmpty() ? null : (T) elements[front]; }
    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
    private void grow() {
        Object[] larger = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) larger[i] = elements[(front + i) % elements.length];
        elements = larger; front = 0;
    }
}
