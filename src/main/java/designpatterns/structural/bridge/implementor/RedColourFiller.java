package designpatterns.structural.bridge.implementor;

public class RedColourFiller implements ColourFiller {

    @Override
    public String fillColour() {
        return "Red colour filled.";
    }
}
