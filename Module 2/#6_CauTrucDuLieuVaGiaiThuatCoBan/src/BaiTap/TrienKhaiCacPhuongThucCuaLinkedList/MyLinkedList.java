package BaiTap.TrienKhaiCacPhuongThucCuaLinkedList;

import java.util.LinkedList;
public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList(E data) {
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(E data) {
            this.data = data;
    }

        public Object getData() {
            return this.data;
        }
    }

//    public void add(int index, E data){
//
//    }
//
//    public void addFirst(E data){
//
//    }
//
//    public  void addLast(E data){
//
//    }

}
