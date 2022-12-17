package ru.bekhter;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C:/Users/nvbek/IdeaProjects/cities/city_ru.csv";
        Scanner scanner = new Scanner(Paths.get(path));
        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            //парсим строку в объект Employee
            City city = parseCSVLine(scanner.next());
            System.out.println(city.toString());
        }
        scanner.close();
    }

    private static City parseCSVLine(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        int id = scanner.nextInt();
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }
        return new City(name, region, district, population, foundation);
    }
}