package observer_pattern_simple;

public class ObserverPatternEx {
    public static void main(String[] args) {
        System.out.println("--- observer_pattern_simple.Observer pattern demo ---");

        Observer observer = new Observer();
        Subject subject = new Subject();

        subject.register(observer);
        System.out.println("Setting Flag = 5");
        subject.set_flag(5);

        System.out.println("Setting Flag = 25");
        subject.set_flag(25);

        subject.unregister(observer);
        //no notifications this time, because it is unregistered.
        System.out.println("Setting Flag = 50");
        subject.set_flag(50);
        System.out.println("No notification, since unregistered");
    }
}
