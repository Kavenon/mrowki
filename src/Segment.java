import java.util.ArrayList;

public class Segment {

    private ArrayList<Ant> ants = new ArrayList<>();

    public ArrayList<Ant> getAnts() {
        return ants;
    }

    public void setAnts(ArrayList<Ant> ants) {
        this.ants = ants;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ants.forEach(sb::append);
        return sb.toString();
    }
}
