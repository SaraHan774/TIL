package observer_pattern_assignment;

public class Observer1 implements IObserver{
    @Override
    public void update(String s, int i) {
        System.out.println("Update Observer1 from " + s + " to value " + i);
    }
}
