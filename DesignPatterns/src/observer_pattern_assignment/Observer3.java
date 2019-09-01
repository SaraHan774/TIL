package observer_pattern_assignment;

public class Observer3 implements IObserver{
    @Override
    public void update(String s, int i) {
        System.out.println("Update Observer3 from " + s + " to value " + i);
    }
}
