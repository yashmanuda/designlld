package designpatterns.creational.builder.usingdirector.builders;

import designpatterns.creational.builder.usingdirector.models.house.House;
import designpatterns.creational.builder.usingdirector.models.floor.Floor;
import designpatterns.creational.builder.usingdirector.models.roof.Roof;
import designpatterns.creational.builder.usingdirector.models.wall.Wall;

/**
 * Abstract builder which will be implemented
 */
public interface AbstractHouseBuilder {

    Wall createWall();

    Floor createFloor();

    Roof createRoof();

    House createHouse();

}
