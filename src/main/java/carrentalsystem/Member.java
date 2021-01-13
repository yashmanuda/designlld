package carrentalsystem;

import carrentalsystem.Vehicle.VehicleState;
import carrentalsystem.Vehicle.VehicleType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static carrentalsystem.Reservation.*;

@Getter
public class Member extends User {
    List<Reservation> reservationList;

    public Member(String name, int contactNumber, String userId) {
        super(name, contactNumber, userId);
        reservationList = new ArrayList<>();
    }

    public List<Vehicle> searchVehicles(VehicleType vehicleType, VehicleState vehicleState) {
        VehicleManager vehicleManager = VehicleManager.getVehicleManager();
        return vehicleManager.getVehicleByTypeAndState(vehicleType, vehicleState);
    }

    public Reservation reserveVehicle(Vehicle vehicle, Services... services) {
        VehicleManager vehicleManager = VehicleManager.getVehicleManager();
        return vehicleManager.reserveVehicle(this, vehicle, services);
    }

    public boolean checkoutVehicle(Reservation reservation) {
        return reservation.checkOutReservation();
    }

    public boolean returnVehicle(Reservation reservation) {
        Bill billToPay = reservation.returnVehicle();
        return billToPay.payBill();
    }
}
