package carrentalsystem;

import org.apache.commons.codec.digest.DigestUtils;

public class Admin extends User {

    public Admin(String name, int contactNumber, String userId) {
        super(name, contactNumber, userId);
    }


    public boolean addNewMember(String name, int contactNumber) {
        MemberDatabase memberDatabase = MemberDatabase.getMemberDatabase();
        Member member = new Member(name, contactNumber, DigestUtils.md5Hex(name + String.valueOf(contactNumber)));
        return memberDatabase.addMember(member);
    }

    public boolean addNewVehicle(Vehicle vehicle) {
        VehicleManager vehicleManager = VehicleManager.getVehicleManager();
        return vehicleManager.addVehicle(vehicle);
    }

    public boolean removeVehicle(String vehicleNumber) {
        VehicleManager vehicleManager = VehicleManager.getVehicleManager();
        return vehicleManager.removeVehicleByNumber(vehicleNumber);
    }

    public boolean cancelMembership(String name, int contactNumber) {
        Member toRemove = new Member(name, contactNumber, DigestUtils.md5Hex(name + String.valueOf(contactNumber)));
        return MemberDatabase.getMemberDatabase().removeMember(toRemove);
    }
}
