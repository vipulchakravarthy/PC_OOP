/**
 *
 */

class List extends AbstractList {

    List() {
        super();
    }

    List(final int capacity) {
        super(capacity);
    }

    public void add(final int item) {
        list[this.size] = item;
        this.size++;
        if (this.size == this.capacity) {
            resize();
        }
    }

    public void resize() {
        this.list = java.util.Arrays.copyOf(list, 2 * capacity);
        capacity = capacity * 2; // I missed this earlier
    }

    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
