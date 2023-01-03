package ru.bekhter;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.bekhter.CityUtils.*;

public class Main {
    public static void main(String[] args) {
        List<City> cities = parse();
        //quantityOfCitiesByRegion(cities);
        findCountCityByRegionV1(cities);
        //findCountCityByRegionV2(cities);
    }

    //поиск количества городов в разрезе регионов

    private static void quantityOfCitiesByRegion(List<City> cities) {
        cities.stream()
                .collect(Collectors.groupingBy(City::getRegion, Collectors.counting()))
                .forEach((s, count) -> System.out.println(s + " - " + count));

    }

    private static void findCountCityByRegionV1(List<City> cities) {
        Map<String, Integer> regions = new HashMap<>();
        for (City city : cities) {
            if (!regions.containsKey(city.getRegion())) {
                regions.put(city.getRegion(), 1);
            } else {
                regions.put(city.getRegion(), regions.get(city.getRegion()) + 1);
            }
        }
        for (String key : regions.keySet()) {
            System.out.println(MessageFormat.format(" {0} = {1}", key, regions.get(key)));
        }
    }

    private static void findCountCityByRegionV2(List<City> cities) {
        Map<String, Integer> regions = new HashMap<>();
        cities.forEach(city -> regions.merge(city.getRegion(), 1, Integer::sum));
        regions.forEach((k, v) -> System.out.println(MessageFormat.format(" {0} = {1}", k, v)));
    }
}