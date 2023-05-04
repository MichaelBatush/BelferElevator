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
    final int cost_to_open = 7;
    final int cost_to_move_one_floor = 7;
    private DoubleLinkList myList = new DoubleLinkList();

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

    public boolean isNextFloorPressed(int floor){
        return calledUp.contains(floor);
    }


}