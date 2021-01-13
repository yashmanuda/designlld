package designpatterns.creational.builder.usingdirector;

import designpatterns.creational.builder.usingdirector.builders.AbstractHouseBuilder;
import designpatterns.creational.builder.usingdirector.builders.BrickHouseBuilder;
import designpatterns.creational.builder.usingdirector.builders.WoodHouseBuilder;
import designpatterns.creational.builder.usingdirector.models.house.House;

public class BuilderTest {
    public static void main(String[] args) {
        BuildingDirector director = new BuildingDirector();

        AbstractHouseBuilder brickHouseBuilder = new BrickHouseBuilder();
        House brickHouse = director.constructHouse(brickHouseBuilder);

        AbstractHouseBuilder woodHouseBuilder = new WoodHouseBuilder();
        House woodHouse = director.constructHouse(woodHouseBuilder);
    }
}
