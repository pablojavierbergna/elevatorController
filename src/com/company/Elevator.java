package com.company;

/**
 * Created by Pablo on 14/3/2017.
 */
public class Elevator {

    //1
    private Integer numberOfFloors = 1;
    private Boolean[] floorRequests;
    private Integer currentFloor;
    private Boolean goingUp;


    Elevator(final Integer aNumberOfFloors) {
        floorRequests = new Boolean[aNumberOfFloors];
        //1
        this.numberOfFloors = aNumberOfFloors;
        //2
        this.currentFloor = 0;
        this.goingUp = true;
    }

    public void moveElevator(final int floor) {
        if (floor <= this.numberOfFloors &&
                floor >= 0) {
            if (this.currentFloor > floor) {
                this.goingUp = false;
            } else {
                this.goingUp = true;
            }
            this.currentFloor = floor;
        }
    }

    //3
    //6
    public void requestFloor(final int floor) {
        if (floor <= this.numberOfFloors &&
                floor >= 0) {
            this.floorRequests[floor] = true;
        }
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public Boolean[] getFloorRequests() {
        return floorRequests;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public Boolean getGoingUp() {
        return goingUp;
    }
}
