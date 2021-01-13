package designpatterns.creational.builder.staticclass;

public class StaticSubClassTest {
    public static void main(String[] args) {
        Person personWithoutNumber = new Person.Builder()
                .withName("John")
                .withGender("Male")
                .withAddress("242 St. Manhattan")
                .withBirthDate(19890223)
                .withEmail("john@sample.com")
                .build();

        System.out.println(personWithoutNumber);


        Person nameAndNumber = new Person.Builder()
                .withName("Meghan Stone")
                .withPhoneNumber("+1", "84294332")
                .build();

        System.out.println(nameAndNumber);
    }
}
