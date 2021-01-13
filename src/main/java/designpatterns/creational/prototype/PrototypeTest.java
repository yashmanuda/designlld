package designpatterns.creational.prototype;

import designpatterns.creational.prototype.models.Book;
import designpatterns.creational.prototype.models.Product;

/**
 * Creation of new instances by cloning the existing instances
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Product book = new Book("1", "Harry Potter", "J.K.Rowling", 457);

        // creating new instance by cloning already existing book
        Product bookCloned = (Product) book.clone();
        System.out.println("original book: " + book);
        bookCloned.setTitle("Fantastic Beasts");
        System.out.println("cloned book: " + bookCloned);
    }
}
