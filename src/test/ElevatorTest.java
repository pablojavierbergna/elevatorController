package test;

import com.company.Elevator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by Pablo on 14/3/2017.
 */
public class ElevatorTest {

    @Test
    public void createElevator() {
        Elevator elevator = new Elevator(3);
        Assertions.assertNotNull(elevator);
        Assertions.assertTrue(elevator.getNumberOfFloors() == 3);
    }

    @Test
    public void moveElevator() {
        Elevator elevator = new Elevator(3);
        Assertions.assertTrue(elevator.getCurrentFloor() == 0);
        elevator.move(2);
        Assertions.assertTrue(elevator.getCurrentFloor() == 2);
    }

    @Test
    public void failToMoveElevatorOutOfBounds() {
        Elevator elevator = new Elevator(3);
        Assertions.assertTrue(elevator.getCurrentFloor() == 0);
        elevator.move(5);
        Assertions.assertTrue(elevator.getCurrentFloor() == 0);
        elevator.move(-1);
        Assertions.assertTrue(elevator.getCurrentFloor() == 0);
    }

}
