import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Project {
     Map<String, Double> projects = Stream.of(new Object[][]{
            {"project1", 1_000_000.0},
            {"project2", 1_500_000.0},
            {"project3", 1_700_000.0}}).collect(Collectors.toMap(data -> (String)data[0], data->(Double)data[1]));
}
