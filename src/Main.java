import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        int segments = 6;

        Map<Integer, Direction> antsMap = new HashMap<>();
        antsMap.put(1, Direction.right());
        antsMap.put(3, Direction.left());
        antsMap.put(6, Direction.left());

        new Simulation(segments,antsMap).run();

    }

}
