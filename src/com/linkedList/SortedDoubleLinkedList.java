package com.linkedList;
import java.util.Comparator;
import java.util.ListIterator;

/**Implements a generic sorted double list using a provided Comparator. It extends BasicDoubleLinkedList class.
 * @author desire Mpondo
 *
 * @param <T> type parameter
 */

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{

    Comparator<T> comparator;

    /**Constructor, Creates an empty list that is associated with the specified comparator.
     * @param comparator
     */
    SortedDoubleLinkedList(java.util.Comparator<T> comparator)
    {
        this.comparator = comparator;
    }

    /**Inserts the specified element at the correct position in the sorted list.
     * @param data - the data to be added to the list
     * @return a reference to the current object
     */

    public T add(T data)
    {
        Node newNode = new Node(null, null, data);
        Node p, q;
        boolean insert = false;
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else if (comparator.compare(data, head.data) <=0)
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else
        {
            p = head;
            q = head.next;
            while(q != null)
            {
                if(comparator.compare(data,p.data)>=0 && comparator.compare(data,q.data)<=0)
                {
                    p.next = (newNode);
                    newNode.prev = (p);
                    newNode.next = (q);
                    q.prev = (newNode);
                    insert = true;
                    break;
                }
                else
                {
                    p = q;
                    q = q.next;
                }

            }
            if(!insert)
            {
                p.next = (newNode);
                newNode.prev = (p);
                tail = newNode;

            }else
            {
                tail = q;
            }
        }
        size++;
        return newNode.data;
    }

    /**This operation is invalid for a sorted list.
     * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
     *
     */
    @Override
    public T addToFront(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
    }


    /**This operation is invalid for a sorted list.
     *  An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
     *
     */
    @Override
    public T addToEnd(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list.");
    }


    /* (non-Javadoc)
     * @see BasicDoubleLinkedList#iterator()
     */
    public ListIterator<T> iterator() {
        return (super.iterator());
    }

    /* (non-Javadoc)
     * @see BasicDoubleLinkedList#remove(java.lang.Object, java.util.Comparator)
     */
    public T remove(T data, Comparator<T> comparator) {
        return super.remove(data, comparator);
    }

}