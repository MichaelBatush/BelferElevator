package org.example;

import java.util.NoSuchElementException;

public class DoubleLinkList {
    private ListNode head;
    private ListNode tail;
    private int size;

    private class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public DoubleLinkList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public int getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.val;
    }

    public int getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
