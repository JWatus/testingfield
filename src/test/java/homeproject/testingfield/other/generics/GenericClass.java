package homeproject.testingfield.other.generics;

public class GenericClass<T> {
    // An object of type T is declared
    T obj;

    GenericClass(T obj) {
        this.obj = obj;
    }  // constructor

    public T getObject() {
        return this.obj;
    }


}

