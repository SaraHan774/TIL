package observer_pattern;

public interface ISubject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
