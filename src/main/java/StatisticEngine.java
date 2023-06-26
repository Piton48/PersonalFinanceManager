import java.io.File;
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
    private final Map<String, String> categories = new HashMap<>();
    private Map<String,List<Request>> statistic = new HashMap<>();


    public StatisticEngine(String fileName) throws IOException {

        Path path = Paths.get(fileName);
        List<String> allLines = Files.readAllLines(
                path, StandardCharsets.UTF_8);

        for (String line : allLines) {
            String[] temp = line.split("\t");
            categories.put(temp[0],temp[1]);
        }
    }

    public void add(Request request){
        statistic.computeIfAbsent(request.getDate(), v -> new ArrayList<>()).add(request);
    }

    public Statistic getMaxCategory(){
        
    }




}
