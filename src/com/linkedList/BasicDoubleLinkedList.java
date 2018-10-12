/**
 * This generic doubly-linked list relies on a head (reference to first element of the list) and tail
 * (reference to the last element of the list).
 * @author Desire Mpondo
 * Fall 2017 CMSC204
 */
package com.linkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {

    protected Node head;
    protected Node tail;
    protected static int  size;

    protected Iterator i;

    /**
     *
     */
    public BasicDoubleLinkedList() {
        super();
        this.head = this.tail = null;
        size = 0;
        i = new Iterator();
    }

    /**
     * @param head ref to the first element
     * @param tail ref to the last elemet
     *
     */
    public BasicDoubleLinkedList(Node head, Node tail) {
        super();
        this.head = head;
        this.tail = tail;
        i = new Iterator();
    }

    public int getSize() {
        return size;
    }

    /** Tells if the list is empty
     * @return Return true when the list is empty and false otherwise
     */
    public boolean isEmpty()
    {
        return size==0;
    }

    /**Adds element to the front of the list. Do not use iterators to implement this method.
     * @param data the data for the Node within the linked list
     * @return reference to the current object
     *
     */
    public T addToFront(T data){

        Node newNode = new Node(null, head, data);
        if(isEmpty())
        {
            head = tail = newNode;
            tail.next = null;
        }
        else
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        return head.data;
    }


    /**Adds an element to the end of the list. Do not use iterators to implement this method.
     * @param data the data for the Node within the linked list
     * @return reference to the current object
     */
    public T addToEnd(T data) {
        Node temp = new Node(tail, null, data);
        if(isEmpty())
        {
            head  = tail= temp;

        }
        if(tail!=null)
        {
            tail.next = temp;
        }
        tail = temp;
        size++;
        return tail.data;
    }

    /**
     * @return
     */
    public ListIterator<T> iterator() throws java.lang.UnsupportedOperationException, java.util.NoSuchElementException
    {
        return new Iterator();
    }


    /**Removes the first instance of the targetData from the list.
     * @param targetData - the data element to be removed
     * @param comparator
     * @throws NoSuchElementException
     */
    public T remove(T targetData, Comparator<T> comparator) throws NoSuchElementException {
        // TODO Auto-generated method stub
        boolean found = false;
        T element = null;

        if(isEmpty())
        {
            throw new NoSuchElementException("The target element was not found in the List, List is Empty");
        }
        else if(comparator.compare(targetData, head.data)==0)//the first node is the good one
        {
            element = head.data;
            head = head.next;
            head.prev = null;
            size--;

        }
        else if(comparator.compare(targetData, tail.data)==0)//the last element is the good one
        {
            element = tail.data;
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        else
        {
            Node p = head;
            Node  q = head;
            while((q!=null) || found==false)
            {
                p = q;
                q = q.next;
                if(comparator.compare(p.data, targetData)==0)
                {
                    found  = true;
                }
            }
            if(found == true)
            {
                element = p.data;
                p.next = q;
                size--;
            }

        }
        return element;
    }

    /**Removes and returns the first element from the list. If there are no elements the method returns null.
     * @return data element or null
     */
    public T retrieveFirstElement() {
        Node element = new Node();
        if(!isEmpty())
        {
            element.data = head.data;
            head = head.next;
        }
        size --;
        return element.data;
    }

    /**Removes and returns the last element from the list. If there are no elements the method returns null.
     * @return data element or null
     */
    public T retrieveLastElement() {
        Node element = new Node();
        if(!isEmpty())
        {
            element.data = tail.data;
            tail = tail.prev;
            //tail.next = null;
        }
        size--;
        return element.data;
    }

    /** Returns an arraylist of the items in the list from head of list to tail of list
     * @return an arraylist of the items in the list
     */
    public ArrayList<T> toArrayList()
    {
        //Traversing the list from head to tail
        ArrayList<T> list = new ArrayList<>();
        if(isEmpty())
        {
            list = null;
        }
        else
        {
            Node node = head;
            for (int i = 0; i < size; i++) {
                list.add(node.data);
                node = node.next;
            }
        }
        return list;
    }

    /**Returns but does not remove the first element from the list. If there are no elements the method returns null.
     * @return the data element or null
     */
    public T getFirst()
    {
        if(isEmpty())//the list is empty
        {
            return null;
        }
        else
        {
            return head.data;
        }
    }

    /**Returns but does not remove the last element from the list. If there are no elements the method returns null.
     * @return the data element or null
     */
    public T getLast()
    {
        if(head.next == null)//the list is empty
        {
            return null;
        }
        else
        {
            return tail.data;
        }
    }

    /**
     * Inner class Node, defines a data element of the data structure
     * @author Desire Mpondo
     *
     */
    protected class Node {

        public Node prev;
        public Node next;
        public T data;

        //Constructor
        public Node()
        {
            prev = next = null;
            data = null;
        }

        /**
         * @param prev previous element's reference
         * @param next next element's reference
         * @param data data element
         */
        public Node(Node prev, Node next, T data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    /**
     * Inner class Iterator implements ListIterator,
     *
     */
    protected class  Iterator implements ListIterator<T>
    {
        private int cursor;
        private Node current;

        /**Constructor of iterator, Set the IP variable to a dummy node.
         *
         */
        public Iterator()
        {
            current = head;
            cursor = 0;
        }


        @Override
        public void add(T e) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasPrevious() {
            return current !=head;
        }

        @Override
        public boolean hasNext() {
            return current !=null;
        }

        @Override
        public T next() {
            if(current ==null)
            {
                throw new NoSuchElementException();
            }
            T temp = current.data;
            current = current.next;
            return temp;
        }

        @Override
        public T previous() {
            if(current==head)
            {
                throw new NoSuchElementException();
            }
            else if(!hasNext()) {
                current = tail;
                T temp = tail.data;
                return temp;
            }
            else{
                T temp = current.prev.data;
                current = current.prev;
                return temp;
            }

			/*if(hasPrevious())
			{
				Node old = current.prev;
				current = current.prev;
				cursor--;
				return old.data;
			}
			else
			{
				throw new NoSuchElementException();
			}*/

        }

        @Override
        public int nextIndex() throws UnsupportedOperationException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void remove() throws UnsupportedOperationException{
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T e) {
            // TODO Auto-generated method stub

        }

        public Node getCurrent()
        {
            return current;
        }

        public int getCursor()
        {
            return cursor;
        }
    }
}
