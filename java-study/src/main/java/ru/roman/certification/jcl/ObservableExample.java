package ru.roman.certification.jcl;

import java.util.Observable;
import java.util.Observer;

/**
 *
 */
class ObservableExample {

    private MyObservable instance = new MyObservable();

    Observable getInstance() {
        return instance;
    }

    private void trigger(String condition) {
        instance.invalidate();
        instance.notifyObservers(condition);
    }

    private void subscribe(Observer observer) {
        getInstance().addObserver(observer);
    }
    private static class MyObservable extends Observable {
        private void invalidate() {
            setChanged();
        }

    }

    public static void main(String[] args) {

        ObservableExample example = new ObservableExample();
        example.subscribe(new Voyeur());

        example.trigger("hey hey hey");
    }
}

class Voyeur implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg.toString());
    }
}
