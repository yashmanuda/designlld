package designpatterns.creational.builder.staticclass;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
class Person {
    private String name;
    private String email;
    private String address;
    private String gender;
    private int birthDate;
    private PhoneNumber phoneNumber;

    private Person(String name, String email, String address, String gender, int birthDate, PhoneNumber phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public static final class Builder {
        private String name;
        private String email;
        private String address;
        private String gender;
        private int birthDate;
        private PhoneNumber phoneNumber;

        Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder withBirthDate(int birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder withPhoneNumber(String extension, String number) {
            this.phoneNumber = new PhoneNumber(extension, number);
            return this;
        }

        public Person build() {
            return new Person(name, email, address, gender, birthDate, phoneNumber);
        }
    }
}
