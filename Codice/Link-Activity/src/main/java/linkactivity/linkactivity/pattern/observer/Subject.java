package linkactivity.linkactivity.pattern.observer;

import linkactivity.linkactivity.IOExceptionHandler;

import java.util.ArrayList;

public abstract class Subject {
    private ArrayList<Observer> observerArrayList;

    protected Subject(){ observerArrayList= new ArrayList<>();}

    public void attach (Observer newObserver){
        observerArrayList.add(newObserver);
    }
    public void detach (Observer removeObserver){observerArrayList.remove(removeObserver);}

    protected void notifyObservers() throws IOExceptionHandler {

        for (Observer observer : observerArrayList) {
            observer.update();
        }
    }
}
