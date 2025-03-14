/**
 * Реализованы методы:
 * add(Object o)
 * add(int index, Object o)
 * get(int index)
 * set(int index, Object o)
 * print()
 * remove(int index)
 * remove(Object o)
 * size()
 * capacity()
 * contains(Object o)
 * isEmpty()
 * clear()
 * mergeSort()
 */

package HW3;

public class MyArrayList<T extends Comparable<T>> {
    private int size;
    private int capacity;
    private Object[] elements;

    public MyArrayList() {
        this.size = 0;
        this.capacity = 10;
        this.elements = new Object[this.capacity];
    }

    public MyArrayList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.elements = new Object[this.capacity];
    }

    public void add(Object o) {
        extension(elements);
        elements[size] = o;
        size++;
    }

    public void add(int index, Object o) {
        extension(elements);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = o;
        size++;
    }

    public T get(int index) {
        return (T) elements[index];
    }

    public T set(int index, T o) {
        if (index < size && index >= 0) {
            T t = (T) elements[index];
            elements[index] = o;
            return t;
        }
        return null;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(elements[i]);
                break;
            }
            System.out.print(elements[i] + ", ");
        }
        System.out.println("]");
    }

    public void extension(Object[] objects) {
        if (size == capacity) {
            capacity = (capacity * 3) / 2 + 1;
            Object[] newElements = new Object[capacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public T remove(int index) {
        if (index < size && index >= 0) {
            T o = (T) elements[index];
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
            elements[--size] = null;
            return o;
        }
        return null;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public int length() {
        return size;
    }

    public void mergeSort() {
        Object[] temp = new Object[size];

        for (int width = 1; width < size; width *= 2) {
            for (int left = 0; left < size - width; left += 2 * width) {
                int mid = left + width - 1;
                int right = Math.min(left + 2 * width - 1, size - 1);
                merge(left, mid, right, temp);
            }
        }
    }

    private void merge(int left, int mid, int right, Object[] temp) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right)
            temp[k++] = ((T) elements[i]).compareTo((T) elements[j]) < 0 ? elements[i++] : elements[j++];

        while (i <= mid) temp[k++] = elements[i++];
        while (j <= right) temp[k++] = elements[j++];

        System.arraycopy(temp, left, elements, left, right - left + 1);
    }


}