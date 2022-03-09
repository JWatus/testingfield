package homeproject.patterns.behavioral.observer;

/**
 * Observer design pattern is useful when you are interested in the state of an object and want to get notified whenever there is any change.
 * In observer pattern, the object that watch on the state of another object are called Observer and the object that is being watched is called Subject.
 *
 * According to GoF, observer design pattern intent is: Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
 *
 * Subject contains a list of observers to notify of any change in its state, so it should provide methods using which observers can register and unregister themselves.
 * Subject also contain a method to notify all the observers of any change and either it can send the update while notifying the observer or it can provide another method to get the update.
 *
 * Observer should have a method to set the object to watch and another method that will be used by Subject to notify them of any updates.
 */
public interface Observer {

    //method to update the observer, used by subject
    public void update();

    //attach with subject to observe
    public void setSubject(Subject sub);
}