package designpatterns.structural.proxy;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the proxy class which implements the actual abstraction
 * It contains the object to which client is supposed to call
 * It is usually used for authentication and limiting the calls to the actual instance
 */
public class ProxyInternet implements Internet {
    private final Internet realInternet;
    private final Set<String> blacklisted;

    ProxyInternet() {
        this.blacklisted = new HashSet<String>() {{
            add("www.abc.com");
            add("www.xyz.com");
        }};
        this.realInternet = new RealInternet();
    }

    @Override
    public void connectTo(String destination) {
        if (blacklisted.contains(destination)) {
            System.out.println("Access denied!");
        } else realInternet.connectTo(destination);
    }
}
