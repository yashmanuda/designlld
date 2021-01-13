package designpatterns.structural.proxy;

public class RealInternet implements Internet {

    @Override
    public void connectTo(String destination) {
        System.out.println("Connected to " + destination);
    }
}
