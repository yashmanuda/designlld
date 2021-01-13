package designpatterns.creational.prototype.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Book extends Product {
    private String author;
    private int numPages;


    public Book(String productId, String title, String author, int numPages) {
        super(productId, title);
        this.author = author;
        this.numPages = numPages;
    }
}
