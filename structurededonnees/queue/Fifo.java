package structurededonnees.queue;

import java.util.ArrayDeque;
import java.util.Objects;

public class Fifo {
    private ArrayDeque<Objects> file;
    private Integer size, head, tail;

    public Fifo(Integer size) {
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.file = new ArrayDeque<Objects>(size);
    }

    public void offer() {

    }

    public void poll() {

    }
}
