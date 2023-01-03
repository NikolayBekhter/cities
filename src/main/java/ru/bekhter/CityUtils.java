package ru.bekhter;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.*;

public class CityUtils {

    public static List<City> parse() {
        List<City> cities = new ArrayList<>();
        Scanner scanner = null; // Загрузка данных из файла
        try {
            scanner = new Scanner(new File("src/main/resources/city_ru.csv"));
            while (scanner.hasNextLine()) { // Обработка данных и заполнение массива
                cities.add(parse(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scanner.close(); // Не забываем вызвать метод закрытия потока данных
        return cities;
    }

    public static void searchСityMaxPopulation(List<City> cities) {
        City[] array = cities.toArray(new City[0]);
        int max = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getPopulation() > max) {
                max = array[i].getPopulation();
                index = i;
            }
        }
        System.out.println(MessageFormat.format("[{0}]={1}", index, max));

    }

    private static City parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }

        scanner.close();

        return new City(name, region, district, population, foundation);
    }

}
