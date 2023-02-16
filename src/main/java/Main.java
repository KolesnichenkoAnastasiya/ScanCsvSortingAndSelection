import model.City;
import scanner.ScanDoc;
import service.SortService;
import java.io.IOException;
import java.util.List;

import static service.ArrayService.listToArray;


public class Main {
    public static void main(String[] args) throws IOException {
        String pathToScanCSV = "src/main/resources/FilesToRead/Задача ВС Java Сбер.csv";
        List<City> cityList = ScanDoc.scanNewDoc(pathToScanCSV);
        City [] cities = listToArray(cityList);
        SortService sortService = new SortService();
    }
}
