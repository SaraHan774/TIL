package observer_pattern_complex;

public class Observer1 implements IObserver{
    @Override
    public void update(int i) {
        System.out.println("Observer1 : my Value in Subject is now : " + i);
    }

}
