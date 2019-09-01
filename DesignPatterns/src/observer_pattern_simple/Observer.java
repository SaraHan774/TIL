package observer_pattern_simple;

public class Observer {
    //this is a simple example, having only one Observer class.
    //now we need to have a multiple observer class.
    //and we also want to know about the exact change in the subject.
    //now, the Observer gets notification that the value has changed,
    //but does not know which value it changed to.
    public void update(){
        System.out.println("flag value changed in observer_pattern_simple.Subject");
    }


}
