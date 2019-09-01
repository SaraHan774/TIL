package observer_pattern_assignment;

public class ObserverPatternDemo3 {

    public static void main(String[] args) {
        Subject1 subject1 = new Subject1();
        Subject2 subject2 = new Subject2();

        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        Observer3 observer3 = new Observer3();

        subject1.register(observer1);
        subject1.register(observer2);
        subject1.register(observer3);

        subject2.register(observer1);
        subject2.register(observer2);
        subject2.register(observer3);
        System.out.println();
        subject1.setMyValue(50);
        System.out.println("my value in subject1 is now " + subject1.getMyValue());
        System.out.println();
        subject1.setMyValue(60);
        System.out.println("my value in subject1 is now " + subject1.getMyValue());
        System.out.println();
        subject2.setMyValue(10);
        System.out.println("my value in subject2 is now " + subject2.getMyValue());
        System.out.println();
        subject2.setMyValue(20);
        System.out.println("my value in subject2 is now " + subject2.getMyValue());
    }
}
