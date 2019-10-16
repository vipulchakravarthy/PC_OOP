/**
 *
 */

public class OrderedList extends AbstractList {
    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     *
     * The method returns void (nothing)
     */
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        // TODO
        // Your code goes here....
        if (size == 0) {
            list[size] = item;
        } else {

            for (int j = 0; j < size; j++) {
                if (item <= list[j]) {
                    insertAt(item, j);
                    break;
                }
            }
        }
        size++;
        if (size == capacity) {
            resize();
        }
    }

     public void insertAt(final int item, final int index) {

        for (int j = size; j > index; j--) {
            list[j] = list[j - 1];
        }
        list[index] = item;
    }


    public void resize() {
        list = java.util.Arrays.copyOf(list, 2 * capacity);
        capacity = capacity * 2; // I missed this earlier
    }
    public int rank(int item) {
        int lo = 0, hi = size-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (item < list[hi]) hi = mid - 1;
            else if (item > list[lo]) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public int indexOf(final int item) {
        return binarySearch(list, 0, size, item);
    }

    public int binarySearch(final int[] arr, final int l,
                                     final int r, final int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        AbstractList lst = new OrderedList();
        lst.add(1, 1);
    }

}
