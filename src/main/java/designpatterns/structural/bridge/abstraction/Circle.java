package designpatterns.structural.bridge.abstraction;

import designpatterns.structural.bridge.implementor.ColourFiller;

public class Circle extends Shape {
    public Circle(ColourFiller colourFiller) {
        super(colourFiller);
    }

    @Override
    public void draw() {
        System.out.println("Circle is drawn. " + colourFiller.fillColour());
    }
}
