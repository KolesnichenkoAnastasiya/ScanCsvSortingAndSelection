package service;

import model.City;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortServiceTest {
    private SortService sortService = new SortService();
    private City city1 = new City("Адыгейск", "Адыгея", "Южный", 12248, "1973");
    private City city2 = new City("Горно-Алтайск", "Алтай", "Сибирский", 56928, "1830");
    private City city3 = new City("Шимановск", "Амурская область", "Дальневосточный", 19815, "1910");
    private City city4 = new City("Алейск", "Алтайский край", "Сибирский", 29512, "1913");
    private City city5 = new City("Барнаул", "Алтайский край", "Сибирский", 612091, "1730");

    @Test /*Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра */
    public void testSortByCityNameDesc() {
        List<City> actual = sortService.sortByCityNameDesc(new ArrayList<>(Arrays.asList(city1, city2, city3, city4, city5)));
        List<City> expected = new ArrayList<>(Arrays.asList(city3, city2, city5, city4, city1));
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test /*Сортировка по федеральному округу по убыванию и наименованию города внутри округа по убыванию с учетом регистра;*/
    public void testSortByDistrictDescAndNameDesc() {
        List<City> actual = sortService.sortByDistrictDescAndNameDesc(new ArrayList<>(Arrays.asList(city1, city2, city3, city4, city5)));
        List<City> expected = new ArrayList<>(Arrays.asList(city1, city2, city5, city4, city3));
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test /*Сортировка по федеральному округу по убыванию и наименованию города внутри округа в алфавитном порядке с учетом регистра;*/
    public void testSortByDistrictDescAndNameAbc() {
        List<City> actual = sortService.sortByDistrictDescAndNameAbc(new ArrayList<>(Arrays.asList(city1, city2, city3, city4, city5)));
        List<City> expected = new ArrayList<>(Arrays.asList(city1, city4, city5, city2, city3));
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test /*Поиск города с максимальной численностью и вывод на консоль в виде: [489] = 11514330 */
    public void testSortByPopulation() {
        String actual = sortService.sortByPopulation(new City[] {city1, city2, city3, city4, city5});
        String  expected = "[4] = 612091";
        assertEquals(expected, actual);
    }

    @Test /*Вывод в консоль количества городов в разрезе региона, в виде: • Адыгея - 2 /n • Алтай - 1 /n • Алтайский край - 12/n */
    public void testCitiesInTheRegionMap() {
        Map<String, Integer> actual = sortService.citiesInTheRegion(Arrays.asList(city1, city2, city3, city4, city5));
        Map<String, Integer> expected = new HashMap<>((Map.of("Адыгея", 1, "Алтай", 1, "Амурская область", 1, "Алтайский край", 2)));
        assertThat(actual, is(expected));
    }

    @Test
    public void testCitiesInTheRegionList() {
        Map<String, Integer>  actual = sortService.citiesInTheRegion(new ArrayList<>(Arrays.asList(city1, city2, city3, city4, city5)));
        Map<String, Integer> expected = new HashMap<>((Map.of("Адыгея", 1, "Алтай", 1, "Амурская область", 1, "Алтайский край", 2)));
        assertThat(actual, is(expected));
    }

    @Test
    public void testPrintMap() {
        String actual = sortService.printMap(sortService.citiesInTheRegion(Arrays.asList(city1, city2, city3, city4, city5)));
        String expected = "• Адыгея - 1\n• Алтай - 1\n• Алтайский край - 2\n• Амурская область - 1\n";
        assertEquals(expected, actual);
    }
}