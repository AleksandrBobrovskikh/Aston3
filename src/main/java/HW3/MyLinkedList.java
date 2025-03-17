/**
 * Реализованы методы:
 *  add(T data)
 *  addLast(T data)
 *  addFirst(T data)
 *  add(int index, T data)
 *  removeFirst()
 *  removeLast()
 *  remove(int index)
 *  set(int index, T data)
 *  get(int index)
 *  print()
 *  size()
 *  quickSort()
 *  isEmpty()
 *  clear()
 */

package HW3;

public class MyLinkedList<T extends Comparable<T>> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public void add(T data) {
        addLast(data);
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void add(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(data);
        } else if (index == size - 1) {
            addLast(data);
        } else {
            Node<T> node = head;
            Node<T> newNode = new Node<>(data);
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
            newNode.prev = node;
        }
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (head == null) {
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.data = data;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<T> node = head;
        System.out.print("[");
        while (node != null) {
            System.out.print(node.data + (node.next != null ? ", " : ""));
            node = node.next;
        }
        System.out.println("]");
    }


    public void quickSort() {
        quickSort(head, tail);
    }

    private void quickSort(Node<T> min, Node<T> max) {
        if (min != null && max != null && min != max && min != max.next) {
            Node<T> pivot = partition(min, max);
            quickSort(min, pivot.prev);
            quickSort(pivot.next, max);
        }
    }

    private Node<T> partition(Node<T> min, Node<T> max) {
        T pivotValue = max.data;
        Node<T> i = min.prev;
        for (Node<T> j = min; j != max; j = j.next) {
            if (j.data.compareTo(pivotValue) < 0) {
                i = (i == null) ? min : i.next;
                swapData(i, j);
            }
        }
        i = (i == null) ? min : i.next;
        swapData(i, max);
        return i;
    }

    private void swapData(Node<T> first, Node<T> second) {
        T temp = first.data;
        first.data = second.data;
        second.data = temp;
    }


}
