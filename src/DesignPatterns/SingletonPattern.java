package DesignPatterns;

public class SingletonPattern {

    private static SingletonPattern obj; //can be initialised here only (early instantiation)

    private SingletonPattern() { }

    public static SingletonPattern getObj() {
        if(obj == null) {
            return new SingletonPattern();  //lazy instantiation
        }
        return obj;
    }

    public void print() {
        System.out.print("SingletonPattern");
    }
}


