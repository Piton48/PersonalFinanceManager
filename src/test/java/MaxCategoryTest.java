import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class MaxCategoryTest {
    StatisticEngine engine;

    {
        try {
            engine = new StatisticEngine("categories.tsv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void maxCategoryTest() throws IOException {
        engine.add(new Request("булка", "2020.02.02", 100));
        engine.add(new Request("вода", "2012.02.02", 50));
        Statistic stat = new Statistic("MaxCategory","еда", 100);
        Assertions.assertEquals(engine.getMaxCategory(), stat);
    }
}
