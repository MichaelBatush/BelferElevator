package org.example;

import java.util.*;

class BelferElevator {

    Queue<Integer> floorRequests = new PriorityQueue<>();
    ElevatorState state = ElevatorState.NOT_MOVING;
    private int currentFloor = 1;
    private int current_weight = 0;
    private Set<Integer> calledUp = new HashSet<>();
    private Set<Integer> calledDown = new HashSet<>();
    final int total_floors = 18;
    boolean empty = true;
    // up = 1, still = 0, down = -1
    int direction = 0;
    final int cost_to_open = 7;
    final int cost_to_move_one_floor = 7;
    private DoublyLinkList myList = new DoublyLinkList();

    enum ElevatorState {
        NOT_MOVING,
        MOVING_UP,

        MOVING_DOWN,
        DOORS_OPEN,

    }

    public BelferElevator() {
        for (int i = 1; i <= 16; i++){
            myList.addLast(i);
        }
    }

    public void move() {
        if (state == ElevatorState.NOT_MOVING && !floorRequests.isEmpty()) {
            int nextFloor = floorRequests.peek();
            if (nextFloor > currentFloor) {
                state = ElevatorState.MOVING_UP;
                while (currentFloor < nextFloor) {
                    currentFloor++;
                    // Send signal to elevator to move up one floor
                }
            } else if (nextFloor < currentFloor) {
                state = ElevatorState.MOVING_DOWN;
                while (currentFloor > nextFloor) {
                    currentFloor--;
                    // Send signal to elevator to move down one floor
                }
            }
            state = ElevatorState.DOORS_OPEN;
            // Send signal to elevator to open doors
            // Wait for a few seconds
            // Send signal to elevator to close doors
            state = ElevatorState.NOT_MOVING;
            floorRequests.poll();
        }
    }

    public boolean isEmpty() {
        return (current_weight == 0);
    }

    public int getFloor(){
        return currentFloor;
    }

    public void setCalledUpperFloor(int floor){
        this.calledUp.add(floor);
    }

    public void setCalledDownFloor(int floor){
        this.calledUp.add(floor);
    }

    public boolean isHighFloorPressed(int floor){
        return calledUp.contains(floor);
    }
    public boolean isLowFloorPressed(int floor){
        return calledUp.contains(floor);
    }

    public int goUp(){
        return 0;
    }

    public class DoublyLinkList {
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

        public DoublyLinkList() {
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



}