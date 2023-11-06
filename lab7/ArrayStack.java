import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {

    private E[] elems; // Used to store the elements of this ArrayStack
    private int top; // Designates the first free cell
    private int capacity; // Designates the capacity of the Array

    @SuppressWarnings("unchecked")

    // Constructor

    public ArrayStack(int capacity) {
        elems = (E[]) new Object[capacity];
        top = 0;// pointer at first empty index
        this.capacity = capacity;
    }

    // Returns true if this ArrayStack is empty

    public boolean isEmpty() {

        // Same as:
        // if ( top == 0 ) {
        // return true;
        // } else {
        // return false;
        // }

        return (top == 0);
    }

    // Returns the top element of this ArrayStack without removing it

    public E peek() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        // pre-conditions: ! isEmpty()

        return elems[top - 1];
    }

    // Removes and returns the top element of this stack

    public E pop() throws EmptyStackException {

        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        // pre-conditions: ! isEmpty()

        // *first* decrements top, then access the value!
        top -= 1;
        E saved = elems[top];
        elems[top] = null; // scrub the memory!

        return saved;
    }

    // Puts the element onto the top of this stack.

    public void push(E element) throws FullStackException {
        if (top == this.getCapacity()) {
            throw new FullStackException();
        }

        // Pre-condition: the stack is not full
        // *first* stores the element at position top, then increments top

        elems[top] = element;
        top += 1;
    }

    // Gets current capacity of the array (for testing purpose)
    public int getCapacity() {
        return elems.length;
    }

    public void clear() {

        // another way:
        // for (int i = top; i < capacity; i++) {
        // elems[i] = null; // scrub the memory!
        // }

        // top = 0;

        while (!this.isEmpty()) {
            this.pop();
        }

    }

}
