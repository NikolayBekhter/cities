package ru.bekhter;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.List;

import static ru.bekhter.CityUtils.*;

public class Main {
    public static void main(String[] args) {
        List<City> cities = parse();
        searchСityMaxPopulation(cities);
        //searchByInsertionSort(cities);
        //searchMaxPopulation(cities);
    }

    private static void searchСityMaxPopulation(List<City> cities) {
        City[] array = new City[cities.size()];
        cities.toArray(array);
        int current = 0;
        int index = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i].getPopulation() > current) {
                current = array[i].getPopulation();
                index = i;
            }
        }
        System.out.println(MessageFormat.format("[{0}] = {1}", index, current));
    }

    private static void searchByInsertionSort(List<City> cities) {
        City[] array = new City[cities.size()];
        cities.toArray(array);
        for (int i = 1; i < array.length; i++) {
            City current = array[i];
            int j = i - 1;
            while (j >= 0 && current.getPopulation() < array[j].getPopulation()) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        System.out.println(MessageFormat.format("[{0}] = {1}", array.length - 1, array[array.length - 1]));
    }

    private static void searchMaxPopulation(List<City> cities) {
        System.out.println(cities.stream().max(Comparator.comparing(City::getPopulation)));
    }
}