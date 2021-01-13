package designlld.decoratorpattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@ToString
class BeverageDescription {
    String name;
    float cost;
}
