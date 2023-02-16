package scanner;

import model.City;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanDoc {
    public static List<City> scanNewDoc(String str) throws IOException {
        List<City> cityList = new ArrayList<>();
        Scanner scanner = new Scanner(Paths.get(str));
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            String[] words = scanner.next().split(";");
            String name = words[1];
            String region = words[2];
            String district = words[3];
            int population = Integer.parseInt(words[4]);
            String foundation = null;
            try {
                foundation = words[5];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Поле \"дата основания или первое упоминание:\" для " + name + " не заполнено");
            }
            cityList.add(new City(name, region, district, population, foundation));
        }
        scanner.close();
        return cityList;
    }
}
