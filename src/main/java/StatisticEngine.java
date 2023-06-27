import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticEngine {
    private final Map<String, String> products = new HashMap<>();
    private Map<String, List<Request>> statistic = new HashMap<>();

    public StatisticEngine(String fileName) throws IOException {

        Path path = Paths.get(fileName);
        List<String> allLines = Files.readAllLines(
                path, StandardCharsets.UTF_8);

        for (String line : allLines) {
            String[] temp = line.split("\t");
            products.put(temp[0], temp[1]);
        }
    }

    public void add(Request request) {
        statistic.computeIfAbsent(request.getDate(), v -> new ArrayList<>()).add(request);
    }

    public Statistic getMaxCategory() {

        Map<String, Integer> categories = new HashMap<>();
        int other = 0;
        for (Map.Entry<String, String> entry : products.entrySet()) {
            if (!categories.containsKey(entry.getValue())) {
                categories.put(entry.getValue(), 0);
            }
        }

        for (Map.Entry<String, List<Request>> entry : statistic.entrySet())
            for (Request request : entry.getValue()) {
                if (products.containsKey(request.getTitle())) {
                    int i = categories.get(products.get(request.getTitle()));
                    i = i + request.getSum();
                    categories.put(products.get(request.getTitle()), i);
                } else {
                    other += request.getSum();
                }
            }

        String maxCat = null;
        for (String key : categories.keySet()) {
            if (maxCat == null || categories.get(key) > categories.get(maxCat)) {
                maxCat = key;
            }
        }

        if (categories.get(maxCat) > other) {
            return new Statistic("MaxCategory", maxCat, categories.get(maxCat));
        } else {
            return new Statistic("MaxCategory", "другое", other);
        }
    }

}
