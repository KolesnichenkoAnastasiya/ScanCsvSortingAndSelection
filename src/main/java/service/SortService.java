package service;

import model.City;

import java.util.*;
import java.util.stream.Collectors;

public class SortService {
    public static List sortByCityNameDesc(List<City> cityList) {
        cityList.sort((o1, o2) -> o2.getName().toLowerCase(Locale.ROOT).compareTo(o1.getName().toLowerCase(Locale.ROOT)));
        System.out.println(cityList);
        return cityList;
    }

    public static List sortByDistrictDescAndNameDesc(List<City> cityList) {
        List sortedProductList = cityList.stream().sorted(
                Comparator.comparing(City::getDistrict).thenComparing(City::getName).reversed()
        ).collect(Collectors.toList());
        System.out.println(sortedProductList);
        return sortedProductList;
    }

    public static List sortByDistrictDescAndNameAbc(List<City> cityList) {
        List sortedProductList = cityList.stream().sorted(
                Comparator.comparing(City::getDistrict).reversed().thenComparing(City::getName)
        ).collect(Collectors.toList());
        System.out.println(sortedProductList);
        return sortedProductList;
    }

    public static String sortByPopulation(City[] cities) {
        int max = 0;
        int index = 0;
        String sortByPopulation = null;
        if (cities.length > 0) {
            for (int i = 0; i < cities.length; i++) {
                if (cities[i].getPopulation() > max) {
                    max = cities[i].getPopulation();
                    index = i;
                }
            }
        }
        sortByPopulation="[" + index + "] = " + cities[index].getPopulation();
        System.out.println(sortByPopulation);
        return sortByPopulation;
    }

    public static Map citiesInTheRegion(List<City> cityList) {
        int firstOccurrence = 1;
        Map<String, Integer> uniqueValues = new TreeMap<>();
        for (City city : cityList) {
            if (uniqueValues.containsKey(city.getRegion())){
            uniqueValues.computeIfPresent(city.getRegion(), (k, v) -> v + 1);
            } else {
                uniqueValues.put(city.getRegion(), firstOccurrence);
            }
        }
        System.out.println("Количество городов по регионам: ");
        printMap(uniqueValues);
        return uniqueValues;
    }

    public static Map citiesInTheRegion(City [] cities) {
        int firstOccurrence = 1;
        Map<String, Integer> uniqueValues = new TreeMap<>();
        for (City city : cities) {
            if (uniqueValues.containsKey(city.getRegion())){
                uniqueValues.computeIfPresent(city.getRegion(), (k, v) -> v + 1);
            } else {
                uniqueValues.put(city.getRegion(), firstOccurrence);
            }
        }
        System.out.println("Количество городов по регионам: ");
        printMap(uniqueValues);
        return uniqueValues;
    }

    public static String printMap (Map<String, Integer> mapForPrint) {
        Iterator<Map.Entry<String, Integer>> iterator = mapForPrint.entrySet().iterator();
        Map.Entry<String, Integer> entry = null;
        StringBuilder printMap = new StringBuilder();
        while(iterator.hasNext()){
            entry = iterator.next();
            printMap.append("• " + entry.getKey() + " - " + entry.getValue() + "\n");
        }
        System.out.println(printMap);
        return new String(printMap);
    }
}

