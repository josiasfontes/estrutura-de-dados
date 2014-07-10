package myqueue;

public class MyQueue<L> {

    private static final int CAPACITY = 10;// Number of standard elements of the queue
    private int capacity;// maximum number of queue
    private L Queue[];// array 
    private int end;// variable end
    private int front = end = -1;// initialized variable start

    public MyQueue() {// default constructor
        end = -1; // // cell position indicates that the stack is empty or null
        Queue = (L[]) new Object[CAPACITY];//array size with standard cell
    }

    public MyQueue(int size) { // Builder, may receive as argument the initial size of the queue
        this.Queue = ((L[]) new Object[size]);
        end = 0;
    }

    public boolean isEmpty() {// tests this queue is empty
        if (end == -1) {//returns true if empty
            return true;
        }
        return false;//returns false if not
    }

    public boolean isFull() {// tests if the queue is full
        if (Queue.length == CAPACITY) {
            if (Queue[CAPACITY] != null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (Queue[Queue.length - 1] == null) {
                return false;
            } else {
                return true;
            }
        }
    }

    public int size() {// returns queue size
        return Queue.length;

    }

    public int front() {// returns index of the first element

        return this.front;
    }

    public int back() {// returns index of the last element

        return this.end - 1;

    }

    public void enqueue(L valor) {// method inserts element at the end of the queue
        this.Queue[end++] = valor; // inserting member at the end of the queue  
    }

    public Object dequeue() {// method removes the element of the queue
        Object value = Queue[front];//
        front++; 
        return value;// 
    }

    public void clear() {// deletes the whole row
        for (int i = 0; i < Queue.length; i++) {
            Queue[i] = null;
            capacity--;
        }
    }

    public void print() {// print queue
        System.out.println("\n");
        for (int i = 0; i < Queue.length; i++) {
            System.out.println("[" + i + "]" + Queue[i]);
        }
    }
}
