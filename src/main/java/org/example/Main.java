package org.example;

import org.example.utils.MyQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyQueue<Boolean> values = new MyQueue<>(10);
        values.add(true); Thread.sleep(200);
        values.add(true); Thread.sleep(200);
        values.add(true); Thread.sleep(200);
        values.add(true); Thread.sleep(200);
        values.add(true); Thread.sleep(200);
        values.add(false); Thread.sleep(200);
        values.add(true); Thread.sleep(200);
        values.add(false); Thread.sleep(200);
        values.add(false); Thread.sleep(200);
        values.add(true); Thread.sleep(200);
        values.add(false); Thread.sleep(200);
        values.add(false); Thread.sleep(200);

        System.out.println(values);

        System.out.println("Current : " + values.current());
        System.out.println("Previous: " + values.previous());
        System.out.println("Since : " + values.since());
        System.out.println("Element t-" + values.since() + ": " + values.get(values.since()) + " @" + values.date(values.since()).getTime());
        int index = values.last(true);
        System.out.println("Last(true) t-" + index + ": " + values.get(index) + " @" + values.date(index).getTime());
        index = values.last(false);
        System.out.println("Last(false) t-" + index + ": " + values.get(index) + " @" + values.date(index).getTime());

        System.out.println("Element t-0: " + values.get(0) + " @" + values.date(0).getTime());
        System.out.println("Element t-09: " + values.get(9) + " @" + values.date(9).getTime());
        System.out.println("Element t-10: " + values.get(10) + " @" + values.date(10));
    }
}