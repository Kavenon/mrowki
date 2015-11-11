public class Direction {

    private int value;

    public Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void toggle(){
        value *= -1;
    }

    public static Direction right(){
        return new Direction(1);
    }

    public static Direction left(){
        return new Direction(-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        return value == direction.value;

    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        if(value == -1)
            return "<";
        else if(value == 1)
            return ">";
        return ".";
    }
}
