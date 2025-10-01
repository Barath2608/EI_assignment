package grid;

public class EmptyCell implements Cell {
    @Override
    public boolean isAccessible() {
        return true;
    }
}
