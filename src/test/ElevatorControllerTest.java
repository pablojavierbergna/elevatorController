package test;

import com.company.Elevator;
import com.company.ElevatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by p_ber on 15/3/2017.
 */
public class ElevatorControllerTest {

    @Test
    public void createController() {
        Elevator elevator = new Elevator(5);
        ElevatorController elevatorController = new ElevatorController(elevator);
        (new Thread(elevatorController)).start();
        Assertions.assertNotNull(elevatorController);
    }

    @Test
    public void requestFloor() throws InterruptedException {
        Elevator elevator = new Elevator(5);
        ElevatorController elevatorController = new ElevatorController(elevator);
        (new Thread(elevatorController)).start();
        Assertions.assertTrue(elevatorController.getCurrentFloor() == 0);
        elevatorController.requestFloor(1);
        TimeUnit.SECONDS.sleep(1);
        Assertions.assertTrue(elevatorController.getCurrentFloor() == 1);

        elevatorController.requestFloor(4);
        TimeUnit.SECONDS.sleep(1);
        Assertions.assertTrue(elevatorController.getCurrentFloor() == 4);

        elevatorController.requestFloor(1);
        elevatorController.requestFloor(2);
        elevatorController.requestFloor(3);
        TimeUnit.SECONDS.sleep(1);
        Assertions.assertTrue(elevatorController.getCurrentFloor() == 1);

        elevatorController.requestFloor(0);
        TimeUnit.SECONDS.sleep(1);
        Assertions.assertTrue(elevatorController.getCurrentFloor() == 0);

        for (int i = 0; i < 5; i++) {
            Assertions.assertTrue(elevatorController.getElevator().getFloorRequests()[i].get() == false);
        }
    }
}
