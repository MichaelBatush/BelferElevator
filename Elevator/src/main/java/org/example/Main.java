package org.example;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class BelferElevator {

    Queue<Integer> floorRequests = new PriorityQueue<>();
    ElevatorState state = ElevatorState.NOT_MOVING;

    private int currentFloor = 1;
    private int current_weight = 0;

    final int total_floors = 18;

   Boolean e1_empty = true;

   final int cost_to_open = 7;

    final int cost_to_move_one_floor = 7;







    // Define the states of the elevator
enum ElevatorState {
    NOT_MOVING,
    MOVING_UP,

    MOVING_DOWN,
    DOORS_OPEN,

// Define the floor requests queue

};

public BelferElevator(){

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
    //method set empty/full
//Method is empty
    //current weight
    //method set weight
    }

