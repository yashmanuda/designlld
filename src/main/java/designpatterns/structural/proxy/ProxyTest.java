package designpatterns.structural.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        ProxyInternet proxyInternet = new ProxyInternet();
        proxyInternet.connectTo("www.google.com");
        proxyInternet.connectTo("www.xyz.com");
    }
}
