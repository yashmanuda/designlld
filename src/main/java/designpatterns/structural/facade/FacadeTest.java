package designpatterns.structural.facade;

/**
 * Client will only call the fetchAllMenus method and let the MenuFetcher (facade) do all the work inside
 */
public class FacadeTest {
    public static void main(String[] args) {
        MenuFetcher menuFetcher = new MenuFetcher();
        System.out.println(menuFetcher.fetchAllMenus());
    }
}
