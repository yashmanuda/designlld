package designpatterns.structural.bridge;

import designpatterns.structural.bridge.abstraction.Circle;
import designpatterns.structural.bridge.abstraction.Shape;
import designpatterns.structural.bridge.abstraction.Square;
import designpatterns.structural.bridge.implementor.BlueColourFiller;
import designpatterns.structural.bridge.implementor.ColourFiller;
import designpatterns.structural.bridge.implementor.RedColourFiller;

public class BridgeTest {
    public static void main(String[] args) {
        ColourFiller redColour = new RedColourFiller();
        ColourFiller blueColour = new BlueColourFiller();

        Shape redSquare = new Square(redColour);
        Shape blueCircle = new Circle(blueColour);

        redSquare.draw();
        blueCircle.draw();
    }
}
