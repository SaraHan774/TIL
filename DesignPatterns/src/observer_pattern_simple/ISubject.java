package observer_pattern_simple;

public interface ISubject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
