package designpatterns.structural.bridge.abstraction;

import designpatterns.structural.bridge.implementor.ColourFiller;
import lombok.AllArgsConstructor;

/**
 * This is the abstraction that will contain implementor
 * This is the classic principle of 'composition over inheritance'
 * This abstraction is decoupled from its implementations
 */
@AllArgsConstructor
public abstract class Shape {

    /**
     * This is the implementor
     */
    ColourFiller colourFiller;

    public abstract void draw();
}
