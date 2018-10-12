package com.linkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class SortedDoubleLinkedListTest {
    SortedDoubleLinkedList<String> sortedLinkedString;
    StringComparator comparator;
    DoubleComparator comparatorD;
    SortedDoubleLinkedList<Double> sortedLinkedDouble;


    @Before
    public void setUp() throws Exception {
        comparator = new StringComparator();
        sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);

        //STUDENT - use the SortedDoubleLinkedList<Double> for your STUDENT tests
        comparatorD = new DoubleComparator();
        sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
    }

    @After
    public void tearDown() throws Exception {
        comparator = null;
        sortedLinkedString = null;
    }

    @Test
    public void testAddToEnd() {
        try {
            sortedLinkedString.addToEnd("Hello");
            assertTrue("Did not throw an UnsupportedOperationException", false);
        }
        catch (UnsupportedOperationException e)
        {
            assertTrue("Successfully threw an UnsupportedOperationException", true);
        }
        catch (Exception e)
        {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }
    }

    @Test
    public void testAddToFront() {
        try {
            sortedLinkedString.addToFront("Hello");
            assertTrue("Did not throw an UnsupportedOperationException", false);
        }
        catch (UnsupportedOperationException e)
        {
            assertTrue("Successfully threw an UnsupportedOperationException", true);
        }
        catch (Exception e)
        {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }
    }

    @Test
    public void testIteratorSuccessfulStringNext() {
        sortedLinkedString.add("Hello");
        sortedLinkedString.add("World");
        sortedLinkedString.add("Begin");
        sortedLinkedString.add("Zebra");
        ListIterator<String> iterator = sortedLinkedString.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("Begin", iterator.next());
        assertEquals("Hello", iterator.next());
        assertEquals("World", iterator.next());
        assertEquals(true, iterator.hasNext());
    }

    @Test
    public void testIteratorSuccessfulStringPrevious() {
        sortedLinkedString.add("Hello");
        sortedLinkedString.add("World");
        sortedLinkedString.add("Begin");
        sortedLinkedString.add("Zebra");
        ListIterator<String> iterator = sortedLinkedString.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("Begin", iterator.next());
        assertEquals("Hello", iterator.next());
        assertEquals("World", iterator.next());
        assertEquals("Zebra", iterator.next());
        assertEquals(true, iterator.hasPrevious());
        assertEquals("Zebra", iterator.previous());
        assertEquals("World", iterator.previous());
        assertEquals("Hello", iterator.previous());
    }

    @Test
    public void testIteratorSuccessfulDoubleNext() {
        sortedLinkedDouble.add(15.0);
        sortedLinkedDouble.add(100.0);
        sortedLinkedDouble.add(0.0);
        sortedLinkedDouble.add(1000.0);
        ListIterator<Double> iterator = sortedLinkedDouble.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("0.0", iterator.next().toString());
        assertEquals("15.0", iterator.next().toString());
        assertEquals("100.0", iterator.next().toString());
        assertEquals(true, iterator.hasNext());
    }

    @Test
    public void testIteratorSuccessfulDoublePrevious() {
        sortedLinkedDouble.add(15.0);
        sortedLinkedDouble.add(100.0);
        sortedLinkedDouble.add(0.0);
        sortedLinkedDouble.add(1000.0);
        ListIterator<Double> iterator = sortedLinkedDouble.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("0.0", iterator.next().toString());
        assertEquals("15.0", iterator.next().toString());
        assertEquals("100.0", iterator.next().toString());
        assertEquals("1000.0", iterator.next().toString());
        assertEquals(true, iterator.hasPrevious());
        assertEquals("1000.0", iterator.previous().toString());
        assertEquals("100.0", iterator.previous().toString());
        assertEquals("15.0", iterator.previous().toString());
    }

    @Test
    public void testIteratorNoSuchElementExceptionString() {
        sortedLinkedString.add("Hello");
        sortedLinkedString.add("World");
        sortedLinkedString.add("Begin");
        sortedLinkedString.add("Zebra");
        ListIterator<String> iterator = sortedLinkedString.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("Begin", iterator.next());
        assertEquals("Hello", iterator.next());
        assertEquals("World", iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals("Zebra", iterator.next());
        try{
            //no more elements in list
            iterator.next();
            assertTrue("Did not throw a NoSuchElementException",false);
        }
        catch (NoSuchElementException e)
        {
            assertTrue("Successfully threw a NoSuchElementException",true);
        }
        catch (Exception e)
        {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }
    }

    @Test
    public void testIteratorNoSuchElementExceptionDouble() {
        sortedLinkedDouble.add(15.0);
        sortedLinkedDouble.add(100.0);
        sortedLinkedDouble.add(0.0);
        sortedLinkedDouble.add(1000.0);
        ListIterator<Double> iterator = sortedLinkedDouble.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("0.0", iterator.next().toString());
        assertEquals("15.0", iterator.next().toString());
        assertEquals("100.0", iterator.next().toString());
        assertEquals("1000.0", iterator.next().toString());
        assertEquals(true, iterator.hasPrevious());
        assertEquals("1000.0", iterator.previous().toString());
        assertEquals("100.0", iterator.previous().toString());
        assertEquals("15.0", iterator.previous().toString());
        try{
            //no more elements in list
            iterator.previous();
            iterator.previous();
            assertTrue("Did not throw a NoSuchElementException",false);
        }
        catch (NoSuchElementException e)
        {
            assertTrue("Successfully threw a NoSuchElementException",true);
        }
        catch (Exception e)
        {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }
    }

    @Test
    public void testIteratorUnsupportedOperationExceptionString() {
        sortedLinkedString.add("Hello");
        sortedLinkedString.add("World");
        sortedLinkedString.add("Begin");
        sortedLinkedString.add("Zebra");
        ListIterator<String> iterator = sortedLinkedString.iterator();
        try{
            //remove is not supported for the iterator
            iterator.remove();
            assertTrue("Did not throw a UnsupportedOperationException",false);
        }
        catch (UnsupportedOperationException e)
        {
            assertTrue("Successfully threw a UnsupportedOperationException",true);
        }
        catch (Exception e)
        {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }
    }

    @Test
    public void testIteratorUnsupportedOperationExceptionDouble() {
        sortedLinkedDouble.add(15.0);
        sortedLinkedDouble.add(100.0);
        sortedLinkedDouble.add(0.0);
        sortedLinkedDouble.add(1000.0);
        ListIterator<Double> iterator = sortedLinkedDouble.iterator();
        try{
            //remove is not supported for the iterator
            iterator.remove();
            assertTrue("Did not throw a UnsupportedOperationException",false);
        }
        catch (UnsupportedOperationException e)
        {
            assertTrue("Successfully threw a UnsupportedOperationException",true);
        }
        catch (Exception e)
        {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }
    }

    @Test
    public void testAddString() {
        sortedLinkedString.add("Banana");
        sortedLinkedString.add("Elephant");
        sortedLinkedString.add("Apple");
        assertEquals("Apple", sortedLinkedString.getFirst());
        assertEquals("Elephant", sortedLinkedString.getLast());
        sortedLinkedString.add("Cat");
        sortedLinkedString.add("Dog");
        assertEquals("Apple", sortedLinkedString.getFirst());
        assertEquals("Elephant", sortedLinkedString.getLast());
        //deletes Elephant from linked list
        assertEquals("Elephant",sortedLinkedString.retrieveLastElement());
        assertEquals("Dog", sortedLinkedString.getLast());
    }

    @Test
    public void testAddDouble() {
        //fail("Not yet implemented");
        sortedLinkedDouble.add(15.5);
        sortedLinkedDouble.add(100.0);
        sortedLinkedDouble.add(0.0);
        assertEquals("0.0", sortedLinkedDouble.getFirst().toString());
        assertEquals("100.0", sortedLinkedDouble.getLast().toString());
        sortedLinkedDouble.add(20.5);
        sortedLinkedDouble.add(35.8);
        assertEquals("0.0", sortedLinkedDouble.getFirst().toString());
        assertEquals("100.0", sortedLinkedDouble.getLast().toString());
        //deletes Elephant from linked list
        assertEquals("100.0",sortedLinkedDouble.retrieveLastElement().toString());
        assertEquals("35.8", sortedLinkedDouble.getLast().toString());
    }

    @Test
    public void testRemoveFirstString() {
        sortedLinkedString.add("Hello");
        sortedLinkedString.add("World");
        assertEquals("Hello", sortedLinkedString.getFirst());
        assertEquals("World", sortedLinkedString.getLast());
        sortedLinkedString.add("Begin");
        assertEquals("Begin", sortedLinkedString.getFirst());
        // remove the first
        sortedLinkedString.remove("Begin", comparator);
        assertEquals("Hello", sortedLinkedString.getFirst());
    }

    @Test
    public void testRemoveFirstDouble() {
        sortedLinkedDouble.add(15.5);
        sortedLinkedDouble.add(100.0);
        assertEquals("15.5", sortedLinkedDouble.getFirst().toString());
        assertEquals("100.0", sortedLinkedDouble.getLast().toString());
        sortedLinkedDouble.add(0.0);
        assertEquals("0.0", sortedLinkedDouble.getFirst().toString());
        // remove the first
        sortedLinkedDouble.remove(0.0, comparatorD);
        assertEquals("15.5", sortedLinkedDouble.getFirst().toString());
    }

    @Test
    public void testRemoveEndString() {
        sortedLinkedString.add("Hello");
        sortedLinkedString.add("World");
        assertEquals("Hello", sortedLinkedString.getFirst());
        assertEquals("World", sortedLinkedString.getLast());
        sortedLinkedString.add("Zebra");
        assertEquals("Zebra", sortedLinkedString.getLast());
        //remove from the end of the list
        sortedLinkedString.remove("Zebra", comparator);
        assertEquals("World", sortedLinkedString.getLast());
    }

    @Test
    public void testRemoveEndDouble() {
        sortedLinkedDouble.add(15.5);
        sortedLinkedDouble.add(100.0);
        assertEquals("15.5", sortedLinkedDouble.getFirst().toString());
        assertEquals("100.0", sortedLinkedDouble.getLast().toString());
        sortedLinkedDouble.add(200.56);
        assertEquals("200.56", sortedLinkedDouble.getLast().toString());
        //remove from the end of the list
        sortedLinkedDouble.remove(200.56, comparatorD);
        assertEquals("100.0", sortedLinkedDouble.getLast().toString());
    }

    @Test
    public void testRemoveMiddleString() {
        sortedLinkedString.add("Hello");
        sortedLinkedString.add("World");
        assertEquals("Hello", sortedLinkedString.getFirst());
        assertEquals("World", sortedLinkedString.getLast());
        sortedLinkedString.add("Begin");
        assertEquals("Begin", sortedLinkedString.getFirst());
        assertEquals("World", sortedLinkedString.getLast());
        assertEquals(3,sortedLinkedString.getSize());
        //remove from middle of list
        sortedLinkedString.remove("Hello", comparator);
        assertEquals("Begin", sortedLinkedString.getFirst());
        assertEquals("World", sortedLinkedString.getLast());
        assertEquals(2,sortedLinkedString.getSize());
    }

    @Test
    public void testRemoveMiddleDouble() {
        sortedLinkedDouble.add(15.5);
        sortedLinkedDouble.add(100.0);
        assertEquals("15.5", sortedLinkedDouble.getFirst().toString());
        assertEquals("100.0", sortedLinkedDouble.getLast().toString());
        sortedLinkedDouble.add(0.0);
        assertEquals("0.0", sortedLinkedDouble.getFirst().toString());
        assertEquals("100.0", sortedLinkedDouble.getLast().toString());
        assertEquals(3,sortedLinkedDouble.getSize());
        //remove from middle of list
        sortedLinkedDouble.remove(15.5, comparatorD);
        assertEquals("0.0", sortedLinkedDouble.getFirst().toString());
        assertEquals("100.0", sortedLinkedDouble.getLast().toString());
        assertEquals(2,sortedLinkedDouble.getSize());
    }

    private class StringComparator implements Comparator<String>
    {
        @Override
        public int compare(String arg0, String arg1) {
            return arg0.compareTo(arg1);
        }

    }

    private class DoubleComparator implements Comparator<Double>
    {
        @Override
        public int compare(Double arg0, Double arg1) {
            return arg0.compareTo(arg1);
        }

    }
}

