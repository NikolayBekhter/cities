package ru.bekhter;

import java.util.Comparator;
import java.util.List;

import static ru.bekhter.CityUtils.*;

public class Main {
    public static void main(String[] args) {
        List<City> cities = parse();
        sortByNameV1(cities); // Сортировка массива по наименованию городов, используя lambda-выражения
        print(cities); // Вывод данных массива с городами в консоль

        sortByNameV2(cities); // Сортировка массива по наименованию городов, используя java.util.Comparator
        print(cities); // Вывод данных массива с городами в консоль

        sortByDistrictAndName(cities); // Сортировка массива по федеральным округам и наименваниям городов в них
        print(cities); // Вывод данных массива с городами в консоль
    }

    private static void sortByNameV1(List<City> cities) {
        cities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    private static void sortByNameV2(List<City> cities) {
        cities.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    private static void sortByDistrictAndName(List<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }

    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }
}