package designpatterns.structural.bridge.abstraction;

import designpatterns.structural.bridge.implementor.ColourFiller;

public class Square extends Shape {

    public Square(ColourFiller colourFiller) {
        super(colourFiller);
    }

    @Override
    public void draw() {
        System.out.println("Square is completed. " + colourFiller.fillColour());
    }
}
