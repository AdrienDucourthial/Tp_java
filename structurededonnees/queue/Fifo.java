package structurededonnees.queue;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Optional;

public class Fifo {
    private Object[] file;
    private int size, head, tail;

    public Fifo(Integer size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Negative size not allowed.");
        }
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.file = new Object[size];
    }

    public void offer(Object o) {
        if (o.equals(null)) {
            System.out.println("Object null.");
        } else {
            if ((tail - head) >= 0 && (tail - head) < size) {
                this.file[tail % size] = o;
                tail++;
            } else {
                throw new IllegalStateException("The list is full.");
            }
        }
    }

    public Object poll() {
        if (head < tail) {
            Object output = this.file[head % size];
            this.file[head % size] = null;
            head++;
            return output;
        } else {
            throw new IllegalStateException("The list is empty.");
        }
    }

    public int size() {
        return (tail-head);
    }

    public Boolean isEmpty() {
        if (head == tail) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String output = "[";
        for (int i = head ; i < tail ; i++) {
            output += file[i%size];
            if (i+1 < tail) {
                output += ", ";
            }
        }
        return output + "]";
    }
}
