package ru.bekhter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

}
