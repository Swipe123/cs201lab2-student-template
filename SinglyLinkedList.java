import java.util.*;

public class SinglyLinkedList<E extends Comparable<E>> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;
    
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
    
        public E getElement(){
            return element;
        }
    
        public Node<E> getNext(){
            return next;
        }
    
        public void setNext(Node<E> n){
            next = n;
        }
    }

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    // write your codes here
    @SuppressWarnings("unchecked")
    public void swap(){
        if (size < 2) {
            return;                              
        }

        Node<E>[] nodes = (Node<E>[]) new Node[size];
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            nodes[i] = current;
            current = current.getNext();
        }

        Integer[] idx = new Integer[size];
        for (int i = 0; i < size; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> nodes[a].getElement().compareTo(nodes[b].getElement()));

        Node<E>[] result = (Node<E>[]) new Node[size];
        for (int r = 0; r < size; r++) {
            result[idx[r]] = nodes[idx[size - 1 - r]];
        }

        for (int i = 0; i < size - 1; i++) {
            result[i].setNext(result[i + 1]);
        }
        head = result[0];
        tail = result[size - 1];
        tail.setNext(null);                      
    }
   
}

