package exercise;

import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {
        return apartments.stream()
                .limit(count)
                .sorted(Comparator.comparing(Home::getArea))
                .map(Object::toString)
                .toList();
    }
}
// END
