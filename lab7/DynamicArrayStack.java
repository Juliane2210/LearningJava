import java.util.EmptyStackException;
public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems; // Used to store the elements of this ArrayStack
    private int top; // Designates the first free cell
    private static final int DEFAULT_INC = 25; // Used to store default increment / decrement

    @SuppressWarnings("unchecked")
    // Constructor
    public DynamicArrayStack(int capacity) {
        elems = (E[]) new Object[capacity];
        this.top = 0;// because array isEmpty()
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return (top == 0);
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() throws EmptyStackException {
        if(this.isEmpty()){
            throw new EmptyStackException();
        }

        return elems[top - 1];
    }

    // Removes and returns the top element of this stack
    public E pop() throws EmptyStackException {
        if(this.isEmpty()){
            throw new EmptyStackException();
        }

        top -= 1;

        this.resizeElems();

        E saved = elems[top];
        elems[top] = null; // scrub the memory!

        return saved;
    }

    // Makes array smaller or bigger and keeps track of minimal size:
    @SuppressWarnings("unchecked")

    public void resizeElems() {

        int growFactor = top / DEFAULT_INC;
        int newArraySize = (growFactor + 1) * DEFAULT_INC;

        // E[] oldElems = elems;

        E[] newElems = (E[]) new Object[newArraySize];

        // Move all the old elements over to the newly created array.
        for (int i = 0; i < elems.length; i++) {
            newElems[i] = elems[i];
        }
        elems = newElems;

    }

    // Puts the element onto the top of this stack.
    public void push(E element) {
        elems[top] = element;
        top += 1;
        this.resizeElems();

    }

    public void clear() {
        while (!this.isEmpty()) {
            this.pop();
            this.resizeElems();

        } // Your code here.
    }

}
