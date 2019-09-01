package observer_pattern_assignment;

public class Observer2 implements IObserver{
    @Override
    public void update(String s, int i) {
        System.out.println("Update Observer2 from " + s + " to value " + i);
    }
}
