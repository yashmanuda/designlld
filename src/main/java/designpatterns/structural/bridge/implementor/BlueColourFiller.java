package designpatterns.structural.bridge.implementor;

public class BlueColourFiller implements ColourFiller {

    @Override
    public String fillColour() {
        return "Blue colour filler.";
    }
}
