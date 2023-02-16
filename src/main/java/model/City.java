package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    @Override
    public String toString() {
        return "{name=" + this.name + ", region=" + this.region + ", district=" + this.district
                + ", population=" + this.population + ", foundation=" + this.foundation + "}\n";
    }
}

