package observer_pattern_complex;

public class ObserverPatternModified {

    public static void main(String[] args) {
        System.out.println("--- modified observer pattern demo ---");

        Subject subject = new Subject();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        subject.register(observer1);
        subject.register(observer2);

        subject.setMyValue(5);
        System.out.println();
        subject.setMyValue(25);
        System.out.println();

        //unregister observer 1 only
        subject.unregister(observer1);
        //now only observer2 will observe the change.
        subject.setMyValue(100);
    }
}
