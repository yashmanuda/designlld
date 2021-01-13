package designpatterns.creational.builder.usingdirector;

import designpatterns.creational.builder.usingdirector.builders.AbstractHouseBuilder;
import designpatterns.creational.builder.usingdirector.models.house.House;

/**
 * Director, it controls the order of execution of construction of the usingdirector
 */
public class BuildingDirector {
    public House constructHouse(AbstractHouseBuilder houseBuilder) {
        House house = houseBuilder.createHouse();
        System.out.println(house.getDescription());

        house.setFloor(houseBuilder.createFloor());
        System.out.println(house.getFloor().getDescription());

        house.setWall(houseBuilder.createWall());
        System.out.println(house.getWall().getDescription());

        house.setRoof(houseBuilder.createRoof());
        System.out.println(house.getRoof().getDescription());

        System.out.println("Building usingdirector completed!\n");

        return house;
    }
}
