package org.example.utils;

import java.util.Date;
import java.util.LinkedList;

public class MyQueue<T> {

    private LinkedList<MyObject<T>> linkedlist;
    private int maxSize;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        this.linkedlist = new LinkedList<>();
    }

    public void add(T object) {
        if( linkedlist.size() == maxSize ) {
            linkedlist.poll();
        }
        MyObject input = new MyObject(object);
        linkedlist.offer(input);
    }

    public T current() {
        return linkedlist.getLast().value;
    }

    public T previous() {
        if( linkedlist.size() > 1 ) {
            return linkedlist.get(linkedlist.size()-2).value;
        } else {
            return null;
        }
    }

    public int size() {
        return linkedlist.size();
    }

    public T get(int index) {
        if( index >= 0 && index < linkedlist.size() ) {
            return linkedlist.get(linkedlist.size() - index - 1).value;
        }
        return null;
    }

    public Date date(int index) {
        if( index >= 0 && index < linkedlist.size() ) {
            return linkedlist.get(linkedlist.size() - index - 1).date;
        }
        return null;
    }

    public void clear() {
        linkedlist.clear();
    }

    public int since() {
        int count = 1;
        T current = current();
        if( linkedlist.size() > 2 ) {
            for (int i = 1; i < linkedlist.size(); i++) {
                T previous = linkedlist.get(linkedlist.size() - i - 1).value;
                if( previous.equals(current)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public int last(T search) {
        for (int i = 0; i < linkedlist.size(); i++) {
            T current = linkedlist.get(linkedlist.size() - i -1).value;
            if( current.equals(search) ) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Elements count: ").append(size()).append("\n");
        for(int i=0; i < linkedlist.size(); i++){
            output.append(String.format("   |-> i-%02d %s", i, linkedlist.get(linkedlist.size()-i-1))).append("\n");
        }
        return output.toString();
    }

    private static class MyObject<T> {
        T value;
        Date date;

        public MyObject(T value) {
            this.value = value;
            this.date = new Date();
        }

        @Override
        public boolean equals(Object obj) {
            return this.value.equals(((MyObject<T>)obj).value);
        }

        @Override
        public String toString() {
            return "["+ date.getTime() +"] " + value;
        }
    }
}
