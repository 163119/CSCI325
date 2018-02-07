package csu.csci325;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 *	Student Name:		Christopher Aumen
 *	Program Name:		Hashing
 *	Creation Date:		April 5, 2016
 *	Last Modified Date:	January 28, 2018
 *	CSCI Course:		CSCI-325 Object-Oriented Programming
 *	Grade Received:		150 (50 extra credit points)
 *	Comments Regarding Design:
 *		
 */

/**
 * Created by student on 4/5/16.
 */
public class CSCILinkedList<T> implements List<T> {
    private class Node {
        T mData;
        Node mNext;
        public Node(T element, Node next) {
            mData = element;
            mNext = next;
        }
    }
    private class CSCILinkedListIterator implements Iterator<T> {
        private Node mRover;
        public CSCILinkedListIterator(Node head) {
            mRover = head;
        }
        @Override
        public boolean hasNext() {
            return mRover != null;
        }

        @Override
        public T next() {
            T ret = mRover.mData;
            mRover = mRover.mNext;
            return ret;
        }
    }
    private Node mHead, mTail;
    public CSCILinkedList() {
        mHead = mTail = null;
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node rover = mHead;
        while (rover != null && !rover.mData.equals(o)) {
            rover = rover.mNext;
        }
        return rover != null;
    }

    @Override
    public Iterator<T> iterator() {
        return new CSCILinkedListIterator(mHead);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node newNode = new Node(t, mHead);
        mHead = newNode;
        if (mHead.mNext == null) {
            mTail = mHead;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node rover = mHead;
        if (rover != null && rover.mData.equals(o)) {
            if (mTail == mHead) {
                mTail = null;
            }
            mHead = mHead.mNext;
            return true;
        } else {
            while (rover.mNext != null && !rover.mNext.mData.equals(o)) {
                rover = rover.mNext;
            }
            if (rover.mNext != null) {
                if (mTail == rover.mNext) {
                    mTail = rover;
                }
                rover.mNext = rover.mNext.mNext;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        mHead = mTail = null;
    }

    @Override
    public T get(int index) {
        int i = 0;
        Node rover;
        for (rover = mHead; rover != null && i < index; rover = rover.mNext, i++) {
        }

        if (rover != null) {
            return rover.mData;
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        int i = 0;
        T ret = null;
        Node rover;
        for (rover = mHead; rover != null && i < index; rover = rover.mNext, i++) {
        }
        if (rover != null) {
            ret = rover.mData;
            rover.mData = element;
        }
        return ret;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int idx = 0;
        for (Node rover = mHead; rover != null; rover = rover.mNext, idx++) {
            if (rover.mData.equals(o)) {
                return idx;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
    public static void main(String[] args) {
        List<Integer> list = new CSCILinkedList<>();
        for (int i = 0; i < 100; i += 5) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println("Element: " + it.next());
        }
    }
}
