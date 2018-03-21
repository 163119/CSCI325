package csu.csci325;

import java.util.*;

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
public class CSCIHashTable<K, V> implements Map<K, V> {
    private int mSize, mTableLength = 1000003;
    CSCILinkedList<Node>[] mTable;
    public CSCIHashTable() {
        mSize = 0;
        mTable = Arrays.copyOf(new Object[mTableLength], mTableLength, CSCILinkedList[].class);
    }
    @Override
    public int size() {
        return mSize;
    }

    @Override
    public boolean isEmpty() {
        return mSize < 1;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V remove(Object key) {
        CSCILinkedList list = mTable[key.hashCode() % mTable.length];
        if (list == null) { return null;}
        Iterator<Node> it = list.iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.mKey.equals(key)) {
                list.remove(node);
                mSize--;
                return node.mValue;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
    }

    @Override
    public void clear() {
        for (int i = 0; i < mTable.length; i++) {
            mTable[i] = null; // just set everything null!
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> ret = new HashSet<>();
        for (int i = 0; i < mTable.length; i++ ) {
            CSCILinkedList list = mTable[i];
            if (list != null) {
                Iterator<Node> it = list.iterator();
                while (it.hasNext()) {
                    ret.add(it.next().mKey);
                }
            }
        }
        return ret;
    }

    @Override
    public Collection<V> values() {
        Collection <V> ret = new LinkedList<>();
        for (int i = 0; i < mTable.length; i++ ) {
            CSCILinkedList list = mTable[i];
            if (list != null) {
                Iterator<Node> it = list.iterator();
                while (it.hasNext()) {
                    ret.add(it.next().mValue);
                }
            }
        }
        return ret;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
    @Override
    public V get(Object key) {
        CSCILinkedList<Node> list = mTable[key.hashCode() % mTable.length];
        if (list == null) {return null;}
        Iterator<Node> it = list.iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.mKey.equals(key)) {
                return node.mValue;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        Node node = new Node();
        node.mKey = key;
        node.mValue = value;
        //mList.addFront(node);
        CSCILinkedList<Node> list = mTable[key.hashCode() % mTable.length];
        if (list == null) {
            list = new CSCILinkedList<>();
            mTable[key.hashCode() % mTable.length] = list;
        }
        if (list.contains(node)) {
            mSize--;
            list.remove(node);
        }
        list.add(node);
        mSize++;
        return value;
    }
    private class Node {
        V mValue;
        K mKey;
        public boolean equals(Object o) {
            if (o instanceof CSCIHashTable.Node) {
                Node n = (Node) o;
                return n.mKey.equals(mKey);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hash Table Library Test\nCreating empty table");
        Map<Integer, Student> studentMap = new CSCIHashTable<>();
        System.out.println("Adding students");
        studentMap.put(1024, new Student("John"));
        studentMap.put(2048, new Student("Paul"));
        studentMap.put(4096, new Student("Luke"));
        studentMap.put(8192, new Student("Mark"));
        Collection<Student> st = studentMap.values();
        Iterator<Student> it = st.iterator();
        System.out.println("Printing list of students:");
        while (it.hasNext()) {
            System.out.println(it.next().getFirstName());
        }
        System.out.println("-----------------------------------------");
        System.out.println("Renaming Mark to Paul then printing list");
        studentMap.put(8192, new Student("Paul"));
        st = studentMap.values();
        it = st.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getFirstName());
        }
        System.out.println("-----------------------------------------");
        System.out.println("Printing name of student with id 1024 (John)");
        System.out.println(studentMap.get(1024).getFirstName());
        System.out.println("Printing output of removing id not found (null)");
        System.out.println(studentMap.remove(100));
        System.out.println("Printing name of student with id 8192 (Paul)");
        System.out.println(studentMap.get(8192).getFirstName());
        System.out.println("Printing number of students in the table (4)");
        System.out.println(studentMap.size());
    }
}
