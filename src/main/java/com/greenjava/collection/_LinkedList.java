package com.greenjava.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Doubly linked list implement List and Deque interface.
 * follow ordering, allowing null
 * Its Iterator and ListIterator are fail fast its thrown ConcurrentModificationException
 * Its not synchronized
 * every element is node that holds reference previous and last node
 * It maintain insertion order
 * <p>
 * Structure : -
 * Search element execution time is O(n) ArrayList used sequential access by index
 * so search element by index for perform O(1)
 * <p>
 * Operation :-
 * Then insertion and delete operation is fast because there are no need to
 * resize array.
 * <p>
 * Memory uses:-
 * LinkedList consumes more memory than the ArrayList because every node store
 * two reference previous and next node.
 * ADD ELEMENT
 * ===========
 * public boolean add(E e)
 * Append the element in end of list
 * this method is equivalent is addLast(E e)
 * override in AbstractList
 * internally its call add((size) E e)
 * <p>
 * public void add(int index, E e)
 * public boolean addAll(Collection<? extends T> c)
 * public void addAll(int index, Collection<? extends T> c)
 * throw ArrayIndexOutOfBoundException (index < 0 || index > size())
 * <p>
 * public void addFirst(E e) insert last
 * public void addList(E e) insert last
 * given methods in dequeue
 * public boolean offer(E e)  insert into last (java 5)
 * public boolean offerFirst(E e) insert into first place
 * public boolean offerLast(E e) insert into last place
 * <p>
 * Removing element
 * ===============
 * public E remove()
 * Remove and return the node from list first occurrence by given index
 * public E remove(int index) // coming from list interface
 * Remove and return the node from the list and shift any subsequent node to left
 * public boolean remove(Object o)
 * Remove and return the node from list first occurrence by given object
 * by given wrong value its not change list just return false status
 * public E removeFirst()
 * public E RemoveLast()
 * Remove first node and return, from list if list is empty throws
 * NoSuchElementFoundException
 * public E removeFirstOccurrence(Object o) its from Dequeue Interface
 * is same as remove(Obj)
 * public E removeLastOccurrence(Object o) its from Dequeue interface
 *
 *
 */
public class _LinkedList {

    public static void main(String[] args) {
        linkedList();
    }

    Logger logger = Logger.getLogger(_LinkedList.class.getName());

    public static void linkedList() {

        LinkedList<String> strings = new LinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("a");
        strings.add("d");


        //strings.offer("z");
        strings.offerLast("z");


        System.out.println(strings);

    }
}
