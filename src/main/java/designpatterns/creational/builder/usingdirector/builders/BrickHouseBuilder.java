package designpatterns.creational.builder.usingdirector.builders;

import designpatterns.creational.builder.usingdirector.models.floor.BrickFloor;
import designpatterns.creational.builder.usingdirector.models.floor.Floor;
import designpatterns.creational.builder.usingdirector.models.house.BrickHouse;
import designpatterns.creational.builder.usingdirector.models.house.House;
import designpatterns.creational.builder.usingdirector.models.roof.BrickRoof;
import designpatterns.creational.builder.usingdirector.models.roof.Roof;
import designpatterns.creational.builder.usingdirector.models.wall.BrickWall;
import designpatterns.creational.builder.usingdirector.models.wall.Wall;

/**
 * concrete builder
 */
public class BrickHouseBuilder implements AbstractHouseBuilder {
    @Override
    public Wall createWall() {
        return new BrickWall();
    }

    @Override
    public Floor createFloor() {
        return new BrickFloor();
    }

    @Override
    public Roof createRoof() {
        return new BrickRoof();
    }

    @Override
    public House createHouse() {
        return new BrickHouse();
    }
}
