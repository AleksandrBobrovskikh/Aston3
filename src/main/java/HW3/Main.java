package HW3;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(45);
        list.addLast(6767);
        list.addLast(2);
        list.add(1, 99);

        System.out.println(list.size());
        list.print();
        list.quickSort();
        list.print();
        System.out.println();

        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(45);
        list2.add(6767);
        list2.add(2);
        list2.add(1);
        System.out.println(list2.size());
        list2.print();
        list2.mergeSort();
        list2.print();

    }
    }

