package carrentalsystem;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private int contactNumber;
    private String userId;

    public User(String name, int contactNumber, String userId) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return contactNumber == user.contactNumber && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + contactNumber;
        return result;
    }
}
