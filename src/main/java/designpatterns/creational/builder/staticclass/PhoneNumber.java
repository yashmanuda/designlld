package designpatterns.creational.builder.staticclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
class PhoneNumber {
    private String extension;
    private String number;
}
