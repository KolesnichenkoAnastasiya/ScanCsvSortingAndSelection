package service;

import model.City;

import java.util.Arrays;
import java.util.List;

public class ArrayService {
    public static City[] listToArray (List<City> cityList){
        return cityList.stream().toArray(City[]::new);
    }
    public static void printArray (City [] cities){
        System.out.println(Arrays.toString(cities));
    }
}
