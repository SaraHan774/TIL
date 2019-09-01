package observer_pattern_assignment;

import java.util.ArrayList;
import java.util.List;

public class Subject1 implements ISubject{

    private int myValue;

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
        notifyObservers(myValue);
    }

    List<IObserver> iObservers = new ArrayList<>();

    @Override
    public void register(IObserver o) {
        System.out.println("Observer registered to subject 1");
        iObservers.add(o);
    }

    @Override
    public void unregister(IObserver o) {
        System.out.println("Observer unregistered from subject 1");
        iObservers.remove(o);
    }

    @Override
    public void notifyObservers(int i) {
        for(IObserver io : iObservers){
            io.update(this.getClass().getSimpleName(), i);
        }
    }
}
