package carrentalsystem;

import carrentalsystem.Reservation.ReservationStatus;

import java.util.Collections;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import static carrentalsystem.Reservation.*;

public class ReservationManager {
    private SortedSet<Reservation> setOfReservations;
    private static ReservationManager reservationManager;

    private ReservationManager() {
        setOfReservations = Collections.synchronizedSortedSet(new TreeSet<Reservation>());
    }

    public static ReservationManager getReservationManager() {
        if (reservationManager == null) {
            synchronized (ReservationManager.class) {
                if (reservationManager == null) {
                    reservationManager = new ReservationManager();
                }
            }
        }
        return reservationManager;
    }


    public Reservation reserveVehicle(Member member, Vehicle vehicle, Services[] services) {
        Reservation reservation = new Reservation(member, vehicle, ReservationStatus.RESERVED, services);
        boolean isReserved = vehicle.reserve(member);
        if (!isReserved) setOfReservations.add(reservation);
        else reservation.setReservationStatus(ReservationStatus.CANCELLED);
        return reservation;
    }

    public boolean checkOutTheVehicle(Reservation reservation) {
        return reservation.checkOutReservation();
    }

    public double calculateReservationAmount(Reservation reservation, Date date) {
        return 100.0;
    }
}
