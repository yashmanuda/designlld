package designpatterns.creational.prototype.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The original prototype type must implement cloneable
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Product implements Cloneable {
    private String productId;
    private String title;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
