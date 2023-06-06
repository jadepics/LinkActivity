package linkactivity.linkactivity.pattern.observer;

import linkactivity.linkactivity.IOExceptionHandler;

public interface Observer {

    void update() throws IOExceptionHandler;
}