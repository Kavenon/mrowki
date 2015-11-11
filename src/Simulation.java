import java.util.Map;

public class Simulation {

    private int iterations = 0;
    private Stick stick;

    public Simulation(int segments, Map<Integer, Direction> antsMap){
        stick = new Stick(segments);
        stick.addAnts(antsMap);
    }
    public void run(){

        System.out.println(stick);

        while(stick.countAnts() > 0){
            stick.moveAll();

            iterations++;
            System.out.println(stick);

        }

        System.out.println("iterations: " + iterations);
    }
}
