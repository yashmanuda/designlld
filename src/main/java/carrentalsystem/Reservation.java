package carrentalsystem;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Getter
@ToString
public class Reservation implements Comparable<Reservation> {
    private String reservationId;
    private Member member;
    private Vehicle vehicle;
    private ReservationStatus reservationStatus;
    private Date reservationDate;
    private Services[] services;

    @Override
    public int compareTo(Reservation o) {
        return reservationDate.compareTo(o.reservationDate);
    }

    enum ReservationStatus {
        RESERVED, CHECKED_OUT, CANCELLED, RETURNED
    }

    enum Services {
        CHILD_SEAT, NAVIGATION, WIFI
    }

    public Reservation(Member member, Vehicle vehicle, ReservationStatus reservationStatus, Services[] services) {
        this.reservationId = UUID.randomUUID().toString();
        this.member = member;
        this.vehicle = vehicle;
        this.reservationStatus = reservationStatus;
        Constants.dateFormat.format(reservationDate);
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public boolean checkOutReservation() {
        synchronized (this) {
            if (reservationStatus == ReservationStatus.RESERVED) {
                reservationStatus = ReservationStatus.CHECKED_OUT;
                return vehicle.checkOut(this);
            }
        }
        return false;
    }

    public Bill returnVehicle() {
        reservationStatus = ReservationStatus.RETURNED;
        vehicle.returnVehicle(this);
        Date date = new Date();
        Constants.dateFormat.format(date);
        double amountToPay = ReservationManager.getReservationManager().calculateReservationAmount(this, date);
        return new Bill(amountToPay, date);
    }

    @Override
    public int hashCode() {
        return reservationId.hashCode();
    }
}

