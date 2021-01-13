package designpatterns.creational.builder.usingdirector.models.house;

import designpatterns.creational.builder.usingdirector.models.BuildingComponent;
import designpatterns.creational.builder.usingdirector.models.floor.Floor;
import designpatterns.creational.builder.usingdirector.models.roof.Roof;
import designpatterns.creational.builder.usingdirector.models.wall.Wall;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class House implements BuildingComponent {
    private Wall wall;
    private Roof roof;
    private Floor floor;
}
