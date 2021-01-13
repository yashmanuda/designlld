package designpatterns.creational.builder.usingdirector.builders;

import designpatterns.creational.builder.usingdirector.models.house.House;
import designpatterns.creational.builder.usingdirector.models.floor.Floor;
import designpatterns.creational.builder.usingdirector.models.floor.WoodFloor;
import designpatterns.creational.builder.usingdirector.models.house.WoodHouse;
import designpatterns.creational.builder.usingdirector.models.roof.Roof;
import designpatterns.creational.builder.usingdirector.models.roof.WoodRoof;
import designpatterns.creational.builder.usingdirector.models.wall.Wall;
import designpatterns.creational.builder.usingdirector.models.wall.WoodWall;

/**
 * concrete builder
 */
public class WoodHouseBuilder implements AbstractHouseBuilder {
    @Override
    public Wall createWall() {
        return new WoodWall();
    }

    @Override
    public Floor createFloor() {
        return new WoodFloor();
    }

    @Override
    public Roof createRoof() {
        return new WoodRoof();
    }

    @Override
    public House createHouse() {
        return new WoodHouse();
    }
}
