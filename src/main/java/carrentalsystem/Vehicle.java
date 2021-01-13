package carrentalsystem;

import carrentalsystem.Event.EventType;
import lombok.Getter;

import java.util.Comparator;
import java.util.PriorityQueue;

@Getter
public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private VehicleState vehicleState;
    private PriorityQueue<Event> vehicleLog;

    public enum VehicleType {
        SUV, VAN, MOTORCYCLE
    }

    public enum VehicleState {
        RESERVED, AVAILABLE, UNAVAILABLE, CURRENTLY_USED
    }

    public boolean reserve(Member member) {
        synchronized (this) {
            if (vehicleState == VehicleState.AVAILABLE) {
                this.vehicleState = VehicleState.RESERVED;
                vehicleLog.add(new Event(EventType.RESERVED, "Reserved by : " + member.toString()));
                return true;
            }
        }
        return false;
    }

    public boolean checkOut(Reservation reservation) {
        synchronized (this) {
            if (vehicleState == VehicleState.RESERVED) {
                vehicleState = VehicleState.CURRENTLY_USED;
                addToLog(new Event(EventType.RESERVED, "Reservation checked out : " + reservation.toString()));
                return true;
            }
        }
        return false;
    }

    public void returnVehicle(Reservation reservation) {
        vehicleState = VehicleState.AVAILABLE;
        addToLog(new Event(EventType.RETURNED, "Returned : " + reservation.toString()));
    }

    public Vehicle(String vehicleNumber, VehicleType vehicleType, VehicleState vehicleState) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleState = vehicleState;
        this.vehicleLog = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addToLog(Event event) {
        vehicleLog.add(event);
    }

    @Override
    public int hashCode() {
        return vehicleNumber.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        return vehicleNumber.equals(vehicle.vehicleNumber);
    }
}
