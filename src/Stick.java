import java.util.Map;

public class Stick {

    private Segment[] segments;

    private Stick() {}

    public void setSegments(Segment[] segments) {
        this.segments = segments;
    }

    public Stick(int segments){
        this.segments = createEmptySegments(segments);
    }

    private Segment[] createEmptySegments(int segments) {

        if(segments < 0)
            throw new IllegalStateException("Number of segments must be > 0");

        Segment[] segments1 = new Segment[segments];

        for(int i=0;i<segments;i++){
            segments1[i] = new Segment();
        }
        return segments1;
    }

    public int countAnts(){
        int count = 0;
        for (Segment segment : segments) {
            count += segment.getAnts().size();
        }
        return count;
    }


    public void moveAll(){
        Segment[] newSegments = createEmptySegments(segments.length);

        for (int i = 0; i < segments.length; i++) {
            handleSegment(newSegments, i);
        }

        toggleDirection(newSegments);
        setSegments(newSegments);
    }

    private void handleSegment(Segment[] newSegments, int i) {
        Segment segment = segments[i];

        for (Ant ant : segment.getAnts()) {
            handleEachAnt(newSegments, i, ant);
        }
    }

    private void handleEachAnt(Segment[] newSegments, int i, Ant ant) {
        int newPos = i + ant.getDirection().getValue();
        if(isOnStick(newPos)){
            newSegments[newPos].getAnts().add(ant);
        }
    }

    private boolean isOnStick(int newPos) {
        return newPos >= 0 && newPos < segments.length;
    }

    public void addAnts(Map<Integer, Direction> antsMap)  {
        for (Map.Entry<Integer, Direction> entry : antsMap.entrySet()) {
            segments[entry.getKey()-1].getAnts().add(new Ant(entry.getValue()));
        }
    }
    private void toggleDirection(Segment[] segments) {
        for (Segment segment : segments) {
            if(segment.getAnts().size() > 1){
                for (Ant ant : segment.getAnts()) {
                    ant.getDirection().toggle();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (Segment segment : segments) {
            sb.append(segment.toString());
            sb.append("|");
        }
        return sb.toString();
    }
}