package carrentalsystem;

import carrentalsystem.Vehicle.VehicleState;
import carrentalsystem.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static carrentalsystem.Reservation.*;

public class VehicleManager {
    private static VehicleManager vehicleManager;
    private Set<Vehicle> setOfVehicles;

    private VehicleManager() {
        setOfVehicles = new HashSet<>();
    }

    public static VehicleManager getVehicleManager() {
        if (vehicleManager == null) {
            synchronized (VehicleManager.class) {
                if (vehicleManager == null) vehicleManager = new VehicleManager();
            }
        }
        return vehicleManager;
    }

    public boolean addVehicle(Vehicle vehicle) {
        return setOfVehicles.add(vehicle);
    }

    public List<Vehicle> getVehicleByTypeAndState(VehicleType vehicleType, VehicleState vehicleState) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : setOfVehicles) {
            boolean toAdd = true;
            if (vehicleType != null) {
                toAdd = vehicle.getVehicleType() == vehicleType;
            }

            if (vehicleState != null) {
                toAdd = toAdd && vehicle.getVehicleState() == vehicleState;
            }

            if (toAdd) result.add(vehicle);
        }
        return result;
    }

    public List<Vehicle> getVehicleByState(VehicleState vehicleState) {
        return getVehicleByTypeAndState(null, vehicleState);
    }

    public List<Vehicle> getVehicleByType(VehicleType vehicleType) {
        return getVehicleByTypeAndState(vehicleType, null);
    }

    public boolean removeVehicleByNumber(String number) {
        synchronized (VehicleManager.class) {
            return setOfVehicles.remove(new Vehicle(number, null, null));
        }
    }


    public Reservation reserveVehicle(Member member, Vehicle vehicle, Services[] services) {
        ReservationManager reservationManager = ReservationManager.getReservationManager();
        return reservationManager.reserveVehicle(member, vehicle, services);
    }
}
